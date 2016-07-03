package ru.outletproject.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.outletproject.model.Restaurant;
import ru.outletproject.model.User;
import ru.outletproject.service.RestaurantService;
import ru.outletproject.service.UserService;
import ru.outletproject.to.RestaurantTo;
import ru.outletproject.to.UserTo;
import ru.outletproject.util.UserUtil;

import java.util.List;

public abstract class AbstractController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    private RestaurantService restaurantService;

//    <---------UserService---------->

    public List<User> getAllUsers() {
        log.info("getAllUsers");
        return userService.getAll();
    }

    public User getUser(int id) {
        log.info("getUser " + id);
        return userService.get(id);
    }

    public User createUser(User user) {
        user.setId(null);
        log.info("createUser " + user);
        return userService.save(UserUtil.prepareToSave(user));
    }

    public void deleteUser(int id) {
        log.info("deleteUser " + id);
        userService.delete(id);
    }

    public void updateUser(User user, int id) {
        user.setId(id);
        log.info("updateUser " + user);
        userService.update(UserUtil.prepareToSave(user));
    }

    public void updateUser(UserTo userTo) {
        log.info("updateUser " + userTo);
        userService.update(userTo);
    }

    public User getByEmail(String email) {
        log.info("getByEmail " + email);
        return userService.getByEmail(email);
    }

    public void enable(int id, boolean enabled) {
        log.info((enabled ? "enable " : "disable ") + id);
        userService.enable(id, enabled);
    }

    //<----------RestaurantService--------->

    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAll();
    }

    public Restaurant getRestaurant(int id){
        return restaurantService.get(id);
    }

    public Restaurant createRestaurant(Restaurant restaurant){
        return restaurantService.save(restaurant);
    }

    public void deleteRestaurant(int id){
        restaurantService.delete(id);
    }

    public void updateRestaurant(Restaurant restaurant, int id){
        restaurantService.update(restaurant);
    }

    public void updateRestaurant(RestaurantTo restaurantTo){
        restaurantService.update(restaurantTo);
    }

    public void vote(int id){
        restaurantService.vote(id);
    }
}
