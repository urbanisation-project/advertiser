package advertiser.service.impl;

import advertiser.model.Image;
import advertiser.repository.ImageRepository;
import advertiser.service.ImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    private ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image save(Image image) throws NullPointerException {
        return imageRepository.save(image);
    }

    @Override
    public Image findByFileName(String fileName) {
        return imageRepository.findByFileName(fileName);
    }
}
