package com.example.appmusic.models;

import java.util.Set;

public abstract class AMusic {

    private int id;
    private String name;
    private int musicTracks;//tinh theo s
    private int listens;
    private int likes;
    private boolean type;//true thi nhac online
    private String source;
    private String image;
    private Set<AMusic> playlists;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMusicTracks() {
        return musicTracks;
    }

    public void setMusicTracks(int musicTracks) {
        this.musicTracks = musicTracks;
    }

    public int getListens() {
        return listens;
    }

    public void setListens(int listens) {
        this.listens = listens;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<AMusic> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<AMusic> playlists) {
        this.playlists = playlists;
    }
}
