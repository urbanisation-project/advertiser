package advertiser.model;

import advertiser.payload.AdvertiserPayload;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
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
