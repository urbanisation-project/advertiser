package advertiser.payload;

import advertiser.model.AdImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdImagePayload {
    private String id;
    private String name;
    private String type;
    private byte[] data;
    public AdImagePayload(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public AdImage toEntity(){
        return new AdImage(getId(), getName(), getType(), getData());
    }

}
