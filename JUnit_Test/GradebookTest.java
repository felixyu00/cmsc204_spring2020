import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

	public class GradebookTest {
		
		//initiating the two gradebooks
		GradeBook g1, g2;
		
		@Before
		public void setUp() throws Exception {
					
			//initiating the gradebook and adding grades 
			g1 = new GradeBook(5);
			g1.addScore(97);
			g1.addScore(83);
			g1.addScore(91);
			
			g2 = new GradeBook(4);
			g2.addScore(55);
			g2.addScore(86);
			
		}

		@After
		public void tearDown() throws Exception {
			g1 = null;
			g2 = null;
		}
		
		@Test //test toString()
		public void testAddScoreMethod() {
			assertTrue(g1.toString().equals("97 83 91 "));
			assertTrue(g2.toString().equals("55 86 "));
		}
		
		@Test //test sum()
		public void testSumMethod() {
			assertEquals(271, g1.sum(), .0001);
			assertEquals(141, g2.sum(), .0001);
			
		}
		
		@Test //test minimum()
		public void testMinimumMethod() {
			assertEquals(83, g1.minimum(), .001);
			assertEquals(55, g2.minimum(), .001);
		}
		
		@Test //test finalScore()
		public void testFinalScoreMethod() {
			assertEquals(188, g1.finalScore(), .001);
			assertEquals(86, g2.finalScore(), .001);
		}

	
	}
