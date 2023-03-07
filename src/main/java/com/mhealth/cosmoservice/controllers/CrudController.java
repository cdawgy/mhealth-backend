package main.java.com.mhealth.cosmoservice.controllers;

import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.models.GameSessionModel;
import main.java.com.mhealth.cosmoservice.models.Player;
import main.java.com.mhealth.cosmoservice.models.Validator;
import main.java.com.mhealth.cosmoservice.repositories.GameSessionRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@CrossOrigin(origins = "http://192.168.0.38:3000")
public class CrudController {
    private final GameSessionRepository gameSessionRepository;

    public CrudController(GameSessionRepository gameSessionRepository) {
        this.gameSessionRepository = gameSessionRepository;
    }

    @GetMapping("/test")
    String test() {
        return "HTTPS!!";
    }

    @GetMapping("/gameSession/{id}")
    Mono<GameSessionModel> findGameSessionById(@PathVariable String id) {
        Mono<GameSessionModel> gameSessionModelMono = gameSessionRepository.findById(id);
        return gameSessionModelMono;
    }

    @PostMapping("/createSession")
    Mono<GameSessionModel> createSession() {
        GameSessionModel newSession = new GameSessionModel(
                new Player(false),
                new Validator(false, false)
        );
        return gameSessionRepository.save(newSession);
//        gameSessionModelMono.subscribe(
//                (successResp) -> {
//                    log.info(successResp.toString());
//                },
//                (errorResp) -> {
//                    log.error("SOMETHING BROKE!");
//                    log.error(errorResp.getMessage());
//                },
//                () -> {
//                    log.info("Completed");
//                }
//        );
    }
}
