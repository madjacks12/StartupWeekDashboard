package dao;

import models.Event;
import models.Attendees;

import java.util.List;

public interface EventDao {

    void add (Event event);

    List<Event> getAll();
    Event findById(int id);
//    List<Attendees> getAllAttendeesByEvent(int eventId);
//

//
//    void update(int id, String name, String description, String date, String time);
//
//    void deleteById(int id);
//    void clearAllEvents();
}
