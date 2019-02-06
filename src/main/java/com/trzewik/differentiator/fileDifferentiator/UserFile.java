package com.trzewik.differentiator.fileDifferentiator;

import com.trzewik.differentiator.dispalyer.InvalidFileException;
import com.trzewik.differentiator.enums.FileType;

import java.io.File;
import java.io.IOException;

public class UserFile {

    private File file;
    private FileType extensionFileType = null;
    private FileType magicNumbersFileType = null;

    UserFile(String path) throws InvalidFileException, IOException {
        this.file = new FileObtainer(path).getFile();
        setExtensionFileType();
        setMagicNumbersFileType();
    }

    public FileType getExtensionFileType() {
        return this.extensionFileType;
    }

    public FileType getMagicNumbersFileType() {
        return this.magicNumbersFileType;
    }

    private void setExtensionFileType() throws InvalidFileException {
        this.extensionFileType = new ExtensionFileTypeSetter().fileTypeMatcherByExtension(this.file);
    }

    private void setMagicNumbersFileType() throws IOException {
        this.magicNumbersFileType = new MagicNumbersFileTypeSetter(file).fileTypeMatcherByMagicNumbers();
    }
}