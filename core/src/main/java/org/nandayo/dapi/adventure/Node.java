package org.nandayo.dapi.adventure;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nandayo.dapi.util.Validate;

import java.util.*;

@Getter
class Node {
    private Node parent;    // null if the root

    private String key;     // null if inside an array or the root
    private Integer index;  // null if outside an array
    private @NotNull JsonElement element;

    public Node(Node parent, String key, Integer index, JsonElement element) {
        Validate.notNull(element, "Element cannot be null!");

        this.parent = parent;
        this.key = key;
        this.index = index;
        this.element = element;
    }

    public void changeKey(String newKey, boolean override) {
        if(parent == null || key == null) return;
        JsonElement parentElement = parent.getElement();
        if(!parentElement.isJsonObject()) return;

        JsonObject obj = parentElement.getAsJsonObject();
        if(!override && obj.has(newKey)) return;

        JsonElement copy = GsonHelper.deepCopy(element);
        obj.add(newKey, copy);
        obj.remove(key);
        this.key = newKey;
        this.element = copy;
    }
    public void changeKey(String newKey) {
        changeKey(newKey, false);
    }

    public void changeIndex(int newIndex, boolean override) {
        if(parent == null || index == -1) return;
        JsonElement parentElement = parent.getElement();
        if(!parentElement.isJsonArray()) return;

        JsonArray array = parentElement.getAsJsonArray();
        if(newIndex >= array.size()) return;

        JsonElement copy = GsonHelper.deepCopy(element);
        if(override) {
            array.set(newIndex, copy);
            array.remove(index);
        }else {
            JsonElement other = array.get(newIndex);
            array.set(newIndex, copy);
            array.set(index, other);
        }
        this.index = newIndex;
        this.element = copy;
    }
    public void changeIndex(int newIndex) {
        changeIndex(newIndex, false);
    }

    public void moveToObject(Node newParent) {
        if(parent == null) return;
        JsonElement newParentElement = newParent.element;
        if(!newParentElement.isJsonObject()) return;

        JsonObject obj = newParentElement.getAsJsonObject();
        JsonElement copy = GsonHelper.deepCopy(element);
        destroy();
        obj.add(key, copy);
        this.parent = newParent;
        this.element = copy;
    }

    public void moveToArray(Node newParent) {
        JsonElement newParentElement = newParent.element;
        if(!newParentElement.isJsonArray()) return;

        JsonArray array = newParentElement.getAsJsonArray();
        JsonElement copy = GsonHelper.deepCopy(element);
        array.add(copy);
    }

    public void move(Node newParent) {
        if(newParent == null) return;
        if(newParent.parent.element.isJsonObject()) {
            moveToObject(newParent);
        }else if(newParent.parent.element.isJsonArray()) {
            moveToArray(newParent);
        }
    }

    public void destroy() {
        if(parent == null) return;
        JsonElement parentElement = parent.getElement();
        if(parentElement.isJsonObject()) {
            parentElement.getAsJsonObject().remove(key);
        }
        else if(parentElement.isJsonArray()) {
            parentElement.getAsJsonArray().remove(index);
        }
    }

    @Nullable
    public Node makeSibling(String key, JsonElement delegate) {
        if(parent == null) return null;
        JsonElement parentElement = parent.getElement();

        JsonElement sibling = GsonHelper.deepCopy(delegate);
        if(parentElement.isJsonObject()) {
            parentElement.getAsJsonObject().add(key, sibling);
            return new Node(parent, key, null, sibling);
        }else if(parentElement.isJsonArray()) {
            JsonArray array = parentElement.getAsJsonArray();
            array.add(sibling);
            return new Node(parent, null, array.size()-1, sibling);
        }
        return null;
    }

    @Nullable
    public Node makeChild(String key, JsonElement delegate) {
        JsonElement child = GsonHelper.deepCopy(delegate);
        if(element.isJsonObject()) {
            element.getAsJsonObject().add(key, child);
            return new Node(this, key, null, child);
        }else if(element.isJsonArray()) {
            JsonArray array = element.getAsJsonArray();
            array.add(child);
            return new Node(this, null, array.size()-1, child);
        }
        return null;
    }



    @NotNull
    public List<Node> getSiblingsOr(Collection<Node> def) {
        if(parent == null) return new ArrayList<>(def);
        JsonElement parentElement = parent.getElement();
        if(parentElement.isJsonObject()) {
            List<Node> siblings = new ArrayList<>();

            for (Map.Entry<String, JsonElement> entry: parentElement.getAsJsonObject().entrySet()) {
                siblings.add(new Node(parent, entry.getKey(), null, entry.getValue()));
            }
            return siblings;
        }
        else if(parentElement.isJsonArray()) {
            JsonArray arr = parent.element.getAsJsonArray();
            List<Node> siblings = new ArrayList<>();

            for(int i = 0; i < arr.size(); i++) {
                siblings.add(new Node(parent, null, i, arr.get(i)));
            }
            return siblings;
        }
        return new ArrayList<>(def);
    }

    @Nullable
    public List<Node> getSiblings() {
        if(parent == null) return null;
        JsonElement parentElement = parent.getElement();
        if(parentElement.isJsonObject()) {
            List<Node> siblings = new ArrayList<>();

            for (Map.Entry<String, JsonElement> entry: parentElement.getAsJsonObject().entrySet()) {
                siblings.add(new Node(parent, entry.getKey(), null, entry.getValue()));
            }
            return siblings;
        }
        else if(parentElement.isJsonArray()) {
            JsonArray arr = parent.element.getAsJsonArray();
            List<Node> siblings = new ArrayList<>();

            for(int i = 0; i < arr.size(); i++) {
                siblings.add(new Node(parent, null, i, arr.get(i)));
            }
            return siblings;
        }
        return null;
    }

    @NotNull
    public List<Node> getChildrenOr(Collection<Node> def) {
        if(element.isJsonObject()) {
            List<Node> children = new ArrayList<>();

            for(Map.Entry<String, JsonElement> entry: element.getAsJsonObject().entrySet()) {
                children.add(new Node(this, entry.getKey(), null, entry.getValue()));
            }
            return children;
        }
        else if(element.isJsonArray()) {
            JsonArray arr = element.getAsJsonArray();
            List<Node> children = new ArrayList<>();

            for(int i = 0; i < arr.size(); i++) {
                children.add(new Node(this, null, i, arr.get(i)));
            }
            return children;
        }
        return new ArrayList<>(def);
    }

    @Nullable
    public List<Node> getChildren() {
        if(element.isJsonObject()) {
            List<Node> children = new ArrayList<>();

            for(Map.Entry<String, JsonElement> entry: element.getAsJsonObject().entrySet()) {
                children.add(new Node(this, entry.getKey(), null, entry.getValue()));
            }
            return children;
        }
        else if(element.isJsonArray()) {
            JsonArray arr = element.getAsJsonArray();
            List<Node> children = new ArrayList<>();

            for(int i = 0; i < arr.size(); i++) {
                children.add(new Node(this, null, i, arr.get(i)));
            }
            return children;
        }
        return null;
    }


    @Override
    public String toString() {
        String p = parent == null ? "root" :
                (parent.key != null ? parent.key :
                        (parent.index != null ? "[" + parent.index + "]" : null));
        if(key == null) {
            return String.format("Node[ parent: %s, index: %s]", p, index);
        }else {
            return String.format("Node[ parent: %s, key: %s]", p, key);
        }
    }
}
