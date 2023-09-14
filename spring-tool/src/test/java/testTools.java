import org.example.Company;
import org.example.Employee;
import org.junit.Test;
import org.springframework.beans.BeanWrapperImpl;

/**
 * @Date: 2023/9/14
 * @Author: Administrator
 * @ClassName: testTools
 * @Description: comment here
 */

public class testTools {

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
}
