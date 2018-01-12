import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import static spark.Spark.*;


public class App {
    public static void main(String[] args) {

        get("/", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "templates/index.hbs");
        }, new HandlebarsTemplateEngine() );

    }
}
