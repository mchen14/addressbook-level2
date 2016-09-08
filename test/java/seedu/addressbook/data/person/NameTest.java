package seedu.addressbook.data.person;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Name;

public class NameTest {
	private Name name;
	@Before
	public void setup() throws IllegalValueException{
		name = new Name("Charlie");
	}
	
	@Test
	public void checkIsSimilarNullTest(){
		Name other = null;
		assertEquals(name.isSimilar(other), false);
	}
	@Test
	public void checkIsSimilarExactNameTest() throws IllegalValueException{
		Name other = new Name("Charlie");
		assertEquals(name.isSimilar(other), true);
	}
	@Test
	public void checkIsSimilarCompletelyDifferentNameTest() throws IllegalValueException{
		Name other = new Name("Aardvark");
		assertEquals(name.isSimilar(other), false);
	}
	@Test
	public void checkIsSimilarDifferentCaseTest() throws IllegalValueException{
		Name other = new Name("chARLIE"); //this is pronounced by heavily emphasizing the capitalized letters.
		assertEquals(name.isSimilar(other), true);
	}
}
