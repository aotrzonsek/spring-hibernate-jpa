package pl.spring.demo.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {

    void create(T entity);
    T get(Serializable id);
    T load(Serializable id);
    List<T> getAll();
    void update(T entity);
    void saveOrUpdate(T entity);
    void delete(T entity);
    void delete(Serializable id);
    void deleteAll();
    long count();
    boolean exists(Serializable id);
}