package org.dvdrental.utils;

import java.time.format.DateTimeFormatter;

public class Utils {
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String COMMA = ",";
    public static final String SLASH = "/";
    public static final String SEMICOLON = ";";
    public final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Utils.DATE_PATTERN);

}
