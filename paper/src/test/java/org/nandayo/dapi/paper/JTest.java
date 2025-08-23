package org.nandayo.dapi.paper;

import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.junit.jupiter.api.Test;
import org.nandayo.dapi.adventure.CompatComponentSerializer;
import org.nandayo.dapi.adventure.ComponentTreeConstantsAdapter;

public class JTest {
    private static final CompatComponentSerializer SERIALIZER = CompatComponentSerializer.newInstance(GsonComponentSerializer.class);

    @Test
    public void test() {
//        String receivedComponentString = ComponentJTest.JSONIFIED;
//        System.out.println("Received");
//        System.out.println(receivedComponentString);
//
//        Component paperComponent = (Component) SERIALIZER.deserialize(receivedComponentString);
//        System.out.println("Translated to Paper Component");
//        System.out.println(SERIALIZER.serialize(paperComponent));

//        String json = SERIALIZER.serialize(ComponentJTest.hover);
//        System.out.println(json);

        String v4_24_0_json = "{\"bold\":true,\"italic\":true,\"underlined\":true,\"strikethrough\":true,\"obfuscated\":true,\"color\":\"aqua\",\"extra\":[{\"bold\":true,\"color\":\"yellow\",\"text\":\" ? Bold Yellow\"},{\"underlined\":true,\"color\":\"#FF4500\",\"text\":\" ? Hex Color (red->orange)\"},{\"italic\":true,\"color\":\"#4B0082\",\"text\":\" ? Gradient-ish\"},{\"color\":\"green\",\"click_event\":{\"action\":\"open_url\",\"url\":\"https://papermc.io/\"},\"hover_event\":{\"action\":\"show_text\",\"value\":{\"color\":\"light_purple\",\"text\":\"You hovered me!\"}},\"text\":\" [Click Me!]\"},{\"color\":\"green\",\"hover_event\":{\"action\":\"show_text\",\"value\":{\"color\":\"light_purple\",\"text\":\"This is a hover text!\"}},\"text\":\"Hover over me! (Text)\"},{\"color\":\"aqua\",\"hover_event\":{\"action\":\"show_item\",\"id\":\"minecraft:diamond_sword\",\"count\":1},\"text\":\"Hover over me! (Item)\"},{\"color\":\"yellow\",\"hover_event\":{\"action\":\"show_entity\",\"id\":\"minecraft:zombie\",\"uuid\":[-2068868124,-410237589,-1539845411,-247678362]},\"text\":\"Hover over me! (Entity)\"},{\"color\":\"blue\",\"insertion\":\"inserted-text\",\"text\":\" [Insertable]\"},{\"color\":\"dark_aqua\",\"translate\":\"block.minecraft.diamond_block\"},{\"color\":\"gold\",\"keybind\":\"key.jump\"},{\"color\":\"red\",\"selector\":\"@p\"},{\"color\":\"dark_purple\",\"score\":{\"name\":\"SomePlayer\",\"objective\":\"dummyObjective\"}},{\"color\":\"yellow\",\"nbt\":\"BlockEntityTag\",\"interpret\":false,\"separator\":\"|\",\"block\":\"^0.0 ^0.0 ^0.0\"},{\"color\":\"gray\",\"nbt\":\"Health\",\"interpret\":false,\"entity\":\"@e[type=armor_stand]\"},{\"nbt\":\"storage_path\",\"interpret\":false,\"separator\":\" | \",\"storage\":\"mynamespace:mystorage\"},{\"extra\":[{\"underlined\":true,\"color\":\"light_purple\",\"text\":\"Child\"}],\"text\":\" Nested \"}],\"text\":\"Hi, Adventure 4.24.0!\"}";
        System.out.println("Received");
        System.out.println(v4_24_0_json);
        String v4_8_1_adapted_json = new ComponentTreeConstantsAdapter(v4_24_0_json, "4.24.0", "4.8.1").doTheJob();
        System.out.println("Adapted");
        System.out.println(v4_8_1_adapted_json);
//        Component paperComponent = (Component) SERIALIZER.deserialize(v4_8_1_adapted_json);
//        String paperString = GsonComponentSerializer.gson().serializeToTree(paperComponent).toString();
//        System.out.println("Serialized");
//        System.out.println(paperString);
    }
}
