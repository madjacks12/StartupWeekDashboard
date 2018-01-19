package dao;

import models.Attendees;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;


public class Sql2oAttendeesDao implements AttendeesDao {

    private final Sql2o sql2o;

    public Sql2oAttendeesDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Attendees attendees) {

        String sql = "INSERT INTO attendees (firstName, lastName, email, phone, eventId) VALUES (:firstName, :lastName, :email, :phone, :eventId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .addParameter("firstName", attendees.getFirstName())
                    .addParameter("lastName", attendees.getLastName())
                    .addParameter("email", attendees.getEmail())
                    .addParameter("phone", attendees.getPhone())
                    .addParameter("eventId", attendees.getEventId())
                    .addColumnMapping("FIRSTNAME", "firstName")
                    .addColumnMapping("LASTNAME", "lastName")
                    .addColumnMapping("EMAIL", "email")
                    .addColumnMapping("PHONE", "phone")
                    .addColumnMapping("EVENTID", "eventId")
                    .executeUpdate()
                    .getKey();
            attendees.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }
    }
        @Override
        public List<Attendees> getAll() {
            try (Connection con = sql2o.open()) {
                return con.createQuery("SELECT * FROM attendees")
                        .executeAndFetch(Attendees.class);
            }
        }

        @Override
        public Attendees findById(int id) {
            try(Connection con = sql2o.open()){
                return con.createQuery("SELECT * FROM attendees WHERE id = :id")
                        .addParameter("id", id) //key/value pair, key must match above
                        .executeAndFetchFirst(Attendees.class); //fetch an individual item
            }
        }

//        @Override
//        public void update(int id, String firstName, String lastName, String email, String phone){
//            String sql = "UPDATE tasks SET (description, categoryId) = (:description, :categoryId) WHERE id=:id"; //raw sql
//            try(Connection con = sql2o.open()){
//                con.createQuery(sql)
//                        .addParameter("description", newDescription)
//                        .addParameter("categoryId", newCategoryId)
//                        .addParameter("id", id)
//                        .executeUpdate();
//            } catch (Sql2oException ex) {
//                System.out.println(ex);
//            }
//        }
}
