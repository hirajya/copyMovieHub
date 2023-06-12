package model;

import java.io.File;

import javafx.scene.image.ImageView;

public class M_10 implements movie{
    private String name = "Spirited Away";
    private String description = "Winner of the Academy Award for Best Animated Feature, \"Spirited Away\" is a magical and captivating journey into the spirit world. When young Chihiro finds herself trapped in a realm of spirits and gods, she must navigate a strange and dangerous world to rescue her parents and find her way back home. Directed by the legendary Hayao Miyazaki, this visually stunning film weaves a tale of bravery, friendship, and the power of love. \"Spirited Away\" is a masterpiece of animation that enchants audiences of all ages.";
    private String yearMade = "2001";
    private String ratePercent = "97%";
    private String rateVotes = "684,400";
    private String imageMScreen = "/movieImages/m_10MainScreen.jpg";
    private String imagePoster = "/movieImages/m_10Poster.jpg";
    private String trailer = "\\src\\movieTrailer\\M10Trailer.mp4";
    private String creatorDescription = "A Ghibli Original film by Hayao Miyazaki";
    private String genre1 = "Animation";
    private String genre2 = "Fantasy";
    private String genre3 = "Adventure";
    private String actor1 = "Rumi Hiiragi";
    private String actor2 = "Miyu Irino";
    private String actor3 = "Mari Natsuki";
    private Boolean isPurchased = false;

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

}
