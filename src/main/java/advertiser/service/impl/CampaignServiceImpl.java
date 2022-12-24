package advertiser.service.impl;

import advertiser.model.Campaign;
import advertiser.payload.CampaignPayload;
import advertiser.repository.CampaignRepository;
import advertiser.service.CampaignService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampaignServiceImpl implements CampaignService {
    private CampaignRepository campaignRepository;

    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
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
}
