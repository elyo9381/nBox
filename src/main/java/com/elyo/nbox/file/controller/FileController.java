package com.elyo.nbox.file.controller;

import com.elyo.nbox.file.controller.dto.FileResponse;
import com.elyo.nbox.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/folders")
    public FileResponse create() throws IOException {
        return fileService.create();
    }

    @GetMapping("/folders")
    public FileResponse list() throws IOException {
        return fileService.getList();
    }

    @PutMapping("/folders/")
    public FileResponse update() throws IOException {
        return fileService.update();
    }

    @DeleteMapping("/folders")
    public FileResponse delete() throws IOException {
        return fileService.delete();
    }

}
