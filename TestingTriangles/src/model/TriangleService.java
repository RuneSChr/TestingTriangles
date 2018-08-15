package model;

import java.util.List;

import model.TriangleState;

public class TriangleService {

	// I use final arraylist because the list content does not change once the app
	// is executed
	public TriangleState checkState(final List<Integer> dimensions) {
		
		// if the first 3 method calls succeed, and therefor invalid triangles
		// they will throw an exception telling the user what is wrong -- early exit
		
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

	// all sides are equal -- returns boolean 
	boolean isEquilateral(final List<Integer> dimensions) {

		int a = dimensions.get(0);
		int b = dimensions.get(1);
		int c = dimensions.get(2);

		if (a == b && b == c && c == a) {

			return true;
		}
		
		return false;
	}

	// no sides are equal - returns boolean
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
	boolean isScalene(final List<Integer> dimensions) {

		int a = dimensions.get(0);
		int b = dimensions.get(1);
		int c = dimensions.get(2);

		if (a == b && a != c || b == c && a != b || c == a && c != b) {

			return true;

		}

		return false;
	}

	// I felt that it was best if the app threw an exception if "invalid" for
	// testing purposes.
	// the sum of 2 sides cannot be shorter than the remaining side, throws illegal
	// argument exception
	void checkInequality(final List<Integer> dimensions) {

		int a = dimensions.get(0);
		int b = dimensions.get(1);
		int c = dimensions.get(2);

		if (a + b < c || a + c < b || b + c < a) {

			throw new IllegalArgumentException("Sum of two sides cannot be less than the remaining side");

		}
	}

	// if a side is equal to or less than zero, throws illegal argument exception
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

	void checkSize(final List<Integer> dimensions) {

		if (dimensions.size() < 3) {

			throw new IllegalArgumentException("3 inputs is needed");

		}
	}

}
