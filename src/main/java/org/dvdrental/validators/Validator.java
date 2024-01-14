package org.dvdrental.validators;

import org.dvdrental.models.user.UserDTO;
import org.dvdrental.utils.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private final static String nameRegex = "^[a-zA-Z]{1,15}$";

    public static boolean validateData(UserDTO userData) {
        return (isValidName(userData.getFirstName())
                && isValidName(userData.getLastName())
                && isDateValid(userData.getBirthDate())
        );
    }

    public static boolean isValidName(String name) {
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }

    public static boolean isDateValid(String birthDate) {
        try {
            LocalDate date = LocalDate.parse(birthDate, Utils.formatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

}
