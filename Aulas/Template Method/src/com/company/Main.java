package com.company;

import com.company.model.Employee;
import com.company.model.EmployeeCLT;
import com.company.model.EmployeeCategory;
import com.company.model.EmployeePJ;
import com.company.service.PaymentService;
import com.company.service.impl.CalculatePaymentCLT;
import com.company.service.impl.CalculatePaymentPJ;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, PaymentService> services = Map.of(
                "CLT", new CalculatePaymentCLT(),
                "PJ", new CalculatePaymentPJ()
        );

        EmployeeCLT cltEmployee = new EmployeeCLT("Jonas", "Malaquias", "123456", EmployeeCategory.CLT);
        cltEmployee.setBaseWage(1500.00);

        EmployeePJ pjEmployee = new EmployeePJ("João", "Malaquias", "234567", EmployeeCategory.PJ);
        pjEmployee.setHours(110);
        pjEmployee.setHourValue(25.12);

        services.get("CLT").pay(cltEmployee);
    }
}
