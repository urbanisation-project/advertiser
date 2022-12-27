package advertiser.model;

import advertiser.payload.AdImagePayload;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdImage {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String type;
    @Lob
    private byte[] data;
    public AdImage(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public AdImagePayload toPayload(){
        return new AdImagePayload(getId(), getName(), getType(), getData());
    }
}
