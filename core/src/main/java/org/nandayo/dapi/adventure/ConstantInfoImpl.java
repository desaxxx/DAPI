package org.nandayo.dapi.adventure;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

@Getter
@Setter
@SuppressWarnings("unused")
class ConstantInfoImpl<T,R> implements ConstantInfo {

    private @NotNull String sinceVersion = "4.0.0";
    private @NotNull String key = "---";

    private @Nullable ConstantInfo parent = null;
    private @Nullable KeyChange keyChange = null;
    private @Nullable KeyRemoval keyRemoval = null;
    private @Nullable Depends depends = null;
    private @Nullable Function<T, R> valueFunction = null;
    public ConstantInfoImpl(){}


    @Override
    public @NotNull String sinceVersion() {
        return sinceVersion;
    }

    @Override
    public @NotNull String key() {
        return key;
    }

    @Override
    public @Nullable ConstantInfo parent() {
        return parent;
    }

    @Override
    public @Nullable KeyChange keyChange() {
        return keyChange;
    }

    @Override
    public @Nullable KeyRemoval keyRemoval() {
        return keyRemoval;
    }

    @Override
    public @Nullable Depends depends() {
        return depends;
    }

    @SuppressWarnings("unchecked")
    @Override
    public @Nullable Function<T, R> valueFunction() {
        return valueFunction;
    }

    @Override
    public boolean matches(Node node) {
        String nodeParentKey = node.getParent() == null ? null : node.getParent().getKey();
        ConstantInfo parent = parent();
        /*
         * If the parent is deprecated and has move in enabled, use the grandparent.
         * Example: SHOW_ENTITY_ID_VALUE, HOVER_EVENT_CONTENTS
         */
        if(parent != null && keyRemoval != null && keyRemoval.moveIn() && keyRemoval.childrenToMove().contains(this)) {
            parent = parent.parent();
        }


        // Check key and parent key equality.
        return key.equals(node.getKey())
                && ((parent == null && nodeParentKey == null) || (parent != null && Objects.equals(parent.key(), nodeParentKey)));
    }


    @Override
    public String toString() {
        if(keyRemoval != null) {
            return String.format("Constant[ parent %s, deprecatedKey: %s ]",
                    (parent == null ? "null" : parent.key()),
                    keyRemoval.deprecatedKey());
        }
        return String.format("Constant[ parent: %s, key: %s ]",
                (parent == null ? "null" : parent.key()),
                key);
    }




    static class Builder<T,R> {

        private final ConstantInfoImpl<T,R> constantInfo = new ConstantInfoImpl<>();
        public Builder() {}

        @NotNull
        public ConstantInfoImpl<T,R> build() {
            return constantInfo;
        }


        public Builder<T,R> sinceVersion(String sinceVersion) {
            constantInfo.setSinceVersion(sinceVersion);
            return this;
        }

        public Builder<T,R> parent(ConstantInfo parent) {
            constantInfo.setParent(parent);
            return this;
        }

        public Builder<T,R> keyChange(String deprecatedKey, String newKey) {
            constantInfo.setKeyChange(new KeyChange() {
                @Override
                public @NotNull String deprecatedKey() {
                    return deprecatedKey;
                }

                @Override
                public @NotNull String newKey() {
                    return newKey;
                }
            });
            return this;
        }

        public Builder<T,R> key(String key) {
            constantInfo.setKey(key);
            return this;
        }

        public Builder<T,R> keyRemoval(String deprecatedKey, boolean moveIn, Set<ConstantInfo> childrenToMove) {
            constantInfo.setKeyRemoval(new KeyRemoval() {
                @Override
                public @NotNull String deprecatedKey() {
                    return deprecatedKey;
                }

                @Override
                public boolean moveIn() {
                    return moveIn;
                }

                @Override
                public @NotNull Set<ConstantInfo> childrenToMove() {
                    return childrenToMove;
                }
            });
            return this;
        }

        public Builder<T,R> depends(Depends depends) {
            constantInfo.setDepends(depends);
            return this;
        }

        public Builder<T,R> valueFunction(Function<T, R> valueFunction) {
            constantInfo.setValueFunction(valueFunction);
            return this;
        }
    }
}
