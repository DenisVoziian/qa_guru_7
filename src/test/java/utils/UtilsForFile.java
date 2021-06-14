package utils;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UtilsForFile {

    public static String readFileToString(File file) throws IOException {
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }

    public static String readFileToStringFromPath(String path) throws IOException {
        return readFileToString(getFile(path));
    }

    public static File getFile(String path) {
        return new File(path);
    }

    public static PDF getPDF(String path) throws IOException {
        return new PDF(getFile(path));
    }

    public static XLS getXLS(String path) throws IOException {
        return new XLS(getFile(path));
    }

    public static String getCellFromXLS(String path,int sheetIndex, int rowIndex, int cellIndex) throws IOException {
        return getXLS(path).excel.getSheetAt(sheetIndex).getRow(rowIndex).getCell(cellIndex).toString();
    }
}
