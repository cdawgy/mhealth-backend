package main.java.com.mhealth.cosmoservice.repositories;

import main.java.com.mhealth.cosmoservice.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    List<Parent> findByGoogleIdIs(String googleId);

    @Query(value = "SELECT * FROM parents WHERE therapist_id=:therapistId", nativeQuery = true)
    List<Parent> findAllParentsForTherapistOfId(@Param("therapistId") int therapistId);
}
