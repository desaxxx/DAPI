package org.nandayo.dapi.service;

import org.bstats.bukkit.Metrics;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.util.Util;

public class RelocateService {

    private static Boolean DAPIRelocated;
    public static boolean isDAPIRelocated() {
        if(DAPIRelocated != null) return DAPIRelocated;
        final String defaultPackage = new String(new byte[] { 'o','r','g','.','n','a','n','d','a','y','o','.','d','a','p','i'});
        if(DAPI.class.getPackage().getName().equals(defaultPackage)) {
            Util.logInternal("DAPI was not relocated. It is recommended to relocate it to avoid potential conflicts with other plugins that also include DAPI.");
            return DAPIRelocated = false;
        }else {
            return DAPIRelocated = true;
        }
    }

    private static Boolean bStatsRelocated;
    public static boolean isbStatsRelocated() {
        if(bStatsRelocated != null) return bStatsRelocated;
        final String defaultPackage = new String(new byte[] { 'o','r','g','.','b','s','t','a','t','s','.','b','u','k','k','i','t'});
        return bStatsRelocated = !Metrics.class.getPackage().getName().equals(defaultPackage);
    }

//    private static Boolean kyoriRelocated;
//    public static boolean isKyoriRelocated() {
//        if(kyoriRelocated != null) return kyoriRelocated;
//        final String defaultPackage= new String(new byte[] { 'n','e','t','.','k','y','o','r','i','.','a','d','v','e','n','t','u','r','e'});
//        return kyoriRelocated = !Adventure.class.getPackage().getName().equals(defaultPackage);
//    }
}
