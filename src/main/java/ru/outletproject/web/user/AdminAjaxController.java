package ru.outletproject.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.outletproject.web.AbstractController;

@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxController extends AbstractController {

    @Autowired
    private MessageSource messageSource;

    //TODO:all controller
}
