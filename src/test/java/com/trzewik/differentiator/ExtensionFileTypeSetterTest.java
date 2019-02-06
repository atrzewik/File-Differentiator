package com.trzewik.differentiator;

import com.trzewik.differentiator.dispalyer.InvalidFileException;
import com.trzewik.differentiator.dispalyer.MessageProvider;
import com.trzewik.differentiator.enums.FileType;
import com.trzewik.differentiator.fileDifferentiator.ExtensionFileTypeSetter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ExtensionFileTypeSetterTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldNotSetExtensionBecauseNoPoint()throws InvalidFileException {
        thrown.expect(InvalidFileException.class);
        thrown.expectMessage(MessageProvider.wrongName);
        File file = new File("./src/main/resources/fileWithNoExtension");
        new ExtensionFileTypeSetter().fileTypeMatcherByExtension(file);
    }

    @Test
    public void shouldNotSetExtensionBecauseItIsUnknown()throws InvalidFileException {
        thrown.expect(InvalidFileException.class);
        thrown.expectMessage(MessageProvider.wrongExtension);
        File file = new File("./src/main/resources/thisIsTextFileWithPdfExt.pdf");
        new ExtensionFileTypeSetter().fileTypeMatcherByExtension(file);
    }

    @Test
    public void isTxtExtension()throws InvalidFileException{
        File file = new File("./src/main/resources/thisIsTextFile.txt");
        FileType fileType = new ExtensionFileTypeSetter().fileTypeMatcherByExtension(file);
        assertEquals(fileType, FileType.TXT);
    }

    @Test
    public void isJpgExtension()throws InvalidFileException{
        File file = new File("./src/main/resources/thisIsTextFileWithJpgExt.jpg");
        FileType fileType = new ExtensionFileTypeSetter().fileTypeMatcherByExtension(file);
        assertEquals(fileType, FileType.JPG);
    }

    @Test
    public void isGifExtension()throws InvalidFileException{
        File file = new File("./src/main/resources/thisIsGifFile.gif");
        FileType fileType = new ExtensionFileTypeSetter().fileTypeMatcherByExtension(file);
        assertEquals(fileType, FileType.GIF);
    }
}