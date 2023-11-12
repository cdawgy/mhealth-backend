package main.java.com.mhealth.cosmoservice;

import main.java.com.mhealth.cosmoservice.models.*;

import java.util.ArrayList;
import java.util.Date;

public class InMemoryDatabase {
    public static ArrayList<Account> AccountTable = new ArrayList();
    public static ArrayList<Parent> ParentTable = new ArrayList();
    public static ArrayList<Child> ChildTable = new ArrayList();
    public static ArrayList<Award> AwardTable = new ArrayList();
    public static ArrayList<Therapist> TherapistTable = new ArrayList();
    public static ArrayList<Message> MessageTable = new ArrayList();
    public static ArrayList<Resource> ResourceTable = new ArrayList();
    public static ArrayList<Word> WordsTable = new ArrayList();
    public static ArrayList<Prescription> PrescriptionTable = new ArrayList();
    public static ArrayList<SoundClip> SoundsTable = new ArrayList();

    private static int PARENT_ACCOUNT_ID = 1;
    public static String PARENT_ACCOUNT_GOOGLE_ID = "117961479542614585037";
    private static int THERAPIST_ACCOUNT_ID = 2;
    public static String THERAPIST_ACCOUNT_GOOGLE_ID = "109020841686505071523";

    public static void InitInMemoryDatabase() {
        AccountTableInit();
        ParentTableInit();
        ChildTableInit();
        AwardTableInit();
        TherapistTableInit();
        MessageTableInit();
        ResourceTableInit();
        WordsTableInit();
        PrescriptionTableInit();
        SoundsTableInit();
    }

    private static void AccountTableInit() {
        // conorloughran99
        var parentAccount = Account.builder().id(PARENT_ACCOUNT_ID).googleId("117961479542614585037").accountType("parent").build();
        // mhealth
        var therapistAccount = Account.builder().id(THERAPIST_ACCOUNT_ID).googleId("109020841686505071523").accountType("therapist").build();
        AccountTable.add(parentAccount);
        AccountTable.add(therapistAccount);
    }

    private static void ParentTableInit() {
        var parentAccount = Parent.getInstance(PARENT_ACCOUNT_GOOGLE_ID, "Conor", "Loughran", 1, 1);
        ParentTable.add(parentAccount);
    }

    private static void ChildTableInit() {
        var child = Child.getInstance(PARENT_ACCOUNT_ID, "Sam");
        ChildTable.add(child);
    }

    private static void AwardTableInit() {
        var award = Award.builder().id(1).cost(3).parentId(1).title("Some Award").build();
        AwardTable.add(award);
    }

    private static void TherapistTableInit() {
        var therapist = Therapist.builder()
                .id(1)
                .googleId(THERAPIST_ACCOUNT_GOOGLE_ID)
                .firstName("Max")
                .surname("Dean")
                .build();
        TherapistTable.add(therapist);
    }

    private static void MessageTableInit() {
        var message = Message.builder()
                .id(1)
                .parentId(1)
                .readState("read")
                .messageBody("Some wicked message.")
                .resourceId(1)
                .build();
        MessageTable.add(message);
    }

    private static void ResourceTableInit() {
        var resource = Resource.builder()
                .id(1)
                .title("Some Resource")
                .content("Some resource content.")
                .build();
        ResourceTable.add(resource);
    }

    private static void WordsTableInit() {
        var word = Word.builder()
                .id(1)
                .word("Tea")
                .image_url("someImgUrl")
                .phonemes("/e/")
                .build();
        WordsTable.add(word);
    }

    private static void PrescriptionTableInit() {
        var prescription = Prescription.builder()
                .id(1)
                .parentId(1)
                .therapistId(1)
                .sessionTime(15)
                .sessionWordCount(10)
                .sessionWordSet("tbd")
                .sessionWordSetTitle("12/11/2023")
                .dateCreated(new Date())
                .build();
        PrescriptionTable.add(prescription);
    }

    private static void SoundsTableInit() {
        var sound = SoundClip.builder()
                .id(1)
                .childId(1)
                .sound("tbd")
                .word("tea")
                .locationUrl("")
                .dateCreated(new Date())
                .build();
        SoundsTable.add(sound);
    }
}
