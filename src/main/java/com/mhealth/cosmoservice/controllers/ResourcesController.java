package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.models.Resource;
import main.java.com.mhealth.cosmoservice.services.ResourcesService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/resources")
public class ResourcesController {

    private ResourcesService resourcesService;

    public ResourcesController(ResourcesService resourcesService) {
        this.resourcesService = resourcesService;
    }

    @GetMapping("/all")
    public ArrayList<Resource> getResources() {
        return resourcesService.listAllResources();
    }

    @GetMapping("/resource/{resourceId}")
    public Resource getResourceById(@PathVariable int resourceId) {
        return resourcesService.getResourceById(resourceId);
    }
}
