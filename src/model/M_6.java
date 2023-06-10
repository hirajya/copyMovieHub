package model;

import javafx.scene.image.ImageView;

public class M_6 implements movie{
    private String name = "Tetris: The Movie";
    private String description = "\"Tetris\" is a thrilling and visually captivating film that explores the fascinating history and impact of one of the most iconic video games of all time. Set during the late 1980s, this historical drama delves into the behind-the-scenes battles and legal disputes surrounding the creation and distribution of the game. With its mix of compelling characters, gripping storytelling, and nostalgic appeal, \"Tetris\" takes audiences on an intriguing journey through the world of gaming.";
    private String yearMade = "2023";
    private String ratePercent = "92%";
    private String rateVotes = "250,000";
    private String imageMScreen = "/movieImages/m_6MainScreen.jpg";
    private String imagePoster = "/movieImages/m_6Poster.png";
    private String trailer = "C:\\Users\\angel\\Desktop\\copyMovieHub\\copyMovieHub\\src\\movieTrailer\\M6Trailer.mp4";
    private String creatorDescription = "An Original Film of Apple Studios";
    private String genre1 = "Historical Drama";
    private String genre2 = "Action";
    private String genre3 = "Comedy";
    private String actor1 = "Taron Egerton";
    private String actor2 = "Sofya Lebedava";
    private String actor3 = "Nikita Efremov";

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
