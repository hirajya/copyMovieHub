package model;

import javafx.scene.image.ImageView;

public interface movie {
    
    String getName();
    String getDescription();
    String getYearMade();
    String getRatePercent();
    String getRateVotes();
    String getTrailer();
    String getCreatorDescription();
    ImageView getPosterImage();
    ImageView getMainImage();
    String getGenre1();
    String getGenre2();
    String getGenre3();
    String getActor1();
    String getActor2();
    String getActor3();
    boolean getIsPurchased();
    void setIsPurchased(boolean isPurchased);
    ImageView getStarring3();
    ImageView getStarring2();
    ImageView getStarring1();



} // abstract vs. interface
// abstract - method ,variable
// interface - method only