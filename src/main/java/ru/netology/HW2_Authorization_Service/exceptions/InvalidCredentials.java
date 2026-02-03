package ru.netology.HW2_Authorization_Service.exceptions;

public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        super(msg);
    }
}
