package org.nandayo.dapi.util;

import org.bukkit.Color;
import org.jetbrains.annotations.NotNull;
import org.nandayo.dapi.color.DColor;
import org.nandayo.dapi.color.DStyle;
import org.nandayo.dapi.color.StyleTranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @since 1.0, relocated since 1.3.0
 * @see StyleTranslator
 */
@SuppressWarnings("unused")
public class HexUtil {
    /**
     * @since 1.3.2
     */
    @Deprecated(since = "1.3.4", forRemoval = true)
    private static final String COLOR_REGEX = "(?i)(aqua|black|blue|dark_(aqua|blue|gray|green|purple|red)|gray|gold|green|light_purple|red|white|yellow|#[0-9a-f]{6})";
    /**
     * @since 1.2.6
     */
    @Deprecated(since = "1.3.4", forRemoval = true)
    private static final Pattern COLORIZE_PATTERN = Pattern.compile(
            "<(#[0-9A-F]{6}|aqua|black|blue|bold|dark_(aqua|blue|gray|green|purple|red)|gray|gold|green|italic|light_purple|obfuscated|red|reset|strikethrough|underline|white|yellow)>|&(?<hex>#[0-9A-F]{6})",
            Pattern.CASE_INSENSITIVE
    );
    /**
     * @since 1.3.2
     */
    @Deprecated(since = "1.3.4", forRemoval = true)
    private static final Pattern GRADIENT_PATTERN = Pattern.compile("<(#[0-9A-F]{6})>(.*?)</(#[0-9A-F]{6})>", Pattern.CASE_INSENSITIVE);
    /**
     * @since 1.2.7
     */
    @Deprecated(since = "1.3.4", forRemoval = true)
    private static final Pattern LEGACY_COLOR_CODE_PATTERN = Pattern.compile("§([0-9A-FK-OR])", Pattern.CASE_INSENSITIVE);
    /**
     * @since 1.2.7
     */
    @Deprecated(since = "1.3.4", forRemoval = true)
    private static final Pattern LEGACY_HEX_COLOR_PATTERN = Pattern.compile("§x(§[0-9A-F]){6}|&#[0-9A-F]{6}", Pattern.CASE_INSENSITIVE);


    // =================
    // Legacy Start
    // =================

    /**
     * Translate the colors to legacy pattern.
     * @param input Text to translate
     * @return Translated text
     * @since 1.2.7
     */
    @NotNull
    public static String colorize(String input) {
        if (input == null || input.isEmpty()) return "";
        String output = input;

        // order is important
        output = StyleTranslator.applyGradient(output);
        output = StyleTranslator.applyCustomHex(output);
        output = DStyle.applyAlternativeStyleChar(output, '&');

        return output;
    }

    /**
     * @since 1.3.2
     * @deprecated in favor of {@link StyleTranslator#applyGradient(String)}.
     */
    @Deprecated(since = "1.3.4", forRemoval = true)
    private static String applyGradient(String input) {
        return StyleTranslator.applyGradient(input);
    }

    /**
     * @since 1.3.2
     * @deprecated in favor of {@link org.nandayo.dapi.color.DColor#interpolate(Color, Color, float)}.
     */
    @Deprecated(since = "1.3.4", forRemoval = true)
    private static Color interpolate(Color start, Color end, float ratio) {
        return DColor.interpolate(start, end, ratio).getColor();
    }

    // =================
    // Legacy End
    // =================


    // =================
    // MiniMessage Start
    // =================

    /**
     * Translate colors to MiniMessage pattern.
     * @param input Text to translate
     * @return Translated text
     * @since 1.2.7
     */
    @NotNull
    public static String colorToMiniMessage(String input) {
        if (input == null || input.isEmpty()) return "";
        String output = input;

        output = colorize(output);
        output = StyleTranslator.adaptLegacyToMiniMessage(output);

        return output;
    }

    /**
     * @since 1.2.7
     * @deprecated in favor of {@link StyleTranslator#adaptHexLegacyToMiniMessage(String)}.
     */
    @Deprecated(since = "1.3.4", forRemoval = true)
    @NotNull
    public static String legacyHexToMiniMessage(String input) {
        return StyleTranslator.adaptHexLegacyToMiniMessage(input);
    }

    /**
     * @since 1.2.7
     * @deprecated in favor of {@link StyleTranslator#adaptLegacyToMiniMessage(String)}.
     */
    @Deprecated(since = "1.3.4", forRemoval = true)
    @NotNull
    public static String legacyToMiniMessage(String input) {
        return StyleTranslator.adaptLegacyToMiniMessage(input);
    }

    // =================
    // MiniMessage End
    // =================


    /**
     * @since 1.2.7
     */
    public static Map<String, String> PLACEHOLDERS = new HashMap<>();

    /**
     * Replace placeholders in the text, then colorize it.
     * @param text Text to replace and colorize
     * @return Result
     * @since Unknown
     */
    public static String parse(String text) {
        return colorize(replacePlaceholders(text));
    }

    /**
     * Replace placeholders in the text.
     * @param text Text to replace
     * @return Result
     * @since 1.2.6
     */
    public static String replacePlaceholders(String text) {
        if(text == null || text.isEmpty()) return "";
        for(Map.Entry<String, String> entry : PLACEHOLDERS.entrySet()) {
            text = text.replace(entry.getKey(), entry.getValue());
        }
        return text;
    }
}
