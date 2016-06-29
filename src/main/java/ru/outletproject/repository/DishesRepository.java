package ru.outletproject.repository;

import ru.outletproject.model.Dish;

import java.util.List;

public interface DishesRepository {

    //false if not found
    boolean delete(int restaurantId, int dishId);

    Dish save(int restaurantId, Dish dish);

    //null if not found
    Dish get(int restaurantId, int dishId);

    List<Dish> getAll(int restaurantId);

    default Dish getWithRestaurant(int restaurantId, int dishId){
        throw new UnsupportedOperationException();
    }
}
