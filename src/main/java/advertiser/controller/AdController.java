package advertiser.controller;

import advertiser.model.Image;
import advertiser.controller.payload.AdDTO;
import advertiser.payload.AdPayload;
import advertiser.payload.KeywordPayload;
import advertiser.service.AdService;
import advertiser.service.ImageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/api/ads")
@CrossOrigin
public class AdController {
    private final AdService adService;
    private final ImageService imageService;

    public AdController(AdService adService, ImageService imageService) {
        this.adService = adService;
        this.imageService = imageService;
    }
    @PostMapping("/save")
    public AdPayload save(@RequestBody AdDTO ad){
        AdPayload ad1=new AdPayload(
                ad.getId(),
                ad.getName(),
                null,
                ad.getStartDate(),
                ad.getEndDate(),
                ad.getDescription(),
                ad.getAdSet(),
                ad.getVisitorsCount()
        );
        return adService.save(ad1);
    }
    @GetMapping("/{adId}/images")
    public ResponseEntity<byte[]> getImage(@PathVariable Long adId) throws Exception {
        advertiser.payload.AdPayload ad = adService.findById(adId);
        Image image = ad.getResource();
        return ResponseEntity.ok().contentType(MediaType.valueOf(image.getFileType())).body(image.getData());
    }
    @PutMapping("/{adId}")
    public void addImageToAd(@PathVariable Long adId , @RequestBody MultipartFile file){
        advertiser.payload.AdPayload ad = adService.findById(adId);
        Image image = Image.buildImage(file);
        ad.setResource(imageService.save(image));
        adService.save(ad);
    }
    @GetMapping("/{adId}")
    public advertiser.payload.AdPayload getById(@PathVariable Long adId){
        return adService.findById(adId);
    }

    @GetMapping("/")
    public List<advertiser.payload.AdPayload> getAll(){
        return adService.findAll();
    }
    @GetMapping("/{adId}/delete")
    public Boolean deleteById(@PathVariable Long adId){
        return adService.deleteById(adId);
    }
    @PutMapping("/update")
    public advertiser.payload.AdPayload update(@RequestBody advertiser.payload.AdPayload ad){
        return adService.update(ad);
    }
    @PostMapping("/keywords")
    public List<advertiser.payload.AdPayload> getAdsByKeywords(@RequestBody List<KeywordPayload> keywords){
        return adService.findAdsByKeywords(keywords);
    }
    @GetMapping("/{adId}/counts")
    public Integer getAdVisitorsCount(@PathVariable Long adId){
        return adService.getAdVisitorsCount(adId);
    }
    @GetMapping("/{adId}/update/counts")
    public void updateAdVisitorsCount(@PathVariable Long adId){
        adService.updateAdVisitorsCount(adId);
    }
}
