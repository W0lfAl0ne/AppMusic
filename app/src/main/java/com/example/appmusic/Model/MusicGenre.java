package com.example.appmusic.Model;

import java.util.Set;

public class MusicGenre {

    private int id;
    private String name;
    private Set<Music> musics;
    private String source;
    private String slogan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Music> getMusics() {
        return musics;
    }

    public void setMusics(Set<Music> musics) {
        this.musics = musics;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    @Override
    public String toString() {
        return "MusicGenre{" +
                "name='" + name + '\'' +
                ", musics=" + musics +
                ", source='" + source + '\'' +
                '}';
    }
}
