package jh.springbasicapp.provider;

import jh.springbasicapp.encryptor.TextEncryptor;
import jh.springbasicapp.enums.UserRole;
import jh.springbasicapp.model.User;
import jh.springbasicapp.model.UserEntity;
import jh.springbasicapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BS-113-Jahangir on 3/2/2015.
 */
@Component
@Transactional
public class BasicAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TextEncryptor textEncryptor;


    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
        if (authentication.getName() != null && authentication.getCredentials() != null) {
            try {

                UserEntity userEntity = userRepository.getUserByUserId(authentication.getName());
                User currentUser = createUserFromEntity(userEntity);
                if (userEntity != null && textEncryptor.isEqual(userEntity.getPassword(), authentication.getCredentials().toString())) {
                    AUTHORITIES.add(new SimpleGrantedAuthority(UserRole.getNameByValue(2)));
                    return new UsernamePasswordAuthenticationToken(currentUser, "", AUTHORITIES);
                } else {
                    throw new UserStatusException("User Credential does not match");
                }


            } catch (Exception e) {
                e.printStackTrace();
                throw new UserStatusException("Invalid Attempt");
            }

        } else {
            throw new UserStatusException("Invalid Attempt");
        }

    }

    public User createUserFromEntity(UserEntity userEntity) {
        User user = new User();

        user.setId(user.getId());

        user.setUserName(userEntity.getUserName());

        user.setFullName(userEntity.getFullName());

        user.setAddress(userEntity.getAddress());

        user.setEmail(userEntity.getEmail());

        user.setMobile(userEntity.getMobile());

        return user;
    }


    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    class UserStatusException extends AccountStatusException {
        public UserStatusException(String msg) {
            super(msg);
        }
    }
}
