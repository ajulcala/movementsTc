package com.movemments.app.services;

import com.movemments.app.models.documents.MovementsPersonal;
import com.movemments.app.models.dto.Card;
import com.movemments.app.models.dto.CurrentAccountPersonal;
import com.movemments.app.models.dto.FixedTermAccount;
import com.movemments.app.models.dto.SavingsAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementsPersonalService {
    public Flux<MovementsPersonal> findAll();
    public Mono<MovementsPersonal> findById(String id);
    public Flux<SavingsAccount> cardSavings(Card card);
    public Flux<MovementsPersonal> findByCard(Card card);

    public Mono<SavingsAccount> saveMon(MovementsPersonal movementsPersonal);

    public Mono<FixedTermAccount> saveFixed(MovementsPersonal movementsPersonal);
    public Flux<FixedTermAccount> cardFixed(Card card);

    public Flux<CurrentAccountPersonal> cardCurrentPersonal(Card card);
    public Mono<CurrentAccountPersonal> saveCurrentPersonal(MovementsPersonal movementsPersonal);
}
