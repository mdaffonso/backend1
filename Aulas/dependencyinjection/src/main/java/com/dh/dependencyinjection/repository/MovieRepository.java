package com.dh.dependencyinjection.repository;

import com.dh.dependencyinjection.dao.MovieDAO;
import com.dh.dependencyinjection.model.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieRepository implements IRepository<Movie, MovieDAO> {
    public static Map<Integer, Movie> movieMap = new HashMap<>();
    private static Integer counter = 0;

    @Override
    public Map<Integer, Movie> create(MovieDAO dao) {
        counter++;
        Movie m = new Movie(dao.getName(), dao.getGenre(), dao.getRating(), dao.getPublisher(), dao.getReleaseYear());
        movieMap.put(counter, m);

        Map<Integer, Movie> create = new HashMap<>();
        create.put(counter, m);
        return create;
    }

    @Override
    public Map<Integer, Movie> update(MovieDAO dao) {
        return null;
    }

    @Override
    public Map<Integer, Movie> all() {
        return movieMap;
    }

    @Override
    public Map<Integer, Movie> find(Integer id) {
        Map<Integer, Movie> select = new HashMap<>();
        select.put(id, movieMap.get(id));
        return select;
    }

    @Override
    public void delete(Integer id) {
        movieMap.remove(id);
    }


}
