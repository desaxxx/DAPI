package org.nandayo.dapi.guimanager;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Getter
@ApiStatus.Experimental
@SuppressWarnings("unused")
public class MenuItem {

    private final @Nullable Material material;
    private final @NotNull String name;
    private final @NotNull List<String> lore;
    private final @NotNull List<String> extraLore;
    private final @NotNull List<String> commands;

    public MenuItem(@Nullable Material material, @NotNull String name, @NotNull List<String> lore, @NotNull List<String> extraLore,
                    @NotNull List<String> commands) {
        this.material = material;
        this.name = name;
        this.lore = lore;             /* these lists of strings return new array list due config defaults */
        this.extraLore = extraLore;   /* these lists of strings return new array list due config defaults */
        this.commands = commands;     /* these lists of strings return new array list due config defaults */
    }

    @NotNull
    public static <T extends ConfigurationSection> MenuItem read(@NotNull T section) {
        Material material = Material.getMaterial(section.getString("material",""));
        String name = section.getString("name","");
        List<String> lore = section.getStringList("lore");
        List<String> extraLore = section.getStringList("extraLore");
        List<String> commands = section.getStringList("commands");
        return new MenuItem(material, name, lore, extraLore, commands);
    }
}
