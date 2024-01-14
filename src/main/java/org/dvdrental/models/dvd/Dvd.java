package org.dvdrental.models.dvd;

import org.dvdrental.models.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dvd {
    private String title;
    private DVDGenre genre;
    private LocalDate releaseDate;
    private BigDecimal price;
    private boolean isRent;
    private User currentOwner;

    public Dvd() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(DVDGenre genre) {
        this.genre = genre;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setRent(boolean rent) {
        isRent = rent;
    }

    public boolean isRent() {
        return isRent;
    }

    public void setCurrentOwner(User currentOwner) {
        this.currentOwner = currentOwner;
    }

    @Override
    public String toString() {
        String owner = "";
        if (currentOwner != null) {
            owner = "current owner: " + currentOwner;
        }
        return "Dvd{ " +
                "title: '" + title +
                ", genre: " + genre +
                ", release date: " + releaseDate +
                ", price: " + price +
                owner +
                " }";
    }

    public List<String> asCSVRecord() {
        List<String> record = new ArrayList<>();
        record.add(title);
        record.add(genre.toString());
        record.add(releaseDate.toString());
        record.add(price.toString());
        record.add(String.valueOf(isRent));
        if (currentOwner != null)
            record.add(currentOwner.toString());
        return record;
    }

}
