package com.solvd.service;

import com.solvd.model.Employee;

import java.util.Random;

public class EmployeeService {

    public static Employee getEmployee() {
        return Employee.builder()
                .firstName("John")
                .middleName("Albert")
                .lastName("McCain")
                .idEmployee(getRandomId())
                .build();
    }

    private static String getRandomId() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

}
