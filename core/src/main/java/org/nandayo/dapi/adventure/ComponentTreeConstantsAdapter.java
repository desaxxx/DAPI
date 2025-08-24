package org.nandayo.dapi.adventure;

import com.google.gson.*;
import org.jetbrains.annotations.ApiStatus;
import org.nandayo.dapi.util.Util;
import org.nandayo.dapi.util.Validate;

import java.util.*;

/**
 * @since 1.4.0
 */
@SuppressWarnings("unused")
@ApiStatus.Experimental
public class ComponentTreeConstantsAdapter {
    private static final boolean DEBUG = true;
    private static void debug(String msg) {
        if(!DEBUG) return;
        System.err.println(msg);
    }

    // ===================
    // Constant changes
    // ===================

    // since 4.21.0
    // https://github.com/KyoriPowered/adventure/commit/5346fc54d9f802b7a8eacb7e3f479db5f7769d4d
    private static final ConstantInfo CLICK_EVENT           = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .key("click_event")
            .keyChange("clickEvent", "click_event").build();
    private static final ConstantInfo CLICK_EVENT_URL       = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(CLICK_EVENT)
            .key("url")
            .keyChange("value", "url").build();
    private static final ConstantInfo CLICK_EVENT_PATH      = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(CLICK_EVENT)
            .key("path")
            .keyChange("value", "path").build();
    private static final ConstantInfo CLICK_EVENT_COMMAND   = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(CLICK_EVENT)
            .key("command")
            .keyChange("value", "command").build();
    private static final ConstantInfo CLICK_EVENT_PAGE      = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(CLICK_EVENT)
            .key("page")
            .keyChange("value", "page").build();
    private static final ConstantInfo HOVER_EVENT           = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .key("hover_event")
            .keyChange("hoverEvent", "hover_event").build();
    /**
     * This was used instead of {@link #SHOW_ENTITY_UUID} before 4.21.0
     * It took the place of {@link #SHOW_ENTITY_TYPE} as {@link #SHOW_ENTITY_UUID} is added.
     */
    private static final ConstantInfo SHOW_ENTITY_ID        = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(HOVER_EVENT)
            .key("id")
            .keyChange("type", "id").build();
    private static final ConstantInfo SHOW_ENTITY_TYPE      = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(HOVER_EVENT)
            .keyRemoval("type", false, Set.of()).build();
    private static final ConstantInfo SHOW_ENTITY_UUID      = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(HOVER_EVENT)
            .key("uuid")
            .keyChange("id", "uuid")
            .depends(() -> Set.of(SHOW_ENTITY_ID)).build();
    private static final ConstantInfo HOVER_EVENT_CONTENTS  = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(HOVER_EVENT)
            .keyRemoval("contents", true, Set.of(SHOW_ENTITY_ID, SHOW_ENTITY_TYPE))
            .depends(() -> Set.of(SHOW_ENTITY_ID, SHOW_ENTITY_TYPE)).build();


    // since 4.15.0
    // https://github.com/KyoriPowered/adventure/commit/540653a2342e57758437a8afd59789ce2b1f62d9
    /**
     * This used to be a UUID String but then converted to 4 ints of array.
     */
    private static final ConstantInfo SHOW_ENTITY_ID_VALUE  = new ConstantInfoImpl.Builder<int[], String>().sinceVersion("4.15.0")
            .parent(HOVER_EVENT_CONTENTS)
            .key("id")
            .valueFunction(ComponentTreeConstantsAdapter::convertUUID).build();


    private static final List<ConstantInfo> UNSTABLE_CONSTANT_INFO_LIST = List.of(
            /* 4.21.0 */
            CLICK_EVENT, CLICK_EVENT_URL, CLICK_EVENT_PATH, CLICK_EVENT_COMMAND, CLICK_EVENT_PAGE,
            HOVER_EVENT, HOVER_EVENT_CONTENTS, SHOW_ENTITY_ID, SHOW_ENTITY_TYPE, SHOW_ENTITY_UUID,
            /* 4.15.0 */
            SHOW_ENTITY_ID_VALUE
            );




