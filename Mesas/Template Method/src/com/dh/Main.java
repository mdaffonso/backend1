package com.dh;

import com.dh.model.Affiliate;
import com.dh.model.Employee;
import com.dh.model.Salesperson;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Salesperson employee = new Employee();
        employee.setRegistry(LocalDate.of(2015, 05, 15));
        System.out.println(employee.toString());
        employee.addAffiliate();
        employee.makeSale();
        employee.makeSale();
        employee.showCategory();
        System.out.println(employee.toString());

        Salesperson affiliate = new Affiliate();
        System.out.println(affiliate.toString());
        affiliate.makeSale();
        affiliate.makeSale();
        affiliate.showCategory();
        System.out.println(affiliate.toString());
    }
}
