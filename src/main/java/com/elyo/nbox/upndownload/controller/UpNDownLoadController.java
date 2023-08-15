package com.elyo.nbox.upndownload.controller;

import com.elyo.nbox.file.controller.dto.FileResponse;
import com.elyo.nbox.upndownload.service.DefaultFileDownloadService;
import com.elyo.nbox.upndownload.service.DefaultFileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UpNDownLoadController {

    private final DefaultFileUploadService uploadService;
    private final DefaultFileDownloadService downloadService;

    @PostMapping("upload")
    public FileResponse upload(MultipartHttpServletRequest request) throws IOException {
        return uploadService.upload(request);
    }
    @PostMapping("down")
    public ResponseEntity<ByteArrayResource> down() throws IOException {
        return downloadService.download();
    }
}
