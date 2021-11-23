package com.dh.dependencyinjection.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDAO {
    private Integer id;
    private String name;
    private String genre;
    private String rating;
    private String publisher;
    private Integer releaseYear;
}
