package models;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EventTest {
    public Event testEvent() {
        Event testEvent = new Event("Java", "test description", 2018, 30, "March", );
        return testEvent;
    }

    @After
    public void tearDown() {
        Event.clearAllEvents();
    }
    @Test
    public void newEvent_eventInstantiatesCorrectly_True() {
        Event testEventOne = testEvent();
        assertEquals(true, testEventOne instanceof Event);
    }

    @Test
    public void newEvent_AddsAllEventsToArray_3(){
        Event testEventOne = testEvent();
        Event testEventTwo = testEvent();
        Event testEventThree = testEvent();

        assertEquals(3, Event.getAll().size());
    }

    }

