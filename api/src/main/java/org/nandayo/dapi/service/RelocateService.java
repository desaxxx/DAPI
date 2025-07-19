package org.nandayo.dapi.service;

import net.kyori.adventure.Adventure;
import org.bstats.bukkit.Metrics;
import org.nandayo.dapi.DAPI;
import org.nandayo.dapi.Util;

public class RelocateService {

    static private Boolean DAPIRelocated;
    static public boolean isDAPIRelocated() {
        if(DAPIRelocated != null) return DAPIRelocated;
        final String defaultPackage = new String(new byte[] { 'o','r','g','.','n','a','n','d','a','y','o','.','d','a','p','i'});
        if(DAPI.class.getPackage().getName().equals(defaultPackage)) {
            Util.log("[DAPI] DAPI was not relocated. It is recommended to relocate it to avoid potential conflicts with other plugins that also include DAPI.");
            return DAPIRelocated = false;
        }else {
            return DAPIRelocated = true;
        }
    }

    static private Boolean bStatsRelocated;
    static public boolean isbStatsRelocated() {
        if(bStatsRelocated != null) return bStatsRelocated;
        final String defaultPackage = new String(new byte[] { 'o','r','g','.','b','s','t','a','t','s','.','b','u','k','k','i','t'});
        return bStatsRelocated = !Metrics.class.getPackage().getName().equals(defaultPackage);
    }

    static private Boolean kyoriRelocated;
    static public boolean isKyoriRelocated() {
        if(kyoriRelocated != null) return kyoriRelocated;
        final String defaultPackage= new String(new byte[] { 'n','e','t','.','k','y','o','r','i','.','a','d','v','e','n','t','u','r','e'});
        return kyoriRelocated = !Adventure.class.getPackage().getName().equals(defaultPackage);
    }
}
