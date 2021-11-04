package com.dh.dao;

public interface IDAO<T> {
    public T save();
    public void delete();
    public T selectById();
    public T selectAll();
}
