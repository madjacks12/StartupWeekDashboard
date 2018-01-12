package models;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String name;
    private String description;
    private int year;
    private int day;
    private String month;
    private String attendees;
    private static ArrayList<Event>instances = new ArrayList<>();
    private int id;


    public Event(String name, String description, int year, int day, String month, String attendees) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.day = day;
        this.month = month;
        instances.add(this);
        this.attendees = attendees;
        this.id = instances.size();
    }

    public String getAttendees() {
        return attendees;
    }

    public static Event findById(int id){
        return  instances.get(id-1);
    }

    public void update(String name, String description, String attendees, String month, int year, int day) {
        this.name = name;
        this.description=description;
        this.attendees=attendees;
        this.month=month;
        this.year=year;
        this.day=day;
    }
    public void deletePost() {
        instances.remove(id-1);
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

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public static ArrayList<Event> getAll() {
        return instances;
    }

    public int getId() {
        return id;
    }
}
