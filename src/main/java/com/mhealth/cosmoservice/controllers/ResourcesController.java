package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.models.Resource;
import main.java.com.mhealth.cosmoservice.services.ResourcesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/resources")
public class ResourcesController {

    private ResourcesService resourcesService;

    public ResourcesController(ResourcesService resourcesService) {
        this.resourcesService = resourcesService;
    }

    @GetMapping("/all")
    public List<Resource> getResources() {
        return resourcesService.listAllResources();
    }

    @GetMapping("/resource/{resourceId}")
    public Resource getResourceById(@PathVariable Long resourceId) {
        return resourcesService.getResourceById(resourceId);
    }
}
