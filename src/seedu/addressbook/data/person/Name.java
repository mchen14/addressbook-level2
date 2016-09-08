package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";

    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        name = name.trim();
        if (!isValidName(name)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = name;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }
    /*
     * Returns true of the other name is very similar to this name.
     * Two names are considered similar if the longest common subsequence's length is over half 
     * the shorter of the name's length.
     */
     public boolean isSimilar(Name other){
    	//set up base cases. 
    	if(other == null){
    		return false;
    	}
    	if(other.toString().toLowerCase().equals(this.fullName.toLowerCase())){
    		return true;
    	}
    	String subsequence = findLongestCommonSubsequence(this.fullName.toLowerCase(), other.fullName.toLowerCase());
    	if(subsequence.length() > this.fullName.length() / 2
    	|| subsequence.length() > other.fullName.length() / 2){
    		return true;
    	}
    	return false;
     }
     /*
      * Helper method for finding the LCS for name similarity. Names shouldn't be obscenely long
      * so this method is super inefficient because I only have like twenty minutes before tutorial.
      */
     public static String findLongestCommonSubsequence(String a, String b){
    	 if(a.isEmpty() || b.isEmpty()){
    		 return "";
    	 }
    	 if(a.charAt(0) == b.charAt(0)){
    		 return a.charAt(0) + findLongestCommonSubsequence(a.substring(1), b.substring(1));
    	 }
    	 String caseOne = findLongestCommonSubsequence(a.substring(1), b);
    	 String caseTwo = findLongestCommonSubsequence(a, b.substring(1));
    	 return (caseOne.length() > caseTwo.length())? caseOne: caseTwo;
     }
}
