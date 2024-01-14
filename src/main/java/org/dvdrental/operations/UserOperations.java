package org.dvdrental.operations;

import org.dvdrental.models.OperationStatus;
import org.dvdrental.models.cache.UserCache;
import org.dvdrental.models.user.User;
import org.dvdrental.models.user.UserDTO;
import org.dvdrental.operations.Operations;
import org.dvdrental.utils.Utils;
import org.dvdrental.validators.Validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserOperations extends Operations {

    private List<User> cachedConvertedUsers;

    public UserOperations(UserCache cachedUsers) {
        this.cachedConvertedUsers = cachedUsers.getCachedConvertedUsers();
    }

    public OperationStatus addUser(UserDTO userData) {
        boolean validationStatus = Validator.validateData(userData);
        if (!validationStatus) {
            return OperationStatus.INVALID_DATA;
        }
        User user = createUser(userData);
        boolean isUserExist = doesUserExist(user);

        if (isUserExist) {
            return OperationStatus.USER_EXIST;
        } else {
            cachedConvertedUsers.add(user);
            return OperationStatus.SUCCESS;
        }
    }

    public List<User> getUsers() {
        return sortUsers(cachedConvertedUsers);
    }

    private List<User> sortUsers(List<User> users) {
        users.sort(Comparator.comparing(User::getFirstName));
        return users;
    }

    private boolean doesUserExist(User user) {
        for (User cachedUser : cachedConvertedUsers) {
            if (user.equals(cachedUser)) {
                return true;
            }
        }
        return false;
    }

    public static User createUser(UserDTO userData) {
        return new User(userData.getFirstName(),
                userData.getLastName(),
                LocalDate.parse(userData.getBirthDate(), Utils.formatter)
        );
    }

    public void saveCachedData(UserCache cachedUsers) {
        List<List<String>> csvUsers = new ArrayList<>();

        for (User user : cachedConvertedUsers) {
            List<String> csvRecord = user.asCSVRecord();
            csvUsers.add(csvRecord);
        }
        cachedUsers.updateCachedData(csvUsers);
        cachedUsers.updateFile();
    }
}
