package advertiser.controller;

import advertiser.payload.AdPayload;
import advertiser.payload.AdSetPayload;
import advertiser.service.AdSetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/adSets")
public class AdSetController {
    private final AdSetService adSetService;

    public AdSetController(AdSetService adSetService) {
        this.adSetService = adSetService;
    }
    @PostMapping("/save")
    public AdSetPayload save(@RequestBody AdSetPayload adSet){
        return adSetService.save(adSet);
    }
    @GetMapping("/{adSetId}")
    public AdSetPayload getById(@PathVariable Long adSetId){
        return adSetService.findById(adSetId);
    }

    @GetMapping("/")
    public List<AdSetPayload> getAll(){
        return adSetService.findAll();
    }
    @GetMapping("/{adSetId}/delete")
    public Boolean deleteById(@PathVariable Long adSetId){
        return adSetService.deleteById(adSetId);
    }
    @PutMapping("/update")
    public AdSetPayload update(@RequestBody AdSetPayload adSet){
        return adSetService.update(adSet);
    }
    @GetMapping("/{adSetId}/ads")
    public List<AdPayload> getAdsByAdSetId(@PathVariable Long adSetId){
        return adSetService.findAdsByAdSetId(adSetId);
    }
}
