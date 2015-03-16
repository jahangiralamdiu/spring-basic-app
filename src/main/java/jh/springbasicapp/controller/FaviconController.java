package jh.springbasicapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by BS-113-Jahangir on 3/16/2015.
 */
@Controller
public class FaviconController {

    @RequestMapping("favicon.ico")
    String favicon() {
        return "forward:/contents/images/favicon.ico";
    }
}
