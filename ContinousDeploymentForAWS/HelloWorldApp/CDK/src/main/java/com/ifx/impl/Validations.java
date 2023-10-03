package com.ifx.impl;

public class Validations {
    
    private Validations() {}

    public static void requireNonEmpty(String string, String message) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}
