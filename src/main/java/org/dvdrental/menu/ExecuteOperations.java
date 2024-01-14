package org.dvdrental.menu;

import org.dvdrental.utils.Setup;

public class ExecuteOperations {

    private final Setup setup;

    public ExecuteOperations(Setup setup) {
        this.setup = setup;
    }

    public void executeOperations(int choice) {
        switch (choice) {
            case 1:
                setup.userCommands.printUsers();
                setup.userCommands.addUser();
                break;
            case 2:
                setup.dvdCommands.printAvailableDvds();
                break;
            case 3:
                setup.dvdCommands.printAllDvds();
                break;
            case 4:
                setup.dvdCommands.printAvailableDvds();
                setup.userCommands.printUsers();
                setup.rentCommands.rentDvd();
                break;
            case 5:
                setup.dvdCommands.printRentedDvds();
                setup.rentCommands.returnDvd();
                break;
            case 6:
                String exitProgram = "Exiting the program. Goodbye!";
                System.out.println(exitProgram);
                setup.userOperations.saveCachedData(setup.userCache);
                setup.dvdOperations.saveCachedData(setup.dvdCache);
                System.exit(0);
                break;
            default:
                String invalidChoice = "Invalid choice. Please try again.";
                System.out.println(invalidChoice);
                break;
        }
    }
}
