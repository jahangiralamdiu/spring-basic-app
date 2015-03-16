package jh.springbasicapp.controller;


import com.fasterxml.jackson.databind.deser.Deserializers;
import jh.springbasicapp.model.BaseResponse;
import jh.springbasicapp.model.User;
import jh.springbasicapp.service.RegistrationService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.sun.org.apache.xml.internal.security.utils.Base64.*;

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
    public String doRegister(@ModelAttribute("user") @Valid User user, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        BaseResponse response = registrationService.doRegistration(user);

        if (response.getResponseCode()==100)
        {
            try {
                    byte[] bytes = user.getImageFile().getBytes();
                    String encodedImage = org.apache.commons.codec.binary.Base64.encodeBase64String(user.getImageFile().getBytes());
                    user.setImageString(encodedImage);
                }
            catch (IOException e)
            {
                    e.printStackTrace();
            }

            redirectAttributes.addAttribute("userName", user.getUserName());
            redirectAttributes.addFlashAttribute("message", "You have successfully registered!");

            return "redirect:/registersuccess";
        }


        return "register";
    }

    @RequestMapping(value = "/view")
    public String viewAllUser(Model model)
    {
        model.addAttribute("users", registrationService.getAllUser());

        return "viewallusers";

    }

    @RequestMapping(value = "/registersuccess")
    public String registerSuccess(@RequestParam String userName, Model model)
    {
        User user = registrationService.getRegisteredUser(userName);

        model.addAttribute("user", user);

        return "registersuccess";
    }

}
