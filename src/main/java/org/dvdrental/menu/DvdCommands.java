package org.dvdrental.menu;

import org.dvdrental.models.dvd.Dvd;
import org.dvdrental.operations.DvdOperations;

import java.util.List;

public class DvdCommands {
    private final DvdOperations operations;

    public DvdCommands(DvdOperations operations) {
        this.operations = operations;
    }

    public void printAllDvds() {
        List<Dvd> dvds = operations.getAllDvds();
        String allDvds = "---All dvds---";
        System.out.println(allDvds);
        printDvds(dvds);
    }

    public void printAvailableDvds() {
        List<Dvd> dvds = operations.getAvailableDvds();
        if (!dvds.isEmpty()) {
            String availableDVDs = "---Available dvds---";
            System.out.println(availableDVDs);
            printDvds(dvds);
        } else {
            String noAvailableDVDs = "No available dvds";
            System.out.println(noAvailableDVDs);
        }

    }

    public void printRentedDvds() {
        List<Dvd> dvds = operations.getRentedDvds();
        String rentedDvds = "---Rented dvds---";
        System.out.println(rentedDvds);
        printDvds(dvds);
    }

    private void printDvds(List<Dvd> dvds) {
        int index = 1;
        for (Dvd dvd : dvds) {
            System.out.println(index++ + ": " + dvd.toString());
        }
    }

}
