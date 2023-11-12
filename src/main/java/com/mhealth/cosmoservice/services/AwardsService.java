package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.InMemoryDatabase;
import main.java.com.mhealth.cosmoservice.models.Award;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AwardsService {
//    private AwardsRepository awardsRepository;

    public AwardsService() {
//        this.awardsRepository = awardsRepository;
    }

    public List<Award> getAllAwardsForId(int id) {
//        return awardsRepository.findByParentIdIs(id);
        return InMemoryDatabase.AwardTable.stream().filter(award -> award.getParentId() == id).collect(Collectors.toList());
    }

    public void createNewAward(Award award) {
        // Nothing
    }
}
