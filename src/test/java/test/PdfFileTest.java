package test;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;
import utils.UtilsForFile;

import java.io.IOException;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class PdfFileTest extends BaseTest{

    private String validText = "A Simple PDF File";
    private String pdfFilePath = "src/test/resources/1.pdf";

    @Test
    void pdfDownLoadReadmeTest() throws IOException {
        PDF pdf = UtilsForFile.getPDF(pdfFilePath);
        assertThat(pdf).containsExactText(validText);    }
}
