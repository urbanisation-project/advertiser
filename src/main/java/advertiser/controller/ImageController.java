package advertiser.controller;

import advertiser.service.AdImageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/api/image")
public class ImageController {
    private final AdImageService adImageService;

    public ImageController(AdImageService adImageService) {
        this.adImageService = adImageService;
    }

    @PostMapping("/upload")
    public boolean uploadFile(@RequestParam("file") MultipartFile image) {
        try {
            adImageService.save(image);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}