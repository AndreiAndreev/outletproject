package ru.outletproject.repository.datajpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.outletproject.model.Restaurant;
import ru.outletproject.repository.RestaurantRepository;

import java.util.List;

@Repository
public class DataJpaRestaurantRepositoryImpl implements RestaurantRepository{

    @Autowired
    private ProxyRestaurantRepository proxy;


    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return proxy.save(restaurant);
    }

    @Override
    public Restaurant get(Integer id) {
        return proxy.findOne(id);
    }

    @Override
    public List<Restaurant> getAll() {
        return proxy.findAll();
    }

    @Override
    public Restaurant findByName(String name) {
        return proxy.findByName(name);
    }

    @Override
    public boolean vote(int id) {
        return proxy.vote(id) != 0;
    }

    @Override
    public Restaurant getWithDishes(int id) {
        return proxy.getWithDishes(id);
    }
}
