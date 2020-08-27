package it.si2001.testlogin.dao;

import it.si2001.testlogin.domain.User;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<I extends Serializable, Id extends Serializable> implements GenericRepository<I,Id> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected final Class<I> entityClass;

    CriteriaBuilder builder;

    @SuppressWarnings("unchecked")
    public AbstractDao () {
        this.entityClass = (Class<I>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    private CriteriaQuery<I> initCriteria () {

        builder = this.entityManager.getCriteriaBuilder();
        return builder.createQuery(this.entityClass);
    }


    @Override
    public List<I> selectAll () {
        CriteriaQuery<I> query = this.initCriteria();

        return this.entityManager.createQuery(
                query.select(query.from(this.entityClass))).getResultList();
    }

    @Override
    public I selectById (Id id){
        CriteriaQuery<I> query = this.initCriteria();

        return this.entityManager.createQuery(
                query.where(builder.equal(query.from(
                        this.entityClass).get("id"),id))).getSingleResult();
    }

    @Override
    public void aggiorna (I entity){
        this.entityManager.merge(entity);
        flushAndClear();
    }

    @Override
    public void inserisci (I entity){
        this.entityManager.persist(entity);
        flushAndClear();

    }

    @Override
    public void elimina (I entity){
        this.entityManager.remove(this.entityManager.contains(entity) ? entity: this.entityManager.merge(entity));
        flushAndClear();
    }


    @Override
    public void eliminaById (Id id) {
        CriteriaQuery<I> query = this.initCriteria();

        this.entityManager.createQuery(
                query.where(
                        builder.equal(
                                query.from(this.entityClass)
                                        .get("id"), id)
                )).executeUpdate();

        flushAndClear();
        }


        @Override
        public User checkUser (String email, String password){


        String JPQL = "SELECT c FROM User c WHERE c.email = :custEmail AND c.password = :custPass ";

            User utente = (User) entityManager.createQuery(JPQL)
                    .setParameter("custEmail",email)
                    .setParameter("custPass",password).getSingleResult();

            return utente;

        }



    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }

}
