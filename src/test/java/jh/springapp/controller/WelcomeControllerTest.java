package jh.springapp.controller;

import jh.springbasicapp.controller.WelcomeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by BS-113-Jahangir on 3/12/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class WelcomeControllerTest {

    private MockMvc mockMvc;


    @InjectMocks
    private WelcomeController welcomeController;

    @Before
    public void setup()
    {
        this.mockMvc = MockMvcBuilders.standaloneSetup(welcomeController).build();
    }

    @Test
    public void welcomeNegativeTest() throws Exception {

       assertNotEquals("notindex", welcomeController.welcome());

    }

    @Test
    public void welcomePositiveTest() throws Exception {
        this.mockMvc.perform(get("/")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

    }
}
