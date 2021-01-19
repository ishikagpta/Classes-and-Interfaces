
/**
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Classes and Interfaces; Money class
 * @date 11/25/20
 */

import java.io.Serializable;

/**
 * 
 * @version 1.0 Money class is a class to store and keep track of USD using
 *          dollars and cents. It also implements Comparable, Cloneable, and
 *          Serializeable interfaces.
 *
 */
public class Money implements Comparable<Object>, Cloneable, Serializable {

	private static final long serialVersionUID = -4495364138799837126L;
	// this instance variable has the dollars value
	private int dollars;
	// this instance variable has the cents value
	private int cents;

	/**
	 * No-arg Money constructor that initializes dollars and cents to 0.
	 */
	public Money() {
		this.dollars = 0;
		this.cents = 0;
	}

	/**
	 * Money constructor that takes in dol representing dollars as a parameter
	 * argument to initialize instance variable dollars if the dol value is greater
	 * than equal to 0 otherwise IllegalArgumentException is thrown. It also
	 * initializes cents to 0.
	 * 
	 * @param dol
	 */
	public Money(int dol) {
		if (dol >= 0) {
			this.dollars = dol;
		} else {
			throw new IllegalArgumentException();
		}
		this.cents = 0;
	}

	/**
	 * This Money constructor takes in formal parameter dol and cent that has
	 * arguments for dollars and cents. The instance variable dollars is initialized
	 * to the argument given in formal parameter dol if it is greater than or equal
	 * to 0. Else, it throws IllegalArgumentException. The instance variable cents
	 * is initialized to the argument given in formal parameter cent if it is
	 * greater than or equal to 0 and less than and equal to 99 cents. Else, it
	 * throws IllegalArgumentException.
	 * 
	 * @param dol
	 * @param cent
	 */
	public Money(int dol, int cent) {
		if (dol >= 0) {
			this.dollars = dol;
		} else {
			throw new IllegalArgumentException();
		}
		if (cents >= 0 && cents <= 99) {
			this.cents = cent;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Money copy constructor
	 * 
	 * @param other
	 */
	Money(Money other) {
		/*
		 * dollars = other.dollars; cents = other.cents;
		 */
	}

	/**
	 * This accessor method accesses the instance variable dollars and returns it
	 * 
	 * @return dollars
	 */
	public int getDollars() {
		return dollars;
	}

	/**
	 * This accessor method accesses the instance variable cents and returns it
	 * 
	 * @return cents
	 */
	public int getCents() {
		return cents;
	}

	/**
	 * get method that returns the money amount as a double
	 * 
	 * @return
	 */
	double getMoney() {

		return dollars + ((double) cents / 100);
	}

	/**
	 * Sets the money value by setting the instance variable dollars to the formal
	 * parameter dol's argument if the dol argument is greater than or equal to 0,
	 * else it throws IllegalArgumentException. It also sets the instance variable
	 * cents to the formal parameter cent's argument if the cent argument is greater
	 * than or equal to 0 and is less than or equal to 99, else it throws
	 * IllegalArgumentException
	 * 
	 * @param dol
	 * @param cent
	 */
	void setMoney(int dol, int cent) {
		if (dol >= 0) {
			this.dollars = dol;
		} else {
			throw new IllegalArgumentException();
		}
		if (cents >= 0 && cents <= 99) {
			this.cents = cent;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * This method adds the formal parameter dol argument value to the instance
	 * variable dollars value if the dol argument is greater than or equal to 0.
	 * Else, it throws an IllegalArgumentException
	 * 
	 * @param dol
	 */
	void add(int dol) {
		if (dol >= 0) {
			dollars = dollars + dol;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * This method adds the formal parameter dol argument value to the instance
	 * variable dollars value if the dol argument is greater than or equal to 0.
	 * Else, it throws IllegalArgumentException.It also adds the formal parameter
	 * cent argument value to the instance variable cents value if the cent argument
	 * is greater than or equal to 0 and if it is less than or equal to 99. Else, it
	 * throws IllegalArgumentException. If instance variable cents than is greater
	 * than 99, 100 is subtracted from cents and one is added to the instance
	 * variable dollars.
	 * 
	 * @param dol
	 * @param cent
	 */
	void add(int dol, int cent) {
		if (dol >= 0) {
			dollars = dollars + dol;
		} else {
			throw new IllegalArgumentException();
		}
		if (cent >= 0 && cent <= 99) {
			cents = cents + cent;
		} else {
			throw new IllegalArgumentException();
		}
		if (cents > 99) {
			cents = cents - 100;
			dollars = dollars + 1;
		}
	}

	/**
	 * This method takes a Money other formal parameter object and makes sure it is
	 * not null else it throws IllegalArgumentException. It then adds the Money
	 * other object dollars and cents values to the current dollars and cents value
	 * by calling the add(int dol, int cent) method
	 * 
	 * @param other
	 */
	void add(Money other) {
		if (other != null) {
			add(other.dollars, other.cents);
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * This equals method first checks to see if formal parameter Object o argument
	 * is an instance of Money. If it is not than it returns false. If it is then it
	 * typecasts the o argument to be of type Money and sets it equal to the Money
	 * that object. It then checks to see if the Money that object dollars and cents
	 * values are equal to this Money object current dollars and cents values. If it
	 * is, the method returns true else it returns false.
	 * 
	 * @param o
	 */
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Money)) {
			return false;
		} else {
			Money that = (Money) o;
			if ((this.getDollars() == that.getDollars()) && (this.getCents() == that.getCents())) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * This method returns a String formatted USD version of the Money value with
	 * two values after the decimal point for cents always
	 */
	public String toString() {
		return String.format("$%.2f", getMoney());
	}

	/**
	 * This method compares this money to other money to see if they are equal or
	 * one is greater than the other. It first checks to see that the current object
	 * class is not the same as other Object class and if the other Object is null
	 * and throws an exception if true. Else, it sets Object other to Money that. It
	 * first checks to see if this Money is less than that Money and if it is, it
	 * returns -1. Else if this Money is greater than that Money, it returns 1.
	 * Else, it returns 0 as both Money objects are the same.
	 * 
	 * @return -1
	 * @return 1
	 * @return 0
	 */
	public int compareTo(Object other) {
		if (getClass() != other.getClass() || other == null)
			throw new IllegalArgumentException("other cannot be a different class or null");
		else {

			Money that = (Money) other;
			if (this.getMoney() < that.getMoney()) {
				return -1;
			} else if (this.getMoney() > that.getMoney()) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	/**
	 * This clone method creates a clone of the local Money value and sets it equal
	 * to value. It then returns that cloned value. It does all this in a try
	 * statement and if anything goes wrong, it goes down to a catch statement where
	 * it catches any exception.
	 */
	public Money clone() {
		Money value;
		try {
			value = (Money) super.clone();
			return value;
		} catch (CloneNotSupportedException a) {
			throw new RuntimeException();
		}
	}

}
