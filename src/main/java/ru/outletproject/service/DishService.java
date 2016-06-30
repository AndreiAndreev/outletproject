package ru.outletproject.service;

import ru.outletproject.model.Dish;
import ru.outletproject.util.exception.NotFoundException;

import java.util.Collection;

public interface DishService {
    Dish get(int id, int restaurantId) throws NotFoundException;

    void delete(int id, int restaurantId) throws NotFoundException;

    Collection<Dish> getAll(int restaurantId);

    Dish update(Dish dish, int restaurantId) throws NotFoundException;

    Dish save(Dish dish, int restaurantId);

    Dish getWithRestaurant(Integer id, Integer restaurantId);
}
