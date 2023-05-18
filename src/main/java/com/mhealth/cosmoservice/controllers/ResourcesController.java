package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.services.ResourcesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/account")
public class ResourcesController {

    private ResourcesService resourcesService;

    public ResourcesController(ResourcesService resourcesService) {
        this.resourcesService = resourcesService;
    }

    @GetMapping
    public void getResources() {
        // TODO
    }
}
