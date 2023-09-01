import org.example.Dao.UserDao;
import org.example.Entity.*;
import org.example.Entity.ForAnnotationTest.Boy;
import org.example.Service.OrderService;
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
        User user = (User)context.getBean("user");
        logger.info(user.toString());
    }

    @Test
    public void testPCTag(){
        User user = (User)context.getBean("a");
        logger.info(user.toString());
    }

    @Test
    public void testAutoWired(){
        ApplicationContext context = new ClassPathXmlApplicationContext("autowired.xml");
        User user1 = context.getBean(User.class);
        User user2 = context.getBean(User.class);
        logger.info(user1.toString());
        logger.info(user2.toString());
        logger.info(String.valueOf(user1 == user2));
    }

    @Test
    public void testCycle(){
        ApplicationContext context = new ClassPathXmlApplicationContext("cycle.xml");
        A a = context.getBean(A.class);
        B b = context.getBean(B.class);
        logger.info(a.toString());
        logger.info(b.toString());
    }

    @Test
    public void testLifeCycle(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("autowired.xml");
        Address address = context.getBean(Address.class);
        logger.info("{}", address);
        context.close();
    }

    @Test
    public void testLowCouplingLifeCycle(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lifecycle.xml");
        A a = (A)context.getBean("a");
        A b = (A) context.getBean("b");
        logger.info("{}", a);
        logger.info("{}", b);
        context.close();
    }

    @Test
    public void testAware(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aware.xml");
        C c = context.getBean(C.class);
        c.printName();
        context.close();
    }

    @Test
    public void testAnnotation_Autowired(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        Boy boy = context.getBean(Boy.class);
        logger.info("{}", boy);
    }

    @Test
    public void testScan(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("scan.xml");
        OrderService orderService = context.getBean(OrderService.class);
        logger.info("{}", orderService);
    }
}
