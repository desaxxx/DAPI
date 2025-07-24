package org.nandayo.dapi.util;

public class DAPIException extends RuntimeException {

    public DAPIException(String message) {
        super("[DAPI] " + message);
    }
}
