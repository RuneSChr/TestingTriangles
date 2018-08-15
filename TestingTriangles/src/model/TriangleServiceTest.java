package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TriangleServiceTest {

	List<Integer> dimensions = new ArrayList<>(3);
	TriangleService triangleService = new TriangleService();
	
	@Test
	public void checkStates_isEquilateral_if_statement_succes() {
		
		dimensions.add(2);
		dimensions.add(2);
		dimensions.add(2);
		
		assertEquals(TriangleState.EQUILATERAL, triangleService.checkState(dimensions));
	}
	
	@Test
	public void checkStates_isEquilateral_if_statement_fail() {
		
		dimensions.add(1);
		dimensions.add(2);
		dimensions.add(3);
		
		assertEquals(TriangleState.ISOCELES, triangleService.checkState(dimensions));
	}
	
	@Test
	public void checkStates_isIsoceles_if_statement_succes() {
		
		dimensions.add(1);
		dimensions.add(2);
		dimensions.add(3);
		
		assertEquals(TriangleState.ISOCELES, triangleService.checkState(dimensions));
	}
	
	@Test
	public void checkStates_isIsoceles_if_statement_fail() {
		
		dimensions.add(1);
		dimensions.add(3);
		dimensions.add(3);
		
		assertEquals(TriangleState.SCALENE, triangleService.checkState(dimensions));
	}
	
	@Test
	public void checkStates_isScalene_if_statement_succes() {
		
		dimensions.add(1);
		dimensions.add(2);
		dimensions.add(2);
		
		assertEquals(TriangleState.SCALENE, triangleService.checkState(dimensions));
	}
	
	@Test
	public void checkStates_isScalene_if_statement_fail() {
		
		dimensions.add(1);
		dimensions.add(2);
		dimensions.add(3);
		
		assertEquals(TriangleState.ISOCELES, triangleService.checkState(dimensions));
	}
	
	//use _ format instead of camel express what is being tested
	@Test(expected = IllegalArgumentException.class)
	public void inequality_when_the_sum_of_2_sides_are_less_than_the_remainder_throw_IllegalArgumentException() {
		
		dimensions.add(5);
		dimensions.add(2);
		dimensions.add(2);
		
		triangleService.checkInequality(dimensions);
		
	}
	
	@Test()
	public void inequality_when_the_sum_of_2_sides_are_less_than_the_remainder_do_nothing() {
		
		dimensions.add(3);
		dimensions.add(2);
		dimensions.add(2);
		
		triangleService.checkInequality(dimensions);
		
	}
	
	
	//positive case for fail cases
	
	@Test(expected = IllegalArgumentException.class)
	public void sidesLength_succes_sides_cannot_be_equal_or_less_than_0_should_throw_IllegalArgumentException() {
		
		dimensions.add(0);
		dimensions.add(2);
		dimensions.add(2);
		
		triangleService.checkSidesLength(dimensions);
		
	}
	
	@Test()
	public void sidesLength_sides_cannot_be_equal_or_less_than_0_should_do_nothing() {
		
		dimensions.add(2);
		dimensions.add(2);
		dimensions.add(2);
		
		triangleService.checkSidesLength(dimensions);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void size_of_list_has_to_be_3_should_throw_IllegalArgumentException() {
		
		triangleService.checkSize(dimensions);
		
	}
	
	@Test()
	public void size_of_list_has_to_be_3_should_do_nothing() {
		
		dimensions.add(2);
		dimensions.add(2);
		dimensions.add(2);
		
		triangleService.checkSize(dimensions);
		
	}	
	
	@Test
	public void equilateral_succes_all_sides_are_equal() {
		
		dimensions.add(2);
		dimensions.add(2);
		dimensions.add(2);
		
		assertTrue(triangleService.isEquilateral(dimensions));

	}
	
	@Test
	public void equilateral_succes_all_sides_are_not_equal() {
		
		dimensions.add(1);
		dimensions.add(2);
		dimensions.add(2);
		
		assertFalse(triangleService.isEquilateral(dimensions));

	}
	
	@Test
	public void isoceles_Succes_all_sides_are_different() {
		
		dimensions.add(1);
		dimensions.add(2);
		dimensions.add(3);
		
		assertTrue(triangleService.isIsoceles(dimensions));

	}
	
	@Test
	public void isoceles_Succes_all_sides_are_not_different() {
		
		dimensions.add(2);
		dimensions.add(2);
		dimensions.add(3);
		
		assertFalse(triangleService.isIsoceles(dimensions));

	}
	
	@Test
	public void scalene_Succes_2_sides_are_equal() {
		
		dimensions.add(2);
		dimensions.add(2);
		dimensions.add(3);
		
		assertTrue(triangleService.isScalene(dimensions));

	}
	
	@Test
	public void scalene_Succes_2_sides_are_not_equal() {
		
		dimensions.add(4);
		dimensions.add(2);
		dimensions.add(3);
		
		assertFalse(triangleService.isScalene(dimensions));

	}
	
}
