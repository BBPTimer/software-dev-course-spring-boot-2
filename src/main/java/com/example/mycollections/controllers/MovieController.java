package com.example.mycollections.controllers;

import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    //    private final List<Movie> movies = new ArrayList<>() {
//        {
//            add(new Movie("Nosferatu", 2024, "Robert Eggers", 122));
//            add(new Movie("Superman", 2025, "James Gunn", 129));
//            add(new Movie("KPop Demon Hunters", 2025, "Maggie Kang", 96));
//        }
//    };
    private final ArrayList<Movie> movies = new ArrayList<>();

    MovieController() {
        movies.add(new Movie("Nosferatu", 2024, "Robert Eggers", 122));
        movies.add(new Movie("Superman", 2025, "James Gunn", 129));
        movies.add(new Movie("KPop Demon Hunters", 2025, "Maggie Kang", 96));
    }

    @GetMapping("/json")
    public List<Movie> getMoviesJson() {
        return movies;
    }

    @GetMapping("/html")
    public String getMoviesHtml() {
        String movieList = "<ul>";
        for (Movie movie : movies) {
            movieList += "<li>" + movie + "</li>";
        }
        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Books</h1>
                        <ul>
                """ +
                movieList +
                """
                                </ul>
                            </body>
                        """;
    }
}
