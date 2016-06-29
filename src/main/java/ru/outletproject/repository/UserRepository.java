package ru.outletproject.repository;


import ru.outletproject.model.User;

import java.util.List;

public interface UserRepository {

    //false if not found
    boolean delete(int id);

    User save(User user);

    //null if not found
    User get(Integer id);

    List<User> getAll();

    //null if not found
    User getByEmail(String email);
}
