import org.example.config.AppConfig;
import org.example.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @Date: 2023/9/26
 * @Author: Administrator
 * @ClassName: AccountTest
 * @Description: comment here
 */

public class AccountTest {
    @Test
    public void testTransfer(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tx.xml");
        IAccountService accountService = context.getBean(IAccountService.class);
        accountService.transferByTransactionTemplate("tom", "jerry", BigDecimal.valueOf(300));
    }

    @Test
    public void testTransferWithAOP(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tx.xml");
        IAccountService accountService = context.getBean(IAccountService.class);
        accountService.transferByTransactionTemplate("tom", "jerry", BigDecimal.valueOf(300));
    }

    @Test
    public void testTransactional(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        IAccountService accountService = context.getBean(IAccountService.class);
        accountService.transfer("tom", "jerry", BigDecimal.valueOf(300));
    }

    // 若是采用纯注解的方式实现事务，则需要用获取配置类了
    @Test
    public void testAnnotationTransaction(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IAccountService accountService = context.getBean(IAccountService.class);
        accountService.transfer("tom", "jerry", BigDecimal.valueOf(300));
    }
}
