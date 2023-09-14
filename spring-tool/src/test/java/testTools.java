import org.example.Company;
import org.example.Employee;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("propertyEditor.xml");
        Company company = context.getBean(Company.class);
        logger.info("{}", company);
    }
}
