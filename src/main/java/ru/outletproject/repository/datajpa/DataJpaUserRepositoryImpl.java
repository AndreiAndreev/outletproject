package ru.outletproject.repository.datajpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.outletproject.model.User;
import ru.outletproject.repository.UserRepository;

import java.util.List;

@Repository
public class DataJpaUserRepositoryImpl implements UserRepository{

    @Autowired
    private ProxyUserRepository proxy;


    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public User save(User user) {
        return proxy.save(user);
    }

    @Override
    public User get(Integer id) {
        return proxy.findOne(id);
    }

    @Override
    public List<User> getAll() {
        return proxy.findAll();
    }

    @Override
    public User getByEmail(String email) {
        return proxy.getByEmail(email);
    }
}
