package jh.springbasicapp.repository;

import jh.springbasicapp.model.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jahangir on 18/02/2015.
 */

@Repository
public class UserRepository extends BaseRepository<UserEntity> {

    public UserEntity getUserByUserId(String userName)
    {
        Criteria criteria = getSession().createCriteria(UserEntity.class)
                .add(Restrictions.eq("userName", userName).ignoreCase());

        return (UserEntity) criteria.uniqueResult();


    }
}
