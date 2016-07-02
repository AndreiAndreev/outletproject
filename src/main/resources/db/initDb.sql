DROP TABLE IF EXISTS users CASCADE ;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS restaurants CASCADE ;
DROP TABLE IF EXISTS restaurants_dishes;
DROP SEQUENCE IF EXISTS users_seq;
DROP SEQUENCE IF EXISTS rest_seq;

CREATE SEQUENCE users_seq START 100000;
CREATE SEQUENCE rest_seq START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('users_seq'),
  name       VARCHAR NOT NULL,
  email      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  registered TIMESTAMP DEFAULT now(),
  enabled    BOOL DEFAULT TRUE
);

CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
  id        INTEGER PRIMARY KEY DEFAULT nextval('rest_seq'),
  name      VARCHAR NOT NULL,
  votes     INTEGER NOT NULL
);

CREATE UNIQUE INDEX restaurants_unique_idx_id_name ON restaurants(id, name);

CREATE TABLE restaurants_dishes
(
  dish_id   INTEGER NOT NULL,
  name      VARCHAR NOT NULL,
  price     INTEGER NOT NULL,
  FOREIGN KEY (dish_id) REFERENCES restaurants(id) ON DELETE CASCADE
)


