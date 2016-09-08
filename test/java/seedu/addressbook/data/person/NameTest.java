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
	public void checkIsSimilarDifferentNameTest() throws IllegalValueException{
		Name other = new Name("Carl");
		assertEquals(name.isSimilar(other), false);
	}
	
}
