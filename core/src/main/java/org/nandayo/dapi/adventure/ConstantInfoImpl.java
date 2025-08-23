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
    private @Nullable String deprecatedKey = null;
    private boolean moveIn = false;
    private @Nullable Set<ConstantInfo> childrenToMove = null;
    private @Nullable Depends depends = null;
    private @Nullable Function<T, R> valueFunction = null;
    public ConstantInfoImpl(){}


    @Override
    public @NotNull String sinceVersion() {
        return sinceVersion;
    }

    @Override
    public @Nullable String key() {
        return key;
    }

    @Override
    public @Nullable ConstantInfo parent() {
        return parent;
    }

    @Override
    public @Nullable String deprecatedKey() {
        return deprecatedKey;
    }

    @Override
    public boolean moveIn() {
        return moveIn;
    }

    @Override
    public @Nullable Set<ConstantInfo> childrenToMove() {
        return childrenToMove;
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
        return key.equals(node.getKey())
                && ((parent == null && nodeParentKey == null) || (parent != null && Objects.equals(parent.key(), nodeParentKey)));
    }


    @Override
    public String toString() {
        return String.format("ConstantInfoImpl[ parent: %s, key: %s, deprecatedKey: %s ]",
                (parent == null ? "null" : parent.key()),
                key,
                deprecatedKey);
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
        public Builder<T,R> deprecatedKey(String deprecatedKey) {
            constantInfo.setDeprecatedKey(deprecatedKey);
            return this;
        }
        public Builder<T,R> key(String key) {
            constantInfo.setKey(key);
            return this;
        }
        public Builder<T,R> moveIn(boolean moveIn) {
            constantInfo.setMoveIn(moveIn);
            return this;
        }
        public Builder<T,R> childrenToMove(Set<ConstantInfo> childrenToMove) {
            constantInfo.setChildrenToMove(childrenToMove);
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
