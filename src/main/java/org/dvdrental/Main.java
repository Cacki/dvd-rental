package org.dvdrental;

import org.dvdrental.menu.ExecuteOperations;
import org.dvdrental.menu.UserInterface;
import org.dvdrental.utils.Setup;

public class Main {


    public static void main(String[] args) {
        Setup setup = new Setup();
        setup.setup();
        UserInterface ui = new UserInterface();
        ExecuteOperations ex = new ExecuteOperations(setup);
        while (true) {
            ui.printOptions();
            int choice = ui.scanIntChoice();
            ex.executeOperations(choice);
        }
    }
}