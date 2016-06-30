package ru.outletproject.service;


import ru.outletproject.model.User;
import ru.outletproject.to.UserTo;
import ru.outletproject.util.exception.NotFoundException;

import java.util.List;

public interface UserService {

        User save(User user);

        void delete(int id) throws NotFoundException;

        User get(int id) throws NotFoundException;

        User getByEmail(String email) throws NotFoundException;

        void update(UserTo userTo);

        List<User> getAll();

        void update(User user);

        void evictCache();

        void enable(int id, boolean enable);


}
