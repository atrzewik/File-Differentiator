package com.trzewik.differentiator;

import com.trzewik.differentiator.dispalyer.InvalidFileException;
import com.trzewik.differentiator.dispalyer.MessageProvider;
import com.trzewik.differentiator.dispalyer.UserInputProvider;
import com.trzewik.differentiator.fileDifferentiator.FileDifferentiator;

import java.io.IOException;

public class MainFileDifferentiator {

    public static void main(String[] args) throws InvalidFileException, IOException {
        new FileDifferentiator(UserInputProvider.collectString(MessageProvider.askForPathToFile));
    }
}