
/**
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Classes and Interfaces; ExpenseAccount class
 * @date 11/25/20
 */

/**
 * 
 * @version 1.0 The ExpenseAccount class extends the ArrayList class and creates
 *          an ArrayList of bills. It also implements the Cloneable interface.
 *
 */
public class ExpenseAccount extends ArrayList<Bill> implements Cloneable {

	/**
	 * No arg ExpenseAccount class constructor
	 */
	public ExpenseAccount() {

	}

	/**
	 * This clone method satisfies the Cloneable interface implementation by setting
	 * a new ExpenseAccount value to a clone of the ExpenseAccount and then returns
	 * the cloned ExpenseAccount value in a try statement. If any part of this
	 * fails, it drops down to the catch statement where CloneNotSupportedException
	 * is thrown.
	 */
	public ExpenseAccount clone() {
		ExpenseAccount value;
		try {
			value = (ExpenseAccount) super.clone();
			return value;
		} catch (CloneNotSupportedException a) {
			throw new RuntimeException();
		}
	}

	/**
	 * This AddBillsToArList method calls the superclass insert method to insert the
	 * parameter b Bill to be stored at the ExpenseAccount arraylist of bills at the
	 * end of the arraylist (size)
	 * 
	 * @param b
	 */
	public void AddBillsToArList(Bill b) {

		insert(b, size());
	}

}
