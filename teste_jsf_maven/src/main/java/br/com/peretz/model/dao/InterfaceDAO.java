package br.com.peretz.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Rafael
 */
public interface InterfaceDAO<T> {
    
    void insert(T entity);
    void update(T entity);
    void delete(T entity);
    void merge(T entity);
    T getEntity(Serializable id);
    T getEntityByDetachedCriteria(DetachedCriteria criteria);
    List<T> getEntities();
    List<T> getListByDetachedCriteria(DetachedCriteria criteria);
       
    
}