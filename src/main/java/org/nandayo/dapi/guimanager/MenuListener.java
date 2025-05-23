package org.nandayo.dapi.guimanager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;
import org.nandayo.dapi.DAPI;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MenuListener implements Listener {

    /**
     * Cancel click if button is unmodifiable
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

            // Click on player inventory.
            boolean clickedOnPlayerInventory = Objects.equals(e.getClickedInventory(), p.getInventory());
            if(clickedOnPlayerInventory) {
                if(!menu.isEmptySlotsModifiable()) {
                    e.setCancelled(true);
                    BiConsumer<PlayerInventory, Integer> playerClickConsumer = menu.getOnPlayerInventoryClick();
                    if(playerClickConsumer != null) playerClickConsumer.accept(p.getInventory(), e.getSlot());
                }
                return;
            }

            // Abstract button click.
            AbstractButton abstractButton = menu.getButton(e.getSlot());
            if(abstractButton == null) {
                e.setCancelled(!menu.isEmptySlotsModifiable());
            }
            else if(abstractButton instanceof Button) {
                Button button = (Button) abstractButton;
                e.setCancelled(!button.isModifiable());
                button.onClick(p, e.getClick());
            }
            else if (abstractButton instanceof LazyButton) {
                LazyButton lazyButton = (LazyButton) abstractButton;
                e.setCancelled(!lazyButton.isModifiable());
            }
        }
    }

    /**
     * Cancel click anyway if it is drag event
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
     * Remove metadata on inventory close event
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
                Consumer<Inventory> closeConsumer = menu.getCloseCallback();
                if(closeConsumer != null) closeConsumer.accept(menu.getInventory());
            }
            p.removeMetadata(dapi.GUI_METADATA_KEY, dapi.plugin);
        }
    }

    /**
     * Remove metadata on quit event
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
                Consumer<Inventory> closeConsumer = menu.getCloseCallback();
                if(closeConsumer != null) closeConsumer.accept(menu.getInventory());
            }
            p.removeMetadata(dapi.GUI_METADATA_KEY, dapi.plugin);
        }
    }
}
