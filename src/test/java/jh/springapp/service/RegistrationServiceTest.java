package jh.springapp.service;

import jh.springbasicapp.encryptor.TextEncryptor;
import jh.springbasicapp.repository.UserPermissionRepository;
import jh.springbasicapp.repository.UserRepository;
import jh.springbasicapp.service.RegistrationService;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by BS-113-Jahangir on 3/16/2015.
 */
public class RegistrationServiceTest {

    @Mock
    private UserRepository userRepository;


    @Mock
    private UserPermissionRepository userPermissionRepository;

    @Mock
    private TextEncryptor textEncryptor;

    private RegistrationService registrationService;

    private MockMvc mockMvc;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(registrationService).build();
    }


}
