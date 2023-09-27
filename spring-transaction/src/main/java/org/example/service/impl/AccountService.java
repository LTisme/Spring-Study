package org.example.service.impl;

import org.example.dao.TransferDao;
import org.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Date: 2023/9/26
 * @Author: Administrator
 * @ClassName: AccountService
 * @Description: comment here
 */

@Service
public class AccountService implements IAccountService {

    @Autowired
    private TransferDao transferDao;

    public AccountService(TransferDao transferDao) {
        this.transferDao = transferDao;
    }

    @Override
    public void transfer(String from, String to, BigDecimal money) {
        transferDao.doTransfer(from, to, money);
    }

    @Override
    public void transferByTransactionTemplate(String from, String to, BigDecimal money) {
        transferDao.doTransferByTransactionTemplate(from, to, money);
    }
}
