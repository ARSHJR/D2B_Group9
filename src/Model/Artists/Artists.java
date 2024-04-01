package Model.Artists;

import java.util.ArrayList;

public class Artists extends Celebrities {
    static int Artists_Count = 0;
    int A_id;
    String A_Genre;
    String A_Label;

    public Artists() {
        super();
        Artists_Count++;
        setA_id(Artists_Count);
    }

    public Artists(String fname, String lname, String email, int networth, String A_Genre, String A_Label) {
        super(fname, lname, email, networth);
        Artists_Count++;
        setA_id(getArtists_Count());
        setA_Genre(A_Genre);
        setA_Label(A_Label);
    }

    public Artists(int A_id, String fname, String lname, String email, int networth, String A_Genre, String A_Label) {
        super(fname, lname, email, networth); //If you're calling a parent class' constructor from a child class' constructor, it has to be in the 1st line
        Artists_Count++;
        setA_id(A_id);
        setA_Genre(A_Genre);
        setA_Label(A_Label);
    }
    public static int getArtists_Count() {
        return Artists_Count;
    }

    public void setA_id(int id) {
        this.A_id = id;
    }
    public void setA_Genre(String Genre) {
        this.A_Genre = Genre;
    }
    public void setA_Label(String Label) {
        this.A_Label = Label;
    }

    public int getA_id() {
        return A_id;
    }
    public String getA_Genre() {
        return A_Genre;
    }
    public String getA_Label() {
        return A_Label;
    }

    public void display() {
        System.out.println("Artist's ID: " + getA_id());
        super.display();
        System.out.println("Artist's Genre: " + getA_Genre());
        System.out.println("Artist's Label: " + getA_Label());
        System.out.println("--------------------------------------------");
    }
}