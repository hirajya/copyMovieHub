package model;

import javafx.scene.image.ImageView;

public class M_8 implements movie{
    private String name = "Avatar: The Way of Water";
    private String description = "\"Avatar: The Way of Water\" is the highly anticipated sequel to James Cameron's groundbreaking sci-fi epic. Set in the immersive world of Pandora, the film follows the continuing adventures of Jake Sully (Sam Worthington) and Neytiri (Zoe Saldana) as they explore uncharted territories and encounter new threats and wonders. With stunning visual effects, an immersive storyline, and a deep connection to nature and indigenous cultures, \"Avatar: The Way of Water\" promises to transport audiences back to the breathtaking world that captivated millions.";
    private String yearMade = "2022";
    private String ratePercent = "93%";
    private String rateVotes = "300,000";
    private String imageMScreen = "/movieImages/m_8MainScreen.jpg";
    private String imagePoster = "/movieImages/m_8Poster.jpg";
    private String trailer = "/movieTrailers/m_8Trailer.mp4";
    private String creatorDescription = "An Original Film of 20th Century Studios";
    private String genre1 = "Adventure";
    private String genre2 = "Science Fiction";
    private String genre3 = "Drama";
    private String actor1 = "Sam Worthington";
    private String actor2 = "Zoe Saldana";
    private String actor3 = "Sigourney Weaver";

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
