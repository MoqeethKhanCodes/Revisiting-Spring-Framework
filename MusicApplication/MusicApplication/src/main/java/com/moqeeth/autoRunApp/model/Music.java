package com.moqeeth.autoRunApp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Music")
@Setter
@Getter
@NoArgsConstructor
public class Music {
    private long id;
    private String name;
    private String artistName;
    private Date releaseYear;

    public Music(String artistName, long id, String name, Date releaseYear) {
        this.artistName = artistName;
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
    }
}
