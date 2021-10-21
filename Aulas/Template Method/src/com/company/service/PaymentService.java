package com.company.service;

import com.company.model.Employee;
import com.company.model.EmployeeCategory;

import java.text.DecimalFormat;
import java.util.Map;

public abstract class PaymentService {

    public void pay(Employee employee) {
        employee.setFinalPayment(calculateWage(employee));
        Double payment = employee.getFinalPayment();
        String formatted = String.format("%.2f", payment);

        System.out.println(makePayment(employee.getAccount(), formatted));
        System.out.println(generateReceipt(employee.getCategory()));
    }

    private String makePayment(String account, String finalValue) {
        return "Bling bling, mother fucker!\n" + finalValue + " deposited to account number " + account;
    }

    private String generateReceipt(EmployeeCategory category) {
        Map<EmployeeCategory, String> map = Map.of(
                EmployeeCategory.PJ, "Recibo enviado por email",
                EmployeeCategory.CLT, "Recibo impresso com sucesso"
        );
        return map.get(category);
    }

    protected abstract Double calculateWage(Employee employee);
}
