DELETE FROM restaurants;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE users_seq RESTART WITH 100000;
ALTER SEQUENCE rest_seq RESTART WITH 100000;


INSERT INTO users(name, email, password)VALUES
  ('User', 'user@yandex.ru', '$2a$10$Sh0ZD2NFrzRRJJEKEWn8l.92ROEuzlVyzB9SV1AM8fdluPR0aC1ni'),
  ('Admin', 'admin@gmail.com', '$2a$10$WejOLxVuXRpOgr4IlzQJ.eT4UcukNqHlAiOVZj1P/nmc8WbpMkiju');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_USER', 100001),
  ('ROLE_ADMIN', 100001);

INSERT INTO restaurants(name, votes) VALUES
  ('Skoletto', 0),
  ('Mariachi', 0),
  ('PiskaRest', 0);


INSERT INTO restaurants_dishes(dish_id, name, price) VALUES
  (100000,'dish1', 100),
  (100001,'dish2', 300),
  (100001,'dish3', 400);


