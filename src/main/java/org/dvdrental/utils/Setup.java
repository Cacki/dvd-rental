package org.dvdrental.utils;

import org.dvdrental.menu.DvdCommands;
import org.dvdrental.menu.RentCommands;
import org.dvdrental.menu.UserCommands;
import org.dvdrental.models.cache.DvdCache;
import org.dvdrental.models.cache.UserCache;
import org.dvdrental.operations.DvdOperations;
import org.dvdrental.operations.RentOperations;
import org.dvdrental.operations.UserOperations;

public class Setup {
    public UserCache userCache;
    public DvdCache dvdCache;
    public UserOperations userOperations;
    public DvdOperations dvdOperations;
    public UserCommands userCommands;
    public DvdCommands dvdCommands;
    public RentOperations rentOperations;
    public RentCommands rentCommands;
    private final String USERS_CSV = "users.csv";
    private final String DVDS_CSV = "dvds.csv";

    public Setup() {
    }

    public void setup() {
        userCache = new UserCache(USERS_CSV);
        userOperations = new UserOperations(userCache);
        userCommands = new UserCommands(userOperations);
        dvdCache = new DvdCache(DVDS_CSV);
        dvdOperations = new DvdOperations(dvdCache);
        dvdCommands = new DvdCommands(dvdOperations);
        rentOperations = new RentOperations(dvdOperations, userOperations);
        rentCommands = new RentCommands(rentOperations);
    }
}
