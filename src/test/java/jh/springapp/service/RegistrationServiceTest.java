package jh.springapp.service;

import jh.springbasicapp.encryptor.TextEncryptor;
import jh.springbasicapp.model.BaseResponse;
import jh.springbasicapp.model.User;
import jh.springbasicapp.model.UserEntity;
import jh.springbasicapp.model.UserPermissionEntity;
import jh.springbasicapp.repository.UserPermissionRepository;
import jh.springbasicapp.repository.UserRepository;
import jh.springbasicapp.service.RegistrationService;
import org.hibernate.HibernateException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by BS-113-Jahangir on 3/16/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {

    @Mock
    private UserRepository userRepository;


    @Mock
    private UserPermissionRepository userPermissionRepository;

    @Mock
    private TextEncryptor textEncryptor;

    @Spy
    private BaseResponse response;

    @Spy
    private User user;

    @Spy
    private UserEntity userEntity;

    @InjectMocks
    private RegistrationService registrationService;

    private MockMvc mockMvc;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(registrationService).build();

        user.setUserName("jahangir");
        user.setEmail("jahangir@gmail");

        userEntity.setId(1);
        userEntity.setUserName("jahangir");
    }

    @Test
    public void doRegistrationHibernateExceptionTest()
    {
      doThrow(new HibernateException("Hibernate Errors")).when(userRepository).create(any(UserEntity.class));

        response = registrationService.doRegistration(new User());

        assertEquals(101, response.getResponseCode());

        assertEquals("Hibernate Errors", response.getErrors().get(0));
    }

    @Test
    public void doRegistrationSuccessTest()
    {
        doNothing().when(userRepository).create(any(UserEntity.class));

        doNothing().when(userPermissionRepository).create(any(UserPermissionEntity.class));

        when(userRepository.getUserByUserId(anyString()))
                .thenReturn(userEntity);

        response = registrationService.doRegistration(user);

        assertEquals(100, response.getResponseCode());

        assertEquals(response.getErrors().size(), 0);

        verify(userRepository).create(any(UserEntity.class));
    }



}
