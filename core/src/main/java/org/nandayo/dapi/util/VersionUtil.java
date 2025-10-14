package org.nandayo.dapi.util;

import java.util.regex.Pattern;

/**
 * A utility class for converting semantic version strings to and from a comparable integer format.
 * This allows for easy and reliable version comparison.
 *
 * @since 1.4.3
 */
public class VersionUtil {

    private static final int VERSION_BASE = 100;

    /**
     * Converts a version string into a single integer for easy comparison.
     * Each part of the version is treated as a digit in a base-100 number system.
     * For example, "2.20.10" becomes 22010. Pre-release tags like "-SNAPSHOT" are ignored.
     *
     * @param version   The version string to convert (e.g., "1.9.0", "2.6").
     * @param separator The literal character or string used to separate version parts (e.g., ".").
     * @return An integer representation of the version.
     */
    public static int intify(String version, String separator) {
        String cleanVersion = version.split("-")[0];
        String[] parts = cleanVersion.split(Pattern.quote(separator));
        int v = 0;
        int multiplier = 1;
        for(int i = parts.length-1; i >= 0; i--) {
            try {
                int num = Integer.parseInt(parts[i]);
                v = v + (num * multiplier);
                multiplier *= VERSION_BASE;
            } catch (NumberFormatException ignored) {}
        }
        return v;
    }

    /**
     * Convenience method to convert a version string using a dot (.) as the default separator.
     *
     * @param version The version string to convert (e.g., "1.9.0").
     * @return An integer representation of the version.
     * @see #intify(String, String)
     */
    public static int intify(String version) {
        return intify(version, ".");
    }

    /**
     * Converts a numeric version integer back into a standard string format using a specified separator.
     * This method is the reverse of {@link #intify(String, String)}. For example, 22010 becomes "2.20.10".
     *
     * @param version   The integer representation of the version.
     * @param separator The separator to use between version parts (e.g., ".").
     * @return The version formatted as a String.
     */
    public static String stringify(int version, String separator) {
        if (version == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int tempVersion = Math.abs(version);
        int numParts = (int) (Math.log10(tempVersion) / 2) + 1;
        for (int i = numParts - 1; i >= 0; i--) {
            int divisor = (int) Math.pow(VERSION_BASE, i);
            int part = tempVersion / divisor;
            sb.append(part);
            tempVersion = tempVersion % divisor;
            if (i > 0) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    /**
     * Convenience method to convert a numeric version integer back into a string using a dot (.) as the separator.
     *
     * @param version The integer representation of the version.
     * @return The version formatted as a String with dot separators.
     * @see #stringify(int, String)
     */
    public static String stringify(int version) {
        return stringify(version, ".");
    }
}
