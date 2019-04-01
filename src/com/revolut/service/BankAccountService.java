package com.revolut.service;

import static com.revolut.constants.OperationTypeConstant.TRANSFER;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import com.revolut.dao.AccountDao;
import com.revolut.dao.BankOperationDao;
import com.revolut.provider.H2ConnectionProvider;

public class BankAccountService {
	
	public void transferMoney(int idAccountFrom, int idAccountTo, BigDecimal value) {
		Connection connection = H2ConnectionProvider.getConnection();
		AccountDao accountDao = new AccountDao();
		try {
			accountDao.removeValue(idAccountFrom, connection, value);
			accountDao.addValue(idAccountTo, connection, value);
			BankOperationDao bankOperationDao = new BankOperationDao();
			bankOperationDao.insertOperation(TRANSFER, idAccountFrom, idAccountTo, value, connection);
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
