package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Event {
    private String name;
    private String description;
    private String startDate;
    private String startTime;
    private int id;


    public Event(String name, String description, String startDate, String startTime) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (!name.equals(event.name)) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (startDate != null ? !startDate.equals(event.startDate) : event.startDate != null) return false;
        return startTime != null ? startTime.equals(event.startTime) : event.startTime == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}