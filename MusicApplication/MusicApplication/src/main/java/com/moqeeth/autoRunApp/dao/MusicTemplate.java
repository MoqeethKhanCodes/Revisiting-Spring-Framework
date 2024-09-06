package com.moqeeth.autoRunApp.dao;

import com.moqeeth.autoRunApp.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MusicTemplate {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Music> getAllTracks() {
        return mongoTemplate.findAll(Music.class);
    }

    public Music getTrackById(long id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        return mongoTemplate.findOne(query, Music.class);

    }

    public Music getTrackByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));

        return mongoTemplate.findOne(query, Music.class);
    }

    public List<Music> getTracksByArtist(String artistName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("artistName").is(artistName));

        return mongoTemplate.find(query, Music.class);

    }

    public void storeOneTrack(Music music) {
        mongoTemplate.save(music);
    }

    public void storeTrackList(List<Music> musicList) {
        mongoTemplate.insertAll(musicList);
    }

    public void updateTrack(long id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        Music music = mongoTemplate.findOne(query, Music.class);

        if (music != null) {
            mongoTemplate.save(music);
        } else {
            System.out.println("Music track with ID " + id + " not found.");
        }
    }
}
