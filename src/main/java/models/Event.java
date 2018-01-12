package models;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String name;
    private String description;
    private List<Object>attendeeList = new ArrayList<>();
    private int year;
    private int day;
    private String month;
    private String attendee;
    private static ArrayList<Event>instances = new ArrayList<>();
    private int id;


    public Event(String name, String description, int year, int day, String month, String attendee) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.day = day;
        this.month = month;
        this.attendee = attendee;
        attendeeList.add(this.attendee);
        instances.add(this);
        this.id = instances.size();
    }

    public static void clearAllEvents() {
        instances.clear();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Object> getAttendeeList() {
        return attendeeList;
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getAttendee() {
        return attendee;
    }

    public static ArrayList<Event> getAll() {
        return instances;
    }

    public int getId() {
        return id;
    }
}
