import org.example.Company;
import org.example.Employee;
import org.example.EmployeeValidator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date: 2023/9/14
 * @Author: Administrator
 * @ClassName: testTools
 * @Description: comment here
 */

public class testTools {

    private static final Logger logger = LoggerFactory.getLogger(testTools.class);

    // 用BeanWrapper可以使用简化的API来操控复杂的反射操作
    @Test
    public void testBeanWrapper(){
        Company company = new Company();
        Employee employee = new Employee();

        // 将实例进行包装
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(company);
        // 用简单的API来对被包装的实例实现复杂的反射操作
        beanWrapper.setPropertyValue("name", "tencent");
        beanWrapper.setPropertyValue("managingDirector", new Employee());
        beanWrapper.setPropertyValue("managingDirector.name", "Mr.Lee");
        beanWrapper.setPropertyValue("managingDirector.salary", "1000000");

        // 拿到包装的实例
        System.out.println(beanWrapper.getWrappedInstance());
    }

    @Test
    public void testPropertyEditor(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("propertyEditorAndConverter.xml");
        Company company = context.getBean(Company.class);
        logger.info("{}", company);
    }

    @Test
    public void testConverter(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("propertyEditorAndConverter.xml");
        Employee employee = context.getBean(Employee.class);
        logger.info("{}", employee);
    }

    // 开启数据校验，这里了解就好，在SpringMVC里会有用场
    @Test
    public void testDataBinder(){
        Employee employee = new Employee();
        employee.setSalary(1500);

        // 绑定校验对象和校验规则
        DataBinder dataBinder = new DataBinder(employee);
        dataBinder.addValidators(new EmployeeValidator());
        // 开启校验
        dataBinder.validate();
        // 获得校验结果
        BindingResult bindingResult = dataBinder.getBindingResult();
        logger.info("{}", bindingResult);
    }

    // 测试Spring表达式，可能现在看着功能很鸡肋，但是它可以用在某些场景里
    @Test
    public void testSpEl(){
        int order = 1;
        ConcurrentHashMap<Integer, String> hashMap = new ConcurrentHashMap<>();
        // 构造一个解析器
        SpelExpressionParser parser = new SpelExpressionParser();
        // 解析
        Expression exp = parser.parseExpression("'Hello SpEl'");
        // 获取解析的结果
        String message = (String) exp.getValue();
        hashMap.put(order++, message);
        hashMap.put(order++, (String) parser.parseExpression("'Hello SpEl'.concat('!')").getValue());
        hashMap.put(order++, (String) parser.parseExpression("new String('Hello SpEl').toUpperCase()").getValue());
        // SpEL更常见的用法是提供一个针对特定对象实例（称为根对象）求值的表达式字符串。区别是在getValue的時候要传入对象
        Employee employee = new Employee();
        employee.setName("lucy");
        hashMap.put(order++, (String) parser.parseExpression("name").getValue(employee));


        hashMap.forEach((key, val) -> {
            System.out.println(key + " -> " + val);
        });
    }

    // 测试Spring表达式的xml配置方法
    @Test
    public void testSpEl_XML(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpEl.xml");
        Employee bean = context.getBean(Employee.class);
        logger.info("{}", bean);
    }

    // 测试Spring表达式的注解配置方法，要指定默认值，可以在字段、方法和方法或构造函数参数上放置“@Value”注解
    @Test
    public void testSpEl_Annotation(){
        // Entity的话，不需要注入到容器里去获取
        ApplicationContext context = new AnnotationConfigApplicationContext(Employee.class);
        Employee bean = context.getBean(Employee.class);
        logger.info("{}", bean);
    }
}
