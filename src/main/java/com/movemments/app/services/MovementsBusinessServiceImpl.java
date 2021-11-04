package com.movemments.app.services;

import com.movemments.app.models.documents.MovementsBusiness;
import com.movemments.app.models.dto.Card;
import com.movemments.app.models.dto.CurrentAccountBusiness;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovementsBusinessServiceImpl implements MovementsBusinessService{
    @Override
    public Flux<MovementsBusiness> findAll() {
        return null;
    }

    @Override
    public Mono<MovementsBusiness> findById(String id) {
        return null;
    }

    @Override
    public Flux<MovementsBusiness> findByCAard(Card card) {
        return null;
    }

    @Override
    public Flux<CurrentAccountBusiness> cardCurrentBusiness(Card card) {
        return null;
    }

    @Override
    public Mono<CurrentAccountBusiness> saveCurrentBusiness(MovementsBusiness movementsBusiness) {
        return null;
    }
}
