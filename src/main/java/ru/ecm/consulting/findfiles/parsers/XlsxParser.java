package ru.ecm.consulting.findfiles.parsers;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import ru.ecm.consulting.findfiles.enums.FileType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
@Component
public class XlsxParser extends FileParser {

    @Override
    public boolean checkFileType(File file) {
        return checkFileType(file, FileType.xlsx);
    }

    @Override
    public int getPagesCount(File file) {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            return workbook.getNumberOfSheets();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return 0;
    }
}
