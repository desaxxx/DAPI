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
    @Deprecated(since = "1.4.0", forRemoval = true)
    @NotNull
    public static String legacyHexToMiniMessage(String input) {
        return StyleTranslator.adaptHexLegacyToMiniMessage(input);
    }

    /**
     * @since 1.2.7
     * @deprecated in favor of {@link StyleTranslator#adaptLegacyToMiniMessage(String)}.
     */
    @Deprecated(since = "1.4.0", forRemoval = true)
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
