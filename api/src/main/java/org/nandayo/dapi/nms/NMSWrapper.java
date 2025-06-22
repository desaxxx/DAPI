package org.nandayo.dapi.nms;

import org.nandayo.dapi.Util;
import org.nandayo.dapi.Wrapper;

@SuppressWarnings("unused")
public class NMSWrapper {

    static private NMSVersion nmsVersion;
    static public NMSVersion getNMSVersion() {
        if (nmsVersion != null) return nmsVersion;
        return nmsVersion = NMSVersion.findVersion(Wrapper.getMinecraftVersion());
    }

    static private AnvilWrapper anvilWrapper;
    static public AnvilWrapper getAnvilWrapper() {
        if (anvilWrapper != null) return anvilWrapper;
        String className = NMSWrapper.class.getPackageName() + ".AnvilManager";
        try {
            return anvilWrapper = (AnvilWrapper) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            Util.log("[DAPI] Couldn't create AnvilManager from class name " + className);
        }
        return null;
    }
}