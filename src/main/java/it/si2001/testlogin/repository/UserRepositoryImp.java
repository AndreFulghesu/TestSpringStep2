package it.si2001.testlogin.repository;

import it.si2001.testlogin.domain.User;

import java.util.List;

public class UserRepositoryImp implements UserRepository {
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(long idUtente) {

    }

    @Override
    public User checkUser(String email, String password) {
        return null;
    }
}
