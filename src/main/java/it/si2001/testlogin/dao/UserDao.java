package it.si2001.testlogin.dao;

import it.si2001.testlogin.domain.User;

public interface UserDao {

    User checkUser (String email,String password);
}
