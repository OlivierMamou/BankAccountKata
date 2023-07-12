package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import entities.Account;
import entities.Customer;

public class AccountServiceTest {

	// Initialize data :
	private Customer customer = new Customer("Jean", "Dupont", "10 avenue Victor Hugo");
	private Account account = new Account(customer);

	@Test
	public void makeAValidDeposit_then_returnthedepositValueAsABalance() {
		AccountService.makeDeposit(account, new BigDecimal(1000));
		assertTrue(account.getCurrentAmount().equals(new BigDecimal(1000)));
	}

	@Test
	public void makeAWrongDeposit_then_return0AsABalance() {
		AccountService.makeDeposit(account, new BigDecimal(-500));
		assertTrue(account.getCurrentAmount().equals(new BigDecimal(0)));
	}

	@Test
	public void makeAValidWithdrawal_then_returntheCorrectBalance() {
		AccountService.makeDeposit(account, new BigDecimal(1000));
		AccountService.makeWithdrawal(account, new BigDecimal(350));
		assertTrue(account.getCurrentAmount().equals(new BigDecimal(650)));
	}

	@Test
	public void makeAWrongWithdrawal_then_returntheInitialBalance() {
		AccountService.makeDeposit(account, new BigDecimal(1000));
		AccountService.makeWithdrawal(account, new BigDecimal(-500));
		assertTrue(account.getCurrentAmount().equals(new BigDecimal(1000)));
	}

	@Test
	public void makeATooImportantWithdrawal_then_returntheInitialBalance() {
		AccountService.makeDeposit(account, new BigDecimal(1000));
		AccountService.makeWithdrawal(account, new BigDecimal(500000));
		assertTrue(account.getCurrentAmount().equals(new BigDecimal(1000)));
	}

	@Test
	public void seeAccountHistory_then_returnthenumberofLinesOfTheHistory() {
		AccountService.makeDeposit(account, new BigDecimal(1000));
		AccountService.makeWithdrawal(account, new BigDecimal(350));
		String history = AccountService.showHistory(account);
		// Verify that the number of lines is 3 :
		assertEquals(history.split(System.getProperty("line.separator")).length, 3);
	}
}
