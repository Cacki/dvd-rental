package org.dvdrental.models.dvd;

public enum DVDGenre {
    ACTION("Action"),
    THRILLER("Thriller"),
    HORROR("Horror"),
    COMEDY("Comedy");

    private final String displayName;

    DVDGenre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
