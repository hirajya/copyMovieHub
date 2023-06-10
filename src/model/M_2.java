package model;

import javafx.scene.image.ImageView;

public class M_2 implements movie{
    private String name = "Creed III";
    private String description = "\"Creed III\" continues the thrilling journey of Adonis Creed (Michael B. Jordan) as he steps into the boxing ring once again, facing new challenges both inside and outside the ring. Under the guidance of his mentor Rocky Balboa (Sylvester Stallone), Adonis must confront his past and define his own legacy in the world of boxing. Packed with intense boxing sequences, heartfelt moments, and gripping drama, this installment in the Creed franchise delivers an emotional and powerful punch.";
    private String yearMade = "2023";
    private String ratePercent = "90%";
    private String rateVotes = "100,000";
    private String imageMScreen = "/movieImages/m_2MainScreen.jpg";
    private String imagePoster = "/movieImages/m_2Poster.jpg";
    private String trailer = "/movieTrailers/m_2Trailer.mp4";
    private String creatorDescription = "An Original Film of MGM Studios";
    private String genre1 = "Drama";
    private String genre2 = "Sports";
    private String genre3 = "Action";
    private String actor1 = "Michael B. Jordan";
    private String actor2 = "Sylvester Stallone";
    private String actor3 = "Tessa Thompson";

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getYearMade() {
        return yearMade;
    }

    public String getRatePercent() {
        return ratePercent;
    }

    public String getRateVotes() {
        return rateVotes;
    }

    public String getTrailer() {
        return trailer;
    }

    public String getCreatorDescription() {
        return creatorDescription;
    }

    public String getGenre1() {
        return genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public String getGenre3() {
        return genre3;
    }

    public String getActor1() {
        return actor1;
    }

    public String getActor2() {
        return actor2;
    }

    public String getActor3() {
        return actor3;
    }

    @Override
    public ImageView getMainImage() {
        return new ImageView(imageMScreen);
    }

    @Override
    public ImageView getPosterImage() {
        return new ImageView(imagePoster);
    }



}
