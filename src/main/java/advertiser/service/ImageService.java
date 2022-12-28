package advertiser.service;

import advertiser.model.Image;

public interface ImageService {
    Image save(Image image);
    Image findByFileName(String fileName);
}
