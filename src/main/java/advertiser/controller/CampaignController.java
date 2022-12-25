package advertiser.controller;

import advertiser.payload.AdSetPayload;
import advertiser.payload.CampaignPayload;
import advertiser.service.CampaignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/campaigns")
public class CampaignController {
    private final CampaignService campaignService;

    public CampaignController(CampaignService adService) {
        this.campaignService = adService;
    }
    @PostMapping("/save")
    public CampaignPayload save(@RequestBody CampaignPayload campaign){
        return campaignService.save(campaign);
    }
    @GetMapping("/{campaignId}")
    public CampaignPayload getById(@PathVariable Long campaignId){
        return campaignService.findById(campaignId);
    }

    @GetMapping("/")
    public List<CampaignPayload> getAll(){
        return campaignService.findAll();
    }
    @GetMapping("/{campaignId}/delete")
    public Boolean deleteById(@PathVariable Long campaignId){
        return campaignService.deleteById(campaignId);
    }
    @PutMapping("/update")
    public CampaignPayload update(@RequestBody CampaignPayload campaign){
        return campaignService.update(campaign);
    }
    @GetMapping("/advertisers/{advertiserId}")
    public List<CampaignPayload> getCampaigns(@PathVariable Long advertiserId){
        return campaignService.findCampaignsByAdvertiserId(advertiserId);
    }
    @GetMapping("/{campaignId}/ad-sets")
    public List<AdSetPayload> getAdSets(@PathVariable Long campaignId){
        return campaignService.findAdSetsByCampaignId(campaignId);
    }
}
