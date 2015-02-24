package jh.springbasicapp.service;

import jh.springbasicapp.model.User;
import jh.springbasicapp.model.UserEntity;
import jh.springbasicapp.repository.RegistrationRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        try {
            userEntity.setImageFile(user.getImageFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int responsecode = registrationRepository.save(userEntity);

        return responsecode;
    }

    public List<User> getAllUser()
    {
        List<UserEntity> userEntities = registrationRepository.getAllUser();
        List<User> users = new ArrayList<User>();

        for(UserEntity userEntity : userEntities)
        {
            User user = new User();
            user.setUserName(userEntity.getUserName());
            user.setFullName(userEntity.getFullName());
            user.setAddress(userEntity.getAddress());
            user.setMobile(userEntity.getMobile());
            user.setEmail(userEntity.getEmail());
            user.setDateOfBirth(userEntity.getDateOfBirth());
            if(userEntity.getImageFile()==null)
            {
                user.setImageString("noimage");
            }
            else
            {
                user.setImageString(Base64.encodeBase64String(userEntity.getImageFile()));
            }

            users.add(user);
        }

        return users;


    }
}
