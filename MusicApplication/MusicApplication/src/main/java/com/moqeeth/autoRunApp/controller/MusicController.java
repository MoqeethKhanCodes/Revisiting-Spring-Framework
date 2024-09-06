package com.moqeeth.autoRunApp.controller;

import com.moqeeth.autoRunApp.dao.MusicTemplate;
import com.moqeeth.autoRunApp.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicApp")
public class MusicController {

    @Autowired
    private MusicTemplate musicTemplate;

    @GetMapping("/getAllSongs")
    public ResponseEntity<List<Music>> getAllSongs() {
        List<Music> musicTracks = musicTemplate.getAllTracks();
        return ResponseEntity.ok(musicTracks);
    }

    @GetMapping("/getSongById/{id}")
    public ResponseEntity<Music> getSongById(@PathVariable long id) {
        Music musicTrack = musicTemplate.getTrackById(id);
        return ResponseEntity.ok(musicTrack);
    }

    @GetMapping("/getSongByName/{name}")
    public ResponseEntity<Music> getSongByName(@PathVariable String name) {
        Music musicTrack = musicTemplate.getTrackByName(name);
        return ResponseEntity.ok(musicTrack);
    }

    @GetMapping("/getSongsByArtist/{artistName}")
    public ResponseEntity<List<Music>> getSongsByArtist(@PathVariable String artistName) {
        List<Music> musicList = musicTemplate.getTracksByArtist(artistName);
        return ResponseEntity.ok(musicList);
    }

    @PostMapping("/storeASong")
    public ResponseEntity<Music> storeOneMusic(@RequestBody Music music) {
        musicTemplate.storeOneTrack(music);
        return ResponseEntity.status(201).body(music);
    }

    @PostMapping("/storeSongList")
    public ResponseEntity<List<Music>> storeMusicList(@RequestBody List<Music> musicList) {
        musicTemplate.storeTrackList(musicList);
        return ResponseEntity.status(201).body(musicList);
    }

    @PutMapping("/updateTrack/{id}")
    public ResponseEntity<Void> updateTrack(@PathVariable long id, @RequestBody Music music) {
        music.setId(id); // Ensure the ID is set on the object
        musicTemplate.updateTrack(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
