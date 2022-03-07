package seedu.address.testutil;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Telegram;
import seedu.address.model.schedule.Event;
import seedu.address.model.schedule.EventDescription;
import seedu.address.model.schedule.Schedule;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_TELEGRAM = "Amy_Bee";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private Name name;
    private Phone phone;
    private Telegram telegram;
    private Email email;
    private Address address;
    private Schedule schedule;
    private Set<Tag> tags;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        telegram = Telegram.DEFAULT_TELEGRAM;
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        schedule = new Schedule(new ArrayList<>());
        tags = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        telegram = personToCopy.getTelegram().orElse(Telegram.DEFAULT_TELEGRAM);
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        schedule = new Schedule(personToCopy.getSchedule().getEvents());
        tags = new HashSet<>(personToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Telegram} of the {@code Person} that we are building.
     */
    public PersonBuilder withTelegram(String telegram) {
        this.telegram = new Telegram(telegram);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Parses the {@code schedule} into a {@code Schedule} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withSchedule(Schedule schedule) {
        this.schedule = schedule;
        return this;
    }

    /**
     * Parses the {@code event} and set it to the {@code Schedule} of the {@code Person} that we are building.
     */
    public PersonBuilder withEvent(String eventDescription, String date, String time, String duration) {
        EventDescription eventDescription1 = new EventDescription(eventDescription);
        try {
            LocalDate date1 = ParserUtil.parseDate(date);
            LocalTime time1 = ParserUtil.parseTime(time);
            Duration duration1 = ParserUtil.parseDuration(duration);
            Event event = new Event(eventDescription1, date1, time1, duration1);
            ArrayList<Event> newEvents = new ArrayList<>();
            for (Event e : this.schedule.getEvents()) {
                newEvents.add(e);
            }
            newEvents.add(event);
            this.schedule = new Schedule(newEvents);
            return this;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Person build() {
        return new Person(name, phone, telegram, email, address, schedule, tags);
    }

}
