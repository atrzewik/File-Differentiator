package com.trzewik.differentiator;

import com.trzewik.differentiator.enums.FileType;
import com.trzewik.differentiator.fileDifferentiator.MagicNumbersFileTypeSetter;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class MagicNumbersFileTypeSetterTest {

    @Test
    public void isGifFile()throws IOException {
        File file = new File("./src/main/resources/thisIsGifFile.gif");
        FileType fileType = new MagicNumbersFileTypeSetter(file).fileTypeMatcherByMagicNumbers();
        assertEquals(fileType, FileType.GIF);
    }

    @Test
    public void isJpgFile()throws IOException {
        File file = new File("./src/main/resources/thisJpgFIle.jpg");
        FileType fileType = new MagicNumbersFileTypeSetter(file).fileTypeMatcherByMagicNumbers();
        assertEquals(fileType, FileType.JPG);
    }

    @Test
    public void isTxtFile()throws IOException {
        File file = new File("./src/main/resources/thisIsTextFileWithJpgExt.jpg");
        FileType fileType = new MagicNumbersFileTypeSetter(file).fileTypeMatcherByMagicNumbers();
        assertEquals(fileType, FileType.TXT);
    }

    @Test
    public void isUnknownFile()throws IOException{
        File file = new File("./src/main/resources/thisIsUnknownTypeFileWithJpgExt.jpg");
        FileType fileType = new MagicNumbersFileTypeSetter(file).fileTypeMatcherByMagicNumbers();
        assertNull(fileType);
    }
}