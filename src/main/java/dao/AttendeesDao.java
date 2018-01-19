package dao;

import models.Attendees;

import java.util.List;

public interface AttendeesDao {

    void add (Attendees attendees);

    List<Attendees> getAll();

    Attendees findById(int id);

    void update(int id, String firstName, String lastName, String phone, String email);

    void deleteById(int id);
    void clearAllAttendees();
}