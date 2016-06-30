package ru.outletproject.service;

import ru.outletproject.model.Dish;
import ru.outletproject.util.exception.NotFoundException;

import java.util.Collection;

public interface DishService {
    Dish get(int id, int userId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    Collection<Dish> getAll(int userId);

    Dish update(Dish meal, int userId) throws NotFoundException;

    Dish save(Dish meal, int userId);

    Dish getWithUser(Integer id, Integer userId);
}
