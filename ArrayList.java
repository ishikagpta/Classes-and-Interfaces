
/**
 * @author Ishika Gupta
 * @class CSS 143 A
 * @assignment Classes and Interfaces; ArrayList class
 * @date 11/25/20
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @version 1.0 This generic ArrayList class will create methods which will give
 *          resemblance to an ArrayList like structure of objects by using
 *          Arrays. It also implements the Iterable interface.
 * 
 */
public class ArrayList<T> implements Iterable<T> {
	// arrayList to hold all objects
	private Object[] arrayList = new Object[0];
	// numElements to store number of elements
	private int numElements = 0,
			// to be used to keep track of elements in Iterator
			current = 0;

	/**
	 * Insert method is what allows you to insert an element given by formal
	 * parameter in to the arraylist at the index given by the formal parameter
	 * location and uses a dynamic resize to do so
	 * 
	 * @param in
	 * @param location
	 */
	public void insert(T in, int location) {
		// stores parameter "in" in local variable
		T inputValue = in;

		// null check and if negative index
		if (in == null || location < 0 || (location > (arrayList.length + 1))) {
			throw new IllegalArgumentException();
		}
		// if the highest spot is out of bounds, resize the array
		if ((location >= arrayList.length)) {
			arrayList = resize(location + 1);
		}

		// increase the size by 1 even if location is below array length so that new
		// element can be accommodated and inserted in the arraylist
		if (numElements + 1 >= arrayList.length) {
			arrayList = resize(arrayList.length + 1);
		}
		shiftRight(location); // shifting right at the param index
		arrayList[location] = inputValue; // inserts the value in the given parameter index
		numElements++; // updates the amount of elements

	}

	/**
	 * This is the dynamic resize method that is utilized by the insert method as a
	 * way to expand the array if there are more things added that the original size
	 * of the array
	 * 
	 * @param idx
	 * @return tmp
	 */
	private Object[] resize(int idx) {
		// create a temporary array with new size that's larger than previous and copy
		// all the elements and return
		Object[] tmp = new Object[idx];
		for (int ctr = 0; ctr < arrayList.length; ctr++) { // goes for the length of array
			tmp[ctr] = arrayList[ctr];
		}
		return tmp;
	}

	/**
	 * This remove method allows you to remove elements of the ArrayList and then
	 * return the thing you removed.
	 * 
	 * @param index
	 * @return retval
	 */
	public T remove(int index) {
		if (arrayList[index] == null || index < 0) { // null check for objectat index and if negative index
			throw new IllegalArgumentException();
		}
		@SuppressWarnings("unchecked")
		T retVal = (T) arrayList[index]; // cast the input to a T type
		shiftLeft(index); // shifting left at the param index
		arrayList[numElements] = null; // sets last index to null
		numElements--; // reduces the number of elements
		return retVal; // returns the thing removed
	}

	/**
	 * This shiftleft method is called in the remove method and iterates over the
	 * array shifting it to the left
	 * 
	 * @param start
	 */
	@SuppressWarnings("unchecked")
	private void shiftLeft(int start) {
		// iterate over array from the given start and moves all the elements to the
		// left
		for (int first = start; first < numElements; first++) {
			arrayList[first] = (T) arrayList[first + 1];
		}
	}

	/**
	 * This method returns the index of an object that is in the array
	 * 
	 * @param value
	 * @return i, -1
	 */
	@SuppressWarnings("unchecked")
	public int indexOf(Object value) {
		// Checks if object is null
		if ((T) value == null) {
			throw new IllegalArgumentException();
		}

		// Iterates through the array and checks to see if any of the elements are equal
		// to the object at the index. If so, the index is returned
		for (int i = 0; i < numElements; i++) {
			if (arrayList[i].equals(value)) {
				return i;
			}
		}

		// If object is never found, -1 is returned
		return -1;
	}

