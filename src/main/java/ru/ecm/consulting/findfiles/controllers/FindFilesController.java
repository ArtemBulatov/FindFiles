package ru.ecm.consulting.findfiles.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ecm.consulting.findfiles.enums.FileType;
import ru.ecm.consulting.findfiles.dto.FindFilesRequestDTO;
import ru.ecm.consulting.findfiles.dto.FindFilesResponseDTO;

@Tags(value = {@Tag(name = "Поиск файлов",
        description = "Подсчёт файлов и их страниц в заданной директории")})
@RequestMapping("/files")
public interface FindFilesController {

    @Operation(summary = "Получение количества файлов и их страниц в заданной директории")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Количество файлов и страниц в них",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = FindFilesResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Директория не найдена")})
    @PostMapping(path = "/find")
    ResponseEntity<FindFilesResponseDTO> find(@RequestBody FindFilesRequestDTO requestDTO);

    @Operation(summary = "Получение списка поддерживаемых типов файлов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Поддерживаемые типы файлов для подсчёта страниц",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = FileType[].class))})})
    @GetMapping(path = "/supported-types")
    ResponseEntity<FileType[]> getFileTypes();
}
