package advertiser.service.impl;

import advertiser.model.Campaign;
import advertiser.payload.AdSetPayload;
import advertiser.payload.AdvertiserPayload;
import advertiser.payload.CampaignPayload;
import advertiser.repository.CampaignRepository;
import advertiser.service.AdSetService;
import advertiser.service.AdvertiserService;
import advertiser.service.CampaignService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CampaignServiceImpl implements CampaignService {
    private final CampaignRepository campaignRepository;
    private final AdSetService adSetService;
    private final AdvertiserService advertiserService;

    public CampaignServiceImpl(CampaignRepository campaignRepository, AdSetService adSetService, AdvertiserService advertiserService) {
        this.campaignRepository = campaignRepository;
        this.adSetService = adSetService;
        this.advertiserService = advertiserService;
    }

    @Override
    public CampaignPayload save(CampaignPayload campaign) {
        return campaignRepository.save(campaign.toEntity()).toPayload();
    }

    @Override
    public CampaignPayload findById(Long campaignId) {
        return campaignRepository.findById(campaignId).get().toPayload();
    }

    @Override
    public List<CampaignPayload> findAll() {
        return campaignRepository.findAll().stream().map(Campaign::toPayload).collect(Collectors.toList());
    }

    @Override
    public CampaignPayload update(CampaignPayload campaign) {
        return campaignRepository.save(campaign.toEntity()).toPayload();
    }

    @Override
    public boolean deleteById(Long campaignId) {
        try{
            campaignRepository.deleteById(campaignId);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public List<CampaignPayload> findCampaignsByAdvertiserId(Long advertiserId) {
        AdvertiserPayload advertiser = advertiserService.findById(advertiserId);
        if(Objects.nonNull(advertiser)){
            List<Campaign> campaignsByOwner = campaignRepository.findCampaignsByOwner(advertiser.toEntity());
            if(Objects.nonNull(campaignsByOwner) && !campaignsByOwner.isEmpty())
                return campaignsByOwner.stream().map(Campaign::toPayload).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public List<AdSetPayload> findAdSetsByCampaignId(Long campaignId) {
        CampaignPayload campaign = findById(campaignId);
        if(Objects.nonNull(campaign)){
            return adSetService.findAdSetsByCampaign(campaign);
        }
        return null;
    }
}
