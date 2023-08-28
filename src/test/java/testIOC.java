import org.example.Dao.UserDao;
import org.example.Entity.User;
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

    private static final ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");

    @Test
    public void testIOC(){
        UserDao userDao = context.getBean(UserDao.class);
        userDao.sayHello();
    }

    @Test
    public void testStaticFactory(){
        UserService userService = (UserService) context.getBean("userService");
        logger.info(userService.toString());
    }

    @Test
    public void testUser(){
        User user = context.getBean(User.class);
        logger.info(user.toString());
    }
}
