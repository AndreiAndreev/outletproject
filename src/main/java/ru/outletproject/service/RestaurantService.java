package ru.outletproject.service;

import ru.outletproject.model.Restaurant;
import ru.outletproject.to.RestaurantTo;
import ru.outletproject.util.exception.NotFoundException;

import java.util.List;

public interface RestaurantService {
    Restaurant save(Restaurant restaurant);

    void delete(int id) throws NotFoundException;

    Restaurant get(int id) throws NotFoundException;

    void update(RestaurantTo restaurantTo);

    List<Restaurant> getAll();

    void update(Restaurant restaurant);

    void evictCache();

    Restaurant getWithDishes(int id);

    void vote(int id);
}
