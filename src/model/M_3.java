package model;

import java.io.File;

import javafx.scene.image.ImageView;

public class M_3 implements movie{
    private String name = "Howl's Moving Castle";
    private String description = "Based on the enchanting novel by Diana Wynne Jones, \"Howl's Moving Castle\" is a captivating animated tale set in a world of magic and wonder. When a young girl named Sophie is cursed by a wicked witch and transformed into an old woman, she embarks on a fantastical adventure to find a way to break the spell. Along the way, she encounters a mysterious wizard named Howl and his extraordinary moving castle. This visually stunning film, directed by Hayao Miyazaki, combines breathtaking animation, imaginative storytelling, and a touch of romance.";
    private String yearMade = "2004";
    private String ratePercent = "94%";
    private String rateVotes = "319,000";
    private String imageMScreen = "/movieImages/m_3MainScreen.jpg";
    private String imagePoster = "/movieImages/m_3Poster.jpg";
    private String trailer = "\\src\\movieTrailer\\M3Trailer.mp4";
    private String creatorDescription = "A Ghibli Original film by Hayao Miyazaki";
    private String genre1 = "Animation";
    private String genre2 = "Adventure";
    private String genre3 = "Fantasy";
    private String actor1 = "Takuya Kimura";
    private String actor2 = "Emily Mortimer";
    private String actor3 = "Tatsuya Gashuin";
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
