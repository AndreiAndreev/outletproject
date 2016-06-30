package ru.outletproject.repository.datajpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.outletproject.model.Dish;
import ru.outletproject.repository.DishesRepository;

import java.util.List;

@Repository
public class DataJpaDishesRepositoryImpl implements DishesRepository{

    @Autowired
    private ProxyDishesRepository proxy;

    @Autowired
    private ProxyRestaurantRepository restaurantProxy;

    @Override
    public boolean delete(int restaurantId, int dishId) {
        return proxy.delete(restaurantId, dishId) != 0;
    }

    @Override
    public Dish save(int restaurantId, Dish dish) {
        if (!dish.isNew() && get(restaurantId, dish.getId()) == null) {
            return null;
        }
        dish.setRestaurant(restaurantProxy.findOne(restaurantId));
        return proxy.save(dish);
    }

    @Override
    public Dish get(int restaurantId, int dishId) {
        return proxy.findOne(restaurantId, dishId);
    }

    @Override
    public List<Dish> getAll(int restaurantId) {
        return proxy.findAll(restaurantId);
    }
}
