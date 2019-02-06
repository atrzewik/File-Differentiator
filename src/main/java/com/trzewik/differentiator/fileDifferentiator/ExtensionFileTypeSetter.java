package com.trzewik.differentiator.fileDifferentiator;

import com.trzewik.differentiator.enums.FileType;
import com.trzewik.differentiator.dispalyer.InvalidFileException;
import com.trzewik.differentiator.dispalyer.MessageProvider;

import java.io.File;
import java.util.Arrays;

public class ExtensionFileTypeSetter {

    public FileType fileTypeMatcherByExtension(File file) throws InvalidFileException {
        String extension = getExtension(file);
        for (FileType fileType : FileType.values()) {
            if (Arrays.asList(fileType.getStringRepresentationsOfExtension()).contains(extension)) {
                return fileType;
            }
        }
        throw new InvalidFileException(MessageProvider.wrongExtension);
    }

    private String getExtension(File file) throws InvalidFileException {
        String fileName = file.getName();
        if (fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf('.') + 1);
        } else {
            throw new InvalidFileException(MessageProvider.wrongName);
        }
    }
}
