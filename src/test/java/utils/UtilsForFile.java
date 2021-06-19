package utils;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

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

    public static String getXlsxFromPath(String path){
        String result = "";
        XSSFWorkbook myExcelBook = null;

        try {
            myExcelBook = new XSSFWorkbook(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
        Iterator<Row> rows = myExcelSheet.iterator();

        while (rows.hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                CellType cellType = cell.getCellType();
                //перебираем возможные типы ячеек
                switch (cellType) {
//                    case Cell.CELL_TYPE_STRING:
//                        result += cell.getStringCellValue() + "=";
//                        break;
//                    case Cell.CELL_TYPE_NUMERIC:
//                        result += "[" + cell.getNumericCellValue() + "]";
//                        break;
//
//                    case Cell.CELL_TYPE_FORMULA:
//                        result += "[" + cell.getNumericCellValue() + "]";
//                        break;
                    default:
                        result += cell.toString();
                        break;
                }
            }
        }

        try {
            myExcelBook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String getCellXlsxFromPath(String path, int sheetIndex, int rowIndex, int cellIndex){
        String result = "";
        XSSFWorkbook myExcelBook = null;

        try {
            myExcelBook = new XSSFWorkbook(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFSheet myExcelSheet = myExcelBook.getSheetAt(sheetIndex);
        result = myExcelSheet.getRow(rowIndex).getCell(cellIndex).toString();

        try {
            myExcelBook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
