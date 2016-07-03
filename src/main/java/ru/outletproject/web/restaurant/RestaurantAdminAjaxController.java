package ru.outletproject.web.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.outletproject.model.Restaurant;
import ru.outletproject.to.RestaurantTo;
import ru.outletproject.util.RestaurantUtil;
import ru.outletproject.web.AbstractController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/ajax/admin/restaurants")
public class RestaurantAdminAjaxController extends AbstractController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAll(){
        return super.getAllRestaurants();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant get(@PathVariable("id") int id){
        return super.getRestaurant(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id){
        super.deleteRestaurant(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@Valid RestaurantTo restaurantTo){
        try{
            if(restaurantTo.getId()==0){
                super.createRestaurant(RestaurantUtil.createFromTo(restaurantTo));
            }else{
                super.updateRestaurant(restaurantTo);
            }
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(messageSource.getMessage("exception.duplicate_name", null, LocaleContextHolder.getLocale()));
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void vote(@PathVariable("id") int id){
        Restaurant restaurant = getRestaurant(id);
        int incrementedVotes = restaurant.getVotes()+1;
        restaurant.setVotes(incrementedVotes);
        createOrUpdate(RestaurantUtil.asTo(restaurant));
    }
}
