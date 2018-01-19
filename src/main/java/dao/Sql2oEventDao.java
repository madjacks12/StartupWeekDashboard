package dao;

import models.*;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oEventDao implements EventDao{

    private final Sql2o sql2o;

    public Sql2oEventDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Event event) {

        String sql = "INSERT INTO events (name, description, startDate, startTime) VALUES (:name, :description, :startDate, :startTime)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .addParameter("name", event.getName())
                    .addParameter("description", event.getDescription())
                    .addParameter("startDate", event.getStartDate())
                    .addParameter("startTime", event.getStartTime())
                    .addColumnMapping("NAME", "name")
                    .addColumnMapping("DESCRIPTION", "description")
                    .addColumnMapping("DATE", "startDate")
                    .addColumnMapping("TIME", "StartTime")
                    .executeUpdate()
                    .getKey();
            event.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }
    }

    @Override
    public List<Event> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM events")
                    .executeAndFetch(Event.class);
        }
    }

    @Override
    public Event findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM events WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Event.class); //fetch an individual item
        }
    }

    @Override
    public List<Attendees> getAllAttendeesByEvent(int eventId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM attendees WHERE eventId = :eventId")
                    .addParameter("eventId", eventId)
                    .executeAndFetch(Attendees.class);
        }
    }

    @Override
    public void update(int id, String newName, String newDescription, String newStartDate, String newStartTime) {
        String sql = "UPDATE events SET name =:name, description = :description, startDate = :startDate, startTime = :startTime WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("description", newDescription)
                    .addParameter("startDate", newStartDate)
                    .addParameter("startTime", newStartTime)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
