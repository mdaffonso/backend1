package com.dh.model;

public enum ApparelPiece {
    SHIRT("shirt"),
    PANTS("pants"),
    JACKET("jacket"),
    SKIRT("skirt"),
    DRESS("dress"),
    SHORTS("shorts");

    private String piece;

    private ApparelPiece(String piece) {
        this.piece = piece;
    }
}
