package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.InMemoryDatabase;
import main.java.com.mhealth.cosmoservice.models.SoundClip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SoundClipService {
    public SoundClipService(){

    }

    public ArrayList<SoundClip> getAllSoundClips() {
        return InMemoryDatabase.SoundClipTable;
    }

    public SoundClip getSoundClip(int clipId) {
        var optionalClip = InMemoryDatabase.SoundClipTable.stream().filter(soundClip -> soundClip.getId() == clipId).findAny();
        return optionalClip.orElse(null);
    }
}
