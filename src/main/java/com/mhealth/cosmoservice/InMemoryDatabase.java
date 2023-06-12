package main.java.com.mhealth.cosmoservice;

import main.java.com.mhealth.cosmoservice.models.*;

import java.util.ArrayList;
import java.util.Date;

public class InMemoryDatabase {
    public static ArrayList<Account> AccountTable = new ArrayList();
//    public static ArrayList<AccountData> AccountDataTable = new ArrayList();
    public static ArrayList<SoundClip> SoundClipTable = new ArrayList();
    public static ArrayList<Resource> ResourceTable = new ArrayList();

    public static void InitInMemoryDatabase() {
        AccountTableInit();
//        AccountDataTableInit();
//        SoundClipTableInit();
//        ResourceTableInit();
    }

    private static void AccountTableInit() {
//        // conorloughran99
//        var parentAccount = Account.builder().accountId("117961479542614585037").accountType("parent").build();
//        // mhealth
//        var therapistAccount = Account.builder().accountId("109020841686505071523").accountType("therapist").build();
//        AccountTable.add(parentAccount);
//        AccountTable.add(therapistAccount);
    }

//    private static void AccountDataTableInit() {
//        var patientAccountData = new Parent("117961479542614585037", "Conor", "Loughran");
//        patientAccountData.setChild(
//                Child
//                        .builder()
//                        .parent(patientAccountData.getFullName())
//                        .firstname("Sam")
//                        .surname("Foley")
//                        .build()
//        );
//
//        var listOfAwards = new ArrayList<Award>();
//        listOfAwards.add(Award.builder().awardCost(7).awardTitle("Go to the cinema").build());
//        listOfAwards.add(Award.builder().awardCost(7).awardTitle("Go to the arcade").build());
//        listOfAwards.add(Award.builder().awardCost(7).awardTitle("Get a £20 Fortnite card").build());
//        listOfAwards.add(Award.builder().awardCost(5).awardTitle("Go to the park").build());
//        listOfAwards.add(Award.builder().awardCost(3).awardTitle("1 hour on xbox").build());
//        patientAccountData.setListOfAwards(listOfAwards);
//
//        var therapistAccountData = new Therapist("109020841686505071523", "Max", "Dean");
//        var patientList = new ArrayList<String>();
//        patientList.add(patientAccountData.getGoogleId());
//        therapistAccountData.setListOfPatientsIds(patientList);
//
//        AccountDataTable.add(patientAccountData);
//        AccountDataTable.add(therapistAccountData);
//    }
//
//    private static void SoundClipTableInit() {
//        var soundClipOne = SoundClip
//                .builder()
//                .id(1)
//                .word("Tea")
//                .sound("ee")
//                .date(new Date())
//                .build();
//        var soundClipTwo = SoundClip
//                .builder()
//                .id(2)
//                .word("Pea")
//                .sound("ee")
//                .date(new Date())
//                .build();
//        var soundClipThree = SoundClip
//                .builder()
//                .id(3)
//                .word("See")
//                .sound("ee")
//                .date(new Date())
//                .build();
//        var soundClipFour = SoundClip
//                .builder()
//                .id(4)
//                .word("Knee")
//                .sound("ee")
//                .date(new Date())
//                .build();
//
//        SoundClipTable.add(soundClipOne);
//        SoundClipTable.add(soundClipTwo);
//        SoundClipTable.add(soundClipThree);
//        SoundClipTable.add(soundClipFour);
//    }
//
//    private static void ResourceTableInit() {
//        String LOREM_IPSUM = "Donec varius, libero quis dapibus varius, diam arcu commodo eros, vitae ultrices justo purus vel ipsum. Praesent consectetur lectus lacus, et mattis dolor sollicitudin quis. Nulla lobortis nisi id quam tristique, id semper mauris accumsan. Mauris a mauris vehicula, molestie tortor eget, ornare diam. Aenean volutpat nunc non sapien malesuada placerat. Donec fringilla dictum orci, ut fringilla massa commodo vitae. Praesent auctor ullamcorper eros in faucibus. Pellentesque aliquet purus lacus, sed pulvinar arcu fermentum vitae. Vivamus sollicitudin lacus id interdum laoreet. Proin hendrerit laoreet efficitur. Aenean nec leo eget ligula elementum porta. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis ac lorem sit amet lorem pulvinar vestibulum eu sed nisl.";
//        var topicOne = ResourceTopic
//                .builder()
//                .topicName("Some Topic One")
//                .topicContent(LOREM_IPSUM)
//                .build();
//        var topicTwo = ResourceTopic
//                .builder()
//                .topicName("Some Topic Two")
//                .topicContent(LOREM_IPSUM)
//                .build();
//        var topicThree = ResourceTopic
//                .builder()
//                .topicName("Some Topic Three")
//                .topicContent(LOREM_IPSUM)
//                .build();
//        var topicList = new ArrayList<ResourceTopic>();
//        topicList.add(topicOne);
//        topicList.add(topicTwo);
//        topicList.add(topicThree);
//        var resourceOne = Resource
//                .builder()
//                .id(1)
//                .title("Resource One")
//                .topicList(topicList)
//                .build();
//
//        var resourceTwo = Resource
//                .builder()
//                .id(2)
//                .title("Resource Two")
//                .topicList(topicList)
//                .build();
//        ResourceTable.add(resourceOne);
//        ResourceTable.add(resourceTwo);
//    }

}
