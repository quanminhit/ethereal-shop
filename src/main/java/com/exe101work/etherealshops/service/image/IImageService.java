package com.exe101work.etherealshops.service.image;

import com.exe101work.etherealshops.domain.response.ImageResponse;
import com.exe101work.etherealshops.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageResponse> saveImage(List<MultipartFile> files, Long productId);
    void updateImage(MultipartFile file, Long imageId);
}
