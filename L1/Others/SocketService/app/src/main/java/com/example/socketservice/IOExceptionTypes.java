package com.example.socketservice;

public enum IOExceptionTypes {
    NO_EXCEPTION("One error has been added to the logs"),
    CANNOT_CREATE_FILE("Cannot create the logs file"),
    FILE_IS_NULL_OR_NOT_A_FILE("It is not a file or it refer to a null object"),
    DIRECTORY_ERROR("Cannot find the directory"),
    FILE_IS_NOT_WRITABLE("Cannot write into this file"),
    CAUGHT_EXCEPTION("An IOException occurred while creating the file");

    private final String message;

    IOExceptionTypes(String message) {
        this.message = message;
    }

    public String displayMessage() {
        return message;
    }
}
