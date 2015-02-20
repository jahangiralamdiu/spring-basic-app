package jh.springbasicapp.service;

import jh.springbasicapp.model.User;
import jh.springbasicapp.model.UserEntity;
import jh.springbasicapp.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 18/02/2015.
 */
@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    private UserEntity userEntity;
    public int doRegistration(User user)
    {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserName(user.getUserName());
        userEntity.setFullName(user.getFullName());
        userEntity.setMobile(user.getMobile());
        userEntity.setEmail(user.getEmail());
        userEntity.setAddress(user.getAddress());
        userEntity.setDateOfBirth(user.getDateOfBirth());

        int responsecode = registrationRepository.save(userEntity);

        return responsecode;
    }
}
