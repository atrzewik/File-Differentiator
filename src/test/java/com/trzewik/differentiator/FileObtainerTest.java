package com.trzewik.differentiator;

import com.trzewik.differentiator.dispalyer.InvalidFileException;
import com.trzewik.differentiator.dispalyer.MessageProvider;
import com.trzewik.differentiator.fileDifferentiator.FileObtainer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class FileObtainerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldNotObtainFileBecauseFileNotExist() throws InvalidFileException {
        thrown.expect(InvalidFileException.class);
        thrown.expectMessage(MessageProvider.wrongFile);
        new FileObtainer("./src/main/resources/thisFileNoExist.txt");
    }

    @Test
    public void shouldObtainFileBecauseFileExist() throws InvalidFileException {
        File file = new FileObtainer("./src/main/resources/thisIsGifFile.gif").getFile();
        assertEquals(file, new File("./src/main/resources/thisIsGifFile.gif"));
    }

}