package entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

	private UUID transactionId;
	private LocalDateTime transactionDateTime;
	private BigDecimal transactionAmount;
	private BigDecimal accountBalance;
	private UUID accountId;
	private TransactionType transactionType;

	public Transaction(BigDecimal transactionAmount, TransactionType transactionType) {
		this.transactionAmount = transactionAmount;
		this.transactionDateTime = LocalDateTime.now();
		this.transactionId = UUID.randomUUID();
		this.transactionType = transactionType;
	}

	public UUID getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public UUID getAccountId() {
		return accountId;
	}

	public void setAccountId(UUID accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "Transaction [" + "accountId=" + accountId + ", transactionId=" + transactionId
				+ ", transactionDateTime=" + transactionDateTime + ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount + ", accountBalance=" + accountBalance + "]";
	}

}
