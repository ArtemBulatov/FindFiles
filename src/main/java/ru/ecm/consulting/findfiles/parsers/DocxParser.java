package ru.ecm.consulting.findfiles.parsers;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Component;
import ru.ecm.consulting.findfiles.enums.FileType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
@Component
public class DocxParser extends FileParser {

    @Override
    public boolean checkFileType(File file) {
        return checkFileType(file, FileType.docx);
    }

    @Override
    public int getPagesCount(File file) {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(inputStream));
            return docxFile.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();
        } catch (IOException | InvalidFormatException e) {
            log.error(e.getMessage());
        }
        return 0;
    }
}
