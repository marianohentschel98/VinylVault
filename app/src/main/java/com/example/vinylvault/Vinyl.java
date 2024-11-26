package com.example.vinylvault;

public class Vinyl {
    private int foto;
    private String title;
    private String artist;
    private String rpm;
    private String released;
    private String genero;

    public Vinyl(int foto, String title, String artist, String rpm, String released, String genero) {
        this.foto = foto;
        this.title = title;
        this.artist = artist;
        this.rpm = rpm;
        this.released = released;
        this.genero= genero;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRpm() {
        return rpm;
    }

    public void setRpm(String rpm) {
        this.rpm = rpm;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Vynil{" +
                "foto=" + foto +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", rpm='" + rpm + '\'' +
                ", released='" + released + '\'' +
                '}';
    }
}
