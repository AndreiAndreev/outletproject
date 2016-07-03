package ru.outletproject.util;

import ru.outletproject.model.Dish;
import ru.outletproject.to.DishTo;

public class DishUtil {
    public static Dish createFromTo(DishTo dishTo) {
        return new Dish(dishTo.getId(), dishTo.getName(), dishTo.getPrice());
    }
}
