package jh.springbasicapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by BS-113-Jahangir on 3/6/2015.
 */
@Controller
public class AuthenticationController extends BaseController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }
}
