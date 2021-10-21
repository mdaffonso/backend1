package com.dh.service;

import com.dh.model.Product;

public abstract class QualityChecker {
    private QualityChecker nextChecker;
    protected abstract boolean check(Product product);

    public void execute(Product product) {

        if (getNextChecker() == null && check(product)) {
            System.out.println("produto em condições aceitáveis");
            return;
        }

        if (check(product)) {
            getNextChecker().execute(product);
        } else {
            System.out.println("produto rejeitado");
            return;
        }
    }

    public QualityChecker setNextChecker(QualityChecker nextChecker) {
        this.nextChecker = nextChecker;
        return this;
    }

    public QualityChecker getNextChecker() {
        return this.nextChecker;
    }
}
