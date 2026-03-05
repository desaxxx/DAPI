package org.nandayo.dapi.editor;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.guimanager.MenuType;
import org.nandayo.dapi.guimanager.button.Button;
import org.nandayo.dapi.guimanager.menu.Menu;
import org.nandayo.dapi.util.ItemCreator;

import java.util.Map;
import java.util.Set;

/**
 * Bridge between EditorPage and the Menu system.
 * <p>
 * Extends Menu and implements the editor lifecycle:
 * <pre>
 *   - open() — builds field buttons with inline click logic via page.handleClick(),
 *              adds Back / Save / Cancel navigation buttons, calls displayTo(player).
 *
 *   - onClose() — cancels the session if the player closed the menu themselves (Esc),
 *                 suppressed when the close was triggered by navigation code.
 * </pre>
 * Full page refresh is used on every field change via page.setFullRefreshListener(),
 * which re-calls open(). Single-slot updates are not needed.
 */
public class EditorMenuAdapter extends Menu {

    // -----------------------------------------------------------------------
    // Navigation item slots — adjust to wherever your layout puts them
    // -----------------------------------------------------------------------
    private static final int BACK_SLOT   = 45;
    private static final int CANCEL_SLOT = 53;

    // -----------------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------------
    protected final Player player;
    protected final EditorSession session;
    protected final EditorPage page;

    /** Tracks whether the close was triggered by us (navigation) vs the player pressing Esc. */
    private boolean suppressCloseHandling = false;

    // -----------------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------------

    public EditorMenuAdapter(Player player, EditorSession session, EditorPage page) {
        this.player  = player;
        this.session = session;
        this.page    = page;

        // Wire EditorPage callbacks so it can push item updates back into the open inventory
//        page.setSlotUpdateListener((slot, item) -> {
//            // Update a single slot in the open inventory without reopening the whole menu.
//            // Example: getInventory().setItem(slot, item);
//        });

        page.setFullRefreshListener(() -> {
            suppressCloseHandling = true;
            open(); // reopens with a fresh slot map
        });
    }

    // -----------------------------------------------------------------------
    // Open
    // -----------------------------------------------------------------------

    /**
     * Opens the inventory for the player.
     */
    public void open() {
        clearButtons(); // clear any previous buttons from old inventory.

        createInventory(MenuType.getChestFromRows(page.getRows()), page.getTitle());

        for(Map.Entry<Integer, ItemStack> entry : page.buildSlotMap(player).entrySet()) {
            addButton(new Button() {
                @Override
                protected @NotNull Set<Integer> getSlots() {
                    return Set.of(entry.getKey());
                }

                @Override
                public ItemStack getItem() {
                    return entry.getValue();
                }

                @Override
                public void onClick(@NotNull Player p, @NotNull ClickType clickType) {
                    // Delegate field click to EditorPage
                    page.handleClick(player, entry.getKey(), clickType);
                }
            });
        }

        if (session.depth() > 1) {
            addButton(new Button() {
                @Override
                protected @NotNull Set<Integer> getSlots() {
                    return Set.of(BACK_SLOT);
                }

                @Override
                public ItemStack getItem() {
                    return buildBackItem();
                }

                @Override
                public void onClick(@NotNull Player p, @NotNull ClickType clickType) {
                    suppressCloseHandling = true;
                    session.pop(); // pops current page, pageOpenCallback re-opens parent
                }
            });
        }

        addButton(new Button() {
            @Override
            protected @NotNull Set<Integer> getSlots() {
                return Set.of(CANCEL_SLOT);
            }

            @Override
            public ItemStack getItem() {
                return buildCancelItem();
            }

            @Override
            public void onClick(@NotNull Player p, @NotNull ClickType clickType) {
                suppressCloseHandling = true;
                session.cancel();
                player.closeInventory();
            }
        });

        displayTo(player);
    }


    // -----------------------------------------------------------------------
    // Close handler — call this from your Menu's onClose callback
    // -----------------------------------------------------------------------


    /**
     * Called when the inventory is closed.
     * <br>
     * If the close was triggered by the player pressing Esc (not by navigation code),
     * we cancel the session, so the working copy is discarded.
     */
    @Override
    public void onClose(@NotNull Inventory inventory) {
        if (suppressCloseHandling) {
            suppressCloseHandling = false;
            return;
        }
        // Player closed the menu themselves — treat as cancel
        session.cancel();
    }

    // -----------------------------------------------------------------------
    // Navigation item builders
    // -----------------------------------------------------------------------

    /**
     * Builds the Back navigation item.
     */
    protected ItemStack buildBackItem() {
         return ItemCreator.of(Material.ARROW)
             .name("&7← Back")
             .lore("&8Return to previous menu")
             .build();
    }

    /**
     * Builds the Cancel navigation item.
     */
    protected ItemStack buildCancelItem() {
         return ItemCreator.of(Material.BARRIER)
             .name("&cCancel")
             .lore("&7Discard all changes.")
             .build();
    }
}
