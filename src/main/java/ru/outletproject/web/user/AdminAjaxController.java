package ru.outletproject.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.outletproject.model.User;
import ru.outletproject.to.UserTo;
import ru.outletproject.util.UserUtil;
import ru.outletproject.web.AbstractController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxController extends AbstractController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll(){
        return super.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") int id){
        return super.getUser(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id){
        super.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@Valid UserTo userTo){
        try{
            if(userTo.getId() == 0){
                super.createUser(UserUtil.createFromTo(userTo));
            }else{
                super.updateUser(userTo);
            }
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(messageSource.getMessage("exception.duplicate_email", null, LocaleContextHolder.getLocale()));
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void enable(@PathVariable("id") int id, @RequestParam("enable") boolean enable){
        super.enable(id, enable);
    }
}
