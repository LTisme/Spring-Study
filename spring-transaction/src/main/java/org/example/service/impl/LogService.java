package org.example.service.impl;

import org.example.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Date: 2023/10/5
 * @Author: Administrator
 * @ClassName: LogService
 * @Description: comment here
 */

@Service
public class LogService implements ILogService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)      // 在这里演示事务嵌套，默认不加参数的事务是采用required
    // REQUIRES_NEW 则是外层若有事务则先挂起，待本事务执行完毕再执行外层事务
    // SUPPORTS 则是外界有事务，本层就采用事务，外界没事务，那本层也不采用事务
    public void addLog(String msg) {
//        int i = 1/0;
        jdbcTemplate.update("insert into log(msg) values (?)", msg);
    }
}
