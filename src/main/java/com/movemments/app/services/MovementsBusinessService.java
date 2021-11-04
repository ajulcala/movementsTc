package com.movemments.app.services;

import com.movemments.app.models.documents.MovementsBusiness;
import com.movemments.app.models.dto.Card;
import com.movemments.app.models.dto.CurrentAccountBusiness;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementsBusinessService {
    public Flux<MovementsBusiness> findAll();
    public Mono<MovementsBusiness> findById(String id);
    public Flux<MovementsBusiness> findByCAard(Card card);

    public Flux<CurrentAccountBusiness> cardCurrentBusiness(Card card);
    public Mono<CurrentAccountBusiness> saveCurrentBusiness(MovementsBusiness movementsBusiness);
}
