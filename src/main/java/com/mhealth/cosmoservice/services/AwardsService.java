package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.models.Award;
import main.java.com.mhealth.cosmoservice.repositories.AwardsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardsService {
    private AwardsRepository awardsRepository;

    public AwardsService(AwardsRepository awardsRepository) {
        this.awardsRepository = awardsRepository;
    }

    public List<Award> getAllAwardsForId(int id) {
        return awardsRepository.findByParentIdIs(id);
    }

    public void createNewAward(Award award) {
        awardsRepository.save(award);
    }
}
