package com.dh.service;

import com.dh.model.Apparel;
import com.dh.model.ApparelPiece;
import com.dh.model.ApparelSize;

import java.util.HashMap;
import java.util.Map;

public class ApparelFactory {
    private static Map<String, Apparel> pieces = new HashMap<>();
    private static Integer counter = 0;

    public static Apparel make(ApparelSize size, ApparelPiece piece, boolean isNew, boolean isImported) {
        String stringNew = isNew ? "new" : "used";
        String stringImported = isImported ? "imported" : "national";
        String id = piece.toString();

        if (!pieces.containsKey(id)) {
            pieces.put(id, new Apparel(size, piece, isNew, isImported));
        }

        counter++;
        return pieces.get(id);
    }

    public static Apparel getPiece(String id) {
        return pieces.get(id);
    }

    public static Integer getCounter() {
        return counter;
    }

    public static Integer getListSize() {
        return pieces.size();
    }
}
