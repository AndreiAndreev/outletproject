package ru.outletproject.web;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import ru.outletproject.CurrentRestaurant;
import ru.outletproject.LoggedUser;
import ru.outletproject.to.RestaurantTo;
import ru.outletproject.to.UserTo;
import ru.outletproject.util.RestaurantUtil;
import ru.outletproject.util.UserUtil;

import javax.validation.Valid;

@Controller
public class RootController extends AbstractController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:restaurants";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList(){
        return "userList";
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public String restaurantList(){
        return "restaurantList";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model,
                        @RequestParam(value = "error", required = false) boolean error,
                        @RequestParam(value = "message", required = false) String message) {

        model.put("error", error);
        model.put("message", message);
        return "login";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(){
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String updateProfile(@Valid UserTo userTo, BindingResult result, SessionStatus status){
        if (!result.hasErrors()){
            try{
                userTo.setId(LoggedUser.id());
                super.updateUser(userTo);
                LoggedUser.get().update(userTo);
                status.setComplete();
                return "redirect:restaurants";
            }catch (DataIntegrityViolationException ex) {
                result.rejectValue("email", "exception.duplicate_email");
            }
        }
        return profile();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/restaurantsProfile", method = RequestMethod.GET)
    public String restaurantsProfile(){
        return "restaurantsProfile";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/restaurantsProfile", method = RequestMethod.POST)
    public String updateRestaurantsProfile(@Valid RestaurantTo restaurantTo, BindingResult result, SessionStatus status){
        if (!result.hasErrors()){
            try{
                restaurantTo.setId(CurrentRestaurant.id());
                super.updateRestaurant(restaurantTo);
                CurrentRestaurant.get().update(restaurantTo);
                status.setComplete();
                return "redirect:restaurants";
            }catch (DataIntegrityViolationException ex) {
                result.rejectValue("email", "exception.duplicate_email");
            }
        }
        return profile();
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap model) {
        model.addAttribute("userTo", new UserTo());
        model.addAttribute("register", true);
        return "profile";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegister(@Valid UserTo userTo, BindingResult result, SessionStatus status, ModelMap model) {
        if (!result.hasErrors()) {
            try {
                super.createUser(UserUtil.createFromTo(userTo));
                status.setComplete();
                return "redirect:login?message=app.registered";
            } catch (DataIntegrityViolationException ex) {
                result.rejectValue("email", "exception.duplicate_email");
            }
        }
        model.addAttribute("register", true);
        return "profile";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/newRestor", method = RequestMethod.GET)
    public String registerRestaurant(ModelMap model){
        model.addAttribute("restaurantTo", new RestaurantTo());
        model.addAttribute("newRest", this);
        return "restaurantsProfile";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/newRestor", method = RequestMethod.POST)
    public String saveRegisterRestaurant(@Valid RestaurantTo restaurantTo, BindingResult result, SessionStatus status, ModelMap model) {
        if (!result.hasErrors()) {
            try {
                super.createRestaurant(RestaurantUtil.createFromTo(restaurantTo));
                status.setComplete();
                return "redirect:restaurants";
            } catch (DataIntegrityViolationException ex) {
                result.rejectValue("name", "exception.duplicate_name");
            }
        }
        model.addAttribute("newRest", this);
        return "restaurantsProfile";
    }
}
