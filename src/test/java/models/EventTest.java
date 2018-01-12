package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EventTest {

    @Test
    public void newEvent_eventInstantiatesCorrectly_True() {
        Event testEvent = new Event("Java", "test description", 2018, 30, "March", "Dave");
        assertEquals(true, testEvent instanceof Event);
    }

    @Test
    public void newEvent_AddsAttendeeNameToList_1(){
        Event testEvent = new Event("Java", "test description", 2018, 30, "March", "Dave");
        testEvent.getAttendeeList();
        assertEquals(true, testEvent.getAttendeeList().contains("Dave"));
        }


    }

