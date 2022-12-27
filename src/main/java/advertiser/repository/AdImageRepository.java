package advertiser.repository;

import advertiser.model.AdImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdImageRepository extends JpaRepository<AdImage, String> {
}
