package advertiser.service;

import advertiser.payload.AdPayload;
import advertiser.payload.AdSetPayload;
import advertiser.payload.KeywordPayload;

import java.util.List;

public interface AdService {
    AdPayload save(AdPayload ad);
    AdPayload findById(Long adId);
    List<AdPayload> findAll();
    AdPayload update(AdPayload ad);
    boolean deleteById(Long adId);

    List<AdPayload> findAdsByAdSet(AdSetPayload adSet);

    List<AdPayload> findAdsByKeywords(List<KeywordPayload> keywords);

    Integer getAdVisitorsCount(Long adId);

    Integer updateAdVisitorsCount(Long adId);
}
