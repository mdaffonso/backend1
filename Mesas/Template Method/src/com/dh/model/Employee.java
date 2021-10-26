package com.dh.model;

import java.time.LocalDate;
import java.time.Period;

public class Employee extends Salesperson {

    @Override
    protected void addPointsForSales() {
        addPoints(5*getSales());
    }

    @Override
    protected void addPointsForTime() {
        Integer years = Period.between(getRegistry(), LocalDate.now()).getYears();
        addPoints(years * 5);
    }

    @Override
    protected void addPointsForAffiliations() {
        addPoints(10*getAffiliates());
    }
}
