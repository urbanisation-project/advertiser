package advertiser.service;

import advertiser.payload.AdPayload;
import advertiser.payload.AdSetPayload;
import advertiser.payload.CampaignPayload;
import advertiser.payload.KeywordPayload;

import java.util.List;

public interface AdSetService {
    AdSetPayload save(AdSetPayload adSet);
    AdSetPayload findById(Long adSetId);
    List<AdSetPayload> findAll();
    AdSetPayload update(AdSetPayload adSet);
    boolean deleteById(Long adSetId);
    List<AdSetPayload> findAdSetsByCampaign(CampaignPayload campaign);

    List<AdPayload> findAdsByAdSetId(Long adSetId);

    List<AdSetPayload> findAdSetsByKeyword(KeywordPayload keywordPayload);
}
