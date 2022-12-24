package advertiser.repository;

import advertiser.model.AdSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdSetRepository extends JpaRepository<AdSet, Long> {
}
