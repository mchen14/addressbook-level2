package seedu.addressbook.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import seedu.addressbook.common.Utils;
import seedu.addressbook.data.AddressBook;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {
	private ArrayList<Object> uniqueItems;
	private ArrayList<Object> sameItems;
	@Before
	public void setup(){
		uniqueItems = new ArrayList<>();
		sameItems = new ArrayList<>();
		uniqueItems.add(new Integer(1));
		uniqueItems.add(new AddressBook());
		uniqueItems.add(null);
		uniqueItems.add(new Integer(5));
		sameItems.add(uniqueItems.get(1));
		sameItems.add(uniqueItems.get(1));
		
	}
	@Test
	public void nullReturnsTrueTest(){
		Object[] obj = {"what", new Integer(1), new AddressBook(), null};
		assertEquals(Utils.isAnyNull("what", new Integer(1), new AddressBook(), null), true);
	}
	
	@Test
	public void notNullReturnsFalseTest(){
		Object[] obj = {"what", new Integer(1), new AddressBook() };
		assertEquals(Utils.isAnyNull(obj), false);
	}
	
	@Test
	public void uniqueElementsTrueTest(){
		assertEquals(Utils.elementsAreUnique(uniqueItems), true);
	}
	@Test
	public void uniqueElementsFalseTest(){
		assertEquals(Utils.elementsAreUnique(sameItems), false);
	}
	@Test
	public void emptyCollectionNullTest(){
		//Code is written such that an empty collection returns false for isAnyNull. Am assuming that 
		//is the correct interpretation.
		assertEquals(Utils.isAnyNull(new HashSet()), false);
	}
	@Test
	public void emptyCollectionUniqueTest(){
		assertEquals(Utils.elementsAreUnique(new HashSet()), true);
	}
}
