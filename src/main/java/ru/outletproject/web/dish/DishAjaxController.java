package ru.outletproject.web.dish;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.outletproject.model.Dish;
import ru.outletproject.to.DishTo;

import javax.validation.Valid;
import java.util.List;

import static ru.outletproject.util.DishUtil.createFromTo;

@RestController
@RequestMapping("/ajax/profileRestaurant/dishes")
public class DishAjaxController extends AbstractDishController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Dish> getAll(){
        return (List<Dish>) super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Dish get(@PathVariable("id") int id){
        return super.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id){
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@Valid DishTo dishTo){
        if(dishTo.getId()==0){
            super.create(createFromTo(dishTo));
        }else{
            super.update(createFromTo(dishTo), dishTo.getId());
        }
    }
}
