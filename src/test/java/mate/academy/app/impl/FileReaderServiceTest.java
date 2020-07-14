package mate.academy.app.impl;

import java.io.File;
import java.util.List;
import mate.academy.app.service.FileReaderService;
import mate.academy.app.service.impl.FileReaderServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileReaderServiceTest {
    private final FileReaderService readerService = new FileReaderServiceImpl();

    @Test
    void checkCorrectContent() {
        String path = "src/test/resources/testFile.txt";
        assertTrue(new File(path).exists());
        List<String> expected = List.of("Text to test reading from file");
        List<String> actual = readerService.readFromFile(path);
        assertEquals(expected, actual);
    }
    
    @Test
    void checkIoException() {
        String path = null;
        assertThrows(RuntimeException.class, () -> readerService.readFromFile(path));
    }
}
