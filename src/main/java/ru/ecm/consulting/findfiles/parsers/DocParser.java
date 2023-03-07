package ru.ecm.consulting.findfiles.parsers;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hwpf.HWPFDocument;
import org.springframework.stereotype.Component;
import ru.ecm.consulting.findfiles.enums.FileType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
@Component
public class DocParser extends FileParser {

    @Override
    public boolean checkFileType(File file) {
        return checkFileType(file, FileType.doc);
    }

    @Override
    public int getPagesCount(File file) {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            HWPFDocument wordDoc = new HWPFDocument(inputStream);
            return wordDoc.getSummaryInformation().getPageCount();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return 0;
    }
}
