package Model.Copyrights;
import Model.Songs.*;
import Model.Artists.*;

public class Copyrights {
    Songs song;
    Artists artist;
    int copyright_id;
    String record_lable;

    public Copyrights(int copyright_id, Songs song, Artists artist, String record_lable) {
        setSongId(song);
        setArtistId(artist);
        setCopyright_id(copyright_id);
        setRecord_lable(record_lable);
    }

    public void setSongId(Songs song) {
        this.song = song;
    }

    public void setArtistId(Artists artist) {
        this.artist = artist;
    }

    public void setCopyright_id(int copyright_id) {
        this.copyright_id = copyright_id;
    }

    public void setRecord_lable(String record_lable) {
        this.record_lable = record_lable;
    }

    public Songs getSongId() {
        return song;
    }

    public Artists getArtistId() {
        return artist;
    }

    public int getCopyright_id() {
        return copyright_id;
    }

    public String getRecord_lable() {
        return record_lable;
    }

    public int get_song_id() {
        return this.song.getSong_id();
    }

    public int get_artist_id() {
        return this.artist.getA_id();
    }

    public void display(){
        System.out.println("Copyright ID: " + getCopyright_id());
        System.out.println("Song ID: " + get_song_id());
        System.out.println("Artists' ID: " + get_artist_id());
        System.out.println("Record Lable: " + getRecord_lable());
        System.out.println("--------------------------------------------");
    }
}
