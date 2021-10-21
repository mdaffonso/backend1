package com.dh;

import com.dh.model.Condition;
import com.dh.model.Product;
import com.dh.service.QualityChecker;
import com.dh.service.impl.CheckCondition;
import com.dh.service.impl.CheckLot;
import com.dh.service.impl.CheckName;
import com.dh.service.impl.CheckWeight;

public class Main {

    public static void main(String[] args) {
        QualityChecker checker = new CheckName()
                .setNextChecker(new CheckLot()
                .setNextChecker(new CheckWeight()
                .setNextChecker(new CheckCondition())));

        Product p = new Product();
        p.setCondition(Condition.SAUDAVEL);
        p.setLot(1500);
        p.setName("Mouse Gamer");
        p.setWeight(1250);

        checker.execute(p);
    }
}
