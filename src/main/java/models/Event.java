package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Event {
    private String name;
    private String description;
    public static ArrayList<Event>attendees = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private int year;
    private int day;
    private String month;


    public Event(String name, String description, int year, int day, String month) {
        this.name = name;
        this.description = description;
        this.year = year;
        this.day = day;
        this.month = month;

    }

}
