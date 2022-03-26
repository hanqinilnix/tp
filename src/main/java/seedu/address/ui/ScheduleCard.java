package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.model.person.Person;
import seedu.address.model.schedule.Schedule;

/**
 * An UI component that displays information of a {@code Person} in the viewed version.
 */
public class ScheduleCard extends UiPart<Region> {

    private static final String FXML = "ScheduleCard.fxml";

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private VBox cardRows;
    @FXML
    private Label name;
    @FXML
    private Label phone;
    @FXML
    private Label scheduleHeader;
    @FXML
    private HBox scheduleBox;
    @FXML
    private Label upcomingScheduleHeader;
    @FXML
    private HBox upcomingScheduleBox;
    @FXML
    private FlowPane tags;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public ScheduleCard(Person person) {
        super(FXML);
        ImageView scheduleIcon = new ImageView("/images/schedule_icon.png");
        scheduleIcon.setFitHeight(16);
        scheduleIcon.setFitWidth(16);

        ImageView upcomingScheduleIcon = new ImageView("/images/schedule_icon.png");
        upcomingScheduleIcon.setFitHeight(16);
        upcomingScheduleIcon.setFitWidth(16);

        this.person = person;
        name.setText(person.getName().value);
        phone.setText(person.getPhone().value);
        scheduleHeader.setText(String.format("%1$s's Schedule", person.getName().value));
        upcomingScheduleHeader.setText(String.format("%1$s's Upcoming Schedule", person.getName().value));

        if (!Schedule.isEmptySchedule(person.getSchedule())) {
            Label scheduleLabel = new Label(person.getSchedule().toString());
            scheduleBox.getChildren().add(scheduleLabel);
        }

        if (!Schedule.isEmptySchedule(person.getUpcomingSchedule())) {
            Label upcomingScheduleLabel = new Label(person.getUpcomingSchedule().toString());
            upcomingScheduleBox.getChildren().add(upcomingScheduleLabel);
        }

        person.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ScheduleCard)) {
            return false;
        }

        // state check
        ScheduleCard card = (ScheduleCard) other;
        return person.equals(card.person);
    }
}
