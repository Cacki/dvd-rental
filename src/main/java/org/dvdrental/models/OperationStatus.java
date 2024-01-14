package org.dvdrental.models;

public enum OperationStatus {
    SUCCESS("Operation success!"),
    INVALID_DATA("Invalid data!"),
    USER_EXIST("User already exist!"),
    FAILURE("Operation failure!");

    private final String displayName;

    OperationStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
