package org.example;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @Date: 2023/9/18
 * @Author: Administrator
 * @ClassName: EmployeeValidator
 * @Description: comment here
 */

public class EmployeeValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        if (employee.getSalary() < 3000){
            errors.rejectValue("salary", "1001", "员工的最低标准是3000");
        }
    }
}
