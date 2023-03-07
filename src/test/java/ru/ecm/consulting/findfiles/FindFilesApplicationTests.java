package ru.ecm.consulting.findfiles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import ru.ecm.consulting.findfiles.dto.FindFilesRequestDTO;
import ru.ecm.consulting.findfiles.dto.FindFilesResponseDTO;
import ru.ecm.consulting.findfiles.enums.FileType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FindFilesApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void getSupportedTypesTest() {
        ResponseEntity<FileType[]> response = restTemplate
                .exchange("/files/supported-types", HttpMethod.GET, HttpEntity.EMPTY, FileType[].class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(FileType.values().length, response.getBody().length);
    }

    @Test
    void findFilesTest() {
        String directory = getClass().getClassLoader().getResource("files/").getPath().replaceFirst("/", "");
        FindFilesRequestDTO requestDTO = new FindFilesRequestDTO();
        requestDTO.setDirectory(directory);

        ResponseEntity<FindFilesResponseDTO> response = restTemplate
                .exchange("/files/find", HttpMethod.POST, new HttpEntity<>(requestDTO, HttpHeaders.EMPTY), FindFilesResponseDTO.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

}
