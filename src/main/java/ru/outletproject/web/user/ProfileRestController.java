package ru.outletproject.web.user;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.outletproject.LoggedUser;
import ru.outletproject.model.User;
import ru.outletproject.to.UserTo;
import ru.outletproject.web.AbstractController;

@RestController
@RequestMapping(ProfileRestController.REST_URL)
public class ProfileRestController extends AbstractController {
    protected static final String REST_URL = "/rest/profile";

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(){
        return super.getUser(LoggedUser.id());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(){
        super.deleteUser(LoggedUser.id());
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody UserTo userTo){
        userTo.setId(LoggedUser.id());
        super.updateUser(userTo);
    }

    @RequestMapping(value = "/text", method = RequestMethod.GET)
    public String testUTF(){
        return "Русский текст";
    }
}
