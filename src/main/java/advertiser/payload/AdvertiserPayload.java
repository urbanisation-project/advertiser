package advertiser.payload;

import advertiser.model.Advertiser;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdvertiserPayload {
    private Long id;
    private String username;
    private String email;
    private String password;

    public Advertiser toEntity(){
        return new Advertiser(getId(), getUsername(), getEmail(), getPassword());
    }
}
