package main.java.com.mhealth.cosmoservice.controllers;

import com.azure.cosmos.implementation.AsyncDocumentClient;
import lombok.extern.slf4j.Slf4j;
import main.java.com.mhealth.cosmoservice.models.GameSessionModel;
import main.java.com.mhealth.cosmoservice.models.Player;
import main.java.com.mhealth.cosmoservice.models.ValidationRequest;
import main.java.com.mhealth.cosmoservice.models.Validator;
import main.java.com.mhealth.cosmoservice.repositories.GameSessionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class CrudController {
    private final GameSessionRepository gameSessionRepository;
    // TODO: Attempt deleting document from db, refactor into service for controller.
    @Value(value = "spring.cloud.azure.cosmos.endpoint")
    private String endpoint;
    @Value(value = "spring.cloud.azure.cosmos.key")
    private String key;

    public CrudController(GameSessionRepository gameSessionRepository) {
        this.gameSessionRepository = gameSessionRepository;
    }

    @GetMapping("/gameSession/{id}")
    Mono<GameSessionModel> findGameSessionById(@PathVariable String id) {
        Mono<GameSessionModel> gameSessionModelMono = gameSessionRepository.findById(id);
        return gameSessionModelMono;
    }

    @PostMapping("/gameSession/{id}/validate")
    Mono<GameSessionModel> updateGameSessionValidatorConnection(@PathVariable String id, @RequestBody ValidationRequest validationRequest) {
        Mono<GameSessionModel> gameSessionModelMono = gameSessionRepository.findById(id);
        Mono<Void> t = gameSessionRepository.deleteById("6cafa9c5-714e-4ac3-9f16-ffc446bf68c5");

//        gameSessionModelMono.subscribe((success) -> {
//            success.getValidator().setConnected(validationRequest.isValidatorConnected());
//            gameSessionRepository.save(success);
//        });
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
