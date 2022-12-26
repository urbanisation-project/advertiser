package advertiser.service.impl;

import advertiser.model.Ad;
import advertiser.payload.AdPayload;
import advertiser.payload.AdSetPayload;
import advertiser.payload.KeywordPayload;
import advertiser.repository.AdRepository;
import advertiser.service.AdService;
import advertiser.service.AdSetService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdServiceImpl implements AdService {
    private AdRepository adRepository;
    private AdSetService adSetService;

    public AdServiceImpl(AdRepository adRepository,@Lazy AdSetService adSetService) {
        this.adRepository = adRepository;
        this.adSetService = adSetService;
    }

    @Override
    public AdPayload save(AdPayload ad) {
        return adRepository.save(ad.toEntity()).toPayload();
    }

    @Override
    public AdPayload findById(Long adId) {
        return adRepository.findById(adId).get().toPayload();
    }

    @Override
    public List<AdPayload> findAll() {
        return adRepository.findAll().stream().map(Ad::toPayload).collect(Collectors.toList());
    }

    @Override
    public AdPayload update(AdPayload ad) {
        return adRepository.save(ad.toEntity()).toPayload();
    }

    @Override
    public boolean deleteById(Long adId) {
        try {
            adRepository.deleteById(adId);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<AdPayload> findAdsByAdSet(AdSetPayload adSet) {
        return adRepository.findAdsByAdSet(adSet.toEntity()).stream().map(Ad::toPayload).collect(Collectors.toList());
    }

    @Override
    public List<AdPayload> findAdsByKeywords(List<KeywordPayload> keywords) {
        List<AdSetPayload> adSets=new ArrayList<>();
        List<AdPayload> ads=new ArrayList<>();
        for(KeywordPayload keyword:keywords){
            adSets.addAll(adSetService.findAdSetsByKeyword(keyword));
        }
        for(AdSetPayload adSet:adSets){
            ads.addAll(findAdsByAdSet(adSet));
        }
        return ads;
    }

    @Override
    public Integer getAdVisitorsCount(Long adId) {
        return findById(adId).getVisitorsCount();
    }

    @Override
    public Integer updateAdVisitorsCount(Long adId) {
        AdPayload ad = findById(adId);
        ad.setVisitorsCount(ad.getVisitorsCount()+1);
        return update(ad).getVisitorsCount();
    }
}
