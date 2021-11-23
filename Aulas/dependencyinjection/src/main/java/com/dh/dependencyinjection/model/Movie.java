package com.dh.dependencyinjection.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
    private String name;
    private String genre;
    private String rating;
    private String publisher;
    private Integer releaseYear;

    public Movie(String name, String genre, String rating, String publisher, Integer releaseYear) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
    }
}
