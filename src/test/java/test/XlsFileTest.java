package test;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.xlstest.XLS.containsText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.UtilsForFile.*;

public class XlsFileTest {

    private String validText = "Hashimoto";
    private String xlsFilePath = "src/test/resources/1.xls";
    private String xlsxFilePath = "src/test/resources/1.xlsx";

    @Test
    void xlsSampleTest() throws IOException {
        XLS xls = getXLS(xlsFilePath);
        assertThat(xls, containsText(validText));
    }

    @Test
    void xlsRowTest() throws IOException {
        String cell = getCellFromXLS(xlsFilePath, 0, 2, 2);
        assertThat(cell, containsString(validText));
    }

    @Test
    void xlsxTest() {
        String cell = getXlsxFromPath(xlsxFilePath);
        assertThat(cell, containsString(validText));
    }

    @Test
    void xlsxRowTest() {
        String cell = getCellXlsxFromPath(xlsxFilePath, 0, 2, 2);
        assertThat(cell, containsString(validText));
    }
}
