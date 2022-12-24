package advertiser.service;

import advertiser.payload.AdSetPayload;

import java.util.List;

public interface AdSetService {
    AdSetPayload save(AdSetPayload adSet);
    AdSetPayload findById(Long adSetId);
    List<AdSetPayload> findAll();
    AdSetPayload update(AdSetPayload adSet);
    boolean deleteById(Long adSetId);
}
