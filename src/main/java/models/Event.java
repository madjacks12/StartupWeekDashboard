package models;

import java.util.Date;
import java.util.ArrayList;

public class Event {
    private String name;
    private String description;
    private Date date;
    public static ArrayList<Event>attendees = new ArrayList<>();

    public Event(String name, String description, Date date) {
        this.name = name;
        this.description = description;
        this.date=date;
    }
}
