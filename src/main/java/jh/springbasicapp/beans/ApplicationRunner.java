package jh.springbasicapp.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenovo on 16/02/2015.
 */
public class ApplicationRunner {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"spring-config.xml"});

        UserAccounts userAccounts = applicationContext.getBean("userAccounts", UserAccounts.class);

        User user = userAccounts.getUser();

        UserFullAddress address = userAccounts.getFullAddress();

        System.out.println(user.getUserName());

        System.out.println(address.getAddress() +" "+address.getEmail()+ " "+address.getMobile());

    }



}
