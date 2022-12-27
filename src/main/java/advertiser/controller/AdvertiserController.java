package advertiser.controller;

import advertiser.model.Advertiser;
import advertiser.service.AdvertiserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/advertiser")
public class AdvertiserController {
    private AdvertiserService advertiserService;
    @PostMapping("/save")
    public Advertiser save(@RequestBody Advertiser advertiser){
        return advertiserService.save(advertiser);
    }
    @PostMapping("/update")
    public Advertiser update(@RequestBody Advertiser advertiser){
        return advertiserService.update(advertiser);
    }
    @GetMapping("/{advertiserId}")
    public Advertiser findById(@PathVariable Long advertiserId){
        return advertiserService.findById(advertiserId);
    }
    @GetMapping("/")
    public List<Advertiser> getAll(){
        return advertiserService.findAll();
    }
    @DeleteMapping("/{advertiserId}")
    public boolean deleteById(@PathVariable Long advertiserId){
        return advertiserService.deleteById(advertiserId);
    }
}
