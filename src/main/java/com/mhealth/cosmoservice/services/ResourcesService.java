package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.models.Resource;
import main.java.com.mhealth.cosmoservice.repositories.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourcesService {
    private ResourceRepository resourceRepository;

    public ResourcesService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<Resource> listAllResources() {
        return resourceRepository.findAll();
    }

    public Resource getResourceById(Long resourceId) {
//        var optionalResource = InMemoryDatabase.ResourceTable.stream().filter(resource -> resource.getId() == resourceId).findAny();
//        return optionalResource.orElse(null);
        return resourceRepository.findById(resourceId).orElse(null);
    }
}
