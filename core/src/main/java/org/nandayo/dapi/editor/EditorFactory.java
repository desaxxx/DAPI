package org.nandayo.dapi.editor;

import org.nandayo.dapi.editor.annotation.Editable;
import org.bukkit.entity.Player;
import org.nandayo.dapi.editor.handler.EditorHandlerRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * Main entry point for the Object Editor framework.
 * <p>
 * Usage in your plugin:
 * <pre>
 * 1. Setup once in onEnable:
 *   EditorFactory factory = new EditorFactory();
 *   // Optionally register custom handlers:
 *   factory.getRegistry().register(new LocationFieldHandler());
 *
 * 2. Open an editor anywhere:
 *   factory.open(player, gameInstance,
 *       cancel -> player.sendMessage("Edit canceled."));
 * </pre>
 * The factory manages all active sessions, so if a player opens two editors
 * simultaneously, the old one is cleanly canceled first.
 */
@SuppressWarnings("unused")
public class EditorFactory {

    private final EditorHandlerRegistry registry;
    private final Map<UUID, EditorSession> activeSessions = new HashMap<>();

    public EditorFactory(EditorHandlerRegistry registry) {
        this.registry = registry;
    }

    public EditorFactory() {
        this(EditorHandlerRegistry.createDefault());
    }


    // -----------------------------------------------------------------------
    // Open API
    // -----------------------------------------------------------------------

    /**
     * Opens an editor for the given object (must be annotated with @Editable).
     * <p>
     * The framework creates a deep copy of the object; the original is only
     * replaced when the player clicks Save.
     *
     * @param player the admin opening the editor
     * @param object the object to edit
     * @param onCancel called when the player cancels or closes without saving
     * @throws IllegalArgumentException if the object is not annotated with @Editable
     */
    public void open(Player player, Object object, Consumer<Object> onCancel) {
        assertEditable(object);

        // Cancel any existing session for this player
        EditorSession existing = activeSessions.get(player.getUniqueId());
        if (existing != null) {
            existing.cancel();
        }

        Object snapshot = DeepCopyUtil.deepCopy(object);

        // Create session
        EditorSession session = new EditorSession(player, registry);
        session.setOnCancel(() -> {
            activeSessions.remove(player.getUniqueId());
            if (onCancel != null) onCancel.accept(snapshot);
        });

        // Wire the page-open callback: opens an EditorMenuAdapter for each new page
        session.setPageOpenCallback(page -> openMenuForPage(player, session, page));

        activeSessions.put(player.getUniqueId(), session);

        // Push the root page — this fires pageOpenCallback and opens the menu
        EditorPage rootPage = new EditorPage(snapshot, registry, session);
        session.push(rootPage, false);
    }

    /**
     * Convenience overload with no callbacks.
     */
    public void open(Player player, Object object) {
        open(player, object, null);
    }

    // -----------------------------------------------------------------------
    // Menu bridge
    // -----------------------------------------------------------------------

    /**
     * Opens the inventory menu for the given EditorPage.
     * <br>
     * Called by the session's pageOpenCallback whenever a page is pushed or popped.
     */
    private void openMenuForPage(Player player, EditorSession session, EditorPage page) {
        new EditorMenuAdapter(player, session, page).open();
    }

    // -----------------------------------------------------------------------
    // Session management
    // -----------------------------------------------------------------------

    public boolean hasActiveSession(Player player) {
        return activeSessions.containsKey(player.getUniqueId());
    }

    public EditorSession getSession(Player player) {
        return activeSessions.get(player.getUniqueId());
    }

    /** Force-closes any active session for this player (e.g., on disconnect). */
    public void closeSession(Player player) {
        EditorSession s = activeSessions.remove(player.getUniqueId());
        if (s != null) s.cancel();
    }

    public EditorHandlerRegistry getRegistry() {
        return registry;
    }

    // -----------------------------------------------------------------------
    // Internal helpers
    // -----------------------------------------------------------------------

    private void assertEditable(Object object) {
        if (!object.getClass().isAnnotationPresent(Editable.class)) {
            throw new IllegalArgumentException(
                "Cannot open editor: " + object.getClass().getName()
                + " is not annotated with @Editable"
            );
        }
    }
}
