package ru.ecm.consulting.findfiles.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ecm.consulting.findfiles.dto.FindFilesResponseDTO;
import ru.ecm.consulting.findfiles.parsers.FileParser;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Service
public class FindFilesService {
    private final List<FileParser> fileParsers;

    public FindFilesService(List<FileParser> fileParsers) {
        this.fileParsers = fileParsers;
    }

    public FindFilesResponseDTO findFiles(String directory) {
        FindFilesResponseDTO result = new FindFilesResponseDTO();

        try (Stream<Path> walk = Files.walk(Paths.get(directory))) {
            walk.forEach(path -> parseFile(path.toFile(), result));
        }
        catch (UncheckedIOException | IOException e) {
            log.error(e.getClass() + ": " + e.getMessage());
            return null;
        }
        return result;
    }

    private void parseFile(File file, FindFilesResponseDTO countsDTO) {
        fileParsers.stream()
                .filter(parser -> parser.checkFileType(file))
                .findAny()
                .ifPresent(parser -> {
                    countsDTO.incrementPages(parser.getPagesCount(file));
                    countsDTO.incrementFiles();
                });
    }
}
