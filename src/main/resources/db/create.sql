SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS attendees (
  id int PRIMARY KEY auto_increment,
  firstName VARCHAR,
  lastName VARCHAR,
  phone VARCHAR,
  email VARCHAR,
  eventId INTEGER REFERENCES events(id)
);

CREATE TABLE IF NOT EXISTS events (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 description VARCHAR,
 startDate VARCHAR,
 startTime VARCHAR
);