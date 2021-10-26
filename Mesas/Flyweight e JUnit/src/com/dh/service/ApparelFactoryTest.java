package com.dh.service;

import com.dh.model.Apparel;
import com.dh.model.ApparelPiece;
import com.dh.model.ApparelSize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ApparelFactoryTest {

    @Test
    public void makesApparel() {
        Apparel piece = ApparelFactory.make(ApparelSize.M, ApparelPiece.SHIRT, true, false);
        Assertions.assertSame(piece, ApparelFactory.getPiece(ApparelPiece.SHIRT.toString()));
    }

    @Test
    public void checksObjectSize() {
        for (int i = 0; i < 1000; i++) {
            ApparelFactory.make(ApparelSize.M, ApparelPiece.SHIRT, true, false);
            ApparelFactory.make(ApparelSize.S, ApparelPiece.PANTS, false, true);
        }
        Assertions.assertTrue(ApparelFactory.getCounter() > ApparelFactory.getListSize());
    }
}
