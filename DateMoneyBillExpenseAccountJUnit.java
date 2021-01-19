
/**
 * JUnit tests for Date, Money, ExpenseAccount, and Bill classes
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Classes and Privacy Leaks, DateMoneyBillExpenseAccountJUnit Class 
 * @date 11/25/20
 */

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 
 * @version 1.0 DateMoneyBillJUnit class tests asserts on Date, Money,
 *          ExpenseAccount and Bill classes using JUnit
 *
 */
public class DateMoneyBillExpenseAccountJUnit {
	@Test
	public void compareToMoneyTest() {
		Money money1 = new Money(10, 50);
		Money money2 = new Money(10);

		assertEquals(1, money1.compareTo(money2));
	}

	@Test
	public void cloneBillTest() {
		Bill bill1 = new Bill(new Money(10), new Date(4, 30, 2020), "Steven");
		Bill bill2 = bill1.clone();
		assertEquals(true, bill1.equals(bill2));
	}

	@Test
	public void emptyExpenseAccountTest() {
		ExpenseAccount e = new ExpenseAccount();

		assertEquals(true, e.isEmpty());
	}
}
