package advertiser.payload;

import advertiser.model.Advertiser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
