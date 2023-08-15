package com.elyo.nbox.file.service;


import com.elyo.nbox.domain.IDownload;
import com.elyo.nbox.domain.IUpload;
import com.elyo.nbox.file.controller.dto.FileResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
@Slf4j
public class DefaultFileDownloadService implements IDownload {

    @Value("${HOME}")
    private String homeDirectory;

    // TODO: 2023/08/15 다운로드를 위한 직접 체크를 상위 레이어 에서 진행
    public ResponseEntity<ByteArrayResource> download() throws IOException {
        // TODO: 2023/08/15 다운로드를 위한 path를 넘겨 받는다.
        Resource classPathResource = new ClassPathResource("reactor.png");
        byte[] fileData = Files.readAllBytes(Paths.get(classPathResource.getFile().getAbsolutePath()));
        ByteArrayResource resource = new ByteArrayResource(fileData);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=file.txt");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(fileData.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
