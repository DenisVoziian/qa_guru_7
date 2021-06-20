package test;

import org.junit.jupiter.api.Test;
import utils.UtilsForFile;

import static org.assertj.core.api.Assertions.assertThat;

public class DocAndDocxFileTest {
    private String validText = "Vestibulum neque massa";
    private String docFilePath = "src/test/resources/1.doc";
    private String docxFilePath = "src/test/resources/1.docx";

    @Test
    void docTest() {
        String actualText = UtilsForFile.getDocFromPath(docFilePath);
        assertThat(actualText).contains(validText);
    }

    @Test
    void docxTest() {
        String actualText = UtilsForFile.getDocxFromPath(docxFilePath);
        assertThat(actualText).contains(validText);
    }
}
