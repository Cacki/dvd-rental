package org.dvdrental.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface implements ChoiceScanner {
    private final String DVD_RENTAL = "DVD rental app";
    private final String ADD_USER = "1- Add new user";
    private final String LIST_AVAILABLE = "2- List available (not rented) DVDs";
    private final String LIST_ALL = "3- List all DVDs";
    private final String RENT_DVD = "4- Rent DVD";
    private final String RETURN_DVD = "5- Return DVD";
    private final String CLOSE = "6- Exit";

    public void printOptions() {
        System.out.println(DVD_RENTAL);
        System.out.println();
        System.out.println(ADD_USER);
        System.out.println(LIST_AVAILABLE);
        System.out.println(LIST_ALL);
        System.out.println(RENT_DVD);
        System.out.println(RETURN_DVD);
        System.out.println(CLOSE);
    }







}
