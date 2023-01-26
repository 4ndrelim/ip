package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import duke.exceptions.InvalidDateException;

/**
 * Class for Event object.
 *
 * @author Andre Lin HuiKai
 * @version CS2103T AY22/23 Semester 2
 */
public class Event extends Task {
    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * Constructor for an Event object.
     * @param des Description of the event.
     * @param startDate The start date of the event.
     * @param endDate The end date of the event.
     * @throws InvalidDateException Throws InvalidDateException if the string representation of deadline is not of the correct format.
     */
    public Event(String des, String startDate, String endDate) throws InvalidDateException {
        super(des);
        try {
            this.startDate = LocalDate.parse(startDate);
            this.endDate = LocalDate.parse(endDate);
            if (this.startDate.compareTo(this.endDate) > 0) { // invalid end date before start
                throw new InvalidDateException();
            }
        } catch (DateTimeParseException e) {
            throw new InvalidDateException();
        }
    }

    /**
     * Displays formatted information about the event.
     * @return String informing users details about the event.
     */
    @Override
    public String getStatusIcon() {
        return String.format("[E]%s | FROM: %s TO: %s",
                super.getStatusIcon(),
                this.startDate.format(DateTimeFormatter.ofPattern("MMM d yyyy")),
                this.endDate.format(DateTimeFormatter.ofPattern("MMM d yyyy")));
    }

    /**
     * Encodes information about the event to be saved.
     * @return String representing encoded information about the task.
     */
    @Override
    public String encode() {
        return String.format("%s ### %s ### %s ### %s", "event", super.encode(), this.startDate, this.endDate);
    }

    /**
     * Checks if the event falls on a given date.
     * @param date The date to check against.
     * @return A boolean value that checks if the event falls on the specified day.
     */
    @Override
    public boolean fallsOnDate(LocalDate date) {
        return this.startDate.compareTo(date) * date.compareTo(this.endDate) >= 0;
    }
}