package it.si2001.testlogin.dao;

import it.si2001.testlogin.domain.User;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public interface GenericRepository<I extends Serializable, E extends Serializable> {

    @NotNull
    List<I> selectAll ();


    User checkUser (@NotNull String email, @NotNull String password);

    void inserisci (@NotNull I entity);
    void aggiorna (@NotNull I entity);
    void elimina (@NotNull I entity);
    void eliminaById (@NotNull E id);
    I selectById (@NotNull E id);



}
