package model;

import java.io.File;

import javafx.scene.image.ImageView;

public class M_9 implements movie{
    private String name = "Alone / Together";
    private String description = "\"Alone/Together\" is a captivating Filipino romantic drama that explores the complexities of love, ambition, and missed opportunities. It follows the story of Christine (Liza Soberano) and Raf (Enrique Gil), two college sweethearts who meet again after several years apart. As they confront their unfinished business and the paths their lives have taken, they must navigate the choices they made and the consequences that come with them. With its heartfelt performances and thought-provoking narrative, this film offers a bittersweet reflection on love, dreams, and the choices we make along the way.";
    private String yearMade = "2019";
    private String ratePercent = "81%";
    private String rateVotes = "1,700";
    private String imageMScreen = "/movieImages/m_9MainScreen.jpg";
    private String imagePoster = "/movieImages/m_9Poster.jpg";
    private String trailer = "\\src\\movieTrailer\\M9Trailer.mp4";
    private String creatorDescription = "An Original Film of ABS-CBN Film Productions";
    private String genre1 = "Romance";
    private String genre2 = "Comedy";
    private String genre3 = "Drama";
    private String actor1 = "Liza Soberano";
    private String actor2 = "Enrique Gil";
    private String actor3 = "Sylvia Sanchez";
    private Boolean isPurchased = false;

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




}
