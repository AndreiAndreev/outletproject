package ru.outletproject.web.restaurant;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.outletproject.CurrentRestaurant;
import ru.outletproject.model.Restaurant;
import ru.outletproject.to.RestaurantTo;
import ru.outletproject.util.RestaurantUtil;
import ru.outletproject.web.AbstractController;

@RestController
@RequestMapping(RestaurantProfileRestController.REST_URL)
public class RestaurantProfileRestController extends AbstractController {
    protected static final String REST_URL = "/rest/profile/restaurants";

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant get(@PathVariable("id") int id) {
        return super.getRestaurant(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody RestaurantTo restaurantTo) {
        restaurantTo.setId(CurrentRestaurant.id());
        super.updateRestaurant(restaurantTo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void vote(@PathVariable("id") int id) {
        Restaurant restaurant = getRestaurant(id);
        int incrementedVotes = restaurant.getVotes() + 1;
        restaurant.setVotes(incrementedVotes);
        update(RestaurantUtil.asTo(restaurant));
    }
}
