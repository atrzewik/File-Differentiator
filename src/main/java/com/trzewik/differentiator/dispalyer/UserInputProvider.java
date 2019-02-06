package com.trzewik.differentiator.dispalyer;

import java.util.Scanner;

public class UserInputProvider {

    public static String collectString(String message, String... formats) {
        while (true) {
            try {
                Scanner userInput = getMessage(message, formats);
                return userInput.nextLine();
            } catch (Exception e) {
                MessagePrinter.printErrorMessage("Input must be a string! Try again: ");
            }
        }
    }

    private static Scanner getMessage(String message, String... formats) {
        Scanner userInput = new Scanner(System.in);
        MessagePrinter.printMessage(message, formats);
        return userInput;
    }
}
