package ru.ecm.consulting.findfiles.parsers;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import ru.ecm.consulting.findfiles.enums.FileType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
@Component
public class PdfParser extends FileParser {

    @Override
    public boolean checkFileType(File file) {
        return checkFileType(file, FileType.pdf);
    }

    @Override
    public int getPagesCount(File file) {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            Workbook workbook = new HSSFWorkbook(inputStream);
            return workbook.getNumberOfSheets();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return 0;
    }
}
