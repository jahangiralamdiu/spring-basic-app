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
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

    @Spy
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
        response.setResponseCode(100);


        FileInputStream fis = null;
        try {
            fis = new FileInputStream("E:\\images.jpg");
//            fis = new FileInputStream("/home/jahangir/Documents/NoImage_592x444.jpg");
            imageFile = new MockMultipartFile("imageFile",fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void registerPageGetTest() throws Exception {
        this.mockMvc.perform(get("/register"))
                .andExpect(view().name("register"));

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
                .andExpect(view().name("register"));
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
                .andExpect(view().name("register"));
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
                .andExpect(redirectedUrl("/registersuccess?userName=jahangir"));

        verify(registrationService, times(1)).doRegistration(any(User.class));
    }

    @Test

    public void registrationSuccessViewTest() throws Exception
    {
        User user = new User();
        user.setId(20);
        user.setUserName("jahangir");
        user.setEmail("jdjjd");
        when(registrationService.getRegisteredUser("jahangir"))
                .thenReturn(user);

        this.mockMvc.perform(get("/registersuccess?userName=jahangir"))
                .andExpect(model().attribute("user", user))
                .andExpect(view().name("registersuccess"));
    }

    @Test
    public void viewAllUserTest() throws Exception
    {
        List<User> users = new ArrayList<User>();
            users.add(new User());
        when(registrationService.getAllUser())
        .thenReturn(users);

        this.mockMvc.perform(get("/view"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attribute("users", users))
                .andExpect(view().name("viewallusers"));

    }


}
