package com.dh.model;

public class Apparel {
    private ApparelSize size;
    private ApparelPiece piece;
    private boolean isNew;
    private boolean isImported;

    public Apparel(ApparelSize size, ApparelPiece piece, boolean isNew, boolean isImported) {
        this.size = size;
        this.piece = piece;
        this.isNew = isNew;
        this.isImported = isImported;
    }

    public ApparelSize getSize() {
        return size;
    }

    public ApparelPiece getPiece() {
        return piece;
    }

    public boolean isNew() {
        return isNew;
    }

    public boolean isImported() {
        return isImported;
    }

    @Override
    public String toString() {
        return "Apparel{" +
                "size='" + size + '\'' +
                ", piece='" + piece + '\'' +
                ", isNew=" + isNew +
                ", isImported=" + isImported +
                '}';
    }
}
