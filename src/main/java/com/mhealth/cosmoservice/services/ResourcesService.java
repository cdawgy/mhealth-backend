package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.models.Resource;
import main.java.com.mhealth.cosmoservice.models.ResourceTopic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ResourcesService {
    private ArrayList<Resource> listOfResources;
    private String LOREM_IPSUM = "Donec varius, libero quis dapibus varius, diam arcu commodo eros, vitae ultrices justo purus vel ipsum. Praesent consectetur lectus lacus, et mattis dolor sollicitudin quis. Nulla lobortis nisi id quam tristique, id semper mauris accumsan. Mauris a mauris vehicula, molestie tortor eget, ornare diam. Aenean volutpat nunc non sapien malesuada placerat. Donec fringilla dictum orci, ut fringilla massa commodo vitae. Praesent auctor ullamcorper eros in faucibus. Pellentesque aliquet purus lacus, sed pulvinar arcu fermentum vitae. Vivamus sollicitudin lacus id interdum laoreet. Proin hendrerit laoreet efficitur. Aenean nec leo eget ligula elementum porta. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis ac lorem sit amet lorem pulvinar vestibulum eu sed nisl.";

    public ResourcesService() {
        listOfResources = new ArrayList<>();
        var topicOne = ResourceTopic
                .builder()
                .topicName("Some Topic One")
                .topicContent(LOREM_IPSUM)
                .build();
        var topicTwo = ResourceTopic
                .builder()
                .topicName("Some Topic Two")
                .topicContent(LOREM_IPSUM)
                .build();
        var topicThree = ResourceTopic
                .builder()
                .topicName("Some Topic Three")
                .topicContent(LOREM_IPSUM)
                .build();
        var topicList = new ArrayList<ResourceTopic>();
        topicList.add(topicOne);
        topicList.add(topicTwo);
        var resourceOne = Resource
                .builder()
                .id(1)
                .title("Resource One")
                .topicList(topicList)
                .build();
        topicList.add(topicThree);
        var resourceTwo = Resource
                .builder()
                .id(2)
                .title("Resource Two")
                .topicList(topicList)
                .build();
        listOfResources.add(resourceOne);
        listOfResources.add(resourceTwo);
    }

    public ArrayList<Resource> listAllResources() {
        return listOfResources;
    }

    public Resource getResourceById(int resourceId) {
        var optionalResource = listOfResources.stream().filter(resource -> resource.getId() == resourceId).findAny();
        return optionalResource.orElse(null);
    }
}
