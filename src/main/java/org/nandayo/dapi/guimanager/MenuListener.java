package org.nandayo.dapi.guimanager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.DAPI;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class MenuListener implements Listener {

    static private final @NotNull HashMap<UUID, Long> LAST_SHIFT_CLICK = new HashMap<>();

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
            Long lastClick = LAST_SHIFT_CLICK.get(p.getUniqueId());
            long now = System.currentTimeMillis();
            if(e.getClick().isShiftClick() && lastClick != null && now - lastClick < 150) {
                e.setCancelled(true);
                return;
            }
            LAST_SHIFT_CLICK.put(p.getUniqueId(), now);
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
                // Debugged
                Bukkit.getScheduler().runTask(dapi.plugin, () -> abstractButton.onClick(p, e.getClick()));
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
        LAST_SHIFT_CLICK.remove(e.getPlayer().getUniqueId());
        DAPI dapi = DAPI.getInstance();
        if(dapi.plugin == null) return;

        Player p = e.getPlayer();
        if (p.hasMetadata(dapi.GUI_METADATA_KEY)) {
            Menu menu = (Menu) p.getMetadata(dapi.GUI_METADATA_KEY).get(0).value();
            if(menu != null) {
                menu.getCloseCallback().accept(menu.getInventory());
            }
            p.removeMetadata(dapi.GUI_METADATA_KEY, dapi.plugin);
        }
    }
}
