package com.song.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {

    private List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        for (Song song : list) {
            if (song.getId() == id) {
                return song;
            }
        }
        return null;
    }

    public void addSong(Song s) {
        boolean check = false;
        if (list.isEmpty()) {
            list.add(s);
        }
        for (Song song : list) {
            if (song.getId() == s.getId()) {
                check = true;
            }
        }
        if (check == false) {
            list.add(s);
        }
    }
    public void updateSong(Song s) {
        Song song = getSongById(s.getId());
        int indice = list.indexOf(song);
        if (song != null) {
            song.setNome(s.getNome());
            song.setArtista(s.getArtista());
            song.setAlbum(s.getAlbum());
            song.setAnoLancamento(s.getAnoLancamento());
            list.set(indice, song);
        }
    }

    public void removeSong(Song s) {
        Song song = getSongById(s.getId());
        if (song != null) {
            list.remove(s);
        }
    }
}
