package org.nandayo.dapi.editor;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.editor.handler.EnumFieldHandler;
import org.nandayo.dapi.editor.handler.ListFieldHandler;
import org.nandayo.dapi.guimanager.MenuType;
import org.nandayo.dapi.guimanager.button.Button;
import org.nandayo.dapi.guimanager.menu.Menu;

import java.util.List;

/**
 * A dynamically constructed {@link Menu} built from a runtime-provided list of {@link Button}s.
 *
 * <p>Used internally by the editor framework wherever a sub-menu needs to be generated
 * on the fly without a dedicated class. Current usages:</p>
 * <ul>
 *   <li>{@link EnumFieldHandler} — choice picker showing
 *       one button per enum constant.</li>
 *   <li>{@link ListFieldHandler} — list manager showing
 *       one button per element plus Add / Remove controls.</li>
 * </ul>
 *
 * <p>Both handlers construct their button lists, then open a {@code GeneratedMenu}
 * on top of the current editor page. Closing the sub-menu without making a selection
 * fires the {@code onClose} runnable, which is responsible for reopening the parent
 * {@link EditorMenuAdapter} so the player is returned to
 * the editor seamlessly.</p>
 *
 * <p>Example usage inside a handler:</p>
 * <pre>{@code
 * List<Button> buttons = new ArrayList<>();
 * // ... populate buttons ...
 * new GeneratedMenu(player, "Pick a value", 3, buttons, () -> reopenParent(ctx)).open();
 * }</pre>
 */
public class GeneratedMenu extends Menu {

    private final Player player;
    private final String title;
    private final int rows;
    private final List<Button> buttons;
    private final Runnable onClose;

    public GeneratedMenu(Player player, String title, int rows, List<Button> buttons, Runnable onClose) {
        this.player = player;
        this.title = title;
        this.rows = rows;
        this.buttons = buttons;
        this.onClose = onClose;
    }

    public void open() {
        clearButtons();

        createInventory(MenuType.getChestFromRows(rows), title);

        buttons.forEach(this::addButton);

        displayTo(player);
    }

    @Override
    public void onClose(@NotNull Inventory inventory) {
        if (onClose != null) onClose.run();
    }
}
