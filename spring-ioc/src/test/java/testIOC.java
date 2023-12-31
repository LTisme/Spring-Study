import org.example.Config.atValueConfig;
import org.example.Config.whateverConfig;
import org.example.Dao.UserDao;
import org.example.Entity.*;
import org.example.Entity.ForAnnotationTest.Boy;
import org.example.Env.MyPropertySource;
import org.example.FactoryBean.DataSourceFactoryBean;
import org.example.Listener.*;
import org.example.Service.OrderService;
import org.example.Service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import javax.sql.DataSource;

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

    // 完全抛弃配置文件，在配置类上加上注解也是可以的，注意类已经不能再使用 ClassPathXmlApplicationContext 了
    @Test
    public void testScan2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        OrderService orderService = context.getBean(OrderService.class);
        logger.info("{}", orderService);
    }

    @Test
    public void testBean(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        User user = context.getBean(User.class);
        logger.info("{}", user);
    }

    @Test
    public void testFactoryBean(){
        // 但是这里就不能使用扫包的方式了
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceFactoryBean.class);
        DataSource ds = (DataSource)context.getBean("dataSourceFactoryBean");
        // 技巧：在字符串名称前加一个前缀&就能获取到FactoryBean本身，而不是FactoryBean创建的对象
        DataSourceFactoryBean df = (DataSourceFactoryBean)context.getBean("&dataSourceFactoryBean");
        logger.info("{}", ds);
        logger.info("{}", df);
    }

    @Test
    public void testEnvironmentProfile(){
        // 创建空容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 激活指定环境
        context.getEnvironment().setActiveProfiles("product");
        // 通过扫包在容器中注入相应的类
        context.scan("org.example.DataSource");
        // 刷新容器
        context.refresh();
        // 使用
        DataSource dataSource = context.getBean(DataSource.class);
        logger.info("{}", dataSource);
    }

    @Test
    public void testEnvironmentProperty(){
        // 创建空容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 激活指定环境
        ConfigurableEnvironment environment = context.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addFirst(new MyPropertySource("my"));
        context.refresh();
        // 使用
        String hello = environment.getProperty("hello");
        logger.info("{}", hello);

    }

    @Test
    public void testAtValue(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(atValueConfig.class, whateverConfig.class);
        whateverConfig bean = context.getBean(whateverConfig.class);
        System.out.println(bean);
    }

    // 这里是事件机制——你可以用容器发布事件，一旦这个事件发生，对应的监听这个事件的监听器就会有相应的动作
    // 这里是不写数据源，因为event类中已经有了代替数据源的作用
    @Test
    public void testEvent(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmailListener.class, MessageListener.class);
        context.publishEvent(new OrderEvent("nothing", "12345", "lily"));
    }

    // 这里是事件机制——你可以用容器发布事件，一旦这个事件发生，对应的监听这个事件的监听器就会有相应的动作
    // 如果另起一个数据源，则在event中无需做繁琐操作
    @Test
    public void testEvent2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmailListener2.class, MessageListener2.class);
        context.publishEvent(new OrderEvent2(new Order("12345678", "lily")));
    }

    // 这里是事件机制——你可以用容器发布事件，一旦这个事件发生，对应的监听这个事件的监听器就会有相应的动作
    // 你也可以不用实现ApplicationListener接口，而是使用@EventListener将某个方法标记为监听事件即可
    @Test
    public void testEvent3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmailListener3.class, MessageListener3.class);
        context.publishEvent(new OrderEvent2(new Order("87654321", "lily")));
    }

    // Spring 自带一些标准的事件，无需手动发布，只要做了相应的监听器就能自动运行
    @Test
    public void testEvent4(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextFinish.class);
    }
}
