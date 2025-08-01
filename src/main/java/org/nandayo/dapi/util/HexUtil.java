package org.nandayo.dapi.util;

import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"deprecation","unused"})
public class HexUtil {
    private static final String COLOR_REGEX = "(?i)(aqua|black|blue|dark_(aqua|blue|gray|green|purple|red)|gray|gold|green|light_purple|red|white|yellow|#[0-9a-f]{6})";
    private static final Pattern COLORIZE_PATTERN = Pattern.compile(
            "<(#[0-9A-F]{6}|aqua|black|blue|bold|dark_(aqua|blue|gray|green|purple|red)|gray|gold|green|italic|light_purple|obfuscated|red|reset|strikethrough|underline|white|yellow)>|&(?<hex>#[0-9A-F]{6})",
            Pattern.CASE_INSENSITIVE
    );
    private static final Pattern LEGACY_COLOR_CODE_PATTERN = Pattern.compile("§([0-9A-FK-OR])", Pattern.CASE_INSENSITIVE);
    private static final Pattern LEGACY_HEX_COLOR_PATTERN = Pattern.compile("§x(§[0-9A-F]){6}|&#[0-9A-F]{6}", Pattern.CASE_INSENSITIVE);


    @NotNull
    static public String colorize(String text) {
        if (text == null || text.isEmpty()) return "";

        final Matcher matcher = COLORIZE_PATTERN.matcher(text);
        while (matcher.find()) {
            try {
                String original = matcher.group(); // <#RRGGBB>, <aqua>, &#RRGGBB
                String color = matcher.group(1);
                color = color != null ? color : matcher.group("hex"); // #RRGGBB, aqua
                ChatColor chatColor = ChatColor.of(color);

                if (chatColor != null) {
                    text = text.replace(original, chatColor.toString()); // toString() -> e.g. §a
                }
            } catch (IllegalArgumentException ignored) {}
        }

        return ChatColor.translateAlternateColorCodes('&', text);
    }

    @NotNull
    public static String colorToMiniMessage(String text) {
        if (text == null || text.isEmpty()) return "";
        // Translate & to §
        text = ChatColor.translateAlternateColorCodes('&', text);

        // Don't translate <#RRGGBB> or <namedColor>

        // Translate §x§f§f§f§f§f§f and &#ffffff to <#ffffff>, this should be handled before #legacyToMiniMessage()
        text = legacyHexToMiniMessage(text);
        // Translate §a, §b to <reset><green>, <reset><aqua>
        //           §l, §r to <bold>, <reset>
        text = legacyToMiniMessage(text);

        return text;
    }

    /**
     * Translates Minecraft HEX style to MiniMessage HEX format<br>
     * §x§f§f§f§f§f§f | &#ffffff -> <#ffffff>
     * @param text Text to translate
     * @return Result
     */
    @NotNull
    static public String legacyHexToMiniMessage(String text) {
        if (text == null || text.isEmpty()) return "";

        final Matcher matcher = LEGACY_HEX_COLOR_PATTERN.matcher(text);
        while(matcher.find()) {
            String original = matcher.group(); // -> §x§f§f§f§f§f§f | &#ffffff
            String hex = original.replace("§","").replace("&","").substring(1); // -> xffffff | #ffffff -> ffffff
            text = text.replace(original, "<#" + hex + ">"); // -> <#fffff>
        }
        return text;
    }

    /**
     * Translates Minecraft color to MiniMessage color format<br>
     * §f -> <white>
     * @param text Text to translate
     * @return Result
     */
    @NotNull
    static public String legacyToMiniMessage(String text) {
        if (text == null || text.isEmpty()) return "";

        Matcher matcher = LEGACY_COLOR_CODE_PATTERN.matcher(text);
        while(matcher.find()) {
            String original = matcher.group();
            char code = matcher.group(1).charAt(0); // -> f

            ChatColor chatColor = ChatColor.getByChar(code); // WHITE
            if(chatColor != null) {
                String name = chatColor.getName().equals("underline") ? "underlined" : chatColor.getName(); // white
                String replacement = "<" + name + ">";
                if(name.matches(COLOR_REGEX)) {
                    // adding <reset> since legacy colors additionally resets decoration after color change.
                    replacement = "<reset>" + replacement;
                }
                text = text.replace(original, replacement); // -> <reset><white> or <bold>
            }
        }
        return text;
    }



    static public Map<String, String> PLACEHOLDERS = new HashMap<>();

    /**
     * Replace placeholders in the text, then colorize it.
     * @param text Text to replace and colorize
     * @return Result
     */
    static public String parse(String text) {
        return colorize(replacePlaceholders(text));
    }

    /**
     * Replace placeholders in the text.
     * @param text Text to replace
     * @return Result
     */
    static public String replacePlaceholders(String text) {
        if(text == null || text.isEmpty()) return "";
        for(Map.Entry<String, String> entry : PLACEHOLDERS.entrySet()) {
            text = text.replace(entry.getKey(), entry.getValue());
        }
        return text;
    }
}
