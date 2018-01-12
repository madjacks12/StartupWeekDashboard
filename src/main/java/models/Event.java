package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private String name;
    private String description;
    public static List<Event>attendeeList = new ArrayList<>();
    private int year;
    private int day;
    private String month;
    private String attendee;


    public Event(String name, String description, int year, int day, String month, String attendee) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.day = day;
        this.month = month;
        attendeeList.add(this);


    }

}
