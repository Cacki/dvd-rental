package org.dvdrental.operations;

import org.dvdrental.models.OperationStatus;
import org.dvdrental.models.dvd.Dvd;
import org.dvdrental.models.user.User;

import java.util.List;

public class RentOperations {
    private final DvdOperations dvdOperations;
    private final UserOperations userOperations;

    public RentOperations(DvdOperations dvdOperations, UserOperations userOperations) {
        this.dvdOperations = dvdOperations;
        this.userOperations = userOperations;
    }

    public OperationStatus rentDVD(int dvdIndex, int userIndex) {
        try {
            Dvd dvd = dvdOperations.getAvailableDvds().get(dvdIndex - 1);
            User user = userOperations.getUsers().get(userIndex - 1);
            changeRentStatus(dvd, user);
            return OperationStatus.SUCCESS;
        } catch (IndexOutOfBoundsException e) {
            return OperationStatus.FAILURE;
        }
    }

    public OperationStatus returnDVD(int dvdIndex) {
        try {
            Dvd dvd = dvdOperations.getRentedDvds().get(dvdIndex - 1);
            changeRentStatus(dvd, null);
            return OperationStatus.SUCCESS;
        } catch (IndexOutOfBoundsException e) {
            return OperationStatus.FAILURE;
        }
    }

    public void changeRentStatus(Dvd dvd, User user) {
        List<Dvd> cachedConvertedDvds = dvdOperations.getCachedConvertedDvds();
        for (Dvd dvdToChange : cachedConvertedDvds) {
            if (dvdToChange.equals(dvd)) {
                if (user != null) {
                    dvdToChange.setRent(true);
                    dvdToChange.setCurrentOwner(user);
                } else {
                    dvdToChange.setRent(false);
                    dvdToChange.setCurrentOwner(null);
                }
                break;
            }
        }
        dvdOperations.setCachedConvertedDvds(cachedConvertedDvds);
    }

}
