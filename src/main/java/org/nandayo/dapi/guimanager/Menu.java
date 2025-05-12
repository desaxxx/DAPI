package org.nandayo.dapi.guimanager;

import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.HexUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("unused")
@Getter(AccessLevel.PROTECTED)
public class Menu {

    private final @NotNull List<AbstractButton> abstractButtons = new ArrayList<>();

    private int size = 27;
    private @NotNull String title = "Default";
    private Inventory inventory = null;
    private Consumer<Inventory> closeCallback = inventory -> {};
    private boolean emptySlotsModifiable = false;

    //-------------------------------------
    //   Public methods
    //


    /**
     * Check if the slot is a menu button.
     * @param slot Integer
     * @return bool
     */
    public final boolean isButton(int slot) {
        return getButton(slot) != null;
    }

    /**
     * Get an abstract button from given slot.
     * @param slot Integer
     * @return AbstractButton
     */
    @Nullable
    public final AbstractButton getButton(int slot) {
        return this.abstractButtons.stream()
                .filter(b -> {
                    if(b instanceof Button) {
                        return ((Button) b).getSlot() == slot;
                    } else if(b instanceof LazyButton) {
                        return ((LazyButton) b).getSlots().contains(slot);
                    }
                    return false;
                })
                .findFirst()
                .orElse(null);
    }

    /**
     * Handle close callback
     */
    public final void handleCloseCallback() {
        if (this.closeCallback != null) {
            this.closeCallback.accept(this.inventory);
        }
    }

    //----------------------------------------
    //   Protected methods
    //

    /**
     * Create inventory with size and a title.
     * @param size Integer (multiples of 9. Min:0, Max:54)
     * @param title String
     */
    protected final void createInventory(int size, @NotNull String title) {
        this.inventory = Bukkit.createInventory(null, size, HexUtil.parse(title));
    }

    /**
     * Create inventory with size.
     * @param size Integer (multiples of 9. Min:0, Max:54)
     */
    protected final void createInventory(int size) {
        createInventory(size, title);
    }

    /**
     * Create inventory with default settings.
     */
    protected final void createInventory() {
        createInventory(size, title);
    }

    /**
     * Set size of the menu.
     * @param size Integer (multiples of 9. Min:0, Max:54)
     * @deprecated This is not recommended to use, since {@link #createInventory(int, String)} already does what it does.
     */
    @Deprecated(since = "1.1.19")
    protected final void setSize(int size) {
        this.size = size;
        createInventory(size, title);
    }

    /**
     * Set title of the menu.
     * @param title String
     * @deprecated This is not recommended to use, since {@link #createInventory(int, String)} already does what it does.
     */
    @Deprecated
    protected final void setTitle(String title) {
        this.title = title;
        createInventory(size, title);
    }

    /**
     * Add an abstract button to the menu.<br>
     * Available buttons are: Button, LazyButton.
     * @param button AbstractButton
     */
    protected final <T extends AbstractButton> void addButton(@NotNull T button) {
        this.abstractButtons.add(button);
    }

    /**
     * Get item from inventory slot.
     * @param slot Integer
     */
    @Nullable
    protected final ItemStack getInvItem(int slot) {
        if (inventory == null) return null;
        return this.inventory.getItem(slot);
    }

    /**
     * Set an item to a slot of the inventory.
     * @param slot Integer
     * @param item ItemStack
     */
    protected final void setInvItem(int slot, @Nullable ItemStack item) {
        if (inventory == null) return;
        this.inventory.setItem(slot, item);
    }

    /**
     * Make empty slots modifiable.
     * @param b bool
     */
    protected final void makeEmptySlotsModifiable(boolean b) {
        this.emptySlotsModifiable = b;
    }

    /**
     * Set close function for the menu.
     * @param callBack Consumer of Inventory
     */
    protected final void runOnClose(@NotNull Consumer<Inventory> callBack) {
        this.closeCallback = callBack;
    }

    /**
     * Display the menu to a player.
     * @param p Player
     */
    protected final void displayTo(@NotNull Player p) {
        if(inventory == null) {
            createInventory(size, title);
        }
        Inventory inv = this.inventory;

        // Buttons
        for(AbstractButton abstractButton : abstractButtons) {
            if(abstractButton instanceof Button) {
                Button button = (Button) abstractButton;
                inv.setItem(button.getSlot(), button.getItem());
            }
            else if (abstractButton instanceof LazyButton) {
                LazyButton lazyButton = (LazyButton) abstractButton;
                for(int slot : lazyButton.getSlots()) {
                    inv.setItem(slot, lazyButton.getItem());
                }
            }
        }

        p.openInventory(inv);
        DAPI dapi = DAPI.getInstance();
        p.setMetadata(dapi.GUI_METADATA_KEY, new FixedMetadataValue(dapi.plugin, this));
    }
}
