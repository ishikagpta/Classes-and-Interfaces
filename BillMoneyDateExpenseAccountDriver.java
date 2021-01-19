
/**
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Classes and Interfaces; BillMoneyDateExpenseAccountDriver class
 * @date 11/25/20
 */
import java.util.Iterator;

/**
 * @version 1.0 BillMoneyDateExpenseAccountDriver class is a driver to test
 *          Money, Date, ExpenseAccount, and Bill classes
 */
public class BillMoneyDateExpenseAccountDriver {
	/**
	 * This main method tests the Money, Bill, ExpenseAccount, and Date classes by
	 * creating objects of each class, testing their method's, and printing them
	 * 
	 * @param args
	 * @throws CloneNotSupportedException
	 */
	public static void main(String[] args) {
		// Calls and tests the methods in the Money class

		// Creates money objects
		Money money1 = new Money(10);
		Money money2 = new Money(10);
		money1.setMoney(33, 39);

		System.out.println("Test Money class: ");
		System.out.println("Tests the Money toString method on object money1: " + money1.toString());
		System.out.println("Tests the Money toString method on object money2: " + money2.toString());
		System.out.println("Tests the Money clone method on object money2: " + money2.clone());
		System.out.println(
				"Tests the Money equals method on object money1 comparing it with money2: " + money1.equals(money2));
		System.out.println("Tests the Money compareTo method on object money1 comparing it with money2: "
				+ money1.compareTo(money2));
		System.out.println("Tests the Money clone and equals method on object money1 comparing it with money2: "
				+ money1.clone().equals(money2));
		// calls and tests the add method of the Money class on a Money object
		money1.add(10);
		System.out.println("Tests the Money getMoney method on object money1: " + money1.getMoney());
		// calls and tests the add method of the Money class on a Money object
		money1.add(23, 64);
		System.out.println("Tests the Money getMoney method on object money1: " + money1.getMoney());

		// Calls and tests the methods in the Bill class
		System.out.println("\nTest Bill class:");
		// creates a Money object
		Money amount = new Money(20);
		// creates a Date object
		Date dueDate = new Date(4, 30, 2020);
		// creates a Bill object
		Bill bill1 = new Bill(amount, dueDate, "The phone company");
		System.out.println("Tests the Bill toString method on object bill1: " + bill1.toString());
		// calls and tests the setOriginator method of the Bill class on a Bill object
		bill1.setOriginator("Ishika");
		// calls and tests the setPaid method of the Bill class on a Bill object
		bill1.setPaid(dueDate);

		// creates Bill objects
		Bill bill2 = new Bill(amount, dueDate, "The phone company");
		Bill bill4 = new Bill(amount, dueDate, "The phone company");

		// calls and tests the setDueDate method of the Bill class on a Bill object
		bill2.setDueDate(new Date(4, 30, 2021));
		// calls and tests the setAmount method of the Bill class on a Bill object
		bill2.setAmount(new Money(22, 99));
		// calls and tests the setMoney method of the Money class on a Money object
		amount.setMoney(31, 99);
		// calls and tests the setDay method of the Date class on a Date object
		dueDate.setDay(30);
		// calls and tests the setPaid method of the Bill class on a Bill object
		bill2.setPaid(dueDate);

		// creates a Bill object
		Bill bill3 = new Bill(amount, dueDate, "The record company");

		System.out.println(
				"Tests the Bill equals method on object bill1 comparing it with bill2: " + bill1.equals(bill2));
		System.out.println("Tests the Bill getAmount method on object bill1: " + bill1.getAmount());
		System.out.println("Tests the Bill getDueDate method on object bill1: " + bill1.getDueDate());
		System.out.println("Tests the Bill getOriginator method on object bill1: " + bill1.getOriginator());
		System.out.println("Tests the Bill isPaid method on object bill1: " + bill1.isPaid());
		System.out.println("Tests the Bill toString method on object bill1: " + bill1.toString());
		System.out.println("Tests the Bill clone method on object bill1: " + bill1.clone());
		System.out.println(bill2.toString());
		System.out.println(
				"Tests the Bill compareTo method on object bill1 comparing it with bill2: " + bill1.compareTo(bill2));
		System.out.println("Prints bill1: " + bill1);
		System.out.println("Prints bill2: " + bill2);
		System.out.println("Prints bill3: " + bill3);
		System.out.println("Prints bill4: " + bill4);

		// Calls and tests the methods in the Date class
		System.out.println("\nTest Date Class: ");

		// creates Date class objects
		Date testDate = new Date(1, 2, 2018);
		Date testDate1 = new Date(1, 2, 2020);

		System.out.println("Tests the Date isAfter method on object testDate with argument testDate1: "
				+ testDate.isAfter(testDate1));
		System.out.println("Tests the Date equals method on object testDate comparing it with testDate1: "
				+ testDate.equals(testDate1));
		System.out.println("Tests the Date compareTo method on object testDate comparing it with testDate1: "
				+ testDate.compareTo(testDate1));
		System.out.println("Tests the Date clone and equals method on object testDate comparing it with testDate1: "
				+ testDate.clone().equals(testDate1));
		System.out.println("Tests the Date getDay method on object testDate: " + testDate.getDay());
		System.out.println("Tests the Date getMonth method on object testDate: " + testDate.getMonth());
		System.out.println("Tests the Date getYear method on object testDate: " + testDate.getYear());

		// calls and tests the setDay method of the Date class on a Date object
		testDate.setDay(19);
		// calls and tests the setMonth method of the Date class on a Date object
		testDate.setMonth(7);
		// calls and tests the setYear method of the Date class on a Date object
		testDate.setYear(2019);

		System.out.println("Tests the Date toString method on object testDate: " + testDate.toString());

		// Calls and tests the methods in the ExpenseAccount class
		System.out.println("\nTest ExpenseAccount class:");

		// creates ExpenseAccount object
		ExpenseAccount Exp = new ExpenseAccount();
		System.out.println("Tests the ExpenseAccount isEmpty method on object Exp: " + Exp.isEmpty());
		// creates ExpenseAccount object
		ExpenseAccount Exp2 = new ExpenseAccount();

		// Testing the AddBillsToArList method of ExpenseAccount on multiple
		// ExpenseAccount objects
		Exp2.AddBillsToArList(bill2);
		Exp2.AddBillsToArList(bill3);
		Exp2.AddBillsToArList(bill1);
		Exp2.AddBillsToArList(bill3);
		Exp.AddBillsToArList(bill2);
		Exp.AddBillsToArList(bill3);

		System.out.println("Tests the ExpenseAccount size method on object Exp: " + Exp.size());

		// Testing the AddBillsToArList method of ExpenseAccount on multiple
		// ExpenseAccount objects
		Exp.AddBillsToArList(bill1);
		Exp.AddBillsToArList(bill3);

		System.out.println("Tests the ExpenseAccount superclass ArrayList iterator method hasNext on object Exp: "
				+ Exp.iterator().hasNext());
		System.out.println("Tests the ExpenseAccount superclass ArrayList iterator method next on object Exp: "
				+ Exp.iterator().next());
		System.out.println();
		System.out.println("Prints object Exp: " + Exp);
		System.out.println("Tests the ExpenseAccount clone methon on object Exp: " + Exp.clone());
		System.out.println("Tests the ExpenseAccount superclass ArrayList size method on object Exp: " + Exp.size());
		System.out.println(
				"Tests the ExpenseAccount superclass ArrayList equals method on object Exp comparing it with Exp2: "
						+ Exp.equals(Exp2));
		// creates ExpenseAccount object that is set equal to a clone of object Exp2
		ExpenseAccount Exp3 = Exp2.clone();
		System.out.println(
				"Tests the ExpenseAccount superclass ArrayList equals method on object Exp3 comparing it with Exp2: "
						+ Exp3.equals(Exp2));
		System.out
				.println("Tests the ExpenseAccount superclass ArrayList remove method on object Exp: " + Exp.remove(0));
		System.out.println(
				"Tests the ExpenseAccount superclass ArrayList indexOf method on object Exp: " + Exp.indexOf(bill1));
		System.out.println("Tests the ExpenseAccount superclass ArrayList get method on object Exp: " + Exp.get(0));
		System.out.println(
				"Tests the ExpenseAccount superclass ArrayList toString method on object Exp: " + Exp.toString());
		System.out.println(
				"Tests the ExpenseAccount superclass ArrayList isEmpty method on object Exp: " + Exp.isEmpty());
		// While loop goes through list of bills in ExpenseAccount using iterator method
		// hasNext
		while (Exp.iterator().hasNext()) {
			System.out.println("Tests the ExpenseAccount superclass ArrayList iterator method next on object Exp: "
					+ Exp.iterator().next());
		}

	}
}