    private final String receivedJson;
    private final int componentVersion;
    private final int aimingVersion;
    private final boolean backwards;
    public ComponentTreeConstantsAdapter(String receivedJson, String componentVersion, String aimingVersion) {
        Validate.notNull(receivedJson, "Received json string cannot be null.");
        Validate.notNull(componentVersion, "Component version cannot be null.");
        this.receivedJson = receivedJson;
        this.componentVersion = Util.parseVersion(componentVersion);
        this.aimingVersion = Util.parseVersion(aimingVersion);
        this.backwards = this.aimingVersion < this.componentVersion;
    }

    public String doTheJob() {
        // Adventure already has onwards compatibility. (todo not fully tested)
        if(!backwards) return receivedJson;
        JsonElement json = GsonHelper.parseJson(receivedJson);
        if(!json.isJsonObject()) return receivedJson;
        JsonObject rootObject = json.getAsJsonObject();

        List<ConstantInfo> relatedInfos = getRelatedConstantInfos();
        debug("Related infos: " + relatedInfos);
        traverseJson(new Node(null, null, null, rootObject), relatedInfos);

        return rootObject.toString();
    }

    /*
     * NOTES since I don't get json.
     * currentKey is null when the parent is a JsonArray.
     * "parent": [ {} ]; "parent": [ 1,2 ]; "parent": [ [], [] ]
     *
     * parentKey is null when it's the root of the json.
     * parent is null when it's the root of the json.
     */
    private void traverseJson(Node current, List<ConstantInfo> relatedConstants) {
        JsonElement curr = current.getElement();
        /* Visualization
         * "currentKey": { -> current
         *   "childKey": "childValue"
         *   "childArray": [] -> childValue
         * }
         */
        if (curr.isJsonObject()) {
            JsonObject obj = curr.getAsJsonObject();
            Runnable parentRunnable = null;
            Set<ConstantInfo> loadedConstants = new HashSet<>();
            Deque<Node> deque = new ArrayDeque<>(current.getChildrenOr(new ArrayList<>()));

            while (!deque.isEmpty()) {
                Node child = deque.pop();
                debug("[1] Searching constant for child " + child);
                traverseJson(child, relatedConstants); // traverse child first

                JsonElement childElementCopy = GsonHelper.deepCopy(child.getElement());

                List<ConstantInfo> constants = ConstantInfo.find(child, relatedConstants);
                for(ConstantInfo constant : constants) {
                    debug("  [2] Found constant for the child. " + constant);
                    if(loadedConstants.contains(constant)) {
                        debug("  [2.1] This constant is already loaded, skipping...");
                        break;
                    }

                    // Check for dependence
                    Depends depends = constant.depends();
                    if(depends != null) {
                        debug("  [2.2] A dependant constant.");
                        Set<ConstantInfo> dependants = depends.dependantsWithin(relatedConstants);
                        if(!loadedConstants.containsAll(dependants)) {
                            debug("    [3] Dependant constants wasn't loaded, sending the child to last of the line.");
                            deque.addLast(child);
                            break;
                        }
                        debug("    [3] It doesn't have a dependent constant or it's already loaded.");
                    }
                    KeyChange keyChange = constant.keyChange();
                    if(keyChange != null) {
                        debug("  [2.3] Key change found, changing to '" + keyChange.deprecatedKey() + "'");
                        child.changeKey(keyChange.deprecatedKey(), true);
                    }

                    // Schedule parent move event
                    if(parentRunnable == null) {
                        ConstantInfo parentConstant = findParentConstant(constant, relatedConstants);
                        if (parentConstant != null && !loadedConstants.contains(parentConstant)) { // so that another child doesn't run it again.
                            debug("  [2.4] A parent constant found. " + parentConstant);
                            parentRunnable = () -> {
                                KeyRemoval keyRemoval = parentConstant.keyRemoval();
                                if (keyRemoval != null && keyRemoval.moveIn()) {
                                    debug("    [3] Moving in children of parent constant.");
                                    String parentDeprecatedKey = keyRemoval.deprecatedKey();
                                    Node newParent = current.makeChild(keyRemoval.deprecatedKey(), new JsonObject());
                                    if (newParent == null) {
                                        debug("      [4] Failed to make new parent, skipping");
                                    } else {
                                        moveInObject(current, newParent, keyRemoval);
                                    }
                                } else {
                                    child.destroy();
                                    debug("    [3] Move in is disabled, destroying.");
                                }
                            };
                            // mark parent constant as loaded
                            loadedConstants.add(parentConstant);
                        }
                    }
                    // Mark the child constant as loaded
                    loadedConstants.add(constant);
                }
            }
            if(parentRunnable != null) {
                debug("    [3] Running parent constant runnable.");
                parentRunnable.run();
            }
        }
        /* Visualization
         * "parentKey": { -> parent
         *   "currentKey": [] -> current
         * }
         *
         * "parentKey": [ -> parent
         *   [], -> current
         *   []
         * ]
         *
         * "currentKey": [ -> current
         *   "text" -> child
         * ]
         */
        else if (curr.isJsonArray()) {
            JsonArray arr = curr.getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
                JsonElement childElement = arr.get(i);
                traverseJson(new Node(current, null, i, childElement), relatedConstants);
            }
        }
    }

    // Collect first :c todo
    private void traverseJsonCollect(Node current, List<ConstantInfo> relatedConstants, Map<Node, List<ConstantInfo>> map) {
        JsonElement curr = current.getElement();
        if (curr.isJsonObject()) {
            JsonObject obj = curr.getAsJsonObject();
            Deque<Node> deque = new ArrayDeque<>(current.getChildrenOr(new ArrayList<>()));

            while (!deque.isEmpty()) {
                Node child = deque.pop();
                debug("[1] Searching constant for child " + child);
                traverseJson(child, relatedConstants); // traverse child first

                JsonElement childElementCopy = GsonHelper.deepCopy(child.getElement());

                List<ConstantInfo> constants = ConstantInfo.find(child, relatedConstants);
                map.put(child, constants);
                for(ConstantInfo constant : constants) {
                    ConstantInfo parentConstant = findParentConstant(constant, relatedConstants);
                    if(parentConstant != null) {
                        map.getOrDefault(current, new ArrayList<>()).add(parentConstant);
                    }
                }
            }
        }
        else if (curr.isJsonArray()) {
            JsonArray arr = curr.getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
                JsonElement childElement = arr.get(i);
                traverseJson(new Node(current, null, i, childElement), relatedConstants);
            }
        }
    }




    private void moveInObject(Node current, Node newParent, KeyRemoval keyRemoval) {
        JsonElement curr = current.getElement();
        JsonElement parent = newParent.getElement();
        if(!curr.isJsonObject() || !parent.isJsonObject()) return;

        for(Node child : current.getChildrenOr(new ArrayList<>())) {
            for(ConstantInfo constant : keyRemoval.childrenToMove()) {
                if(!constant.matches(child)) continue;
                child.moveToObject(newParent);
                debug("    [3] Moved in " + child + " to " + parent);
            }
        }
    }

    private void undoTransferArray(Node current, Node newParent) {
        JsonElement curr = current.getElement();
        JsonElement parent = newParent.getElement();
        if(!curr.isJsonArray() || !parent.isJsonArray()) return;

        for(Node child : current.getChildrenOr(new ArrayList<>())) {
            child.moveToArray(newParent);
            debug("    [3] Moved in keys " + child + " to " + parent);
        }
    }

    private List<ConstantInfo> getRelatedConstantInfos() {
        List<ConstantInfo> list = new ArrayList<>();
        for(ConstantInfo constant : UNSTABLE_CONSTANT_INFO_LIST) {
            // backwards is false, so aiming version is lower than component version.
            int modifyVersion = Util.parseVersion(constant.sinceVersion());
            if(modifyVersion > aimingVersion && modifyVersion <= componentVersion) {
                list.add(constant);
            }
        }
        list.sort(Comparator.reverseOrder());
        return list;
    }

    private ConstantInfo findParentConstant(ConstantInfo child, Collection<ConstantInfo> relatedConstants) {
        return relatedConstants.stream()
                .filter(constant -> {
                    KeyRemoval keyRemoval = constant.keyRemoval();
                    return keyRemoval != null && keyRemoval.childrenToMove().contains(child);
                })
                .findFirst().orElse(null);
    }


    private static String convertUUID(int[] ints) {
        long most = ((long) ints[0] << 32) | (ints[1] & 0xFFFFFFFFL);
        long least = ((long) ints[2] << 32) | (ints[3] & 0xFFFFFFFFL);
        return new UUID(most, least).toString();
    }
}
