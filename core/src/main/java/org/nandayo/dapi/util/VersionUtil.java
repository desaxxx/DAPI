package org.nandayo.dapi.util;

/**
 * @since 1.4.3
 */
public class VersionUtil {

    public static int intify(String version, String regex) {
        String cleanVersion = version.split("-")[0];
        String[] parts = cleanVersion.split(regex);
        int v = 0;
        int multiplier = 1;
        for(int i = parts.length-1; i >= 0; i--) {
            try {
                int num = Integer.parseInt(parts[i]);
                v = v + (num * multiplier);
                multiplier *= 100;
            } catch (NumberFormatException ignored) {}
        }
        return v;
    }

    public static int intify(String version) {
        return intify(version, ".");
    }

    public static String stringify(int version, String regex) {
        if (version == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int tempVersion = Math.abs(version);
        int numParts = (int) (Math.log10(tempVersion) / 2) + 1;
        for (int i = numParts - 1; i >= 0; i--) {
            int divisor = (int) Math.pow(100, i);
            int part = tempVersion / divisor;
            sb.append(part);
            tempVersion = tempVersion % divisor;
            if (i > 0) {
                sb.append(regex);
            }
        }
        return sb.toString();
    }

    public static String stringify(int version) {
        return stringify(version, ".");
    }
}
