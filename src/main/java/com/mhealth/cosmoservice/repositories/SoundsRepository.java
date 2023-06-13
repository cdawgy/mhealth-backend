package main.java.com.mhealth.cosmoservice.repositories;

import main.java.com.mhealth.cosmoservice.models.SoundClip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoundsRepository extends JpaRepository<SoundClip, Long> {

}
