package model.reader;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelApachePoi implements ExcelRepository {

    private Workbook workbook;

    //FileNotFoundException!
    public void connectToExcelTable(File file) throws IOException {
        String extension = FilenameUtils.getExtension(file.getAbsolutePath());

        if (extension.equals("xls")) {

            workbook = new HSSFWorkbook(new FileInputStream(file));

        } else if (extension.equals("xlsx")) {

            workbook = new XSSFWorkbook(new FileInputStream(file));

        }
    }

    @Override
    public Map<String, Sheet> getSheetsWithNameKeys() {
        Map<String, Sheet> sheetsAndNames = new HashMap<>();
        for (Sheet sheet : workbook) {
            sheetsAndNames.put(sheet.getSheetName(), sheet);
        }
        return sheetsAndNames;
    }

    @Override
    public Map<String, Integer> getColumnsNamesWithIds(Sheet sheet) {
        Map<String, Integer> columnsAndNames = new HashMap<>();
        Row zeroRow = sheet.getRow(0);
        for (Cell cell : zeroRow) {
            columnsAndNames.put(cell.getStringCellValue(), cell.getColumnIndex());
        }
        return columnsAndNames;
    }

    @Override
    public List<String> getAllStringValuesFromColumnById(Sheet sheet, int columnIndex) {
        List<String> values = new LinkedList<>();
        for (Row row : sheet) {
            Cell resultCell = row.getCell(columnIndex);
            values.add(resultCell.getStringCellValue());
        }
        return values;
    }
}
