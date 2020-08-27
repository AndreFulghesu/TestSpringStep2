package it.si2001.testlogin.service;

import it.si2001.testlogin.dao.UserDao;
import it.si2001.testlogin.domain.User;
import it.si2001.testlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
@Transactional
public class UserServiceImp implements  UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDAO(UserDao userDAO) {
        this.userDao = userDAO;
    }

    public UserDao getUserDAO() {
        return userDao;
    }


    @Override
    public User checkUser(String email, String password) {

        User user = getUserDAO().checkUser(email,password);
        return user;
    }
}
