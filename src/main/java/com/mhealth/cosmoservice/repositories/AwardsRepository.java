package main.java.com.mhealth.cosmoservice.repositories;

import main.java.com.mhealth.cosmoservice.models.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AwardsRepository extends JpaRepository<Award, Long> {
//    @Query(value = "SELECT * FROM awards WHERE parent_id=1", nativeQuery = true)
    List<Award> findByParentIdIs(int parentId);

//    @Query("select a from Award a where a.parentId = ?1")
//    List<Award> findAwardsByParentId(int parentId);


}
