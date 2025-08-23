package org.nandayo.dapi.adventure;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.BlockNBTComponent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.jetbrains.annotations.ApiStatus;

import java.util.UUID;

@ApiStatus.Experimental
@ApiStatus.Internal
public class ComponentJTest {

    public static final CompatComponentSerializer SERIALIZER = CompatComponentSerializer.newInstance(GsonComponentSerializer.class);

    @SuppressWarnings("UnstableApiUsage")
    public static final Component v4_24_0__1_21_8 = Component.text("Hi, Adventure 4.24.0!")
            // Basic formatting
            .color(NamedTextColor.AQUA)
            .decorate(TextDecoration.BOLD)
            .decorate(TextDecoration.UNDERLINED)
            .decorate(TextDecoration.ITALIC)
            .decorate(TextDecoration.STRIKETHROUGH)
            .decorate(TextDecoration.OBFUSCATED)

            // Append different styles
            .append(Component.text(" ⚡ Bold Yellow")
                    .color(NamedTextColor.YELLOW)
                    .decorate(TextDecoration.BOLD))

            .append(Component.text(" 🔥 Hex Color (red->orange)")
                    .color(TextColor.color(0xFF4500))
                    .decorate(TextDecoration.UNDERLINED))

            .append(Component.text(" 🎨 Gradient-ish")
                    .color(TextColor.color(0x4B0082))
                    .decorate(TextDecoration.ITALIC))

            // Click + Hover Events
            .append(Component.text(" [Click Me!]")
                    .color(NamedTextColor.GREEN)
                    .clickEvent(ClickEvent.openUrl("https://papermc.io/"))
                    .hoverEvent(HoverEvent.showText(
                            Component.text("You hovered me!").color(NamedTextColor.LIGHT_PURPLE))))

            // Text hover
            .append(Component.text("Hover over me! (Text)")
                    .color(NamedTextColor.GREEN)
                    .hoverEvent(HoverEvent.showText(
                            Component.text("This is a hover text!").color(NamedTextColor.LIGHT_PURPLE))))

            // Item hover
            .append(Component.text("Hover over me! (Item)")
                    .color(NamedTextColor.AQUA)
                    .hoverEvent(HoverEvent.showItem(
                            HoverEvent.ShowItem.of(Key.key("minecraft", "diamond_sword"), 1))))

            // Entity hover
            .append(Component.text("Hover over me! (Entity)")
                    .color(NamedTextColor.YELLOW)
                    .hoverEvent(HoverEvent.showEntity(
                            HoverEvent.ShowEntity.of(Key.key("minecraft","zombie"),UUID.randomUUID()))))


            // Insertion (shift-click)
            .append(Component.text(" [Insertable]")
                    .color(NamedTextColor.BLUE)
                    .insertion("inserted-text"))

            // Translatable component
            .append(Component.translatable("block.minecraft.diamond_block")
                    .color(NamedTextColor.DARK_AQUA))

            // Keybind component
            .append(Component.keybind("key.jump")
                    .color(NamedTextColor.GOLD))

            // Selector component
            .append(Component.selector("@p")
                    .color(NamedTextColor.RED))

            // Score component
            .append(Component.score("SomePlayer", "dummyObjective")
                    .color(NamedTextColor.DARK_PURPLE))

            // NBT Components
            .append(Component.blockNBT("BlockEntityTag", false, Component.text("|"), BlockNBTComponent.Pos.fromString("^0 ^0 ^0"))
                    .color(NamedTextColor.YELLOW))

            // Entity Component
            .append(Component.entityNBT("Health", "@e[type=armor_stand]")
                    .color(NamedTextColor.GRAY))

            // Storage Component
            .append(Component.storageNBT("storage_path", false, Component.text(" | "), Key.key("mynamespace", "mystorage")))

            // Complex nested example
            .append(Component.text(" Nested ")
                    .append(Component.text("Child", NamedTextColor.LIGHT_PURPLE)
                            .decorate(TextDecoration.UNDERLINED)))
            ;


    public static String jsonify() {
        return SERIALIZER.serialize(v4_24_0__1_21_8);
    }
}
