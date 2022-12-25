package advertiser.model;

import advertiser.payload.KeywordPayload;
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
public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public KeywordPayload toPayload(){
        return new KeywordPayload(getId(), getName());
    }
}
