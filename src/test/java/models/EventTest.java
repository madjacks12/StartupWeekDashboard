package models;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EventTest {
    public Event testEvent() {
        Event testEvent = new Event("Java", "test description", 2018, 30, "March","Dave, Brian, Jeff");
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
    @Test
    public void getId_postsInstantiateWithAnID_1() throws Exception {
        Event.clearAllEvents();
        Event testEventOne = testEvent();
        assertEquals(1, testEventOne.getId());
    }
    @Test
    public void findById_findByIDWorks_2() throws Exception {
        Event testEventOne = testEvent();
        Event TestEventTwo = new Event("party", "cool", 2018, 30, "March", "Bill");
        assertEquals(2, Event.findById(TestEventTwo.getId()).getId());
    }
    @Test
    public void updateEvent_UpdateEventWorks_true() throws Exception {
        Event event = testEvent();
        String formerName = event.getName();
        String formerDescription = event.getDescription();
        int formerId = event.getId();

        event.update("C#", "Learning C#", 2018, 30, "March","Dave, Brian, Jeff");
        assertEquals(formerId, event.getId());
        assertEquals(formerId, event.getId());
        assertNotEquals(formerDescription, event.getDescription());
    }
}

