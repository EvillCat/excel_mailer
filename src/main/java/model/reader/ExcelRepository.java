package model.reader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ExcelRepository {

    void connectToExcelTable(File file) throws IOException;

    Map<String, Sheet> getSheetsWithNameKeys();

    Map<String, Integer> getColumnsNamesWithIds(Sheet sheet);

    List<String> getAllStringValuesFromColumnById(Sheet sheet, int columnIndex);

}
