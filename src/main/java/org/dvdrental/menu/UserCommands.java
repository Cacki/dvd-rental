package org.dvdrental.menu;

import org.dvdrental.models.OperationStatus;
import org.dvdrental.models.user.User;
import org.dvdrental.models.user.UserDTO;
import org.dvdrental.operations.UserOperations;

import java.util.List;
import java.util.Scanner;

public class UserCommands {
    private final Scanner scanner = new Scanner(System.in);
    private final UserOperations operations;

    public UserCommands(UserOperations operations) {
        this.operations = operations;
    }

    public void addUser() {
        UserDTO userData = new UserDTO();
        String adUser = "--Add user--";
        String enterFirstName = "Enter first name";
        String enterLastName = "Enter last name";
        String enterBirthDate = "Enter birth date (YYYY-MM-DD)";
        System.out.println(adUser);
        System.out.println(enterFirstName);
        userData.setFirstName(scanner.nextLine());
        System.out.println(enterLastName);
        userData.setLastName(scanner.nextLine());
        System.out.println(enterBirthDate);
        userData.setBirthDate(scanner.nextLine());
        OperationStatus operationStatus = operations.addUser(userData);
        System.out.println(operationStatus.getDisplayName());
    }

    public void printUsers() {
        List<User> users = operations.getUsers();
        int index = 1;
        String allUsers = "--All users--";
        System.out.println(allUsers);
        for (User user : users) {
            System.out.println(index++ + ": " + user.toString());
        }
        System.out.println();
    }

}
