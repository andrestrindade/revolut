package com.revolut.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDao {
	
	public int addValue(int id, Connection connection, BigDecimal value) throws SQLException {
		String sql = "UPDATE account SET balance = balance + ? WHERE id_account = ?";
		PreparedStatement updateValue = connection.prepareStatement(sql);
		updateValue.setBigDecimal(1, value);
		updateValue.setInt(2, id);
		return updateValue.executeUpdate();
	}
	
	public int removeValue(int id, Connection connection, BigDecimal value) throws SQLException {
		String sql = "UPDATE account SET balance = balance - ? WHERE id_account = ?";
		PreparedStatement updateValue = connection.prepareStatement(sql);
		updateValue.setBigDecimal(1, value);
		updateValue.setInt(2, id);
		return updateValue.executeUpdate();
	}
	 
}
