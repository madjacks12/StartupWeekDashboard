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

        String sql = "INSERT INTO events (name, description, date, time) VALUES (:name, :description, :date, :time)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .addParameter("name", event.getName())
                    .addParameter("description", event.getDescription())
                    .addParameter("date", event.getDate())
                    .addParameter("time", event.getTime())
                    .addColumnMapping("NAME", "name")
                    .addColumnMapping("DESCRIPTION", "description")
                    .addColumnMapping("DATE", "date")
                    .addColumnMapping("TIME", "time")
                    .executeUpdate()
                    .getKey();
            event.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }
    }
}
