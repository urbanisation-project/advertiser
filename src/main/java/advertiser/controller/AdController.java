package advertiser.controller;

import advertiser.payload.AdPayload;
import advertiser.service.AdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/ads")
public class AdController {
    private AdService adService;

    public AdController(AdService adService) {
        this.adService = adService;
    }
    @PostMapping("/save")
    public AdPayload save(@RequestBody AdPayload ad){
        return adService.save(ad);
    }
    @GetMapping("/{adId}")
    public AdPayload getById(@PathVariable Long adId){
        return adService.findById(adId);
    }

    @GetMapping("/")
    public List<AdPayload> getAll(){
        return adService.findAll();
    }
    @GetMapping("/{adId}/delete")
    public Boolean deleteById(@PathVariable Long adId){
        return adService.deleteById(adId);
    }
    @PutMapping("/update")
    public AdPayload update(@RequestBody AdPayload ad){
        return adService.update(ad);
    }
}
