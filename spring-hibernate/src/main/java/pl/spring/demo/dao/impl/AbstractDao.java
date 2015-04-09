package pl.spring.demo.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.demo.dao.Dao;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional(Transactional.TxType.SUPPORTS)
public abstract class AbstractDao<T> implements Dao<T> {
    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> domainClass;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void create(T entity) {
        getSession().save(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(Serializable id) {
        return (T) getSession().get(getDomainClass(), id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T load(Serializable id) {
        return (T) getSession().load(getDomainClass(), id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return getSession().createQuery("from " + getDomainClassName()).list();
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public void delete(Serializable id) {
        getSession().delete(load(id));
    }

    @Override
    public void deleteAll() {
        getSession().createQuery("delete " + getDomainClassName()).executeUpdate();
    }

    @Override
    public long count() {
        return (long) getSession().createQuery("Select count(*) from " + getDomainClassName()).uniqueResult();
    }

    @Override
    public boolean exists(Serializable id) {
        return get(id) != null;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getDomainClass() {
        if (domainClass == null) {
            ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
            domainClass = (Class<T>) type.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    private String getDomainClassName() {
        return getDomainClass().getName();
    }
}
