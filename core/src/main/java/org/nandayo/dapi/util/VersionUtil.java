package org.nandayo.dapi.util;

import java.util.regex.Pattern;

/**
 * A utility class for converting semantic version strings to and from a comparable integer format.
 * This class allows for the normalization of versions to a fixed number of parts,
 * which is essential for reliable version comparisons.
 *
 * @since 1.4.3
 */
public class VersionUtil {

    private static final int VERSION_BASE = 100;

    /**
     * Converts a version string into an integer, normalizing it to a target number of parts.
     * <p>
     * This is the <strong>recommended method for reliable version comparisons</strong>, as it ensures
     * that versions like "1.21" and "1.21.0" are treated consistently. For example,
     * {@code intify("1.21", ".", 3)} is handled as "1.21.0" and returns {@code 12100}.
     *
     * @param version         The version string to convert (e.g., "1.21"). Pre-release tags like "-SNAPSHOT" are ignored.
     * @param separator       The literal separator for version parts (e.g., ".").
     * @param targetPartCount The desired number of parts for the calculation (e.g., 3 for major.minor.patch).
     * @return An integer representation of the version, padded to the target part count.
     */
    public static int intify(String version, String separator, int targetPartCount) {
        String cleanVersion = version.split("-")[0];
        String[] parts = cleanVersion.split(Pattern.quote(separator));
        int v = 0;
        int multiplier = 1;
        for (int i = parts.length - 1; i >= 0; i--) {
            try {
                int num = Integer.parseInt(parts[i]);
                v = v + (num * multiplier);
                multiplier *= VERSION_BASE;
            } catch (NumberFormatException ignored) {}
        }

        if (targetPartCount > parts.length) {
            int paddingFactor = targetPartCount - parts.length;
            v = v * (int) Math.pow(VERSION_BASE, paddingFactor);
        }
        return v;
    }

    /**
     * Converts a version string into an integer without normalization.
     * <p>
     * <strong>Warning:</strong> This method does not pad the version. Comparing versions with a
     * different number of parts may lead to unexpected results. For example, {@code intify("1.21")}
     * returns {@code 121}, while {@code intify("1.9.0")} returns {@code 10900}.
     * <p>
     * For robust version comparison, it is highly recommended to use
     * {@link #intify(String, String, int)} to ensure a consistent number of parts.
     *
     * @param version   The version string to convert.
     * @param separator The literal separator for version parts.
     * @return An integer representation of the version based on its actual number of parts.
     */
    public static int intify(String version, String separator) {
        return intify(version, separator, version.split(Pattern.quote(separator)).length);
    }

    /**
     * Convenience method to convert and normalize a version string using a dot (.) as the default separator.
     *
     * @param version         The version string to convert.
     * @param targetPartCount The desired number of parts for the calculation.
     * @return An integer representation of the version, padded to the target part count.
     * @see #intify(String, String, int)
     */
    public static int intify(String version, int targetPartCount) {
        return intify(version, ".", targetPartCount);
    }

    /**
     * Convenience method to convert a version string into an integer without normalization,
     * using a dot (.) as the default separator.
     * <p>
     * <strong>Warning:</strong> This method does not pad the version and can lead to incorrect comparisons.
     * For reliable comparisons, use {@link #intify(String, int)}.
     *
     * @param version The version string to convert.
     * @return An integer representation of the version based on its actual number of parts.
     * @see #intify(String, String)
     */
    public static int intify(String version) {
        return intify(version, ".");
    }



    /**
     * Converts a numeric version integer back into a standard string format, padding with
     * trailing ".0" parts to meet a target number of parts.
     * <p>
     * This is the <strong>recommended method for generating canonical version strings</strong>.
     * For example, {@code stringify(12100, ".", 3)} will return "1.21.0".
     *
     * @param version         The integer representation of the version.
     * @param separator       The separator to use between version parts.
     * @param targetPartCount The desired number of parts in the output string.
     * @return The version formatted as a String, padded to the target part count.
     */
    public static String stringify(int version, String separator, int targetPartCount) {
        if (version == 0) {
            StringBuilder sb = new StringBuilder("0");
            for (int i = 1; i < targetPartCount; i++) {
                sb.append(separator).append("0");
            }
            return sb.toString();
        }

        StringBuilder sb = new StringBuilder();
        int tempVersion = Math.abs(version);
        int numParts = (int) (Math.log10(tempVersion) / Math.log10(VERSION_BASE)) + 1;
        for (int i = numParts - 1; i >= 0; i--) {
            int divisor = (int) Math.pow(VERSION_BASE, i);
            int part = tempVersion / divisor;
            sb.append(part);
            tempVersion = tempVersion % divisor;
            if (i > 0) {
                sb.append(separator);
            }
        }

        if (targetPartCount > numParts) {
            for (int i = numParts; i < targetPartCount; i++) {
                sb.append(separator).append("0");
            }
        }
        return sb.toString();
    }

    /**
     * Converts a numeric version integer back into a string without extra padding.
     * The number of parts in the output string is the minimum required to represent the integer.
     * For example, {@code stringify(12100, ".")} returns "1.21.0", while {@code stringify(121, ".")} returns "1.21".
     *
     * @param version   The integer representation of the version.
     * @param separator The separator to use between version parts.
     * @return The version formatted as a String.
     */
    public static String stringify(int version, String separator) {
        if(version == 0) return "0";
        return stringify(version, separator, (int) (Math.log10(Math.abs(version)) / Math.log10(VERSION_BASE)) + 1);
    }

    /**
     * Convenience method to convert and pad a version integer to a string using a dot (.) as the default separator.
     *
     * @param version         The integer representation of the version.
     * @param targetPartCount The desired number of parts in the output string.
     * @return The version formatted as a String, padded to the target part count.
     * @see #stringify(int, String, int)
     */
    public static String stringify(int version, int targetPartCount) {
        return stringify(version, ".", targetPartCount);
    }

    /**
     * Convenience method to convert a version integer back to a string without padding,
     * using a dot (.) as the default separator.
     *
     * @param version The integer representation of the version.
     * @return The version formatted as a String.
     * @see #stringify(int, String)
     */
    public static String stringify(int version) {
        return stringify(version, ".");
    }
}
