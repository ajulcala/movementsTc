package com.movemments.app.models.dao;

import com.movemments.app.models.documents.MovementsBusiness;
import com.movemments.app.models.dto.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MovementsBusinessDao extends ReactiveMongoRepository<MovementsBusiness, String> {
    Flux<MovementsBusiness> findByCard(Card card);
}
