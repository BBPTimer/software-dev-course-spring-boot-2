package com.example.mycollections.controllers;

import com.example.mycollections.models.Album;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final ArrayList<Album> albums = new ArrayList<>();

    AlbumController() {
        albums.add(new Album("Pop 2", 2017, "Charli XCX", 10));
        albums.add(new Album("Charli", 2019, "Charli XCX", 15));
        albums.add(new Album("how i'm feeling now", 2020, "Charli XCX", 11));
    }

    @GetMapping("/json")
    ArrayList<Album> getAlbumsJson() {
        return albums;
    }

    @GetMapping("/html")
    public String getAlbumsHtml() {
        String albumList = "<ul>";
        for (Album album : albums) {
            albumList += "<li>" + album + "</li>";
        }
        albumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Albums</h1>
                        <ul>
                """ +
                albumList +
                """
                                </ul>
                            </body>
                        """;
    }
}
