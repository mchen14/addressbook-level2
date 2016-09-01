package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;

	public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     * Minimal address needs a Block and Street
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
    	String[] parts = address.split(",");
    	
    	this.block = new Block(Integer.parseInt(parts[0]));
    	this.street = new Street(parts[1]);
    	this.unit = (parts.length > 2) ? new Unit(parts[2]) : new Unit("");
    	this.postalCode = (parts.length > 3) ? new PostalCode(parts[3]) : new PostalCode("");
    	
        this.value = this.block.value + "," +  this.street.value + 
        		((this.unit.value == "") ? "" : "," + this.unit.value) + 
        		((this.postalCode.value == "") ? "" : "," + this.postalCode.value);
        
    }
    /*
     * Basic getters for returning specific information about the address. 
     */
    public Block getBlock() {
		return block;
	}
	public Street getStreet() {
		return street;
	}
	public Unit getUnit() {
		return unit;
	}
	public PostalCode getPostalCode() {
		return postalCode;
	}

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}