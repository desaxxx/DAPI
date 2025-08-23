package org.nandayo.dapi.adventure;

import com.google.gson.*;
import org.jetbrains.annotations.ApiStatus;
import org.nandayo.dapi.util.DAPIException;
import org.nandayo.dapi.util.Util;
import org.nandayo.dapi.util.Validate;

import java.util.*;
import java.util.stream.Collectors;

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
            .deprecatedKey("clickEvent")
            .key("click_event").build();
    private static final ConstantInfo CLICK_EVENT_URL       = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(CLICK_EVENT)
            .deprecatedKey("value")
            .key("url").build();
    private static final ConstantInfo CLICK_EVENT_PATH      = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(CLICK_EVENT)
            .deprecatedKey("value")
            .key("path").build();
    private static final ConstantInfo CLICK_EVENT_COMMAND   = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(CLICK_EVENT)
            .deprecatedKey("value")
            .key("command").build();
    private static final ConstantInfo CLICK_EVENT_PAGE      = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(CLICK_EVENT)
            .deprecatedKey("value")
            .key("page").build();
    private static final ConstantInfo HOVER_EVENT           = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .deprecatedKey("hoverEvent")
            .key("hover_event").build();
    /**
     * This was used instead of {@link #SHOW_ENTITY_UUID} before 4.21.0
     * It took the place of {@link #SHOW_ENTITY_TYPE} as {@link #SHOW_ENTITY_UUID} is added.
     */
    private static final ConstantInfo SHOW_ENTITY_ID        = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(HOVER_EVENT)
            .deprecatedKey("type")
            .key("id").build();
    private static final ConstantInfo SHOW_ENTITY_TYPE      = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(HOVER_EVENT)
            .deprecatedKey("type").build();
    private static final ConstantInfo SHOW_ENTITY_UUID      = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(HOVER_EVENT)
            .deprecatedKey("id")
            .key("uuid")
            .depends(() -> Set.of(SHOW_ENTITY_ID)).build();
    private static final ConstantInfo HOVER_EVENT_CONTENTS  = new ConstantInfoImpl.Builder<>().sinceVersion("4.21.0")
            .parent(HOVER_EVENT)
            .deprecatedKey("contents")
            .moveIn(true)
            .childrenToMove(Set.of(SHOW_ENTITY_ID, SHOW_ENTITY_TYPE))
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
                debug("Searching child " + child);
                traverseJson(child, relatedConstants); // traverse child first

                JsonElement childElementCopy = GsonHelper.deepCopy(child.getElement());

                Optional<ConstantInfo> constantOpt = ConstantInfo.find(child, relatedConstants);
                if(constantOpt.isPresent()) {
                    ConstantInfo constant = constantOpt.get();
                    debug("  Found constant for the child.");
                    if(loadedConstants.contains(constant)) {
                        debug("  This constant is already loaded, skipping...");
                        continue;
                    }

                    // Check for dependence
                    Depends depends = constant.depends();
                    if(depends != null) {
                        debug("  A dependant constant.");
                        Set<ConstantInfo> dependants = depends.dependantsWithin(relatedConstants);
                        if(!loadedConstants.containsAll(dependants)) {
                            debug("    Dependant constants wasn't loaded, so sending " + child + " to the last of the line.");
                            deque.addLast(child);
                            continue;
                        }
                        debug("    It doesn't have a dependent constant or it's already loaded.");
                    }
                    try {
                        String deprecatedKey = constant.deprecatedKey();
                        debug("    Changing " + child.getKey() + " to " + deprecatedKey);
                        child.changeKey(deprecatedKey, true);
                    } catch (DAPIException ignored) {}

                    // Schedule parent move event
                    ConstantInfo parentConstant = findParentConstant(constant, relatedConstants);
                    if(parentConstant != null && !loadedConstants.contains(parentConstant)) { // so that another child doesn't run it again.
                        debug("  A parent constant that contains the child, scheduling.");
                        parentRunnable = () -> {
                            if(parentConstant.moveIn()) {
                                debug("    Moving in.");
                                String parentDeprecatedKey = parentConstant.deprecatedKey();
                                if(parentDeprecatedKey == null) {
                                    debug("    Deprecated key is null, skipping.");
                                }else {
                                    Node newParent = current.makeChild(parentConstant.deprecatedKey(), new JsonObject());
                                    if (newParent == null) {
                                        debug("    Failed to make new parent, skipping");
                                    } else {
                                        moveInObject(current, newParent, parentConstant);
                                    }
                                }
                            }else {
                                child.destroy();
                                debug("    Move in is disabled, destroying.");
                            }
                        };
                        // mark parent constant as loaded
                        loadedConstants.add(parentConstant);
                    }
                    // Mark the child constant as loaded
                    loadedConstants.add(constant);
                }
            }
            if(parentRunnable != null) {
                debug("    Running parent constant runnable.");
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

    private void moveInObject(Node current, Node newParent, ConstantInfo parentConstant) {
        Set<ConstantInfo> childrenToMove = parentConstant.childrenToMove();
        childrenToMove = childrenToMove == null ? new HashSet<>() : childrenToMove;
        Set<String> childrenNames = childrenToMove.stream().map(ConstantInfo::key).collect(Collectors.toSet());
        JsonElement curr = current.getElement();
        JsonElement parent = newParent.getElement();
        if(!curr.isJsonObject() || !parent.isJsonObject()) return;

        for(Node child : current.getChildrenOr(new ArrayList<>())) {
            if(!childrenNames.contains(child.getKey())) continue;
            child.moveToObject(newParent);
            debug("    Moved in " + child + " to " + parent);
        }
    }

    private void undoTransferArray(Node current, Node newParent) {
        JsonElement curr = current.getElement();
        JsonElement parent = newParent.getElement();
        if(!curr.isJsonArray() || !parent.isJsonArray()) return;

        for(Node child : current.getChildrenOr(new ArrayList<>())) {
            child.moveToArray(newParent);
            debug("    Moved in keys " + child + " to " + parent);
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
                    Set<ConstantInfo> children = constant.childrenToMove();
                    return children != null && children.contains(child);
                })
                .findFirst().orElse(null);
    }


    private static String convertUUID(int[] ints) {
        long most = ((long) ints[0] << 32) | (ints[1] & 0xFFFFFFFFL);
        long least = ((long) ints[2] << 32) | (ints[3] & 0xFFFFFFFFL);
        return new UUID(most, least).toString();
    }
}
