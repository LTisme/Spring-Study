package org.example.service;

import java.math.BigDecimal;

/**
 * @Date: 2023/9/26
 * @Author: Administrator
 * @ClassName: IAccountService
 * @Description: comment here
 */

public interface IAccountService {
    void transfer(String from, String to, BigDecimal money);
}
