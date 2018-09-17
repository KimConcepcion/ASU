package windowBuilder.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.MyDumbClass;

public class Test1 {

	//	Initialiseret før klassen udføres:
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	//	Rydde op efter klassen blev udført:
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private MyDumbClass dumb;
	
	@Before
	public void setUp() throws Exception {
		dumb = new MyDumbClass();
	}

	//	Testmetode:
	@Test
	public void test() {
		//assertTrue(true);
		assertEquals(dumb.myret(), "Hello");
	}
}
