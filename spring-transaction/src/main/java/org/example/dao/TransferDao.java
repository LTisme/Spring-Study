package org.example.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.math.BigDecimal;

/**
 * @Date: 2023/9/26
 * @Author: Administrator
 * @ClassName: TransferDao
 * @Description: comment here
 */

@Repository
public class TransferDao {

    private JdbcTemplate jdbcTemplate;

    private DataSourceTransactionManager transactionManager;

    public TransferDao(JdbcTemplate jdbcTemplate, DataSourceTransactionManager transactionManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.transactionManager = transactionManager;
    }

    public void doTransfer(String from, String to, BigDecimal money){

        // 转账其实就是两条语句，其实service作为业务逻辑层，不应该放具体的实现的，应该在Dao层做具体的与数据库的操作
        String sql = "update account set money = money - ? where user_name = ?";
        String sql2 = "update account set money = money + ? where user_name = ?";

        // 但为了防止异常需要用事务管理器来管理事务的完整性
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            jdbcTemplate.update(sql, money, from);
            // 故意使其发生异常
            int i = 1/0;
            jdbcTemplate.update(sql2, money, to);
        } catch (RuntimeException e){
            // 一旦发生异常就需要回滚来还原操作
            transactionManager.rollback(transactionStatus);
        }

        transactionManager.commit(transactionStatus);
    }
}
