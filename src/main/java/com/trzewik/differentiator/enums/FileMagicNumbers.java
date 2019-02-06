package com.trzewik.differentiator.enums;

public enum FileMagicNumbers {
    JPG("ffd8ff", FileType.JPG),
    GIF87("474946383761", FileType.GIF),
    GIF89("474946383961", FileType.GIF);

    private final String magicNumbers;
    private final FileType fileType;

    FileMagicNumbers(String magicNumbers, FileType fileType) {
        this.magicNumbers = magicNumbers;
        this.fileType = fileType;
    }

    public String getMagicNumbers() {
        return this.magicNumbers;
    }

    public FileType getFileType() {
        return this.fileType;
    }
}