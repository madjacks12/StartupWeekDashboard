package models.dao;

import dao.Sql2oAttendeesDao;
import models.Attendees;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class Sql2oAttendeesDaoTest {


    private Sql2oAttendeesDao attendeesDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        attendeesDao = new Sql2oAttendeesDao(sql2o); //ignore me for now

        //keep connection open through entire test so it does not get erased.
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void AddingSetsId() throws Exception {
        Attendees testAttendees = new Attendees("Bruce", "Davis", "bruce@davis.com", "420-300-5000", 1);
        int originalAttendeesId = testAttendees.getId();
        attendeesDao.add(testAttendees);
        assertNotEquals(originalAttendeesId, testAttendees.getId());
    }

    @Test
    public void addedAttendeesAreReturnedFromgetAll() throws Exception {
        Attendees testAttendees = new Attendees("Bruce", "Davis", "bruce@davis.com", "420-300-5000", 1);
        attendeesDao.add(testAttendees);
        assertEquals(1, attendeesDao.getAll().size());
    }

    @Test
    public void existingAttendeesCanBeFoundById() throws Exception {
        Attendees testAttendees = new Attendees("Bruce", "Davis", "bruce@davis.com", "420-300-5000", 1);
        attendeesDao.add(testAttendees); //add to dao (takes care of saving)
        Attendees foundAttendees = attendeesDao.findById(testAttendees.getId());
        assertEquals(testAttendees, foundAttendees);
    }


}
