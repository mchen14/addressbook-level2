package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Taggings {
	private final Person person;

	private final Tag tag;
	private final boolean isAdded;
	public Taggings(Person p, Tag t, boolean added){
		this.person = p;
		this.tag = t;
		this.isAdded = added;
	}
	
	public Person getPerson() {
		return person;
	}
	public Tag getTag() {
		return tag;
	}
	public boolean isAdded() {
		return isAdded;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if(isAdded) {
			sb.append("+ ");
		} else {
			sb.append("- ");
		}
		sb.append(person.getName());
		sb.append(" " + tag.toString());
		
		return sb.toString();
	}
	
}
