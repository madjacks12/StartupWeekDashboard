package models;

import java.util.ArrayList;
import java.util.Objects;

public class Attendees {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int eventId;

    public Attendees(String firstName, String lastName, String email, String phone, int EventId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.eventId = eventId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attendees attendees = (Attendees) o;

        if (eventId != attendees.eventId) return false;
        if (!firstName.equals(attendees.firstName)) return false;
        if (!lastName.equals(attendees.lastName)) return false;
        if (email != null ? !email.equals(attendees.email) : attendees.email != null) return false;
        return phone != null ? phone.equals(attendees.phone) : attendees.phone == null;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + eventId;
        return result;
    }
}