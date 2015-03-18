package jh.springapp.repository;

import jh.springbasicapp.model.UserEntity;
import jh.springbasicapp.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by BS-113-Jahangir on 3/18/2015.
 * jahangiralamdiu@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-config/spring-config.xml")
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private UserEntity userEntity;

    @Before
    public void setUp()
    {
        userEntity = new UserEntity();
        userEntity.setFullName("Jahangir Alam");
        userEntity.setUserName("lalala");
        userEntity.setPassword("Tokchhhd0$");
        userEntity.setEmail("jahangiralamdiu@gmail.com");
        userEntity.setAddress("unknown");
    }

    @Test
    public void getUserByUserIdTest()
    {
        UserEntity userEntity= userRepository.getUserByUserId("jahangir");

        assertNotNull("user Entity is null", userEntity);

        assertEquals("jahangir", userEntity.getUserName());

        assertNotEquals("Tokc", userEntity.getPassword());
    }

    @Test
    public void createUserTest()
    {
        userRepository.create(this.userEntity);

        UserEntity newUserEntity = userRepository.getUserByUserId(this.userEntity.getUserName());

        assertNotNull("user Entity is null", newUserEntity);

        assertEquals(this.userEntity.getUserName(), newUserEntity.getUserName());

        assertEquals(this.userEntity.getAddress(), newUserEntity.getAddress());


    }
}
