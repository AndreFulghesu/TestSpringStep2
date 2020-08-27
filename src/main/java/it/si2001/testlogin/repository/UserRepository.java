package it.si2001.testlogin.repository;

import it.si2001.testlogin.domain.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers ();
    void deleteUser (long idUtente);
    User checkUser (String email, String password);
}
