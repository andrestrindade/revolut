package com.revolut.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankOperationDao {
	
	public int insertOperation(int operationType, int idAccountFrom, int idAccountTo, BigDecimal operationValue,
			Connection connection) throws SQLException {
		String sql = "INSERT into bank_operation (operation_timestamp, operation_value,	"
				+ "fk_operation_type, fk_id_account_from, fk_id_account_to) " 
				+ "VALUES "
				+ "(current_timestamp, ?, ?, ?, ?) ";
		PreparedStatement insertOperation = connection.prepareStatement(sql);
		insertOperation.setBigDecimal(1, operationValue);
		insertOperation.setInt(2, operationType);
		insertOperation.setInt(3, idAccountFrom);
		insertOperation.setInt(4, idAccountTo);
		return insertOperation.executeUpdate();
	}

}
