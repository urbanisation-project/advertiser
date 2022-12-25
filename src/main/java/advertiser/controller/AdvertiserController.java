package advertiser.controller;

import advertiser.payload.AdvertiserPayload;
import advertiser.service.AdvertiserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/advertisers")
public class AdvertiserController {
    private final AdvertiserService adService;

    public AdvertiserController(AdvertiserService adService) {
        this.adService = adService;
    }

    @PostMapping("/save")
    public AdvertiserPayload save(@RequestBody AdvertiserPayload advertiser){
        return adService.save(advertiser);
    }
    @GetMapping("/{advertiserId}")
    public AdvertiserPayload getById(@PathVariable Long advertiserId){
        return adService.findById(advertiserId);
    }

    @GetMapping("/")
    public List<AdvertiserPayload> getAll(){
        return adService.findAll();
    }
    @GetMapping("/{advertiserId}/delete")
    public Boolean deleteById(@PathVariable Long advertiserId){
        return adService.deleteById(advertiserId);
    }
    @PutMapping("/update")
    public AdvertiserPayload update(@RequestBody AdvertiserPayload advertiser){
        return adService.update(advertiser);
    }
}
