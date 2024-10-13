package com.exe101work.etherealshops.service.image;

import com.exe101work.etherealshops.domain.response.ImageResponse;
import com.exe101work.etherealshops.entity.Image;
import com.exe101work.etherealshops.entity.ProductVariant;
import com.exe101work.etherealshops.exception.ResourceNotFoundException;
import com.exe101work.etherealshops.mapper.ImageMapper;
import com.exe101work.etherealshops.repository.ImageRepository;
import com.exe101work.etherealshops.service.productVariant.ProductVariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ImageService implements IImageService {

    private final ImageRepository imageRepository;
    private final ProductVariantService productVariantService;
    private final ImageMapper imageMapper;

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image not found"));
    }

    @Override
    public void deleteImageById(Long id) {
        this.imageRepository.findById(id).ifPresentOrElse(imageRepository::delete,
                () -> { throw new ResourceNotFoundException("Image not found");
        });
    }

    @Override
    public List<ImageResponse> saveImage(List<MultipartFile> files, Long productVariantId) {
        ProductVariant productVariant = productVariantService.getProductVariantById(productVariantId);
        List<ImageResponse> imageResponses = new ArrayList<>();
        files.stream().forEach(imageFile -> {
            try {
                Image image = new Image();
                image.setProduct_variant(productVariant);
                image.setFileName(imageFile.getOriginalFilename());
                image.setFileType(imageFile.getContentType());
                image.setImage(new SerialBlob(imageFile.getBytes()));

                String buildUrl = "api/v1/images/image/download/";
                String downloadUrl = buildUrl + image.getId();
                image.setDownloadUrl(downloadUrl);

                Image savedImage = imageRepository.save(image);

                savedImage.setDownloadUrl(buildUrl+savedImage.getId());
                imageRepository.save(savedImage);

                ImageResponse imageResponse = imageMapper.toImageResponse(savedImage);
                imageResponses.add(imageResponse);
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }

        });
        return imageResponses;
    }

    @Override
    public void updateImage(MultipartFile file, Long imageId) {
        Image image = getImageById(imageId);
        try {
            image.setFileName(file.getOriginalFilename());
            image.setFileType(file.getContentType());
            image.setImage(new SerialBlob(file.getBytes()));
            imageRepository.save(image);
        } catch (IOException |SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
