DELETE FROM restaurants;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE users_seq RESTART WITH 100000;
ALTER SEQUENCE rest_seq RESTART WITH 100000;


INSERT INTO users(name, email, password)VALUES
  ('User', 'piska@gmail.com', 'password'),
  ('User1', 'piska2@gmail.com', 'password'),
  ('Admin', 'golimb111@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO restaurants(name, votes) VALUES
  ('Skoletto', 0),
  ('Mariachi', 0),
  ('PiskaRest', 0);


INSERT INTO restaurants_dishes(dish_id, name, price) VALUES
  (100000,'dish1', 100),
  (100001,'dish2', 300),
  (100001,'dish3', 400);


