import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import models.Event;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import static spark.Spark.*;


public class App {
    public static void main(String[] args) {

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/event/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "event-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("event/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String description = request.queryParams("description");
            int year = Integer.parseInt(request.queryParams("year"));
            int day = Integer.parseInt(request.queryParams("day"));
            String month = request.queryParams("month");
            String attendees = request.queryParams("attendees");
            Event newEvent = new Event(name, description, year, day, month, attendees);
            model.put("newEvent", newEvent);
            System.out.print(attendees);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/event", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Event> events = Event.getAll();

            model.put("events", events);
            return new ModelAndView(model, "all-events.hbs");
        }, new HandlebarsTemplateEngine());

        get("/posts/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfEventToEdit = Integer.parseInt(req.params("id"));
            Event editEvent = Event.findById(idOfEventToEdit);
            model.put("editEvent", editEvent);
            return new ModelAndView(model, "event-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/posts/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newName = req.queryParams("name");
            String newDescription = req.queryParams("description");
            String newAttendees = req.queryParams("attendees");
            String newMonth = req.queryParams("month");
            int newYear = Integer.parseInt(req.queryParams("year"));
            int newDay = Integer.parseInt(req.queryParams("day"));
            int idOfEventToEdit = Integer.parseInt(req.params("id"));
            Event editEvent = Event.findById(idOfEventToEdit);
            editEvent.update(newName, newDescription, newYear, newDay, newMonth, newAttendees);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
