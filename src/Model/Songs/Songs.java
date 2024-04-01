package Model.Songs;

public class Songs extends MediaItems {
    private static int Songs_Count = 0;
    int Song_id;
    String Song_name;
    double Song_duration;

    public Songs() {
        Songs_Count++;
        this.setSong_id(Songs_Count);
    }


    public static int getSongs_Count() {
        return Songs_Count;
    }
    public Songs(int s_id, String language, String s_name, double s_duration, double media_rating, String media_date) {
        super(media_rating, language, media_date);
        Songs_Count++;
        setSong_id(s_id);
        setSong_name(s_name);
        setSong_duration(s_duration);
    }

    public Songs(double Media_Rating, String Language, String Date, String Song_name, double Song_duration) {
        super(Media_Rating, Language, Date);
        Songs_Count++;
        setSong_id(Songs_Count);
        setSong_name(Song_name);
        setSong_duration(Song_duration);
    }

    public void setSong_id(int song_id) {
        this.Song_id = song_id;
    }

    public void setSong_name(String song_Name) {
        Song_name = song_Name;
    }

    public void setSong_duration(double song_duration) {
        Song_duration = song_duration;
    }

    public int getSong_id() {
        return Song_id;
    }

    public String getSong_name() {
        return Song_name;
    }

    public double getSong_duration() {
        return Song_duration;
    }

    public void display(){
        System.out.println("Song ID: " + getSong_id());
        super.display();
        System.out.println("Song name: " + getSong_name());
        System.out.println("Song Duration: " + getSong_duration());
        System.out.println("--------------------------------------------");
    }

}