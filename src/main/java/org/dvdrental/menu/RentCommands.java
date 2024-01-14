package org.dvdrental.menu;

import org.dvdrental.models.OperationStatus;
import org.dvdrental.operations.RentOperations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RentCommands implements ChoiceScanner{
    private final RentOperations rentOperations;
    private final String ENTER_DVD_INDEX = "Enter DVD index";

    public RentCommands(RentOperations rentOperations) {
        this.rentOperations = rentOperations;
    }

    public void rentDvd() {
        try {
        String rentDVD = "--Rent DVD--";
        String enterUser = "Enter user index";
        System.out.println(rentDVD);
        System.out.println(enterUser);
        int userIndex = scanIntChoice();
        System.out.println(ENTER_DVD_INDEX);
        int dvdIndex =  scanIntChoice();
        OperationStatus operationStatus = rentOperations.rentDVD(dvdIndex, userIndex);
        System.out.println(operationStatus);
        } catch (InputMismatchException e) {
            System.out.println();
        }
    }

    public void returnDvd() {
        String returnDVD = "--Return DVD--";
        System.out.println(returnDVD);
        System.out.println(ENTER_DVD_INDEX);
        int dvdIndex =  scanIntChoice();
        OperationStatus operationStatus = rentOperations.returnDVD(dvdIndex);
        System.out.println(operationStatus);
    }
}
