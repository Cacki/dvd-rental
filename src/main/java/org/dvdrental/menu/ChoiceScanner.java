package org.dvdrental.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface ChoiceScanner {
    Scanner sc = new Scanner(System.in);
      String ENTER_CHOICE = "Choice: ";
      String INVALID_INPUT = "Invalid input, try again. ";

     default int scanIntChoice() {
        System.out.print(ENTER_CHOICE);
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.print(INVALID_INPUT);
            sc.nextLine();
        }
        return 0;
    }
}
