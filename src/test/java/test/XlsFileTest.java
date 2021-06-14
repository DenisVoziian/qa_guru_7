package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.xlstest.XLS.containsText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.UtilsForFile.*;

public class XlsFileTest extends BaseTest {

    private String validText = "Hashimoto";
    private String xlsFilePath = "src/test/resources/1.xls";
    private String xlsxFilePath = "src/test/resources/1.xlx";

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }

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
}
