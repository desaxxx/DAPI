package org.nandayo.dapi.service;

import org.bstats.bukkit.Metrics;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.util.Util;

public class RelocateService {

    private static final String DAPI_DEFAULT_PACKAGE = "org.nan".concat("dayo.dapi");
    private static final String BSTATS_DEFAULT_PACKAGE = "org.nan".concat("dayo.dapi.bstats");

    private static Boolean DAPIRelocated;
    public static boolean isDAPIRelocated() {
        if(DAPIRelocated != null) return DAPIRelocated;
        if(DAPI.class.getPackage().getName().equals(DAPI_DEFAULT_PACKAGE)) {
            Util.logInternal("DAPI was not relocated. It is recommended to relocate it to avoid potential conflicts with other plugins that also include DAPI.");
            return DAPIRelocated = false;
        }else {
            return DAPIRelocated = true;
        }
    }

    private static Boolean bStatsRelocated;
    public static boolean isbStatsRelocated() {
        if(bStatsRelocated != null) return bStatsRelocated;
        return bStatsRelocated = !Metrics.class.getPackage().getName().equals(BSTATS_DEFAULT_PACKAGE);
    }

//    private static Boolean kyoriRelocated;
//    public static boolean isKyoriRelocated() {
//        if(kyoriRelocated != null) return kyoriRelocated;
//        final String defaultPackage= new String(new byte[] { 'n','e','t','.','k','y','o','r','i','.','a','d','v','e','n','t','u','r','e'});
//        return kyoriRelocated = !Adventure.class.getPackage().getName().equals(defaultPackage);
//    }
}
