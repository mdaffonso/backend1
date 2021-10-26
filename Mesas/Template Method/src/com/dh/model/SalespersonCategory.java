package com.dh.model;

public enum SalespersonCategory {
    NOVICE("novice"),
    APPRENTICE("apprentice"),
    GOOD("good"),
    MASTER("master");

    private String category;

    private SalespersonCategory(String category) {
        this.category = category;
    }
}
