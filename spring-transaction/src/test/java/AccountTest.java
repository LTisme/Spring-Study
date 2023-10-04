import org.example.service.IAccountService;
import org.junit.Test;
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
}
