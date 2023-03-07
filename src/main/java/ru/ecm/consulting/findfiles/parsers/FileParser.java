package ru.ecm.consulting.findfiles.parsers;

import ru.ecm.consulting.findfiles.enums.FileType;

import java.io.File;

public abstract class FileParser {

    public boolean checkFileType(File file) {
        return false;
    }

    public boolean checkFileType(File file, FileType type) {
        return file.isFile() && file.getName().endsWith("." + type.name());
    }

    public int getPagesCount(File file) {
        return 0;
    }
}
