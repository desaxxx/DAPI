package org.nandayo.dapi.adventure;

import com.google.gson.*;

import java.util.Map;

class GsonHelper {

    /**
     * For compatibility between Gson versions 2.8 to 2.11
     * @param element JsonElement
     * @return Copy of element
     * @since 1.4.0
     */
    public static JsonElement deepCopy(JsonElement element) {
        if(element.isJsonObject()) {
            JsonObject obj = (JsonObject) element;
            JsonObject result = new JsonObject();

            for(Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                result.add(entry.getKey(), deepCopy(entry.getValue()));
            }

            return result;
        }
        else if(element.isJsonArray()) {
            JsonArray arr = (JsonArray) element;
            if (arr.size() == 0) {
                return new JsonArray();
            } else {
                JsonArray result = new JsonArray();

                for (JsonElement jsonElement : arr) {
                    result.add(deepCopy(jsonElement));
                }

                return result;
            }
        }
        else if(element.isJsonPrimitive()) {
            return element;
        }
        else {
            return JsonNull.INSTANCE;
        }
    }

    @SuppressWarnings("deprecation")
    public static JsonElement parseJson(String json) {
        return new JsonParser().parse(json);
    }
}
