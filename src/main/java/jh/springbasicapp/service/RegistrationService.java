package jh.springbasicapp.service;

import jh.springbasicapp.encryptor.TextEncryptor;
import jh.springbasicapp.enums.UserRole;
import jh.springbasicapp.model.BaseResponse;
import jh.springbasicapp.model.User;
import jh.springbasicapp.model.UserEntity;
import jh.springbasicapp.model.UserPermissionEntity;
import jh.springbasicapp.repository.UserPermissionRepository;
import jh.springbasicapp.repository.UserRepository;
import org.apache.commons.codec.binary.Base64;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 18/02/2015.
 */
@Service
@Transactional
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Autowired
    private TextEncryptor textEncryptor;

    public BaseResponse doRegistration(User user)
    {
        UserEntity userEntity = new UserEntity();

        BaseResponse response = new BaseResponse();

        List <String> errors = new ArrayList<String>();

        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(textEncryptor.encrypt(user.getPassword()));
        userEntity.setFullName(user.getFullName());
        userEntity.setMobile(user.getMobile());
        userEntity.setEmail(user.getEmail());
        userEntity.setAddress(user.getAddress());
        userEntity.setDateOfBirth(user.getDateOfBirth());

        if(user.getImageFile() != null)
        {
            try {
                userEntity.setImageFile(user.getImageFile().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try
        {
            userRepository.create(userEntity);
            this.insertUserRole(userEntity.getUserName(), UserRole.ROLE_USER.getCode());
            response.setResponseCode(100);
        }
        catch (HibernateException hbex)
        {

            hbex.printStackTrace();
            response.setResponseCode(101);
            errors.add(hbex.getMessage());

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            response.setResponseCode(101);
            errors.add(ex.getMessage());
        }

        response.setErrors(errors);

        return response;
    }

    public void insertUserRole(String username, int roleId)
    {
        UserEntity userEntity = userRepository.getUserByUserId(username);

        UserPermissionEntity userPermissionEntity = new UserPermissionEntity();

        userPermissionEntity.setUserId(userEntity.getId());

        userPermissionEntity.setUserRoleId(roleId);

        userPermissionRepository.create(userPermissionEntity);

    }

    public List<User> getAllUser()
    {
        List<UserEntity> userEntities = userRepository.getAll();
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

    public User getRegisteredUser(String userName) {

        UserEntity userEntity = userRepository.getUserByUserId(userName);

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
        return user;
    }
}
