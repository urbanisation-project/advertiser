package advertiser.service;

import advertiser.payload.AdSetPayload;
import advertiser.payload.CampaignPayload;

import java.util.List;

public interface CampaignService {
    CampaignPayload save(CampaignPayload campaign);
    CampaignPayload findById(Long campaignId);
    List<CampaignPayload> findAll();
    CampaignPayload update(CampaignPayload campaign);
    boolean deleteById(Long campaignId);

    List<CampaignPayload> findCampaignsByAdvertiserId(Long advertiserId);

    List<AdSetPayload> findAdSetsByCampaignId(Long campaignId);
}
