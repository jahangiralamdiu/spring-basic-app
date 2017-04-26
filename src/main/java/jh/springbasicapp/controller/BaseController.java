package jh.springbasicapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;

/**
 * Created by Jahangir on 23/02/2015.
 */
public class BaseController {

    @Value("${application.version}")
    private String applicationVersion;

    @ModelAttribute
    public void addGlobalAttributes(Map<String, Object> map) {
        map.put("applicationVersion", applicationVersion);
    }
}
