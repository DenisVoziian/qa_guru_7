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

    @Test
    void zipTest() throws IOException {
        unzip(zipFilePath, unzipPath);

        String actualText = UtilsForFile.readFileToStringFromPath(txtFilePath);
        assertThat(actualText).contains(validText);
    }
}
