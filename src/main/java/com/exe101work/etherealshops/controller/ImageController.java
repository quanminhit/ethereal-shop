package com.exe101work.etherealshops.controller;

import com.exe101work.etherealshops.domain.response.ApiResponse;
import com.exe101work.etherealshops.domain.response.ImageResponse;
import com.exe101work.etherealshops.entity.Image;
import com.exe101work.etherealshops.service.image.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse> saveImages(List<MultipartFile> files, @RequestParam Long productVariantId) {
        try {
            List<ImageResponse> responses = imageService.saveImage(files,productVariantId);
            return ResponseEntity.ok(ApiResponse.builder().message("Upload success!")
                    .data(responses)
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.builder()
                            .status(false)
                            .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .message("Upload fail!").status(false).build());
        }
    }

    @GetMapping("/download/{imageId}")
    public ResponseEntity<Resource> downloadImage(@PathVariable Long imageId) throws SQLException {
        Image image = imageService.getImageById(imageId);
        ByteArrayResource resource = new ByteArrayResource(image.getImage().getBytes(1, (int)image.getImage().length()));
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(image.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+image.getFileName() + "\"")
                .body(resource);
    }

    @PutMapping("/update/{imageId}")
    public ResponseEntity<ApiResponse> updateImage(@PathVariable Long imageId, @RequestBody MultipartFile file) {
            Image image = imageService.getImageById(imageId);
            if(image != null) {
                imageService.updateImage(file, imageId);
                return ResponseEntity.ok(ApiResponse.builder().message("Update success!").build());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.builder()
                    .status(false)
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message("Update fail!").build());
    }

    @DeleteMapping("/delete/{imageId}")
    public ResponseEntity<ApiResponse> deleteImage(@PathVariable Long imageId) {
        Image image = imageService.getImageById(imageId);
        if(image != null) {
            imageService.deleteImageById(imageId);
            return ResponseEntity.ok(ApiResponse.builder().message("Delete success!").build());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.builder()
                        .status(false)
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Delete fail!").build());
    }
}
