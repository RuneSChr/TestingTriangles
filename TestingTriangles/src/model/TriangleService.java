package model;

import java.util.List;

import model.TriangleState;

public class TriangleService {

	/**
	 * returns the state/enum of the given inputs in the list that is provided as an argument in the method
	 * early exit if the conditions of checkSize(), checkSidesLength() and checkInequality are true which will trigger an exception
	 * @param dimensions a list of integers that is final because I do not expect, nor want, the content to change through execution
	 * @returns the state/enum of the triangle
	 */
	public TriangleState checkState(final List<Integer> dimensions) {
		
		checkSize(dimensions);
		checkSidesLength(dimensions);
		checkInequality(dimensions);

		if (isEquilateral(dimensions)) {

			return TriangleState.EQUILATERAL;

		} else if (isIsoceles(dimensions)) {

			return TriangleState.ISOCELES;

		}

		return TriangleState.SCALENE;
	}

	/**
	 * returns a boolean, true if the sides of the given inputs are all equal to one another
	 * returns false if not
	 * takes a final list as argument because the content of the list should not change underway
	 * final because the content of the list should not change
	 * @param dimensions
	 * @return boolean
	 */
	boolean isEquilateral(final List<Integer> dimensions) {

		int a = dimensions.get(0);
		int b = dimensions.get(1);
		int c = dimensions.get(2);

		if (a == b && b == c && c == a) {

			return true;
		}
		
		return false;
	}

	/**
	 * returns a boolean, true if the sides of the given triangle are all different from one another
	 * else it returns false
	 * @param dimensions
	 * @return boolean
	 */
	boolean isIsoceles(final List<Integer> dimensions) {

		int a = dimensions.get(0);
		int b = dimensions.get(1);
		;
		int c = dimensions.get(2);

		if (a != b && a != c && b != c) {

			return true;
		}
		
		return false;
	}

	// two sides are equal
	/**
	 * returns a boolean, true if 2 of 3 sides are equal
	 * else it returns false
	 * @param dimensions
	 * @return boolean
	 */
	boolean isScalene(final List<Integer> dimensions) {

		int a = dimensions.get(0);
		int b = dimensions.get(1);
		int c = dimensions.get(2);

		if (a == b && a != c || b == c && a != b || c == a && c != b) {

			return true;

		}

		return false;
	}

	
	/**
	 * method to check for the inequality concept, where the sum of 2 sides cannot be less than the remainder
	 * throws and exception telling the user what is wrong if the condition is true
	 * otherwise it does nothing
	 * @param dimensions
	 * @throws IllegalArgumentException
	 */
	void checkInequality(final List<Integer> dimensions) {

		int a = dimensions.get(0);
		int b = dimensions.get(1);
		int c = dimensions.get(2);

		if (a + b < c || a + c < b || b + c < a) {

			throw new IllegalArgumentException("Sum of two sides cannot be less than the remaining side");

		}
	}

	// if a side is equal to or less than zero, throws illegal argument exception
	/**
	 * method that checks if the sides of the triangle are 0 or less, if they are 
	 * the method will throw an IllegalArgumentException telling the user what is wrong
	 * if sides are okay it will do nothing
	 * @param dimensions
	 * @throws IllegalArgumentException
	 */
	void checkSidesLength(final List<Integer> dimensions) {

		int a = dimensions.get(0);
		int b = dimensions.get(1);
		int c = dimensions.get(2);

		if (

		a <= 0 || b <= 0 || c <= 0)

		{

			throw new IllegalArgumentException("A side cannot be equal to or less than zero");

		}
	}

	/**
	 * method that checks if the size of the dimensions array is less than 3
	 * if it is, the method will throw and IllegalArgumentException telling the user what went wrong
	 * otherwise it will do nothing
	 * @throws IllegalArgumentException
	 */
	void checkSize(final List<Integer> dimensions) {

		if (dimensions.size() < 3) {

			throw new IllegalArgumentException("3 inputs is needed");

		}
	}

}
