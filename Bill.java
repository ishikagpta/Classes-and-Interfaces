
/**
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Classes and Interfaces; Bill class
 * @date 11/25/20
 */
import java.io.Serializable;

/**
 * 
 * @version 1.0 The Bill class stores and keeps track of a Bill and has the
 *          amount due, the date it is due, the date it was paid, and the
 *          originator who owed the bill. It also implements Comparable,
 *          Cloneable, and Serializable interfaces.
 *
 */
public class Bill implements Comparable<Object>, Cloneable, Serializable {

	private static final long serialVersionUID = -4809540671802142636L;
	// this instance variable has the amount due value
	private Money amount;
	// this instance variable has the due date value
	private Date dueDate;
	// this instance variable has the paid date value
	private Date paidDate;
	// this instance variable has the originator of the bill value
	private String originator;

	/**
	 * This Money constructor takes in formal parameter amount, dueDate, originator
	 * that has arguments for instance variables amount, dueDate, originator. The
	 * instance variable amount is initialized to the argument given in formal
	 * parameter amount by creating a clone of the Money object containing the
	 * argument amount. The instance variable dueDate is initialized to the argument
	 * given in formal parameter dueDate by creating a clone of the Date object
	 * containing the argument dueDate. The instance variable originator is
	 * initialized to the argument given in the formal parameter originator. The
	 * instance variable paidDate is initialized to null.
	 * 
	 * @param amount
	 * @param dueDate
	 * @param originator
	 */
	Bill(Money amount, Date dueDate, String originator) {
		this.amount = amount.clone();
		this.dueDate = dueDate.clone();
		this.originator = originator;
		paidDate = null;
	}

	/**
	 * Bill copy constructor
	 * 
	 * @param toCopy
	 */
	Bill(Bill toCopy) {
		/*
		 * this.amount = new Money(toCopy.amount); this.dueDate = new
		 * Date(toCopy.dueDate); this.originator = toCopy.originator;
		 */
	}

	/**
	 * gets and returns the dueDate
	 * 
	 * PRE: none
	 * 
	 * @return dueDate
	 */

	/**
	 * This accessor method accesses the instance variable dueDate and returns a
	 * clone of it
	 * 
	 * @return dueDate
	 */
	Date getDueDate() {
		return dueDate.clone();
	}

	/**
	 * This accessor method accesses the instance variable originator and returns it
	 * 
	 * @return originator
	 */
	String getOriginator() {
		return originator;
	}

	/**
	 * This method checks to see if the bill is paid. If paidDate is equal to null,
	 * the method returns false. Otherwise, it returns true.
	 * 
	 * @return true, false
	 */
	public boolean isPaid() {
		if (paidDate == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * This method does not set the bill instance variable paidDate if the datePaid
	 * formal parameter argument is before the dueDate to be the datePaid and
	 * returns false. Else, it sets the bill instance variable paidDate to be the
	 * datePaid and returns true.
	 * 
	 * @param datePaid
	 * @return true, false
	 */
	public boolean setPaid(Date datePaid) {
		if (dueDate.isAfter(datePaid)) {
			return false;
		} else {
			paidDate = datePaid.clone();
			return true;
		}
	}

	/**
	 * This method sets the dueDate instance variable if the isPaid method is true
	 * to be a clone Date object formal parameter argument nextDate and returns
	 * true. Else, it returns false
	 * 
	 * @param nextDate
	 * @return true, false
	 */
	public boolean setDueDate(Date nextDate) {
		if (!(isPaid() == true)) {
			dueDate = nextDate.clone();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method sets the instance variable amount if the isPaid method is not
	 * true to be a clone of the Money object formal parameter argument newAmount
	 * and returns true. Else it returns false.
	 * 
	 * @param newAmount
	 * @return true, false
	 */
	public boolean setAmount(Money newAmount) {
		if (!(isPaid() == true)) {
			amount = newAmount.clone();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This accessor method accesses the instance variable amount and returns it
	 * 
	 * @return amount
	 */
	Money getAmount() {
		return amount.clone();
	}

	/**
	 * This mutator method sets the instance variable originator to the formal
	 * parameter argument newOriginator if it is not null. Else, it throws an
	 * IllegalArgumentException
	 * 
	 * @param newOriginator
	 */
	void setOriginator(String newOriginator) {
		if (newOriginator != null) {
			originator = newOriginator;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * This method returns a string version of the bill into that gives the amount
	 * that was due, the date it was due, the originator of the bill, whether it was
	 * paid, and what date it was paid
	 */
	public String toString() {
		return "The amount that's due - " + this.getAmount() + " The Due Date -  " + this.getDueDate() + " To - "
				+ this.getOriginator() + " Whether it was paid - " + isPaid() + " Date it was paid - " + this.paidDate;
	}

	/**
	 * This equals method first checks to see if formal parameter Object toCompare
	 * argument is an instance of Bill. If it is not than it returns false. If it is
	 * then it typecasts the toCompare argument to be of type Bill and sets it equal
	 * to the Bill that object. It then checks to see if the Bill that object
	 * amount, dueDate, and paidDate values are equal to this Bill object current
	 * amount, dueDate, and paidDate values. If it is, the method returns true else
	 * it returns false.
	 * 
	 * @param toCompare
	 */
	boolean equals(Bill toCompare) {
		if (toCompare == null || !(toCompare instanceof Bill)) {
			return false;
		} else {
			Bill that = (Bill) toCompare;
			if ((this.getAmount().equals(that.getAmount())) && (this.getDueDate().equals(that.getDueDate()))
					&& (this.getOriginator().equals(that.getOriginator()))) {
				return true;
			} else {
				return false;
			}
		}

	}

	/**
	 * This method compares this bill to other bill to see if they are equal or one
	 * is greater than the other. It first checks to see that the current object
	 * class is not the same as other Object class and if the other Object is null
	 * and throws an exception if true. Else, it sets Object other to Bill that. It
	 * then calls the String class compareTo method to compare the two Bills by
	 * their Originator and return accordingly. It returns the value 0 if the
	 * argument string is equal to this string; a value less than 0 if this string
	 * is lexicographically less than the string argument; and a value greater than
	 * 0 if this string is lexicographically greater than the string argument.
	 * 
	 * @param other
	 */
	public int compareTo(Object other) {
		if (getClass() != other.getClass() || other == null)
			throw new IllegalArgumentException("other cannot be a different class or null");
		else {
			Bill that = (Bill) other;
			return this.getOriginator().compareTo(that.getOriginator());
		}
	}

	/**
	 * This clone method creates a clone of the local Bill value and sets it equal
	 * to value. It then sets the clone Bill value's originator to originator. It
	 * then sets clone Bill value's dueDate to a cloned dueDate. It then sets clone
	 * Bill value's paidDate to a cloned paidDate. It then sets clone Bill value's
	 * amount to a cloned amount. It then returns that cloned Bill value. It does
	 * all this in a try statement and if anything goes wrong, it goes down to a
	 * catch statement where it catches any exception.
	 */
	public Bill clone() {
		Bill value;
		try {
			value = (Bill) super.clone();
			value.originator = originator;
			value.dueDate = (Date) dueDate.clone();
			if (paidDate == null) {
				value.paidDate = null;
			} else {
				value.paidDate = (Date) paidDate.clone();
			}
			value.amount = (Money) amount.clone();
			return value;
		} catch (CloneNotSupportedException a) {
			throw new RuntimeException();
		}
	}

}
