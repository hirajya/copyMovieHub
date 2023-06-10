package model;

import java.io.File;

import javafx.scene.image.ImageView;

public class M_7 implements movie{
    private String name = "John Wick: Chapter 4";
    private String description = "\"John Wick: Chapter 4\" continues the adrenaline-fueled saga of legendary hitman John Wick (Keanu Reeves) as he finds himself in a world of danger and betrayal. After breaking the code of the secretive assassin society, John must navigate a treacherous landscape where every contract comes with a price. Packed with intense action sequences, stylish visuals, and a relentless pursuit of justice, this fourth installment in the John Wick franchise takes the audience on a high-octane thrill ride they won't soon forget.";
    private String yearMade = "2023";
    private String ratePercent = "95%";
    private String rateVotes = "370,000";
    private String imageMScreen = "/movieImages/m_7MainScreen.jpg";
    private String imagePoster = "/movieImages/m_7Poster.jpg";
    private String trailer = "\\src\\movieTrailer\\M7Trailer.mp4";
    private String creatorDescription = "An Original Film of Lionsgate";
    private String genre1 = "Thriller";
    private String genre2 = "Action";
    private String genre3 = "Neo-noir";
    private String actor1 = "Keanu Reeves";
    private String actor2 = "Donnie Yen";
    private String actor3 = "Bill Skarsgard";

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



}
