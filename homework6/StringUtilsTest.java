package homework6;

import static junit.framework.TestCase.assertEquals;

public class StringUtilsTest {
	@org.junit.Before
	public void setUp() throws Exception {

	}

	@org.junit.Test
	public void removeSpaces() throws Exception {

		assertEquals(StringUtils.removeSpaces("    a"), "a");
		assertEquals(StringUtils.removeSpaces("          a"), "a");
		assertEquals(StringUtils.removeSpaces("         \t a"), "a");
		assertEquals(StringUtils.removeSpaces("          \na   "), "a");
		assertEquals(StringUtils.removeSpaces("          \na \t"), "a");
		assertEquals(StringUtils.removeSpaces("          \na  "), "a");
		assertEquals(StringUtils.removeSpaces("          \na     \n"), "a");
	}

	@org.junit.Test
	public void replaceNumbers() throws Exception {
		assertEquals(StringUtils.replaceNumbers("I have four apples"), "I have 4 apples");
		assertEquals(StringUtils.replaceNumbers("I want twenty-nine dollars"), "I want twenty-nine dollars");
		assertEquals(StringUtils.replaceNumbers("I want twenty nine dollars"), "I want twenty 9 dollars");
		assertEquals(StringUtils.replaceNumbers("Five six SEVEN eiGHt!!"), "5 6 7 eiGHt!!");

	}
}