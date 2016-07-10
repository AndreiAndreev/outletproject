package ru.outletproject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.outletproject.model.BaseUser;
import ru.outletproject.to.RestaurantTo;

import static java.util.Objects.requireNonNull;

public class CurrentRestaurant {
    private static int id = BaseUser.START_SEQ;

    private RestaurantTo restaurantTo;

    public void update(RestaurantTo newTo) {
        restaurantTo = newTo;
    }

    public RestaurantTo getRestaurantTo() {
        return restaurantTo;
    }

    public static CurrentRestaurant safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object restaurant = auth.getPrincipal();

        return (restaurant instanceof CurrentRestaurant) ? (CurrentRestaurant) restaurant : null;
    }

    public static CurrentRestaurant get() {
        CurrentRestaurant restaurant = safeGet();
        requireNonNull(restaurant, "No authorized user found");
        return restaurant;
    }

    @Override
    public String toString() {
        return restaurantTo.toString();
    }

    public static int id() {
        return get().restaurantTo.getId();
    }
}
