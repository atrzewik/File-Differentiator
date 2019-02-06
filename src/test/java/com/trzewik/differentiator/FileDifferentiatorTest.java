package com.trzewik.differentiator;

import com.trzewik.differentiator.fileDifferentiator.FileDifferentiator;
import com.trzewik.differentiator.dispalyer.InvalidFileException;
import com.trzewik.differentiator.dispalyer.MessageProvider;
import com.trzewik.differentiator.enums.FileType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class FileDifferentiatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldNotSetExtensionBecauseFileNotExist() throws InvalidFileException, IOException {
        thrown.expect(InvalidFileException.class);
        thrown.expectMessage(MessageProvider.wrongFile);
        new FileDifferentiator("./src/main/resources/thisFileNoExist.txt");
    }

    @Test
    public void shouldNotSetExtensionBecauseNoPoint() throws InvalidFileException, IOException {
        thrown.expect(InvalidFileException.class);
        thrown.expectMessage(MessageProvider.wrongName);
        new FileDifferentiator("./src/main/resources/fileWithNoExtension");
    }

    @Test
    public void shouldNotSetExtensionBecauseItIsUnknown() throws InvalidFileException, IOException {
        thrown.expect(InvalidFileException.class);
        thrown.expectMessage(MessageProvider.wrongExtension);
        new FileDifferentiator("./src/main/resources/thisIsTextFileWithPdfExt.pdf");
    }

    @Test
    public void shouldSayThatJpgIsCorrect() throws InvalidFileException, IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        new FileDifferentiator("./src/main/resources/thisJpgFIle.jpg");
        String expectedOutput = String.format(MessageProvider.fileExtensionIsCorrect, FileType.JPG) + "\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void shouldSayThatNotJpgFileButTextFile() throws InvalidFileException, IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        new FileDifferentiator("./src/main/resources/thisIsTextFileWithJpgExt.jpg");
        String expectedOutput = String.format(MessageProvider.fileExtensionAndMagicNumberNotSame, FileType.JPG, FileType.TXT) + "\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void shouldSayThatJpgIsNotCorrect() throws InvalidFileException, IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        new FileDifferentiator("./src/main/resources/thisIsUnknownTypeFileWithJpgExt.jpg");
        String expectedOutput = String.format(MessageProvider.fileExtensionIsWrong, FileType.JPG) + "\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

}