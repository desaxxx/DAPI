package org.nandayo.dapi.guimanager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.nandayo.dapi.DAPI;

import java.util.Objects;

public class MenuListener implements Listener {

    /**
     * Listening to click on DAPI GUI.
     * @param e Event*
     */
    @EventHandler
    public void onGUIClick(InventoryClickEvent e) {
        DAPI dapi = DAPI.getInstance();
        if(dapi.plugin == null) return;

        Player p = (Player) e.getWhoClicked();
        if(p.hasMetadata(dapi.GUI_METADATA_KEY)) {
            Menu menu = (Menu) p.getMetadata(dapi.GUI_METADATA_KEY).get(0).value();
            if(menu == null) return;
            // DAPI Menu from now.

            // Debug
            if(menu.isClosing()) {
                e.setCancelled(true);
                return;
            }
            if(e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
                e.setCancelled(true);
            }
            //

            // Click on player inventory.
            boolean clickedOnPlayerInventory = Objects.equals(e.getClickedInventory(), p.getInventory());
            if(clickedOnPlayerInventory) {
                if(!menu.isEmptySlotsModifiable()) {
                    e.setCancelled(true);
                    menu.getOnPlayerInventoryClick().accept(p.getInventory(), e.getSlot());
                }
                return;
            }

            // Abstract button click.
            AbstractButton abstractButton = menu.getButton(e.getSlot());
            if(abstractButton == null) {
                e.setCancelled(!menu.isEmptySlotsModifiable());
            }else {
                e.setCancelled(!abstractButton.isModifiable());
                abstractButton.onClick(p, e.getClick());
            }
        }
    }

    /**
     * Listening to drag click on DAPI GUI.
     * @param e Event*
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

    /**
     * Listening to close DAPI GUI.
     * @param e Event*
     */
    @EventHandler
    public void onGUIClose(InventoryCloseEvent e){
        DAPI dapi = DAPI.getInstance();
        if(dapi.plugin == null) return;

        Player p = (Player) e.getPlayer();
        if (p.hasMetadata(dapi.GUI_METADATA_KEY)) {
            Menu menu = (Menu) p.getMetadata(dapi.GUI_METADATA_KEY).get(0).value();
            if(menu != null) {
                menu.getCloseCallback().accept(menu.getInventory());
                // Debug
                menu.setClosing(true);
            }
            p.removeMetadata(dapi.GUI_METADATA_KEY, dapi.plugin);
        }
    }

    /**
     * Listening to player quit for DAPI GUI.
     * @param e Event*
     */
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        DAPI dapi = DAPI.getInstance();
        if(dapi.plugin == null) return;

        Player p = e.getPlayer();
        if (p.hasMetadata(dapi.GUI_METADATA_KEY)) {
            Menu menu = (Menu) p.getMetadata(dapi.GUI_METADATA_KEY).get(0).value();
            if(menu != null) {
                menu.getCloseCallback().accept(menu.getInventory());
                // Debug
                menu.setClosing(true);
            }
            p.removeMetadata(dapi.GUI_METADATA_KEY, dapi.plugin);
        }
    }
}
