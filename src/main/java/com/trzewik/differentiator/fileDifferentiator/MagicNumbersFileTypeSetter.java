package com.trzewik.differentiator.fileDifferentiator;

import com.trzewik.differentiator.enums.FileType;
import com.trzewik.differentiator.enums.FileMagicNumbers;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class MagicNumbersFileTypeSetter {

    private String allFileMagicNumbers;
    private File file;

    public MagicNumbersFileTypeSetter(File file) throws IOException {
        this.file = file;
        setAllFileMagicNumbers();
    }

    public FileType fileTypeMatcherByMagicNumbers() {
        FileType fileType = null;
        for (FileMagicNumbers fileMagicNumbers : FileMagicNumbers.values()) {
            int numberOfCharsToRead = fileMagicNumbers.getFileType().getNumberOfCharsToRead();
            if (fileMagicNumbers.getMagicNumbers().equals(this.allFileMagicNumbers.substring(0, numberOfCharsToRead))) {
                fileType = fileMagicNumbers.getFileType();
            }
        }
        if (fileType == null && isTextFileType()) {
            fileType = FileType.TXT;
        }
        return fileType;
    }

    private boolean isTextFileType() {
        try {
            Charset.availableCharsets().get("UTF-8").newDecoder().decode(ByteBuffer.wrap(getBinaryRepresentationOfFile()));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private void setAllFileMagicNumbers() throws IOException {
        this.allFileMagicNumbers = String.format("%x", new BigInteger(1, getBinaryRepresentationOfFile()));
    }

    private byte[] getBinaryRepresentationOfFile() throws IOException {
        return Files.readAllBytes(this.file.toPath());
    }

}
