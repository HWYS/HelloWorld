package com.hwys.helloworld;

/**
 * Created by htetwaiyanswe on 3/18/18.
 */

public class AlbumInfo {
    private String songName, artistName, duration;
    private int albumCover, id;

    public AlbumInfo(){

    }

    public AlbumInfo(String _songName, String _artistName, String _duration, int _albumCover){
        songName = _songName;
        artistName = _artistName;
        duration = _duration;
        albumCover = _albumCover;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(int albumCover) {
        this.albumCover = albumCover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
