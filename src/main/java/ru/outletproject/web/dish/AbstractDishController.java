package ru.outletproject.web.dish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import ru.outletproject.CurrentRestaurant;
import ru.outletproject.model.Dish;
import ru.outletproject.service.DishService;

import java.util.Collection;

public class AbstractDishController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractDishController.class);

    @Autowired
    private DishService dishService;

    public Dish get(int id) {
        int restaurantId = CurrentRestaurant.id();
        LOG.info("get dish {} for Restaurant {}", id, restaurantId);
        return dishService.get(id, restaurantId);
    }

    public void delete(int id) {
        int restaurantId = CurrentRestaurant.id();
        LOG.info("delete dish {} for Restaurant {}", id, restaurantId);
        dishService.delete(id, restaurantId);
    }

    public Collection<Dish> getAll() {
        int restaurantId = CurrentRestaurant.id();
        LOG.info("getAll for Restaurant {}", restaurantId);
        return dishService.getAll(restaurantId);
    }

    public void update(Dish dish, int id) {
        dish.setId(id);
        int restaurantId = CurrentRestaurant.id();
        LOG.info("update {} for Restaurant {}", dish, restaurantId);
        dishService.update(dish, restaurantId);
    }

    public Dish create(Dish dish) {
        dish.setId(null);
        int restaurantId = CurrentRestaurant.id();
        LOG.info("create {} for Restaurant {}", dish, restaurantId);
        return dishService.save(dish, restaurantId);
    }

}
