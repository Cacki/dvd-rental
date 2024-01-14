package org.dvdrental.converters;

import org.dvdrental.models.dvd.DVDGenre;
import org.dvdrental.models.dvd.Dvd;
import org.dvdrental.models.user.User;
import org.dvdrental.models.user.UserDTO;
import org.dvdrental.operations.UserOperations;
import org.dvdrental.utils.Utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {
    private static final int TITLE_INDEX = 0;
    private static final int GENRE_INDEX = 1;
    private static final int RELEASE_DATE_INDEX = 2;
    private static final int PRICE_INDEX = 3;
    private static final int RENT_INDEX = 4;
    private static final int OWNER_INDEX = 5;
    private static final int FIRST_NAME_INDEX = 0;
    private static final int LAST_NAME_INDEX = 1;
    private static final int BIRTH_DATE_INDEX = 2;
    private static final String TRUE_STRING = "true";
    private static final String TRUE_INT = "1";

    public static String convertToCSV(List<String> data) {
        return String.join(Utils.COMMA, data);
    }

    public static List<String> convertToListElement(String line) {
        String delimiter = detectDelimiter(line);
        String[] values = line.split(delimiter);
        return Arrays.asList(values);
    }

    private static String detectDelimiter(String line) {
        if (line.contains(Utils.COMMA)) {
            return Utils.COMMA;
        } else if (line.contains(Utils.SEMICOLON)) {
            return Utils.SEMICOLON;
        }
        return "";
    }

    public static Dvd convertFromCSVToDVD(List<String> dvdFromFile) {
        Dvd dvd = new Dvd();
        dvd.setTitle(dvdFromFile.get(TITLE_INDEX));
        dvd.setGenre(DVDGenre.valueOf(dvdFromFile.get(GENRE_INDEX)));
        dvd.setReleaseDate(LocalDate.parse(dvdFromFile.get(RELEASE_DATE_INDEX), Utils.formatter));
        dvd.setPrice(new BigDecimal(dvdFromFile.get(PRICE_INDEX)));
        dvd.setRent(convertRentStatus(dvdFromFile.get(RENT_INDEX).toLowerCase()));
        if (dvd.isRent()) {
            String ownerToConvert = dvdFromFile.get(OWNER_INDEX);
            dvd.setCurrentOwner(convertDvdOwner(ownerToConvert));
        }
        return dvd;
    }

    public static List<Dvd> convertDvds(List<List<String>> dvdsFromFile) {
        List<Dvd> dvds = new ArrayList<>();
        for (List<String> dvdFromFile : dvdsFromFile) {
            dvds.add(convertFromCSVToDVD(dvdFromFile));
        }
        return dvds;
    }

    public static boolean convertRentStatus(String isRent) {
        return isRent.equals(TRUE_STRING) || isRent.equals(TRUE_INT);
    }

    public static User convertUserFromCSV(List<String> csvUser) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(csvUser.get(FIRST_NAME_INDEX));
        userDTO.setLastName(csvUser.get(LAST_NAME_INDEX));
        userDTO.setBirthDate(csvUser.get(BIRTH_DATE_INDEX));
        return UserOperations.createUser(userDTO);
    }

    public static List<User> convertUsers(List<List<String>> usersFromCSV) {
        List<User> users = new ArrayList<>();
        for (List<String> csvUser : usersFromCSV) {
            users.add(convertUserFromCSV(csvUser));
        }
        return users;
    }

    public static User convertDvdOwner(String owner) {
        if (!owner.isEmpty()) {
            String[] split = owner.split(Utils.SLASH);
            List<String> list = Arrays.stream(split).toList();
            return convertUserFromCSV(list);
        }
        return null;
    }

}
