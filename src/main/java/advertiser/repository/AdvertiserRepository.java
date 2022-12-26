package advertiser.repository;

import advertiser.model.Advertiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiserRepository extends JpaRepository<Advertiser, Long> {
    Advertiser findByEmailAndPassword(String mail, String password);
}
