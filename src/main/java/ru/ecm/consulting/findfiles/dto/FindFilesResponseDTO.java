package ru.ecm.consulting.findfiles.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "ДТО ответа с количеством файлов и страниц в этих файлах")
public class FindFilesResponseDTO {

    @Schema(example = "5", description = "Количество файлов")
    private int filesCount;

    @Schema(example = "15", description = "Количество страниц")
    private int pagesCount;

    public void incrementPages(int count) {
        pagesCount += count;
    }

    public void incrementFiles() {
        filesCount++;
    }
}
