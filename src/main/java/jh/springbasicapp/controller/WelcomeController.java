package jh.springbasicapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Jahangir on 23/02/2015.
 */
@Controller
public class WelcomeController extends BaseController {

    @RequestMapping(value = "/")
    public String welcome()
    {
        return "index";
    }

}
