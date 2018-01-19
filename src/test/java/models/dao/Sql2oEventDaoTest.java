package models.dao;

import dao.Sql2oAttendeesDao;
import dao.Sql2oEventDao;
import models.Event;
import models.Attendees;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class Sql2oEventDaoTest {

    private Sql2oEventDao eventDao;
    private Sql2oAttendeesDao attendeesDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        eventDao = new Sql2oEventDao(sql2o);
        attendeesDao = new Sql2oAttendeesDao(sql2o);

        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void AddingSetsId() throws Exception {
        Event testEvent = new Event("Coding Workshop", "A good one", "03-04-1999", "7:00");
        int originalEventId = testEvent.getId();
        eventDao.add(testEvent);
        assertNotEquals(originalEventId, testEvent.getId());
    }

    @Test
    public void addedEventsAreReturnedFromgetAll() throws Exception {
        Event testEvent = new Event("Coding Workshop", "A good one", "03-04-1999", "7:00");
        eventDao.add(testEvent);
        assertEquals(1, eventDao.getAll().size());
    }

    @Test
    public void existingEventsCanBeFoundById() throws Exception {
        Event testEvent = new Event("Coding Workshop", "A good one", "03-04-1999", "7:00");
        eventDao.add(testEvent);
        Event foundevent = eventDao.findById(testEvent.getId());
        assertEquals(testEvent, foundevent);
    }

    @Test
    public void getAllAttendeesByEventReturnsAttendeesCorrectly() throws Exception {
        Event testEvent = new Event("Coding Workshop", "A good one", "03-04-1999", "7:00");
        eventDao.add(testEvent);
        int eventId = testEvent.getId();
        Attendees testAttendeesOne = new Attendees("Bruce", "Davis", "bruce@davis.com", "420-300-5000", eventId);
        Attendees testAttendeesTwo = new Attendees("chris", "smith", "bruce@davis.com", "420-300-5000", eventId);
        Attendees testAttendeesThree = new Attendees("ryan", "blim", "bruce@davis.com", "420-300-5000", eventId);
        attendeesDao.add(testAttendeesOne);
        attendeesDao.add(testAttendeesTwo);
        assertTrue(eventDao.getAllAttendeesByEvent(eventId).size() == 2);
        assertTrue(eventDao.getAllAttendeesByEvent(eventId).contains(testAttendeesOne));
        assertTrue(eventDao.getAllAttendeesByEvent(eventId).contains(testAttendeesTwo));
        assertFalse(eventDao.getAllAttendeesByEvent(eventId).contains(testAttendeesThree)); //things are accurate!
    }
}
