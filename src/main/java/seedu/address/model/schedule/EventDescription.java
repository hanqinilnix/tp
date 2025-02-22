package seedu.address.model.schedule;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class EventDescription {
    public static final String MESSAGE_CONSTRAINTS =
            "Event descriptions cannot contain \"/\", cannot be blank, and contains at most 60 characters";
    public static final String VALIDATION_REGEX = "^(?!.*\\/).+$";
    public final String value;

    /**
     * Constructs a {@code Name}.
     *
     * @param eventDescription A valid eventDescription.
     */
    public EventDescription(String eventDescription) {
        requireNonNull(eventDescription);
        checkArgument(isValidEventDescription(eventDescription), MESSAGE_CONSTRAINTS);
        this.value = eventDescription;
    }

    /**
     * Returns true if a given string is a valid eventDescription.
     */
    public static boolean isValidEventDescription(String test) {
        return test.trim().matches(VALIDATION_REGEX) && test.trim().length() <= 60;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EventDescription // instanceof handles nulls
                && value.toLowerCase().equals(((EventDescription) other).value.toLowerCase())); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
