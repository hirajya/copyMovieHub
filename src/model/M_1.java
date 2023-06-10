package model;

import javafx.scene.image.ImageView;

public class M_1 implements movie{
    private String name = "Guardians of the Galaxy Vol. 3";
    private String description = "In \"Guardians of the Galaxy Vol. 3,\" the beloved misfit heroes return for an epic cosmic adventure to save the universe from an enigmatic threat. Led by Peter Quill, aka Star-Lord, the Guardians must confront their personal demons, forge new alliances, and embark on a perilous journey across the cosmos. This action-packed installment combines elements of science fiction, superhero, and comedy genres, delivering a visually stunning and emotionally satisfying conclusion to the beloved space opera.";
    private String yearMade = "2023";
    private String ratePercent = "87%";
    private String rateVotes = "250,000";
    private String imageMScreen = "/movieImages/m_1MainScreen.jpg";
    private String imagePoster = "/movieImages/m_1Poster.jpg";
    private String trailer = "/movieTrailers/m_1Trailer.mp4";
    private String creatorDescription = "An Original Film of Marvel Studios";
    private String genre1 = "Science Fiction";
    private String genre2 = "Superhero";
    private String genre3 = "Comedy";
    private String actor1 = "Chris Pratt";
    private String actor2 = "Zoe Saldana";
    private String actor3 = "Dave Bautista";

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
