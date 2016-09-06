package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public abstract class Contact {
	public final String value;
	public final boolean isPrivate;
	public final String INVALID_VALUE = "Value is invalid. Please try again.";
	public Contact(String val, boolean isPriv) throws IllegalValueException{
		this.value = val;
		this.isPrivate = isPriv;
		if(!isValid(val)){
            throw new IllegalValueException(INVALID_VALUE);

		}
	}
	
    /**
     * Gets overridden by child classes. Needed for constructor. I think. Who knows.
     */
    private static boolean isValid(String test){
    	return true;
    }
    
    public abstract boolean equals(Object other);

    public String toString() {
        return value;
    }

    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
