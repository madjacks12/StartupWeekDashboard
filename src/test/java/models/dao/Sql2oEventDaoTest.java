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
}
