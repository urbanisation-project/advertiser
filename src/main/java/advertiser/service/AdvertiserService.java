package advertiser.service;

import advertiser.payload.AdvertiserPayload;

import java.util.List;

public interface AdvertiserService {
    AdvertiserPayload save(AdvertiserPayload advertiser);
    AdvertiserPayload findById(Long advertiserId);
    List<AdvertiserPayload> findAll();
    AdvertiserPayload update(AdvertiserPayload advertiser);
    boolean deleteById(Long advertiserId);
}
