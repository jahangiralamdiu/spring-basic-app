package jh.springbasicapp.service;

import jh.springbasicapp.model.User;
import jh.springbasicapp.model.UserEntity;
import jh.springbasicapp.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by BS-113-Jahangir on 3/2/2015.
 */
@Service
public class AuthenticationService {

    private UserRepository userRepository;

    public User getCurrentUser(String userName) {
        User user = new User();

        UserEntity userEntity = userRepository.getUserByUserId(userName);

        return user;
    }
}
