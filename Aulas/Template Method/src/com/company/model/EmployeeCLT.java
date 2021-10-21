package com.company.model;

public class EmployeeCLT extends Employee {

    private Double discount = 14.00;
    private Double bonus = 5.00;
    private Double baseWage = 0.00;

    public Double getBaseWage() {
        return baseWage;
    }

    public void setBaseWage(Double baseWage) {
        this.baseWage = baseWage;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public EmployeeCLT(String name, String surname, String account, EmployeeCategory category) {
        super(name, surname, account, category);
    }
}
