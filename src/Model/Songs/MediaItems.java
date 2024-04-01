package Model.Songs;

public class MediaItems {
    double Media_Rating;
    String Media_Lang;
    String Media_Date;

    public MediaItems() {

    }
    public MediaItems(double Rating, String Lang, String Date) {
        setMedia_Rating(Rating);
        setMedia_Lang(Lang);
        setMedia_Date(Date);
    }

    public void setMedia_Lang(String media_Lang) {
        Media_Lang = media_Lang;
    }

    public void setMedia_Date(String media_Date) {
        Media_Date = media_Date;
    }

    public void setMedia_Rating(double media_Rating) {
        try {
            if(media_Rating > 10.0) {
                throw new RatingException("Rating should be out of 10! ");
            }
            else {
                Media_Rating = media_Rating;
            }
        } catch (RatingException e) {
            System.out.println("Custom Exception caught: " + e.getMessage());
        }
    }

    public String getMedia_Lang() {
        return Media_Lang;
    }

    public String getMedia_Date() {
        return Media_Date;
    }

    public double getMedia_Rating() {
        return Media_Rating;
    }

    public void display() {
        System.out.println("Media Rating: " + getMedia_Rating());
        System.out.println("Media Language: " + getMedia_Lang());
        System.out.println("Date of Creation: " + getMedia_Date());
    }
}