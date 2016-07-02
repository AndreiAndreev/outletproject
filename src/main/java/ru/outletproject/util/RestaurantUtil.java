package ru.outletproject.util;

import ru.outletproject.model.Restaurant;
import ru.outletproject.to.RestaurantTo;

public class RestaurantUtil {

    public static Restaurant createFromTo(RestaurantTo restaurantTo) {
        return new Restaurant(null, restaurantTo.getName(), restaurantTo.getVotes());
    }

    public static RestaurantTo asTo(Restaurant restaurant) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), restaurant.getVotes());
    }

    public static Restaurant updateFromTo(Restaurant restaurant, RestaurantTo restaurantTo) {
        restaurant.setName(restaurantTo.getName());
        restaurant.setVotes(restaurantTo.getVotes());
        return restaurant;
    }
}
