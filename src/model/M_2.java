package model;

import java.io.File;

import javafx.scene.image.ImageView;

public class M_2 implements movie{
    private String name = "Creed III";
    private String description = "\"Creed III\" continues the thrilling journey of Adonis Creed (Michael B. Jordan) as he steps into the boxing ring once again, facing new challenges both inside and outside the ring. Under the guidance of his mentor Rocky Balboa (Sylvester Stallone), Adonis must confront his past and define his own legacy in the world of boxing. Packed with intense boxing sequences, heartfelt moments, and gripping drama, this installment in the Creed franchise delivers an emotional and powerful punch.";
    private String yearMade = "2023";
    private String ratePercent = "90%";
    private String rateVotes = "100,000";
    private String imageMScreen = "/movieImages/m_2MainScreen.jpg";
    private String imagePoster = "/movieImages/m_2Poster.jpg";
    private String trailer = "\\src\\movieTrailer\\M2Trailer.mp4";
    private String creatorDescription = "An Original Film of MGM Studios";
    private String genre1 = "Drama";
    private String genre2 = "Sports";
    private String genre3 = "Action";
    private String actor1 = "Michael B. Jordan";
    private String actor2 = "Jonathan Majors";
    private String actor3 = "Tessa Thompson";
    private Boolean isPurchased = false;
    private String starring1 = "/castImage/MikeBJordan.png";
    private String starring2 = "\\castImage\\JonathanMajors.png";
    private String starring3 = "\\castImage\\DaveBautista.png";

    public void setIsPurchased(boolean isPurchased) {
        this.isPurchased = isPurchased;
    }

    public boolean getIsPurchased() {
        return isPurchased;
    }

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
        File directory = new File("");
        String loc = (directory.getAbsolutePath() + trailer);

        return loc;
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
     @Override
    public ImageView getStarring1(){
        return new ImageView(starring1);
    }
    @Override
    public ImageView getStarring2(){
        return new ImageView(starring2);
    }
    @Override
    public ImageView getStarring3(){
        return new ImageView(starring3);
    }



}
