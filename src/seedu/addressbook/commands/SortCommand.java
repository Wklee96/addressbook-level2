package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list with index numbers sorted by their name.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        List<ReadOnlyPerson> newList = new ArrayList<>(allPersons);
        Collections.sort(newList);
        return new CommandResult(getMessageForPersonListShownSummary(newList), newList);
    }
}
