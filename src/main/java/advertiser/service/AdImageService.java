package advertiser.service;

import advertiser.payload.AdImagePayload;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AdImageService {
    AdImagePayload save(MultipartFile image) throws IOException;
}
