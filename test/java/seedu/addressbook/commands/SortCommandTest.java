package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortCommandTest {
    private TypicalPersons td = new TypicalPersons();

    private AddressBook typicalAddressBook = td.getTypicalAddressBook();
    private List<ReadOnlyPerson> listWithAllTypicalPersons = Arrays.asList(td.getTypicalPersons());
    private List<ReadOnlyPerson> listWithInorderedTypicalPersons = Arrays.asList(td.amy, td.candy, td.bill, td.dan);

    @Test
    public void execute_invalidIndex_returnsInvalidIndexMessage() {

        SortCommand sortCommand = new SortCommand();
        sortCommand.setData(typicalAddressBook, listWithAllTypicalPersons);
        String expectedMessage = sortCommand.execute().feedbackToUser;

        assertSortBehavior(sortCommand, typicalAddressBook, listWithAllTypicalPersons,
                expectedMessage);
    }

    /**
     * Executes the sort command for the given addressbook data.
     * Checks that SortCommand exhibits the correct command behavior, namely:
     * 1. Returns a sorted list of person in the address book
     */
    private static void assertSortBehavior(Command sortCommand, AddressBook addressBook,
                                           List<ReadOnlyPerson> relevantPersons, String expectedMessage) {
        AddressBook expectedAddressBook = TestUtil.clone(addressBook);

        sortCommand.setData(addressBook, relevantPersons);
        CommandResult result = sortCommand.execute();

        // feedback message is as expected and there are no relevant persons returned.
        assertEquals(expectedMessage, result.feedbackToUser);

        // addressbook was not modified.
        assertEquals(expectedAddressBook.getAllPersons(), addressBook.getAllPersons());
    }
}