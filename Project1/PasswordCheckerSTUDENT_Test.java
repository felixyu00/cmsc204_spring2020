import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import _solution.InvalidSequenceException;
import _solution.LengthException;
import _solution.NoDigitException;
import _solution.NoLowerAlphaException;
import _solution.NoUpperAlphaException;
import _solution.PasswordCheckerUtility;


/**
 * STUDENT unit tests for the methods of PasswordChecker
 * @author felixyu00
 *
 */

public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords;
	String password1, password2;
	private Scanner scan;

	@Before
	public void setUp() throws Exception {
		String[] p = {"Felixyu0618!", "Fel12", "FelixYuChiuHang", "felixyuchiuhang123", "HELLOWORLD123", "FelixxxYu123", 
				"FelixYu123", "", "Felix123"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); // puts strings into the ArrayList
		
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Felixyu0618!"));
			PasswordCheckerUtility.isValidPassword("Fel12");
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one upper case alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Felixyu0618!"));
			PasswordCheckerUtility.isValidPassword("felixyuchiuhang123");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lower case alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Felixyu0618!"));
			PasswordCheckerUtility.isValidPassword("HELLOWORLD123");
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertTrue(PasswordCheckerUtility.isWeakPassword("Felix123"));
			assertFalse(PasswordCheckerUtility.isWeakPassword("Felixyu0618!"));
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Felixyu0618!"));
			PasswordCheckerUtility.isValidPassword("FelixxxYu123");
			assertTrue("Did not throw InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Felixyu0618!"));
			PasswordCheckerUtility.isValidPassword("FelixYuChiuHang");
			assertTrue("Did not throw NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Felixyu0618!")); //valid password
			PasswordCheckerUtility.isValidPassword("Fel12"); //invalid password
			assertTrue("Did not throw any Exception",false);
		}
		catch(Exception e)
		{
			assertTrue("Threw some exception.",true);
		}
	}
	
	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 * @throws InvalidSequenceException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 */
	@Test
	public void testValidPasswords() throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, InvalidSequenceException {
		ArrayList<String> results;
		results = PasswordCheckerUtility.invalidPasswords(passwords);
		scan = new Scanner(results.get(0));
		assertEquals(scan.next(), "Fel12");

	}
	
}