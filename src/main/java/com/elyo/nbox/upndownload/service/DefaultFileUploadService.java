package com.elyo.nbox.upndownload.service;


import com.elyo.nbox.domain.dataObj.IUpload;
import com.elyo.nbox.file.controller.dto.FileResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Service
@Slf4j
public class DefaultFileUploadService implements IUpload {

    @Value("${HOME}")
    private String homeDirectory;

    public FileResponse upload(MultipartHttpServletRequest request) throws IOException {
        List<MultipartFile> files = request.getFiles("files");

        int size = files.size();
        File folder = new File(homeDirectory, "testtmp");
        String path = folder.getPath();


        if (!folder.exists()) {
            folder.mkdirs();
        }
        for (int i = 0; i < size; i++) {
            MultipartFile file = files.get(i);
            String s = path + "/" + file.getOriginalFilename() + i + ".png";
            Paths.get(s);
            file.transferTo(new File(s));
        }
        return null;
    }
}
