package org.example;

import java.beans.PropertyEditorSupport;

/**
 * @Date: 2023/9/14
 * @Author: Administrator
 * @ClassName: EmployeeEditor
 * @Description: comment here
 */

public class EmployeeEditor extends PropertyEditorSupport {
    // 这个方法会主动调用,在依赖识别时,将xml中的字符串转换成对应的Bean
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Employee employee = new Employee();
        employee.setName(text);
        employee.setSalary(666666F);
        super.setValue(employee);
    }
}
