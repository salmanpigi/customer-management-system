package com.enigma.api.inventory.models.request;

import org.springframework.web.multipart.MultipartFile;

public class ImageUploadRequest {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
