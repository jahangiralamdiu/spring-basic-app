package jh.springbasicapp.beans;

/**
 * Created by lenovo on 16/02/2015.
 */
public class UserAccounts {

    private User user;

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
