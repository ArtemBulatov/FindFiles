package ru.ecm.consulting.findfiles.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "ДТО запроса для поиска файлов по директории")
public class FindFilesRequestDTO {

    @Schema(example = "D:/projects", description = "Директория для поиска файлов")
    private String directory;
}