	/**
	 * This method get returns the object at the specified index in the parameter
	 * from the array
	 * 
	 * @param index
	 */
	public Object get(int index) {
		if (index > numElements) { // if index is more than number of the elements, error
			throw new IllegalArgumentException();
		}
		// returns the object at the parameter given index in the array
		return arrayList[index];
	}

	/**
	 * This shiftRight method is called in the insert method as it iterates through
	 * the array and shifts it to the right
	 * 
	 * @param start
	 */
	private void shiftRight(int start) {
		// iterates through the array until the giving parameter value and shifts all
		// the array values to the right one
		for (int last = numElements; last >= start; last--) {
			arrayList[last + 1] = arrayList[last];
		}
	}

	/**
	 * This size method returns the size of the array as it goes through the array
	 * and increments a counter to keep track of the number of elements in the array
	 * 
	 * @return count
	 */
	public int size() {
		int count = 0;

		// checks to see if the number of elements is not 0. If not, it iterates through
		// the array ensuring all values are not null and upping the count value as each
		// element is accounted for
		if (numElements != 0) {
			for (int i = 0; i <= numElements; i++) {
				if (arrayList[i] != null) {
					count++;
				}
			}
		}
		// returns the count which contains the amt of elements aka size of the array
		return count;
	}

	/**
	 * This method toString puts all the elements of the array in a String to be
	 * returned
	 */
	@SuppressWarnings("unchecked")
	public String toString() {
		// declare a return value String type
		String retVal = "";
		// iterate over array
		for (int i = 0; i < arrayList.length; i++) {
			// null check
			if ((T) arrayList[i] == null) {
				continue;
			} else {
				// if not null add this to String return value
				retVal += (T) arrayList[i] + "\n ";
			}
		}
		return retVal; // return string with elements of the array
	}

	/**
	 * This isEmpty method returns a boolean that tells us if the array is empty or
	 * not
	 * 
	 * @return true, false
	 */
	@SuppressWarnings("unchecked")
	public boolean isEmpty() {
		// iterate over array
		for (int first = 0; first < numElements; first++)
			// check if null, return false if true
			if ((T) arrayList[first] != null) {
				return false;
			}
		return true; // else return true if no element is null
	}

	/**
	 * Equals method tests to see if the current object is equal to the parameter
	 * object
	 */
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {

		// First checks if parameter object is not equal to null and that it is an
		// instance of class ArrayList. If true, sets parameter object equal to an
		// ArrayList newAL.
		if ((T) obj != null && (T) obj instanceof ArrayList == true) {
			ArrayList newAL = (ArrayList) (T) obj;

			// checks to see if current and given arraylists are the same size. If so, it
			// iterates through the arraylist and checks to see if every element of each
			// arraylist is the same. If they are not, it returns false. Otherwise it
			// returns true.
			if (this.size() == (newAL.size())) {
				for (int i = 0; i <= size(); i++) {
					if ((T) this.arrayList[i] != (T) newAL.arrayList[i]) {
						return false;
					}
					return true;
				}
			}
		}

		// False is returned if original condition of this arraylist and parameter
		// object not being null and being of the same class are not met
		return false;
	}

	@Override
	/**
	 * This Iterator returns an iterator that iterates over elements of type T
	 */
	public Iterator<T> iterator() {

		// returns a new Instance of Iterator that iterates over elements of type T
		return new Iterator<T>() {
			@Override
			// creates an overridden boolean hadNext method that checks to see if there is a
			// next value
			// in the
			// array
			public boolean hasNext() {
				// if the current index the iterator is on is less than the number of elements,
				// there is a next element and true is returned. Else, false is
				// returned.
				if (current < numElements)
					return true;
				else
					return false;
			}

			@Override
			@SuppressWarnings("unchecked")
			/**
			 * This overridden next method returns the next value in the array if it exists
			 */
			public T next() {
				// Calls hasNext method to see if a next element exists. If not, it throws an
				// exception
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				// returns the element at the next index value from where the current of the
				// iterator was at in the array
				return (T) arrayList[current++];
			}
		};
	}
}