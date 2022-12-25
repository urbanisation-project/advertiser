package advertiser.service.impl;

import advertiser.model.AdSet;
import advertiser.payload.AdPayload;
import advertiser.payload.AdSetPayload;
import advertiser.payload.CampaignPayload;
import advertiser.payload.KeywordPayload;
import advertiser.repository.AdSetRepository;
import advertiser.service.AdService;
import advertiser.service.AdSetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AdSetServiceImpl implements AdSetService {
    private final AdSetRepository adSetRepository;
    private final AdService adService;

    public AdSetServiceImpl(AdSetRepository adSetRepository, AdService adService) {
        this.adSetRepository = adSetRepository;
        this.adService = adService;
    }

    @Override
    public AdSetPayload save(AdSetPayload adSet) {
        return adSetRepository.save(adSet.toEntity()).toPayload();
    }

    @Override
    public AdSetPayload findById(Long adSetId) {
        return adSetRepository.findById(adSetId).get().toPayload();
    }

    @Override
    public List<AdSetPayload> findAll() {
        return adSetRepository.findAll().stream().map(AdSet::toPayload).collect(Collectors.toList());
    }

    @Override
    public AdSetPayload update(AdSetPayload adSet) {
        return adSetRepository.save(adSet.toEntity()).toPayload();
    }

    @Override
    public boolean deleteById(Long adSetId) {
        try{
            adSetRepository.deleteById(adSetId);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public List<AdSetPayload> findAdSetsByCampaign(CampaignPayload campaign) {
        return adSetRepository.findAdSetsByCampaign(campaign.toEntity())
                .stream()
                .map(AdSet::toPayload)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdPayload> findAdsByAdSetId(Long adSetId) {
        AdSetPayload adSet = findById(adSetId);
        return adService.findAdsByAdSet(adSet);
    }

    @Override
    public List<AdSetPayload> findAdSetsByKeyword(KeywordPayload keyword) {
        return adSetRepository.findAdSetsByKeywordsContains(keyword.toEntity())
                .stream()
                .map(AdSet::toPayload)
                .collect(Collectors.toList());
    }
}
