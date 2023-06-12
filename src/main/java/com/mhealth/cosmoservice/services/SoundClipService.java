package main.java.com.mhealth.cosmoservice.services;

import main.java.com.mhealth.cosmoservice.models.SoundClip;
import main.java.com.mhealth.cosmoservice.repositories.SoundsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoundClipService {
    private SoundsRepository soundsRepository;

    public SoundClipService(SoundsRepository soundsRepository) {
        this.soundsRepository = soundsRepository;
    }

    public List<SoundClip> getAllSoundClips() {
//        return InMemoryDatabase.SoundClipTable;
        return soundsRepository.findAll();
    }

    public SoundClip getSoundClip(Long clipId) {
//        var optionalClip = InMemoryDatabase.SoundClipTable.stream().filter(soundClip -> soundClip.getId() == clipId).findAny();
//        return optionalClip.orElse(null);
        return soundsRepository.findById(clipId).orElse(null);
    }
}
