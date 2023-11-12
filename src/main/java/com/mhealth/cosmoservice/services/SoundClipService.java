package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.InMemoryDatabase;
import main.java.com.mhealth.cosmoservice.models.SoundClip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoundClipService {

    public SoundClipService() {
    }

    public List<SoundClip> getAllSoundClips() {
        return InMemoryDatabase.SoundsTable;
//        return soundsRepository.findAll();
    }

    public SoundClip getSoundClip(Long clipId) {
//        var optionalClip = InMemoryDatabase.SoundClipTable.stream().filter(soundClip -> soundClip.getId() == clipId).findAny();
//        return optionalClip.orElse(null);
        return InMemoryDatabase.SoundsTable.stream().filter(soundClip -> soundClip.getId() == clipId).findFirst().orElse(null);
    }
}
