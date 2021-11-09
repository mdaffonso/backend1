package com.dh.server;

public interface IDAO<T> {
    public T insert(T t) throws Exception;
    public T update(T t) throws Exception;
    public T findById(int id) throws Exception;
    public void delete(int id) throws Exception;
}
