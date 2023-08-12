package com.elyo.nbox.file.controller;

import com.elyo.nbox.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("upload")
    public FileResponse upload(MultipartHttpServletRequest request) throws IOException {

        List<MultipartFile> files = request.getFiles("files");

        int size = files.size();
        for (int i = 0; i < size; i++) {
            MultipartFile file = files.get(i);
            file.transferTo(new File("testfile"+i));
        }

        return null;
    }
}
