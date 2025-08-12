package org.nandayo.dapi.color;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @since 1.3.4
 */
@SuppressWarnings("unused")
@ApiStatus.Experimental
public class StyleTranslator {

    private static final Pattern CUSTOM_GRADIENT_PATTERN = Pattern.compile("<(#[0-9A-F]{6})>(.*?)</(#[0-9A-F]{6})>", Pattern.CASE_INSENSITIVE);
    private static final Pattern CUSTOM_HEX_PATTERN = Pattern.compile("&(#[0-9A-F]{6})", Pattern.CASE_INSENSITIVE);

    private static final Pattern LEGACY_COLOR_PATTERN = Pattern.compile("§([0-9A-F])", Pattern.CASE_INSENSITIVE);
    private static final Pattern LEGACY_DECORATION_PATTERN = Pattern.compile("§([K-OR])", Pattern.CASE_INSENSITIVE);
    private static final Pattern LEGACY_STYLE_PATTERN = Pattern.compile("§([0-9A-FK-OR])", Pattern.CASE_INSENSITIVE);
    private static final Pattern LEGACY_HEX_COLOR_PATTERN = Pattern.compile("§X((§[0-9A-F]){6})", Pattern.CASE_INSENSITIVE);


    //================
    // Appliers
    //================

    /**
     * Apply gradient to given text.
     * @param input {@code <#RRGGBB>}content{@code </#RRGGBB>}
     * @return {@code §X§R§R§G§G§B§B}c{@code §X§R§R§G§G§B§B}o{@code §X§R§R§G§G§B§B}n{@code §X§R§R§G§G§B§B}t{@code §X§R§R§G§G§B§B}e{@code §X§R§R§G§G§B§B}n{@code §X§R§R§G§G§B§B}t
     * @since 1.3.4
     */
    @NotNull
    public static String applyGradient(final String input) {
        if(input == null || input.isEmpty()) return "";
        String output = input;

        final Matcher matcher = CUSTOM_GRADIENT_PATTERN.matcher(output);
        while (matcher.find()) {
            String original = matcher.group();  // -> <#RRGGBB>content</#RRGGBB>
            String start = matcher.group(1);    // start #RRGGBB
            String content = matcher.group(2);  // content
            String end = matcher.group(3);      // end #RRGGBB

            try {
                DColor startColor = DColor.of(start);
                DColor endColor = DColor.of(end);

                StringBuilder builder = new StringBuilder();
                for(int i = 0; i < content.length(); i++) {
                    float ratio = (float) i / Math.max(1.0f, content.length() - 1);
                    DColor color = DColor.interpolate(startColor, endColor, ratio);
                    builder.append(color.insertLegacyStyleChar()).append(content.charAt(i)); // -> §X§R§R§G§G§B§Bc
                }
                output = output.replace(original, builder.toString());
            } catch (Exception ignored) {}
        }
        return output;
    }

    /**
     * Apply custom hex to given text.
     * @param input {@code &#RRGGBB}content
     * @return {@code §X§R§R§G§G§B§B}content
     * @since 1.3.4
     */
    @NotNull
    public static String applyCustomHex(final String input) {
        if(input == null || input.isEmpty()) return "";
        String output = input;

        final Matcher matcher = CUSTOM_HEX_PATTERN.matcher(output);
        while (matcher.find()) {
            String original = matcher.group(); // -> &#RRGGBB
            String rgb = matcher.group(1); // -> #RRGGBB

            try {
                DColor color = DColor.of(rgb);
                output = output.replace(original, color.insertLegacyStyleChar()); // -> §X§R§R§G§G§B§B
            } catch (Exception ignored) {}
        }
        return output;
    }









    //================
    // Adapters
    //================

    /**
     * Adapt legacy colors to MiniMessage format.
     * @param input Text with color codes like {@code §a}, {@code §b}
     * @return Text with MiniMessage color format like {@code <green>}, {@code <aqua>}
     * @since 1.3.4
     */
    @NotNull
    public static String adaptColorLegacyToMiniMessage(final String input) {
        if(input == null || input.isEmpty()) return "";
        String output = input;

        final Matcher matcher = LEGACY_COLOR_PATTERN.matcher(output);
        while (matcher.find()) {
            String original = matcher.group(); // -> §a, §d
            String c = matcher.group(1); // -> a, d

            try {
                DColor color = DColor.getByLegacyCode(c);
                if(color != null) {
                    output = output.replace(original, color.getMiniMessageFormat());
                }
            } catch (Exception ignored) {}
        }
        return output;
    }

