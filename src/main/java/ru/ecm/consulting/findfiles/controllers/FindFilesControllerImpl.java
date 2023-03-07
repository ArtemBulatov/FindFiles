package ru.ecm.consulting.findfiles.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.ecm.consulting.findfiles.enums.FileType;
import ru.ecm.consulting.findfiles.dto.FindFilesRequestDTO;
import ru.ecm.consulting.findfiles.dto.FindFilesResponseDTO;
import ru.ecm.consulting.findfiles.services.FindFilesService;

@RestController
public class FindFilesControllerImpl implements FindFilesController{
    private final FindFilesService findFilesService;

    public FindFilesControllerImpl(FindFilesService findFilesService) {
        this.findFilesService = findFilesService;
    }

    @Override
    public ResponseEntity<FindFilesResponseDTO> find(FindFilesRequestDTO requestDTO) {
        FindFilesResponseDTO responseDTO = findFilesService.findFiles(requestDTO.getDirectory());
        if (responseDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(responseDTO);
    }

    @Override
    public ResponseEntity<FileType[]> getFileTypes() {
        return ResponseEntity.ok(FileType.values());
    }

}
