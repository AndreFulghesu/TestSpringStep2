package it.si2001.testlogin.dao;

import it.si2001.testlogin.domain.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp extends AbstractDao<User,Long>   implements UserDao {

    @Override
    public User checkUser(String email, String password) {
        return super.checkUser(email,password);
    }
}
