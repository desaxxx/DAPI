package org.nandayo.dapi.editor;

import org.bukkit.entity.Player;
import org.nandayo.dapi.editor.handler.EditorHandlerRegistry;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Consumer;

/**
 * Per-player editor session.
 * <p>
 * Holds the navigation stack of EditorPages so players can drill down
 * into nested objects and come back up with the Back button.
 * <pre>
 * Lifecycle:
 *   EditorFactory.open(player, object)
 *       → creates EditorSession
 *       → pushes root EditorPage
 *       → opens EditorMenuAdapter for that page
 *
 *   Player clicks a nested field
 *       → NestedObjectHandler calls session.push(newPage)
 *       → new EditorMenuAdapter opens on top
 *
 *   Player clicks Back / closes the menu
 *       → session.pop() returns to the parent page
 *
 *   Player clicks Cancel / closes root
 *       → session.cancel() fires the onCancel callback (working copy is discarded)
 * </pre>
 */
public class EditorSession {

    private final Player player;
    private final EditorHandlerRegistry registry;
    private final Deque<EditorPage> pageStack = new ArrayDeque<>();

    /** Fired when the player cancels or closes the root page without saving. */
    private Runnable onCancel;

    /**
     * Called whenever a new page is pushed so EditorMenuAdapter can open the new menu.
     * <br>
     * Note: This calls {@link EditorMenuAdapter#open()}, so it doesn't suppress next close.
     */
    private Consumer<EditorPage> pageOpenCallback;

    private boolean suppressNextClose = false;

    public EditorSession(Player player, EditorHandlerRegistry registry) {
        this.player = player;
        this.registry = registry;
    }

    // -----------------------------------------------------------------------
    // Navigation
    // -----------------------------------------------------------------------

    /**
     * Pushes a new page onto the stack and fires the pageOpenCallback so the
     * EditorMenuAdapter (or EditorFactory) can open the inventory for it.
     */
    public void push(EditorPage page, boolean suppressNextClose) {
        pageStack.push(page);
        if (pageOpenCallback != null) {
            if(suppressNextClose) this.suppressNextClose = true;
            pageOpenCallback.accept(page);
        }
    }

    /**
     * Pops the current page. If there are still pages remaining, fires pageOpenCallback
     * for the new top so the parent menu is re-opened. If the stack is now empty, cancels.
     *
     * @param suppressNextClose suppress next close handler
     */
    public void pop(boolean suppressNextClose) {
        if (!pageStack.isEmpty()) {
            pageStack.pop();
        }
        if (pageStack.isEmpty()) {
            cancel();
        } else {
            // Re-open the parent page
            if (pageOpenCallback != null) {
                if (suppressNextClose) this.suppressNextClose = true;
                pageOpenCallback.accept(pageStack.peek());
            }
        }
    }

    /** Returns the currently active page without removing it. */
    public EditorPage currentPage() {
        return pageStack.peek();
    }

    public boolean isEmpty() {
        return pageStack.isEmpty();
    }

    public int depth() {
        return pageStack.size();
    }

    // -----------------------------------------------------------------------
    // Lifecycle
    // -----------------------------------------------------------------------

    /**
     * Discards all changes and fires the onCancel callback.
     */
    public void cancel() {
        pageStack.clear();
        if (onCancel != null) {
            onCancel.run();
        }
    }

    // -----------------------------------------------------------------------
    // Callback wiring
    // -----------------------------------------------------------------------

    public void setOnCancel(Runnable onCancel) {
        this.onCancel = onCancel;
    }

    /**
     * Set by EditorFactory. Called whenever the session wants to open/re-open a page.
     * The callback should open the EditorMenuAdapter for the given EditorPage.
     */
    public void setPageOpenCallback(Consumer<EditorPage> callback) {
        this.pageOpenCallback = callback;
    }

    public Player getPlayer() {
        return player;
    }

    public EditorHandlerRegistry getRegistry() {
        return registry;
    }

    public void setSuppressNextClose(boolean suppress) {
        this.suppressNextClose = suppress;
    }

    public boolean isSuppressNextClose() {
        return suppressNextClose;
    }
}
