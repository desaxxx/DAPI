package org.nandayo.DAPI.GUIManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.nandayo.DAPI.DAPI;

import java.util.Objects;

public class MenuListener implements Listener {

    private final DAPI plugin = DAPI.getInstance();

    /*
     * Cancel click if button is unmodifiable
     */
    @EventHandler
    public void onGUIClick(InventoryClickEvent e) {
       Player p = (Player) e.getWhoClicked();
       if(p.hasMetadata(plugin.GUI_METADATA_KEY)) {
           Menu menu = (Menu) p.getMetadata(plugin.GUI_METADATA_KEY).get(0).value();
           if(menu == null) {
               return;
           }
           if(menu.isEmptySlotsModifiable() && Objects.equals(e.getClickedInventory(), e.getWhoClicked().getInventory())) {
               return;
           }

           Button button = menu.getButton(e.getSlot());
           if(button != null) {
               e.setCancelled(!button.isModifiable());
               button.onClick(p, e.getClick());
           }else {
               e.setCancelled(!menu.isEmptySlotsModifiable());
           }
       }
    }

    /*
     * Cancel click anyway if it is drag event
     */
    @EventHandler
    public void onGUIDrag(InventoryDragEvent e){
        Player p = (Player) e.getWhoClicked();
        if (p.hasMetadata(plugin.GUI_METADATA_KEY)) {
            Menu menu = (Menu) p.getMetadata(plugin.GUI_METADATA_KEY).get(0).value();
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
        Player p = (Player) e.getPlayer();
        if (p.hasMetadata(plugin.GUI_METADATA_KEY)) {
            Menu menu = (Menu) p.getMetadata(plugin.GUI_METADATA_KEY).get(0).value();
            if(menu != null) {
                 menu.handleCloseCallback();
            }
            p.removeMetadata(plugin.GUI_METADATA_KEY, plugin);
        }
    }

    /*
     * Remove metadata on quit event
     */
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (p.hasMetadata(plugin.GUI_METADATA_KEY)) {
            Menu menu = (Menu) p.getMetadata(plugin.GUI_METADATA_KEY).get(0).value();
            if(menu != null) {
                menu.handleCloseCallback();
            }
            p.removeMetadata(plugin.GUI_METADATA_KEY, plugin);
        }
    }
}
