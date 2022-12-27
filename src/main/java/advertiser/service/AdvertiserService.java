package advertiser.service;

import advertiser.model.Advertiser;

import java.util.List;

public interface AdvertiserService {
    Advertiser save(Advertiser advertiser);

    Advertiser update(Advertiser advertiser);

    Advertiser findById(Long advertiserId);

    List<Advertiser> findAll();

    boolean deleteById(Long advertiserId);
}
