SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS attendees (
  id int PRIMARY KEY auto_increment,
  firstName VARCHAR,
  lastName VARCHAR,
  phone VARCHAR,
  email VARCHAR,
  eventId INTEGER
);

CREATE TABLE IF NOT EXISTS events (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 description VARCHAR,
 date VARCHAR,
 time VARCHAR
);