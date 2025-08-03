package org.nandayo.dapi.util;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Color;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @since 1.0, relocated since 1.3.0
 */
@SuppressWarnings({"deprecation","unused"})
public class HexUtil {
    /**
     * @since 1.3.2
     */
    private static final String COLOR_REGEX = "(?i)(aqua|black|blue|dark_(aqua|blue|gray|green|purple|red)|gray|gold|green|light_purple|red|white|yellow|#[0-9a-f]{6})";
    /**
     * @since 1.2.6
     */
    private static final Pattern COLORIZE_PATTERN = Pattern.compile(
            "<(#[0-9A-F]{6}|aqua|black|blue|bold|dark_(aqua|blue|gray|green|purple|red)|gray|gold|green|italic|light_purple|obfuscated|red|reset|strikethrough|underline|white|yellow)>|&(?<hex>#[0-9A-F]{6})",
            Pattern.CASE_INSENSITIVE
    );
    /**
     * @since 1.3.2
     */
    private static final Pattern GRADIENT_PATTERN = Pattern.compile("<(#[0-9A-F]{6})>(.*?)</(#[0-9A-F]{6})>", Pattern.CASE_INSENSITIVE);
    /**
     * @since 1.2.7
     */
    private static final Pattern LEGACY_COLOR_CODE_PATTERN = Pattern.compile("§([0-9A-FK-OR])", Pattern.CASE_INSENSITIVE);
    /**
     * @since 1.2.7
     */
    private static final Pattern LEGACY_HEX_COLOR_PATTERN = Pattern.compile("§x(§[0-9A-F]){6}|&#[0-9A-F]{6}", Pattern.CASE_INSENSITIVE);


    // =================
    // Legacy Start
    // =================

    /**
     * Translate the colors to legacy pattern.
     * @param text Text to translate
     * @return Translated text
     * @since 1.2.7
     */
    @NotNull
    static public String colorize(String text) {
        if (text == null || text.isEmpty()) return "";

        text = applyGradient(text);

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

    /**
     * Translate <#RRGGBB>Content</#RRGGBB> to <#RRGGBB>C<#RRGGBB>o<#RRGGBB>n<#RRGGBB>t<#RRGGBB>e<#RRGGBB>n<#RRGGBB>t.
     * @param text Text to translate
     * @return Translated text
     * @since 1.3.2
     */
    static private String applyGradient(String text) {
        if (text == null || text.isEmpty()) return "";

        final Matcher matcher = GRADIENT_PATTERN.matcher(text);
        while (matcher.find()) {
            String original = matcher.group();
            String start = matcher.group(1); // #RRGGBB
            String content = matcher.group(2);
            String end = matcher.group(3); // #RRGGBB

            Color startColor = Color.fromRGB(Integer.parseInt(start.substring(1), 16));
            Color endColor = Color.fromRGB(Integer.parseInt(end.substring(1), 16));

            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < content.length(); i++) {
                Color color = interpolate(startColor, endColor,  (float) i / (content.length()-1));
                String hex = String.format("%06X", color.asRGB()); // RRGGBB
                builder.append("<#").append(hex).append(">").append(content.charAt(i)); // <#RRGGBB>C
            }
            text = text.replace(original, builder.toString());
        }
        return text;
    }

    /**
     * Interpolate the colors with given ratio.
     * @param start Start color
     * @param end End color
     * @param ratio Ratio
     * @return Color
     * @since 1.3.2
     */
    static private Color interpolate(Color start, Color end, float ratio) {
        int red = (int) (start.getRed() + ratio * (end.getRed() - start.getRed()));
        int green = (int) (start.getGreen() + ratio * (end.getGreen() - start.getGreen()));
        int blue = (int) (start.getBlue() + ratio * (end.getBlue() - start.getBlue()));
        return Color.fromRGB(red, green, blue);
    }

    // =================
    // Legacy End
    // =================


    // =================
    // MiniMessage Start
    // =================

    /**
     * Translate colors to MiniMessage pattern.
     * @param text Text to translate
     * @return Translated text
     * @since 1.2.7
     */
    @NotNull
    public static String colorToMiniMessage(String text) {
        if (text == null || text.isEmpty()) return "";
        // Translate & to §
        text = ChatColor.translateAlternateColorCodes('&', text);

        // Translate <#RRGGBB>ABC</#RRGGBB> to <#RRGGBB>A<#RRGGBB>B<#RRGGBB>C
        text = applyGradient(text);

        // Don't translate <#RRGGBB> or <namedColor>

        // Translate §x§f§f§f§f§f§f and &#ffffff to <#ffffff>, this should be handled before #legacyToMiniMessage()
        // TODO: need to add <reset> before hex colors, <#RRGGBB>(?not sure), &#RRGGBB
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
     * @since 1.2.7
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
     * @since 1.2.7
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

    // =================
    // MiniMessage End
    // =================


    /**
     * @since 1.2.7
     */
    static public Map<String, String> PLACEHOLDERS = new HashMap<>();

    /**
     * Replace placeholders in the text, then colorize it.
     * @param text Text to replace and colorize
     * @return Result
     * @since Unknown
     */
    static public String parse(String text) {
        return colorize(replacePlaceholders(text));
    }

    /**
     * Replace placeholders in the text.
     * @param text Text to replace
     * @return Result
     * @since 1.2.6
     */
    static public String replacePlaceholders(String text) {
        if(text == null || text.isEmpty()) return "";
        for(Map.Entry<String, String> entry : PLACEHOLDERS.entrySet()) {
            text = text.replace(entry.getKey(), entry.getValue());
        }
        return text;
    }
}
