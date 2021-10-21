package com.company.model;

public class EmployeePJ extends Employee {

    private Integer hours;
    private Double hourValue;

    public EmployeePJ(String name, String surname, String account, EmployeeCategory category) {
        super(name, surname, account, category);
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double getHourValue() {
        return hourValue;
    }

    public void setHourValue(Double hourValue) {
        this.hourValue = hourValue;
    }
}
