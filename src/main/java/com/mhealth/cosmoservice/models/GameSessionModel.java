package main.java.com.mhealth.cosmoservice.models;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.*;
import org.springframework.data.annotation.Id;

@Container(containerName = "game-sessions")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class GameSessionModel {
    @Id
    @GeneratedValue
    @PartitionKey
    private String id;
    @NonNull
    private Player player;
    @NonNull
    private Validator validator;
}
