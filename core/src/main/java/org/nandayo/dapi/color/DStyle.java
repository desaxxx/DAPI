package org.nandayo.dapi.color;

import org.jetbrains.annotations.NotNull;

/**
 * @since 1.4.0
 */
@SuppressWarnings("unused")
public interface DStyle {
    char LEGACY_STYLE_CHAR = '§';
    char LEGACY_ALTERNATIVE_STYLE_CHAR = '&';
    String LEGACY_STYLE_CODES = "0123456789ABCDEFKLMNORabcdefklmnorx";

    String insertLegacyStyleChar();


    @NotNull
    static String applyAlternativeStyleChar(final String input, char alternativeChar) {
        if(input == null || input.isEmpty()) return "";
        char[] output = input.toCharArray();

        for(int i = 0; i < output.length - 1; i++) {
            if(output[i] == alternativeChar && LEGACY_STYLE_CODES.indexOf(output[i+1]) != -1) {
                output[i] = LEGACY_STYLE_CHAR;
            }
        }
        return new String(output);
    }
}
