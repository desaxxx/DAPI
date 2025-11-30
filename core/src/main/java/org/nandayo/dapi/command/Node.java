package org.nandayo.dapi.command;

import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 1.5.1
 */
@ApiStatus.Experimental
public class Node {

    private final @Nullable Node parent;
    private final @NotNull List<@NotNull Node> children;
    private Node(@Nullable Node parent, @NotNull List<@NotNull Node> children) {
        this.parent = parent;
        this.children = new ArrayList<>(children);
    }

    public boolean hasParent() {
        return parent != null;
    }

    public @Nullable Node getParent() {
        return parent;
    }

    public boolean hasSiblings() {
        return !children.isEmpty();
    }

    public @NotNull List<@NotNull Node> getChildren() {
        return ImmutableList.copyOf(children);
    }

    @NotNull
    public Node children(@NotNull Node @NotNull... children) {
        this.children.addAll(List.of(children));
        return this;
    }


    @NotNull
    public static Node builder(@Nullable Node parent) {
        return new Node(parent, new ArrayList<>());
    }
}
