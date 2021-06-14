package test;

import org.junit.jupiter.api.Test;
import utils.UtilsForFile;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;


public class DownloadFileTest extends BaseTest{

    private String validText = "# Selenide = UI Testing Framework powered by Selenium WebDriver";

    @Test
    void selenideDownLoadReadmeTest() throws IOException {
        open("https://github.com/selenide/selenide/blob/master/README.md");
        File downloadedFile = $("#raw-url").download();

        String fileContent = UtilsForFile.readFileToString(downloadedFile);
        assertThat(fileContent).contains(validText);
    }
}
