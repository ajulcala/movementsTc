package com.movemments.app.models.dao;

import com.movemments.app.models.documents.MovementsPersonal;
import com.movemments.app.models.dto.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MovementsPersonalDao extends ReactiveMongoRepository<MovementsPersonal, String> {
    Flux<MovementsPersonal> findByCard(Card card);
}
