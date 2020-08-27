package it.si2001.testlogin.service;

import it.si2001.testlogin.domain.User;


public interface UserService {

    User checkUser (String email, String password);
}
