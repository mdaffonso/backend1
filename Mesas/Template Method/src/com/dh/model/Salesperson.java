package com.dh.model;

import java.time.LocalDate;

public abstract class Salesperson {

    private Integer sales = 0;
    private Integer affiliates = 0;
    private Integer points = 0;
    private SalespersonCategory category = SalespersonCategory.NOVICE;
    private LocalDate registry;

    public Integer getAffiliates() {
        return affiliates;
    }

    public void addAffiliate() {
        this.affiliates++;
    }

    public void addAffiliates(Integer num) {
        this.affiliates += num;
    }

    public Integer getSales() {
        return sales;
    }

    public void makeSale() {
        this.sales++;
    }

    public LocalDate getRegistry() {
        return registry;
    }

    public void setRegistry(LocalDate registry) {
        this.registry = registry;
    }

    protected void addPoints(Integer points) {
        this.points += points;
    }

    public SalespersonCategory showCategory() {
        addPointsForAffiliations();
        addPointsForSales();
        addPointsForTime();

        redefineCategory();
        return category;
    }

    private void redefineCategory() {
        category = points > 40
                ? SalespersonCategory.MASTER
                : points > 30
                ? SalespersonCategory.GOOD
                : points > 20
                ? SalespersonCategory.APPRENTICE
                : SalespersonCategory.NOVICE;
    }

    protected abstract void addPointsForSales();
    protected abstract void addPointsForTime();
    protected abstract void addPointsForAffiliations();

    @Override
    public String toString() {
        return "Salesperson{" +
                "sales=" + sales +
                ", affiliates=" + affiliates +
                ", points=" + points +
                ", category=" + category +
                ", registry=" + registry +
                '}';
    }
}
