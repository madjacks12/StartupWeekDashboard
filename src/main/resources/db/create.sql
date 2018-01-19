SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS attendees (
  id int PRIMARY KEY auto_increment,
  firstname VARCHAR
  lastname VARCHAR,
  phone VARCHAR,
  email VARCHAR,
  eventid INTEGER
);

CREATE TABLE IF NOT EXISTS events (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 description VARCHAR,
 time VARCHAR
);