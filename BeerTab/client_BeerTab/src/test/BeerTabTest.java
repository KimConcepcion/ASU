package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//	Import package with methods to test:
import common.Person;
import common.beerType;

public class BeerTabTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private Person person;
	
	@Before
	public void setUp() throws Exception 
	{
		person = new Person();
	}
	
	@Test
	public void test() 
	{	
		//	Test addBeer() - Add 3x Newcastle beers:
		person.bType=beerType.NewCastle;
		assertEquals(1, person.addBeer(person.bType));
		assertEquals(2, person.addBeer(person.bType));
		assertEquals(3, person.addBeer(person.bType));
		
		//	Test addBeer() - Add 2x Carlsberg beers:
		person.bType=beerType.Carlsberg;
		assertEquals(4, person.addBeer(person.bType));
		assertEquals(5, person.addBeer(person.bType));
		
		//	Calculate payment:
		person.setPayment();
		
		//	Test getPayment() - Test price of 3x Newcastle beers:
		assertEquals(70, person.getPayment());
		
		//	Test removeBeer() - Test amount of remaining Carlsberg beers:
		assertEquals(4, person.removeBeer(person.bType));
		
		//	Test print of hashmap:
		person.printHashMap(person.beerMap);		
	}
}