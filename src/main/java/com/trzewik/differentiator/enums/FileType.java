package com.trzewik.differentiator.enums;

public enum FileType {
    JPG(6, new String[]{"jpg", "jpeg"}),
    GIF(12, new String[]{"gif"}),
    TXT(0, new String[]{"txt"});

    private final int numberOfCharsToRead;
    private final String[] stringRepresentationsOfExtension;

    FileType(int numberOfCharsToRead, String[] stringRepresentationsOfExtension) {
        this.numberOfCharsToRead = numberOfCharsToRead;
        this.stringRepresentationsOfExtension = stringRepresentationsOfExtension;
    }

    public int getNumberOfCharsToRead() {
        return this.numberOfCharsToRead;
    }

    public String[] getStringRepresentationsOfExtension() {
        return this.stringRepresentationsOfExtension;
    }
}
