package org.nandayo.dapi.adventure;

import org.nandayo.dapi.service.Platform;
import org.nandayo.dapi.util.DAPIException;

import java.lang.reflect.Field;

/**
 * @since 1.4.0
 */
class ItemMetaHandlerProvider {
    public static final ItemMetaHandler INSTANCE;
    static {
        if(Platform.isPaperFork()) {
            try {
                Class<?> paperItemMetaHandler = Class.forName("org.nandayo.dapi.adventure.PaperItemMetaHandler");
                Field instance = paperItemMetaHandler.getDeclaredField("INSTANCE");
                instance.setAccessible(true);
                INSTANCE = (ItemMetaHandler) instance.get(null);
            } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
                throw new DAPIException("Couldn't find PaperItemMetaHandler instance! " + e);
            }
        }else {
            INSTANCE = SpigotItemMetaHandler.INSTANCE;
        }
    }
}
