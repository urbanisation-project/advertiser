package advertiser.service;

import advertiser.payload.AdvertiserPayload;
import advertiser.payload.Credentials;

public interface AuthenticationService {
    AdvertiserPayload findByCredentials(Credentials credentials);
}
