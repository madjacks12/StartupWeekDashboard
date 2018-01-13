package models;

import java.util.ArrayList;

public class Attendees {
    private ArrayList<Attendees> attendeeList = new ArrayList<>();

    public Attendees(ArrayList attendeeList){
        attendeeList.add(this);

    }

    public ArrayList<Attendees> getAttendeeList() {
        return attendeeList;
    }
}
