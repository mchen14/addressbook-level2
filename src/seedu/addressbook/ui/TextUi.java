package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;
import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.common.Utils;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class TextUi {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    private final Scanner in;
    private final PrintStream out;
    private final Formatter format;
    public TextUi(){
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
        format = new Formatter(out);
    }

    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    private boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }

    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    private boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     * Ignores empty, pure whitespace, and comment lines.
     * Echos the command back to the user.
     * @return command (full line) entered by the user
     */
    public String getUserCommand() {
        out.print(LINE_PREFIX + "Enter command: ");
        String fullInputLine = in.nextLine();

        // silently consume all ignored lines
        while (shouldIgnore(fullInputLine)) {
            fullInputLine = in.nextLine();
        }

        format.showToUser("[Command entered:" + fullInputLine + "]");
        return fullInputLine;
    }

    /** Wrapper method for formatter. */
    public void showWelcomeMessage(String version, String storageFilePath) {
        format.showWelcomeMessage(version, storageFilePath);
    }
    /** Wrapper method for formatter. */
    public void showGoodbyeMessage() {
        format.showGoodbyeMessage();
    }

    /** Wrapper method for formatter. */
    public void showInitFailedMessage() {
    	format.showInitFailedMessage();
    }
    /** Wrapper method for formatter. Shows message to user. */
    public void showToUser(String... message){
        format.showToUser(message);
    }

    /**
     * wrapper method for Formatter to format the result of the CommandResult and display
     * to user. 
     */
    public void showResultToUser(CommandResult result) {
        format.showResultToUser(result);
    }

}
