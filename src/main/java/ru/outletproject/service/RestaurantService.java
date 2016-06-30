package ru.outletproject.service;

import ru.outletproject.model.Restaurant;
import ru.outletproject.to.RestaurantTo;
import ru.outletproject.util.exception.NotFoundException;

import java.util.List;

public interface RestaurantService {
    Restaurant save(Restaurant restaurant);

    void delete(int id) throws NotFoundException;

    Restaurant get(int id) throws NotFoundException;

    Restaurant getByEmail(String email) throws NotFoundException;

    void update(RestaurantTo user);

    List<Restaurant> getAll();

    void update(Restaurant user);

    void evictCache();

    void enable(int id, boolean enable);

    Restaurant getWithDishes(int id);
}
