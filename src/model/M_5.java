package model;

import javafx.scene.image.ImageView;

public class M_5 implements movie{
    private String name = "Ant-Man and the Wasp: Quantumania";
    private String description = " In \"Ant-Man and the Wasp: Quantumania,\" Scott Lang (Paul Rudd) and Hope Van Dyne (Evangeline Lilly) return as the dynamic superhero duo, as they embark on a mind-bending adventure into the quantum realm. Joined by Hank Pym (Michael Douglas) and their newfound ally, Cassie Lang (Catherine Newton), they must unravel the secrets of the quantum realm while facing a new and formidable enemy. Packed with humor, action, and mind-boggling visuals, this Marvel Cinematic Universe film takes the Ant-Man franchise to new dimensions.";
    private String yearMade = "2023";
    private String ratePercent = "89%";
    private String rateVotes = "350,500";
    private String imageMScreen = "/movieImages/m_5MainScreen.jpg";
    private String imagePoster = "/movieImages/m_5Poster.png";
    private String trailer = "C:\\Users\\angel\\Desktop\\copyMovieHub\\copyMovieHub\\src\\movieTrailer\\M5Trailer.mp4";
    private String creatorDescription = "An Original Film of Marvel Studios";
    private String genre1 = "Superhero";
    private String genre2 = "Action";
    private String genre3 = "Comedy";
    private String actor1 = "Paul Rudd";
    private String actor2 = "Evangeline Lilly";
    private String actor3 = "Michael Douglas";

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
