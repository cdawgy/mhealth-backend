package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.models.SoundClip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class SoundClipService {

    private ArrayList<SoundClip> listOfSoundClips;

    public SoundClipService(){
        var soundClipOne = SoundClip
                .builder()
                .id(1)
                .word("Tea")
                .sound("ee")
                .date(new Date())
                .build();
        var soundClipTwo = SoundClip
                .builder()
                .id(2)
                .word("Pea")
                .sound("ee")
                .date(new Date())
                .build();
        var soundClipThree = SoundClip
                .builder()
                .id(3)
                .word("See")
                .sound("ee")
                .date(new Date())
                .build();
        var soundClipFour = SoundClip
                .builder()
                .id(4)
                .word("Knee")
                .sound("ee")
                .date(new Date())
                .build();

        listOfSoundClips = new ArrayList<>();
        listOfSoundClips.add(soundClipOne);
        listOfSoundClips.add(soundClipTwo);
        listOfSoundClips.add(soundClipThree);
        listOfSoundClips.add(soundClipFour);
    }

    public ArrayList<SoundClip> getAllSoundClips() {
        return listOfSoundClips;
    }

    public SoundClip getSoundClip(int clipId) {
        var optionalClip = listOfSoundClips.stream().filter(soundClip -> soundClip.getId() == clipId).findAny();
        return optionalClip.orElse(null);
    }
}
