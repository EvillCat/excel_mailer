package model.reader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;
import java.util.Map;

public interface ExcelRepository {

    Map<String, Sheet> getSheetsWithNameKeys();

    Map<String, Integer> getColumnsNamesWithIds(Sheet sheet);

    List<String> getAllStringValuesFromColumnById(Sheet sheet, int columnIndex);

}
