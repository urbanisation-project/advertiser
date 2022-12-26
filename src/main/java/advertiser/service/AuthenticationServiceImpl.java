package advertiser.service;

import advertiser.payload.AdvertiserPayload;
import advertiser.payload.Credentials;
import advertiser.repository.AdvertiserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AdvertiserRepository advertiserRepository;

    public AuthenticationServiceImpl(AdvertiserRepository advertiserRepository) {
        this.advertiserRepository = advertiserRepository;
    }

    @Override
    public AdvertiserPayload findByCredentials(Credentials credentials) {
        return advertiserRepository.findByEmailAndPassword(credentials.getMail(), credentials.getPassword()).toPayload();
    }
}
