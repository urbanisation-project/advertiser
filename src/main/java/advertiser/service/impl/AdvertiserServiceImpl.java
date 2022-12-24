package advertiser.service.impl;

import advertiser.model.Advertiser;
import advertiser.payload.AdvertiserPayload;
import advertiser.repository.AdvertiserRepository;
import advertiser.service.AdvertiserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertiserServiceImpl implements AdvertiserService {
    private AdvertiserRepository advertiserRepository;

    public AdvertiserServiceImpl(AdvertiserRepository advertiserRepository) {
        this.advertiserRepository = advertiserRepository;
    }

    @Override
    public AdvertiserPayload save(AdvertiserPayload advertiser) {
        return advertiserRepository.save(advertiser.toEntity()).toPayload();
    }

    @Override
    public AdvertiserPayload findById(Long advertiserId) {
        return advertiserRepository.findById(advertiserId).get().toPayload();
    }

    @Override
    public List<AdvertiserPayload> findAll() {
        return advertiserRepository.findAll().stream().map(Advertiser::toPayload).collect(Collectors.toList());
    }

    @Override
    public AdvertiserPayload update(AdvertiserPayload advertiser) {
        return advertiserRepository.save(advertiser.toEntity()).toPayload();
    }

    @Override
    public boolean deleteById(Long advertiserId) {
        try{
            advertiserRepository.deleteById(advertiserId);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
