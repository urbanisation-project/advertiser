package advertiser.payload;

import advertiser.model.Category;
import advertiser.model.TYPE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryPayload {
    private Long id;
    private String name;
    private String description;
    private TYPE type;

    public Category toEntity(){
        return new Category(getId(), getName(), getDescription(), getType());
    }
}
