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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by BS-113-Jahangir on 3/12/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

    @Mock
    private RegistrationService registrationService;

    @InjectMocks
    private RegistrationController registrationController;

    MockMvc mockMvc;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
    }

    @Test
    public void doRegisterTest() throws Exception {
        BaseResponse response = new BaseResponse();
        response.setResponseCode(100);
        when(registrationService.doRegistration(any(User.class))
        ).thenReturn(response);
        this.mockMvc.perform(post("/register")
            .param("userName", "jahangir")
                .param("password","Tokchud")
                        .param("fullName","Jahangir")
                        .param("mobile", "0178577788")
                        .param("email", "jah")
                        .param("address", "fdfd"))
                .andExpect(model().hasNoErrors())
                .andExpect(view().name("registersuccess"));



    }

}
