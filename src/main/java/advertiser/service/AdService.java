package advertiser.service;

import advertiser.payload.AdPayload;

import java.util.List;

public interface AdService {
    AdPayload save(AdPayload ad);
    AdPayload findById(Long adId);
    List<AdPayload> findAll();
    AdPayload update(AdPayload ad);
    boolean deleteById(Long adId);
}
