package com.trzewik.differentiator.fileDifferentiator;

import com.trzewik.differentiator.dispalyer.InvalidFileException;
import com.trzewik.differentiator.dispalyer.MessageProvider;

import java.io.File;

public class FileObtainer {

    private String path;
    private File file;

    public FileObtainer(String path) throws InvalidFileException {
        this.path = path;
        setFile();
    }

    public File getFile() {
        return this.file;
    }

    private void setFile() throws InvalidFileException {
        this.file = new File(this.path);
        if (!this.file.exists()) {
            throw new InvalidFileException(MessageProvider.wrongFile);
        }
    }
}