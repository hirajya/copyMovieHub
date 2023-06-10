package model;

import javafx.scene.image.ImageView;

public class M_4 implements movie{
    private String name = "The Hows of Us";
    private String description = "\"The Hows of Us\" is a poignant and heartfelt Filipino romantic drama that explores the challenges and complexities of long-term relationships. It follows the journey of a young couple, Primo (Daniel Padilla) and George (Kathryn Bernardo), as they navigate the ups and downs of their seven-year relationship. As they face career aspirations, personal aspirations, and the realities of adulthood, their love is put to the ultimate test. With its emotional depth and realistic portrayal of love's triumphs and tribulations, this film captures the hearts of audiences worldwide.";
    private String yearMade = "2018";
    private String ratePercent = "85%";
    private String rateVotes = "3,500";
    private String imageMScreen = "/movieImages/m_4MainScreen.jpg";
    private String imagePoster = "/movieImages/m_4Poster.jpg";
    private String trailer = "/movieTrailers/m_4Trailer.mp4";
    private String creatorDescription = "An Original Film of Star Cinema";
    private String genre1 = "Romance";
    private String genre2 = "Drama";
    private String genre3 = "Comedy";
    private String actor1 = "Daniel Padilla";
    private String actor2 = "Kathryn Bernardo";
    private String actor3 = "Darren Espanto";

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
