package ru.netology.HW2_Authorization_Service.exceptions;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}
