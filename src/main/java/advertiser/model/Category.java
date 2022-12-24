package advertiser.model;

import advertiser.payload.CategoryPayload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
//    @ElementCollection(targetClass = TYPE.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "category_type", joinColumns = @JoinColumn(name = "category_uid"))
    @Enumerated(EnumType.STRING)
    private TYPE type;

    public CategoryPayload toPayload(){
        return new CategoryPayload(getId(), getName(), getDescription(), getType());
    }
}
