package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.models.SoundClip;
import main.java.com.mhealth.cosmoservice.services.SoundClipService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/soundClips")
public class SoundClipController {
    private final SoundClipService soundClipService;

    public SoundClipController(SoundClipService soundClipService) {
        this.soundClipService = soundClipService;
    }

    @GetMapping("/all")
    public ArrayList<SoundClip> getAllSoundClips() {
        return soundClipService.getAllSoundClips();
    }

    @GetMapping("/clip/{clipId}")
    public SoundClip getAllSoundClips(@PathVariable int clipId) {
        return soundClipService.getSoundClip(clipId);
    }
}
