package dao;

import java.util.List;

public interface IGenericDAO <T>{


    void saveOrUpdate(T entity);
    T findById(Class<T> clazz, Long id);
    void delete(T entity);
    List<T> findAll(String namedQuery);
}
