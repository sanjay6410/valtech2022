package com.valtech.valtech_junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ArthimeticTest {
	
	private Arthimetic arithemetic;
	private static int ZERO;
	
	@org.junit.jupiter.api.Nested
	public class DivisionTest {
		private Arthimetic arithemetic;
		
		@Test
		public void testDivByZero() {
			arithemetic= new ArthimeticImpl();
			assertThrows(ArithmeticException.class, () ->{ arithemetic.div(2,ZERO);});
		}
	}
	
	@org.junit.jupiter.api.Nested
	@DisplayName("This is Testing sub mehod of arithemetic")
	public class substractionTest {
		
		private Arthimetic arithemetic;
		
		@ParameterizedTest
		@CsvSource({
			"'Substracting 2 Positive Numbers',2,3,-1",
			"'Substracting 2 Negative Numbers',-2,-3,1",
			"'Substracting 1 positive Number And 1 Negative Numbers',-2,3,-5",
		})
		
		public void testSub(String name,int a,int b,int res){
			arithemetic= new ArthimeticImpl();
			assertEquals(res, arithemetic.sub(a, b));
		}
	}
	
	@DisplayName("{index}) {0} {1} +{2}={3}")
	@ParameterizedTest
	@CsvSource({
		"'Adding 2 Positive Numbers',2,3,5",
		"'Adding 2 Negative Numbers',-2,-3,-5",
		"'Adding 1 positive Number And 1 Negative Numbers',-2,3,1",
	})
	public void testAdd(String name,int a,int b,int res) {
		
	}
	
	public static Stream<Arguments> argumentsForAdd() {
        return Stream.of(Arguments.of(2,3,5),Arguments.of(1,3,4));
    }
    
    
	@DisplayName(value="{index}) Testing for add with {0} and {1} should be equals {2}")
	@ParameterizedTest
	@MethodSource("argumentsForAdd")
	public void testAdd(int a,int b,int res){
	   
	}
	
	
	@ParameterizedTest
    @ValueSource(ints = {2,3,4,-1,-2})
	@DisplayName(value="{index}) Testing for add with {0} and 0")
    public void testAdd(int a) {
        assertEquals(a, arithemetic.add(a, ZERO));
    }
    
    
    @Test
    @DisplayName("Generic Test Cases for Add ....")
    public void testAdd() {
        assertEquals(5, arithemetic.add(2, 3));
        assertEquals(6, arithemetic.add(2, 4));
    }
	@BeforeAll
	public static void executeMeFirst(){
		System.out.println("Before All-Executed First");
		ZERO=0;
	}
	
	@AfterAll
	public static void executeMeLast(){
		System.out.println("Last Method to be Executed");
	}
	
	
	
	
	@BeforeEach
	public void runBeforetest()
	{
		arithemetic=new ArthimeticImpl();
		System.out.println("Run Before.........");
		
	}
	@AfterEach
	public void afterTest()
	{
		System.out.println("After Each Method.........");
	}
	@Test
	public void testHello()
	{
//		assertTrue(true);
		System.out.println("Hello..");
	}
	@Test
	public void testHi()
	{
//		assertTrue(true);
		System.out.println("Hi..");
	}
	

}
