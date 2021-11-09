package com.dh.server;

import java.util.List;

public interface IDAO<T> {
    public T insert(T t) throws Exception;
    public T update(T t) throws Exception;
    public T findById(int id) throws Exception;
    public List<T> findAll() throws Exception;
    public void delete(int id) throws Exception;
}
