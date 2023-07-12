package entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Account {

	private UUID accountId;
	private Customer customer;
	private BigDecimal currentAmount;
	private LocalDateTime creationDate;
	private ArrayList<Transaction> transactionsList;

	public Account(Customer customer) {
		this.accountId = UUID.randomUUID();
		this.customer = customer;
		this.currentAmount = BigDecimal.ZERO;
		this.creationDate = LocalDateTime.now();
		this.transactionsList = new ArrayList<Transaction>();
		addTransaction(new Transaction(BigDecimal.ZERO, TransactionType.ACCOUNT_CREATION));
	}

	public UUID getAccountId() {
		return accountId;
	}

	public void setAccountId(UUID accountId) {
		this.accountId = accountId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(BigDecimal currentAmount) {
		this.currentAmount = currentAmount;
	}

	public ArrayList<Transaction> getTransactionsList() {
		return transactionsList;
	}

	public void setTransactionsList(ArrayList<Transaction> transactionsList) {
		this.transactionsList = transactionsList;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public void addTransaction(Transaction transaction) {
		transaction.setAccountId(accountId);
		this.setCurrentAmount(currentAmount.add(transaction.getTransactionAmount()));
		transaction.setAccountBalance(currentAmount);
		transactionsList.add(transaction);
	}

	public String getHistory() {
		String history = new String();
		for (Transaction transaction : transactionsList) {
			history += transaction.toString() + System.getProperty("line.separator");
		}
		return history;
	}
}
