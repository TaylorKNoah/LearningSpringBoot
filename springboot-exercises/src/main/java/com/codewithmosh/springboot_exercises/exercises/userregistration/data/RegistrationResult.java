package com.codewithmosh.springboot_exercises.exercises.userregistration.data;

public class RegistrationResult {
    public boolean success;
    public String errorMessage;

    public RegistrationResult(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }
}
