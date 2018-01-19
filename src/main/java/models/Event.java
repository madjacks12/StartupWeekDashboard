package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Event {
    private String name;
    private String description;
    private String time;
    private int id;


    public Event(String name, String description, int year, int day, String time) {
        this.name = name;
        this.description = description;
        this.time=time;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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
        return time != null ? time.equals(event.time) : event.time == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
