package com.exe101work.etherealshops.mapper;

import com.exe101work.etherealshops.domain.request.AddImageRequest;
import com.exe101work.etherealshops.domain.response.ImageResponse;
import com.exe101work.etherealshops.entity.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    ImageResponse toImageResponse(Image image);
    Image toImage(AddImageRequest imageRequest);
}
