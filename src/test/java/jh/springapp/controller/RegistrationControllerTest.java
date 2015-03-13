package jh.springapp.controller;

import jh.springbasicapp.controller.RegistrationController;
import jh.springbasicapp.model.BaseResponse;
import jh.springbasicapp.model.User;
import jh.springbasicapp.service.RegistrationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by BS-113-Jahangir on 3/12/2015.
 */

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

    @Mock
    private RegistrationService registrationService;

    @InjectMocks
    private RegistrationController registrationController;

    private BaseResponse response;

    private MockMultipartFile imageFile;

    MockMvc mockMvc;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".jsp");

        this.mockMvc = MockMvcBuilders.standaloneSetup(registrationController)
                .setViewResolvers(viewResolver)
                .build();
    }

    public void setupForRegistratrion()
    {
        response = new BaseResponse();
        response.setResponseCode(100);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("E:\\images.jpg");
            imageFile = new MockMultipartFile("imageFile",fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void registerPageGetTest() throws Exception {
        this.mockMvc.perform(get("/registers"))
                .andExpect(view().name("register"))
                .andExpect(forwardedUrl("register.jsp"));
    }

    @Test
    public void doRegisterHasErrorTest() throws Exception
    {
        setupForRegistratrion();

        when(registrationService.doRegistration(any(User.class))
        ).thenReturn(response);
        this.mockMvc.perform(MockMvcRequestBuilders.fileUpload("/register")
                .file(imageFile)
                .param("password", "Tokchud")
                .param("fullName", "Jahangir")
                .param("mobile", "0178577788")
                .param("email", "jah"))
                .andExpect(model().hasErrors())
                .andExpect(status().isMovedTemporarily())
                .andExpect(redirectedUrl("/register"));
    }

    @Test
    public void doRegisterFailTest() throws Exception
    {
        setupForRegistratrion();
        response.setResponseCode(200);

        when(registrationService.doRegistration(any(User.class))
        ).thenReturn(response);
        this.mockMvc.perform(MockMvcRequestBuilders.fileUpload("/register")
                .file(imageFile)
                .param("userName", "jahangir")
                .param("password", "Tokchudb0$")
                .param("fullName", "Jahangir")
                .param("mobile", "0178577788")
                .param("email", "jahangir@gmail.com"))
                .andExpect(model().hasNoErrors())
                .andExpect(status().isMovedTemporarily())
                .andExpect(redirectedUrl("/register"));
    }

    @Test
    public void doRegisterSuccessTest() throws Exception
    {
        setupForRegistratrion();

        when(registrationService.doRegistration(any(User.class))
        ).thenReturn(response);
        this.mockMvc.perform(MockMvcRequestBuilders.fileUpload("/register")
                .file(imageFile)
                .param("userName", "jahangir")
                .param("password", "Tokchudb0$")
                .param("fullName", "Jahangir")
                .param("mobile", "0178577788")
                .param("email", "jahangir@gmail.com"))
                .andExpect(model().hasNoErrors())
                .andExpect(status().isMovedTemporarily())
                .andExpect(redirectedUrl("/registersuccess"));
    }

    @Test
    public void viewAllUserTest() throws Exception {

        User user = new User();

        List<User> users = new ArrayList<User>();
        users.add(user);

        when(registrationService.getAllUser())
        .thenReturn(users);

        this.mockMvc.perform(get("/view"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attribute("users", users))
                .andExpect(view().name("viewallusers"));

    }


}