package advertiser.service.impl;

import advertiser.payload.AdImagePayload;
import advertiser.repository.AdImageRepository;
import advertiser.service.AdImageService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AdImageServiceImpl implements AdImageService {
    private final AdImageRepository adImageRepository;

    public AdImageServiceImpl(AdImageRepository adImageRepository) {
        this.adImageRepository = adImageRepository;
    }

    @Override
    public AdImagePayload save(MultipartFile image) throws IOException {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        AdImagePayload adImagePayload= new AdImagePayload(fileName, image.getContentType(), image.getBytes());
        return adImageRepository.save(adImagePayload.toEntity()).toPayload();
    }
}
