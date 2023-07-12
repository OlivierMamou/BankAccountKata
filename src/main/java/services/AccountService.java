package services;

import java.math.BigDecimal;

import entities.Account;
import entities.Transaction;
import entities.TransactionType;

public class AccountService {

	public static void makeDeposit(Account account, BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) > 0) {
			account.addTransaction(new Transaction(amount, TransactionType.DEPOSIT));
		}
	}

	public static void makeWithdrawal(Account account, BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(account.getCurrentAmount()) <= 0) {
			account.addTransaction(new Transaction(amount.multiply(new BigDecimal(-1)), TransactionType.WITHDRAWAL));
		}
	}

	public static String showHistory(Account account) {
		System.out.println(account.getHistory());
		return account.getHistory();
	}
}