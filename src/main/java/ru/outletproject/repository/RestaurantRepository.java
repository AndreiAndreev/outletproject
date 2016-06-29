package ru.outletproject.repository;


import ru.outletproject.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    //false if not found
    boolean delete(int id);

    Restaurant save(Restaurant restaurant);

    //null if not found
    Restaurant get(Integer id);

    List<Restaurant> getAlll();

    //null if not found
    Restaurant findByName(String name);

    //false if not found
    boolean vote(int id);

    default Restaurant getWithDishes(int id){
        throw new UnsupportedOperationException();
    }
}
