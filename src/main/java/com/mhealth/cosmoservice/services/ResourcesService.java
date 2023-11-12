package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.InMemoryDatabase;
import main.java.com.mhealth.cosmoservice.models.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourcesService {

    public ResourcesService() {

    }

    public List<Resource> listAllResources() {
        return InMemoryDatabase.ResourceTable;
    }

    public Resource getResourceById(Long resourceId) {
//        var optionalResource = InMemoryDatabase.ResourceTable.stream().filter(resource -> resource.getId() == resourceId).findAny();
//        return optionalResource.orElse(null);
        return InMemoryDatabase.ResourceTable.stream().filter(resource -> resource.getId() == resourceId).findFirst().orElse(null);
    }
}
