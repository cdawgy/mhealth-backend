package main.java.com.mhealth.cosmoservice.repositories;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import main.java.com.mhealth.cosmoservice.models.GameSessionModel;
import reactor.core.publisher.Mono;

public interface GameSessionRepository extends ReactiveCosmosRepository<GameSessionModel, String> {
}
