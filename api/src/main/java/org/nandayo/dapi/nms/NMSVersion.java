package org.nandayo.dapi.nms;

@SuppressWarnings("unused")
public enum NMSVersion {

    V1_16_R1(161),
    V1_16_R2(162),
    V1_16_R3(164),
    V1_17_R1(170),
    V1_18_R1(180),
    V1_18_R2(182),
    V1_19_R1(190),
    V1_19_R2(193),
    V1_19_R3(194),
    V1_20_R1(200),
    V1_20_R2(202),
    V1_20_R3(203),
    V1_20_R4(205),
    V1_21_R1(210),
    V1_21_R2(212),
    V1_21_R3(214),
    V1_21_R4(215),
    V1_21_R5(216);

    NMSVersion(int minecraftVersion) {
        this.minecraftVersion = minecraftVersion;
    }
    private final int minecraftVersion;

    public String removeV() {
        return name().replace("V","");
    }


    static public NMSVersion findVersion(int minecraftVersion) {
        for (NMSVersion v : values()) {
            if (v.minecraftVersion == minecraftVersion) {
                return v;
            }
        }
        return V1_21_R5;
    }
}
