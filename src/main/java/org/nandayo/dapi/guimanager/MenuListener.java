package org.nandayo.dapi.guimanager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.nandayo.dapi.DAPI;

import java.util.Objects;

public class MenuListener implements Listener {

    /*
     * Cancel click if button is unmodifiable
     */
    @EventHandler
    public void onGUIClick(InventoryClickEvent e) {
        DAPI dapi = DAPI.getInstance();
        if(dapi.plugin == null) return;

        Player p = (Player) e.getWhoClicked();
        if(p.hasMetadata(dapi.GUI_METADATA_KEY)) {
            Menu menu = (Menu) p.getMetadata(dapi.GUI_METADATA_KEY).get(0).value();
            if(menu == null) {
                return;
            }
            boolean clickedOnPlayerInventory = Objects.equals(e.getClickedInventory(), p.getInventory());
            if(clickedOnPlayerInventory) {
                if(!menu.isEmptySlotsModifiable()) {
                    e.setCancelled(true);
                }
                return;
            }

            // Abstract click call.
            AbstractButton abstractButton = menu.getButton(e.getSlot());
            if(abstractButton == null) {
                e.setCancelled(!menu.isEmptySlotsModifiable());
            } else if(abstractButton instanceof Button) {
                Button button = (Button) abstractButton;
                button.onClick(p, e.getClick());
            }
        }
    }

    /*
     * Cancel click anyway if it is drag event
     */
    @EventHandler
    public void onGUIDrag(InventoryDragEvent e){
        DAPI dapi = DAPI.getInstance();
        if(dapi.plugin == null) return;

        Player p = (Player) e.getWhoClicked();
        if (p.hasMetadata(dapi.GUI_METADATA_KEY)) {
            Menu menu = (Menu) p.getMetadata(dapi.GUI_METADATA_KEY).get(0).value();
            if(menu != null) {
                e.setCancelled(true);
            }
        }
    }

    /*
     * Remove metadata on inventory close event
     */
    @EventHandler
    public void onGUIClose(InventoryCloseEvent e){
        DAPI dapi = DAPI.getInstance();
        if(dapi.plugin == null) return;

        Player p = (Player) e.getPlayer();
        if (p.hasMetadata(dapi.GUI_METADATA_KEY)) {
            Menu menu = (Menu) p.getMetadata(dapi.GUI_METADATA_KEY).get(0).value();
            if(menu != null) {
                menu.handleCloseCallback();
            }
            p.removeMetadata(dapi.GUI_METADATA_KEY, dapi.plugin);
        }
    }

    /*
     * Remove metadata on quit event
     */
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        DAPI dapi = DAPI.getInstance();
        if(dapi.plugin == null) return;

        Player p = e.getPlayer();
        if (p.hasMetadata(dapi.GUI_METADATA_KEY)) {
            Menu menu = (Menu) p.getMetadata(dapi.GUI_METADATA_KEY).get(0).value();
            if(menu != null) {
                menu.handleCloseCallback();
            }
            p.removeMetadata(dapi.GUI_METADATA_KEY, dapi.plugin);
        }
    }
}
