package advertiser.model;

import advertiser.payload.AdvertiserPayload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advertiser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;

    public AdvertiserPayload toPayload(){
        return new AdvertiserPayload(getId(), getUsername(), getEmail(), getPassword());
    }
}
