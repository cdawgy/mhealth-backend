package main.java.com.mhealth.cosmoservice.repositories;

import main.java.com.mhealth.cosmoservice.models.Therapist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TherapistRepository extends JpaRepository<Therapist, Long> {
    List<Therapist> findByGoogleIdIs(String googleId);
}
