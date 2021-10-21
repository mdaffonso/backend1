package com.company.service.impl;

import com.company.model.Employee;
import com.company.model.EmployeePJ;
import com.company.service.PaymentService;

public class CalculatePaymentPJ extends PaymentService {

    @Override
    protected Double calculateWage(Employee employee) {
        EmployeePJ pj = ((EmployeePJ) employee);

        return pj.getHourValue() * pj.getHours();
    }
}
