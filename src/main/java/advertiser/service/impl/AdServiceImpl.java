package advertiser.service.impl;

import advertiser.model.Ad;
import advertiser.payload.AdPayload;
import advertiser.repository.AdRepository;
import advertiser.service.AdService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AdServiceImpl implements AdService {
    private AdRepository adRepository;

    public AdServiceImpl(AdRepository adRepository) {
        this.adRepository = adRepository;
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
        try{
            adRepository.deleteById(adId);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
