import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.xpath.internal.operations.Mod;
import models.Item;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import sun.jvm.hotspot.oops.ObjectHeap;

import javax.print.DocFlavor;

import static spark.Spark.*;


public class App {
    public static void main(String[] args) {

        get("/", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine() );

    }
}
