package com.revolut.application;
import static spark.Spark.get;

import java.math.BigDecimal;

import com.revolut.service.BankAccountService;

public class BankAccountApplication {

	public static void main(String[] args) {
		
		get("/transferMoney/:accountFrom/:value/:accountTo", (req, res) -> {
			Integer idAccountFrom = Integer.valueOf(req.params(":accountFrom"));
			BigDecimal value = new BigDecimal(req.params(":value"));
			Integer idAccountTo = Integer.valueOf(req.params(":accountTo"));
			BankAccountService bankAccountService = new BankAccountService();
			bankAccountService.transferMoney(idAccountFrom, idAccountTo, value);
			return "Transfer sucessful - Account from: "+ req.params(":accountFrom") + " Value: " + req.params(":value") + " Account: " + req.params(":accountTo");
		});

	}

}
