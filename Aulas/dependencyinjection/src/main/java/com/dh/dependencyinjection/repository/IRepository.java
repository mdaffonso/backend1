package com.dh.dependencyinjection.repository;

import java.util.Map;

public interface IRepository<M, D> {
    Map<Integer, M> create(D dao);
    Map<Integer, M> update(D dao);
    Map<Integer, M> all();
    Map<Integer, M> find(Integer id);
    void delete(Integer id);
}
