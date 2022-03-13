package seedu.address.logic.parser.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.logic.commands.person.ViewGroupCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.IsTagInPersonPredicate;
import seedu.address.model.tag.Tag;

public class ViewGroupCommandParser implements Parser<ViewGroupCommand> {
    @Override
    public ViewGroupCommand parse(String userInput) throws ParseException {
        requireNonNull(userInput);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(userInput, PREFIX_TAG);

        boolean hasTagPrefix = argMultimap.getValue(PREFIX_TAG).isPresent();

        if (hasTagPrefix) {
            Tag tag = new Tag(argMultimap.getValue(PREFIX_TAG).get());

            return new ViewGroupCommand(new IsTagInPersonPredicate(tag));
        } else {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewGroupCommand.MESSAGE_USAGE));
        }
    }
}
