package com.trzewik.differentiator.fileDifferentiator;

import com.trzewik.differentiator.dispalyer.InvalidFileException;
import com.trzewik.differentiator.dispalyer.MessagePrinter;
import com.trzewik.differentiator.dispalyer.MessageProvider;

import java.io.IOException;

public class FileDifferentiator {

    public FileDifferentiator(String path) throws InvalidFileException, IOException {
        UserFile userFile = new UserFile(path);
        if (userFile.getExtensionFileType() == userFile.getMagicNumbersFileType()) {
            MessagePrinter.printMessage(MessageProvider.fileExtensionIsCorrect, userFile.getMagicNumbersFileType().toString());
        } else if (userFile.getMagicNumbersFileType() != null) {
            MessagePrinter.printMessage(MessageProvider.fileExtensionAndMagicNumberNotSame, userFile.getExtensionFileType().toString(), userFile.getMagicNumbersFileType().toString());
        } else {
            MessagePrinter.printMessage(MessageProvider.fileExtensionIsWrong, userFile.getExtensionFileType().toString());
        }
    }
}