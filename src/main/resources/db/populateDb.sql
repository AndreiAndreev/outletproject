DELETE FROM restaurants;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users(name, email, password)VALUES
  ('User', 'piska@gmail.com', 'password'),
  ('User1', 'piska2@gmail.com', 'password'),
  ('Admin', 'golimb111@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO restaurants(name, menu, votes) VALUES
  ('Skoletto', 'dish1, dish2, dish3', 0),
  ('Mariachi', 'bludo1, bludo2, bludo3', 0),
  ('PiskaRest', 'first, second, third', 0);
