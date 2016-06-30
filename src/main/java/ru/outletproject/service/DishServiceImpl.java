package ru.outletproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.outletproject.model.Dish;
import ru.outletproject.repository.datajpa.DataJpaDishesRepositoryImpl;
import ru.outletproject.util.exception.ExceptionUtil;
import ru.outletproject.util.exception.NotFoundException;

import java.util.Collection;
import java.util.Objects;


@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DataJpaDishesRepositoryImpl repository;

    @Override
    public Dish get(int id, int restaurantId) throws NotFoundException {
        return repository.get(restaurantId, id);
    }

    @Override
    public void delete(int id, int restaurantId) throws NotFoundException {
        repository.delete(restaurantId, id);
    }

    @Override
    public Collection<Dish> getAll(int restaurantId) {
        return repository.getAll(restaurantId);
    }

    @Override
    public Dish update(Dish dish, int restaurantId) throws NotFoundException {
        return ExceptionUtil.check(repository.save(restaurantId, dish), restaurantId);
    }

    @Override
    public Dish save(Dish dish, int restaurantId) {
        Objects.requireNonNull(dish);
        return ExceptionUtil.check(repository.save(restaurantId, dish), restaurantId);
    }

    @Override
    public Dish getWithRestaurant(Integer id, Integer restaurantId) {
        return repository.getWithRestaurant(restaurantId, id);
    }
}
