package test;

import org.junit.jupiter.api.Test;
import utils.UtilsForFile;

import java.io.IOException;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static utils.Zip.unzip;

public class ZipFileTest {

    private String validText = "qa.guru";
    private String zipFilePath = "src/test/resources/1.zip";
    private String unzipPath = "src/test/resources/unzip";
    private String txtFilePath = "src/test/resources/unzip/1.txt";
    private char[] password = {'a', 'b', 'c', 'd'};

    @Test
    void zipTest() throws IOException {
        unzip(zipFilePath, unzipPath);

        String actualText = UtilsForFile.readFileToStringFromPath(txtFilePath);
        assertThat(actualText).contains(validText);
    }

    @Test
    void zipWithPassTest() throws IOException {
        unzip(zipFilePath, unzipPath, password);

        String actualText = UtilsForFile.readFileToStringFromPath(txtFilePath);
        assertThat(actualText).contains(validText);
    }
}
