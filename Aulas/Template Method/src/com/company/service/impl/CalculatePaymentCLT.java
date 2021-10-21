package com.company.service.impl;

import com.company.model.Employee;
import com.company.model.EmployeeCLT;
import com.company.service.PaymentService;

public class CalculatePaymentCLT extends PaymentService {

    @Override
    protected Double calculateWage(Employee employee) {
        EmployeeCLT clt = ((EmployeeCLT) employee);
        Double wage = clt.getBaseWage();
        wage = wage * (1 - (clt.getDiscount() / 100) + (clt.getBonus() / 100));

        return wage;
    }
}