    /**
     * Adapt legacy hex colors to MiniMessage format.
     * @param input Text with hex color codes like {@code §x§a§a§f§d§5§5}
     * @return Text with MiniMessage hex color format like {@code <#aafd55>}
     * @since 1.3.4
     */
    @NotNull
    public static String adaptHexLegacyToMiniMessage(final String input) {
        if (input == null || input.isEmpty()) return "";
        String output = input;

        final Matcher matcher = LEGACY_HEX_COLOR_PATTERN.matcher(output);
        while(matcher.find()) {
            String original = matcher.group();                  // -> §x§f§f§f§f§f§f
            String c = matcher.group(1);                        // -> §f§f§f§f§f§f
            String hex = c.replace("§","");    // -> ffffff

            try {
                DColor color = DColor.of(DColor.MINIMESSAGE_HEX_CHAR + hex);
                output = output.replace(original, color.getMiniMessageFormat());
            }catch (Exception ignored) {}
        }
        return output;
    }

    /**
     * Adapt legacy decoration to MiniMessage format.
     * @param input Text with decorations like {@code §k}, {@code §l}
     * @return Text with MiniMessage decoration format like {@code <obfuscated>}, {@code <bold>}
     * @since 1.3.4
     */
    @NotNull
    public static String adaptDecorationLegacyToMiniMessage(final String input) {
        if (input == null || input.isEmpty()) return "";
        String output = input;

        final Matcher matcher = LEGACY_DECORATION_PATTERN.matcher(output);
        while(matcher.find()) {
            String original = matcher.group(); // -> §k, §l
            String d = matcher.group(1); // -> k, l

            try {
                DDecoration decoration = DDecoration.getByLegacyCode(d);
                if(decoration != null) {
                    output = output.replace(original, decoration.getMiniMessageFormat());
                }
            }catch (Exception ignored) {}
        }
        return output;
    }

    /**
     * Adapt legacy style to MiniMessage format.
     * @param input Text with styles like {@code §a}, {@code §b}, {@code §k}, {@code §l}
     * @return Text with MiniMessage decoration format like {@code <green>}, {@code <aqua>}, {@code <obfuscated>}, {@code <bold>}
     * @since 1.3.4
     */
    @NotNull
    public static String adaptStyleLegacyToMiniMessage(final String input) {
        if (input == null || input.isEmpty()) return "";
        String output = input;

        final Matcher matcher = LEGACY_STYLE_PATTERN.matcher(output);
        while(matcher.find()) {
            String original = matcher.group(); // -> §a, §b, §k, §l, §r
            String style = matcher.group(1); // -> a, b, k, l, r

            try {
                DColor color = DColor.getByLegacyCode(style);
                if(color != null) {
                    output = output.replace(original, color.getMiniMessageFormat());
                } else {
                    DDecoration decoration = DDecoration.getByLegacyCode(style);
                    if(decoration != null) {
                        output = output.replace(original, decoration.getMiniMessageFormat());
                    }
                }
            }catch (Exception ignored) {}
        }
        return output;
    }

    /**
     * Adapt legacy hex colors and style to MiniMessage format.
     * @param input Text with hex colors and styles like {@code §x§f§f§5§4§d§c}, {@code §a}, {@code §b}, {@code §k}, {@code §l}
     * @return Text with MiniMessage decoration format like {@code <#ff54dc>}, {@code <green>}, {@code <aqua>}, {@code <obfuscated>}, {@code <bold>}
     * @since 1.3.4
     */
    @NotNull
    public static String adaptLegacyToMiniMessage(final String input) {
        if (input == null || input.isEmpty()) return "";
        String output = input;

        // order is important
        output = adaptHexLegacyToMiniMessage(output); // §X§R§R§G§G§B§B -> <#RRGGBB>
        output = adaptStyleLegacyToMiniMessage(output); // §a, §b, §k, §l, §r -> <green>, <aqua>, <obfuscated>, <bold>, <reset>

        return output;
    }
}
