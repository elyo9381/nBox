package com.elyo.nbox.file.controller;

import com.elyo.nbox.file.controller.dto.FileResponse;
import com.elyo.nbox.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("upload")
    public FileResponse upload(MultipartHttpServletRequest request) throws IOException {
        return fileService.upload(request);
    }
}
