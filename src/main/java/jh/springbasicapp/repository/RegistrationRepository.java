package jh.springbasicapp.repository;

import jh.springbasicapp.model.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lenovo on 18/02/2015.
 */

@Repository
public class RegistrationRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public int save(UserEntity userEntity)
    {
        if(userEntity != null)
        {
            sessionFactory.getCurrentSession().save(userEntity);
            return 100;
        }

        return 101;
    }

    @Transactional
    public List<UserEntity> getAllUser()
    {
        return sessionFactory.getCurrentSession().createQuery("FROM UserEntity").list();
    }
}
