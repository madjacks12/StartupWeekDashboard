package models;

import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class EventTest {

    @Test
    public void newEvent_eventInstantiatesCorrectly_True() throws ParseException {
        Event testEvent = new Event("Java", "test description", 2018, 30, "March");
        assertEquals(false, testEvent instanceof Event);


    }

}