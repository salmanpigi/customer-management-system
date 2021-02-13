package com.enigma.api.inventory.models.request;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ImageUploadRequestTest {

    @InjectMocks
    private ImageUploadRequest imageUploadRequest;

    @Mock
    private MultipartFile file;

    @Test
    void getterSetterTest() {
        imageUploadRequest = new ImageUploadRequest();
        imageUploadRequest.setFile(file);

        assertEquals(file, imageUploadRequest.getFile());
    }
}
