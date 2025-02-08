package org.nandayo.DAPI.GUIManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.nandayo.DAPI.DAPI;
import org.nandayo.DAPI.HexUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class Menu {

    private final List<Button> buttons = new ArrayList<>();
    private final List<LazyButton> lazyButtons = new ArrayList<>();

    private int size = 27;
    private String title = "Default";
    private Inventory inventory = null;
    private Consumer<Inventory> closeCallback = inventory -> {};
    private boolean emptySlotsModifiable = false;

    //-------------------------------------
    //   Public methods
    //

    /*
     * Buttons
     */
    public final List<Button> getButtons() {
        return this.buttons;
    }

    /*
     * Is button
     */
    public final boolean isButton(int slot) {
        return this.buttons.stream().anyMatch(b -> b.getSlot() == slot);
    }

    /*
     * Get button
     */
    public final Button getButton(int slot) {
        return this.buttons.stream()
                .filter(b -> b.getSlot() == slot)
                .findFirst()
                .orElse(null);
    }

    /*
     * Lazy buttons
     */
    public final List<LazyButton> getLazyButtons() {
        return this.lazyButtons;
    }

    /*
     * Is lazy button
     */
    public final boolean isLazyButton(int slot) {
        return this.lazyButtons.stream().anyMatch(lb -> lb.getSlots().contains(slot));
    }

    /*
     * Get lazy button
     */
    public final LazyButton getLazyButton(int slot) {
        return this.lazyButtons.stream()
                .filter(lb -> lb.getSlots().contains(slot))
                .findFirst()
                .orElse(null);
    }

    /*
     * Is empty slots modifiable
     */
    public boolean isEmptySlotsModifiable() {
        return emptySlotsModifiable;
    }

    /*
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

    /*
     * Create inventory with
     * @param size
     * @param title
     */
    protected final void createInventory(int size, String title) {
        this.inventory = Bukkit.createInventory(null, size, HexUtil.parse(title));
    }

    /*
     * Create inventory with
     * @param size
     */
    protected final void createInventory(int size) {
        createInventory(size, title);
    }

    /*
     * Create inventory with no info
     */
    protected final void createInventory() {
        createInventory(size, title);
    }

    /*
     * Get inventory
     */
    protected final Inventory getInventory() {
        return inventory;
    }

    /*
     * Set size of GUI
     */
    protected final void setSize(int size) {
        this.size = size;
        createInventory(size, title);
    }

    /*
     * Set title of GUI
     */
    protected final void setTitle(String title) {
        this.title = title;
        createInventory(size, title);
    }

    /*
     * Add buttons
     */
    protected final void addButton(Button button) {
        this.buttons.add(button);
    }

    /*
     * Add lazy buttons
     */
    protected final void addLazyButton(LazyButton lazyButton) {
        this.lazyButtons.add(lazyButton);
    }

    /*
     * Get item from inventory slot
     */
    protected final ItemStack getInvItem(int slot) {
        if (inventory == null) return null;
        return this.inventory.getItem(slot);
    }

    /*
     * Set slot item in inventory
     */
    protected final void setInvItem(int slot, ItemStack item) {
        if (inventory == null) return;
        this.inventory.setItem(slot, item);
    }

    /*
     * Make empty slots modifiable
     */
    protected final void makeEmptySlotsModifiable(boolean b) {
        this.emptySlotsModifiable = b;
    }

    /*
     * Close functions
     */
    protected final void runOnClose(Consumer<Inventory> callBack) {
        this.closeCallback = callBack;
    }

    /*
     * Display GUI to player
     */
    protected final void displayTo(Player p) {
        if(inventory == null) {
            createInventory(size, title);
        }
        Inventory inv = this.inventory;

        // Buttons
        for(Button button : buttons) {
            inv.setItem(button.getSlot(), button.getItem());
        }

        // Lazy buttons
        for(LazyButton lazyButton : lazyButtons) {
            for(int slot : lazyButton.getSlots()) {
                inv.setItem(slot, lazyButton.getItem());
            }
        }

        p.openInventory(inv);
        DAPI dapi = DAPI.getInstance();
        p.setMetadata(dapi.GUI_METADATA_KEY, new FixedMetadataValue(dapi.plugin, this));
    }
}
