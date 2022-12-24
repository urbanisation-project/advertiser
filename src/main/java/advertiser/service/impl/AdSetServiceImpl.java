package advertiser.service.impl;

import advertiser.model.AdSet;
import advertiser.payload.AdSetPayload;
import advertiser.repository.AdSetRepository;
import advertiser.service.AdSetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AdSetServiceImpl implements AdSetService {
    private AdSetRepository adSetRepository;

    public AdSetServiceImpl(AdSetRepository adSetRepository) {
        this.adSetRepository = adSetRepository;
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
}
