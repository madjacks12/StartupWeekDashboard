import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import models.Event;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import static spark.Spark.*;


public class App {
    public static void main(String[] args) {

        get("/", (request, response) ->{
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
            String attendee = request.queryParams("attendee");
            Event newEvent = new Event(name, description, year, day, month, attendee);
            model.put("newEvent", newEvent);
            return new ModelAndView(model, "success.hbs");

        }, new HandlebarsTemplateEngine());



    }
}
