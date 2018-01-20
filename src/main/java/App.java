import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.*;
import models.*;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/todolist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oAttendeesDao attendeesDao = new Sql2oAttendeesDao(sql2o);
        Sql2oEventDao eventDao = new Sql2oEventDao(sql2o);


        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Attendees> attendees = attendeesDao.getAll();
            List<Event> events = eventDao.getAll();
            model.put("events", events);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/events/:event_id/attendees/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEventToFind = Integer.parseInt(request.params("event_id")); //pull id - must match route segment
            Event foundEvent = eventDao.findById(idOfEventToFind); //use it to find post
            model.put("event", foundEvent); //add it to model for template to display
            return new ModelAndView(model, "attendees-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/about", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "about.hbs");
        }, new HandlebarsTemplateEngine());

        get("/events/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "event-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/events/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String description = request.queryParams("description");
            String startDate = request.queryParams("startDate");
            String startTime = request.queryParams("startTime");
            String month = request.queryParams("month");
            Event newEvent = new Event(name, description, startDate, startTime);
            eventDao.add(newEvent);
            model.put("event", newEvent);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/events/:event_id/attendees/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String firstName = request.queryParams("firstName");
            String lastName = request.queryParams("lastName");
            String email = request.queryParams("email");
            String phone = request.queryParams("phone");
            Attendees newAttendees = new Attendees(firstName, lastName, email, phone);
            attendeesDao.add(newAttendees);
            model.put("attendee", newAttendees);
            return new ModelAndView(model, "success-attendee.hbs");
        }, new HandlebarsTemplateEngine());

        get("/event/:event_id/attendees/:attendee_id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfAttendeeToFind = Integer.parseInt(req.params("attendee_id"));
            Attendees foundAttendee = attendeesDao.findById(idOfAttendeeToFind);
            model.put("attendee", foundAttendee);
            return new ModelAndView(model, "attendee-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/events/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Event> events = eventDao.getAll();
            model.put("events", events);
            return new ModelAndView(model, "all-events.hbs");
        }, new HandlebarsTemplateEngine());

        get("/events/:event_id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEventToFind = Integer.parseInt(req.params("event_id")); //pull id - must match route segment
            Event foundEvent = eventDao.findById(idOfEventToFind); //use it to find post
            model.put("event", foundEvent); //add it to model for template to display
            return new ModelAndView(model, "event-details.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());

        get("/events/:event_id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEventToEdit = Integer.parseInt(req.params("event_id"));
            Event editEvent = eventDao.findById(idOfEventToEdit);
            model.put("editEvent", editEvent);
            return new ModelAndView(model, "event-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/events/:event_id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newName = req.queryParams("name");
            String newDescription = req.queryParams("description");
            String newAttendees = req.queryParams("attendees");
            String newStartDate = req.queryParams("newStartDate");
            String newStartTime = req.queryParams("newStartTime");
            int idOfEventToEdit = Integer.parseInt(req.params("event_id"));
            Event editEvent = eventDao.findById(idOfEventToEdit);
            eventDao.update(1, newName, newDescription, newStartDate, newStartTime);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
