package com.revolut.application;
import static spark.Spark.get;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import com.revolut.provider.H2ConnectionProvider;

public class BankAccountApplication {

	public static void main(String[] args) {
		
		get("/transferMoney/:accountFrom/:value/:accountTo", (req, res) -> {
			Long accountFrom = Long.valueOf(req.params(":accountFrom"));
			BigDecimal value = new BigDecimal(req.params(":value"));
			Long accountTo = Long.valueOf(req.params(":accountTo")); 
			return req.params(":accountFrom") + " " + req.params(":value") + " " + req.params(":accountTo");
			//TODO -> Instead returning params, I should call transferMoney method.
		});
		/*Connection connection = ConnectionProvider.getConnection(); 

		 try {
			System.out.println(connection.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
	}

}
