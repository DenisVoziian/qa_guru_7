package test;

import org.junit.jupiter.api.Test;
import utils.UtilsForFile;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class TxtFileTest {
    private String validText = "qa.guru";
    private String txtFilePath = "src/test/resources/1.txt";

    @Test
    void txtTest() throws IOException {
        String actualText = UtilsForFile.readFileToStringFromPath(txtFilePath);
        assertThat(actualText).contains(validText);
    }
}
