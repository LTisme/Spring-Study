import org.example.Dao.UserDao;
import org.example.Service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Date: 2023/8/21
 * @Author: LTisme
 * @ClassName: testIOC
 * @Description: --->
 */

public class testIOC {

    private static final Logger logger = LoggerFactory.getLogger(testIOC.class);

    @Test
    public void testIOC(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        UserDao userDao = context.getBean(UserDao.class);
        userDao.sayHello();
    }

    @Test
    public void testStaticFactory(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        UserService userService = (UserService) context.getBean("userService");
        //System.out.println(userService);
        logger.info(userService.toString());
    }
}
