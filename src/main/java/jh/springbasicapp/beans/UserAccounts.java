package jh.springbasicapp.beans;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lenovo on 16/02/2015.
 */
public class UserAccounts {

    private User user;
    private UserFullAddress fullAddress;

//    public UserAccounts() {
//    }

    public UserFullAddress getFullAddress() {
        return fullAddress;
    }

    @Autowired
    public void setFullAddress(UserFullAddress fullAddress) {
        this.fullAddress = fullAddress;
    }



    public UserAccounts(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
