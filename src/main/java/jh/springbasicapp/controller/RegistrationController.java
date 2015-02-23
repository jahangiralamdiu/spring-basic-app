package jh.springbasicapp.controller;


import com.fasterxml.jackson.databind.deser.Deserializers;
import jh.springbasicapp.model.User;
import jh.springbasicapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by lenovo on 18/02/2015.
 */
@Controller
public class RegistrationController extends BaseController{

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@ModelAttribute("user") User user) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        if (registrationService.doRegistration(user)==100)
        {
            return "registersuccess";
        }


        return "register";
    }

}
