package com.movemments.app.services;

import com.movemments.app.models.dao.MovementsPersonalDao;
import com.movemments.app.models.documents.MovementsPersonal;
import com.movemments.app.models.dto.Card;
import com.movemments.app.models.dto.CurrentAccountPersonal;
import com.movemments.app.models.dto.FixedTermAccount;
import com.movemments.app.models.dto.SavingsAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
@Slf4j
@Service
public class MovementsPersonalServiceImpl implements MovementsPersonalService{
    @Value("${config.base.savingsaccount}")
    private String url;

    @Value("${config.base.savingssaldo}")
    private String urlx;

    @Value("${config.base.fixedcar}")
    private String urlfc;

    @Value("${config.base.fixedsaldo}")
    private String urlfs;

    @Value("${config.base.currentcard}")
    private String urlcc;

    @Value("${config.base.currentsaldo}")
    private String urlcs;

    @Autowired
    private WebClient.Builder webClientBuilder;


    @Autowired
    private MovementsPersonalDao dao;
    @Override
    public Flux<MovementsPersonal> findAll() {
        return dao.findAll();
    }

    @Override
    public Mono<MovementsPersonal> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Flux<SavingsAccount> cardSavings(Card card) {
        Flux<SavingsAccount> savings = webClientBuilder.build().post()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(card),Card.class)
                .retrieve()
                .bodyToFlux(SavingsAccount.class);
        return savings;
    }

    @Override
    public Flux<MovementsPersonal> findByCard(Card card) {
        return dao.findByCard(card);
    }

    @Override
    public Mono<SavingsAccount> saveMon(MovementsPersonal movementsPersonal) {
        if(movementsPersonal.getCreateAt()==null){
            movementsPersonal.setCreateAt(new Date());
        }

        movementsPersonal.setTypemovements("Account Savings");
        dao.save(movementsPersonal).subscribe();
        Flux<SavingsAccount> savings = webClientBuilder.build().put()
                .uri(urlx)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(movementsPersonal),Card.class)
                .retrieve()
                .bodyToFlux(SavingsAccount.class);
        log.info("saldo modificado en la cuenta de ahorro");
        return savings.next().defaultIfEmpty(new SavingsAccount());
    }

    @Override
    public Mono<FixedTermAccount> saveFixed(MovementsPersonal movementsPersonal) {
        if(movementsPersonal.getCreateAt()==null){
            movementsPersonal.setCreateAt(new Date());
        }
        movementsPersonal.setTypemovements("Account Fixed");

        Flux<FixedTermAccount> fiexd = webClientBuilder.build().put()
                .uri(urlfs)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(movementsPersonal),Card.class)
                .retrieve()
                .bodyToFlux(FixedTermAccount.class);
        log.info("saldo modificado en la cuenta a plazo fijo");
        dao.save(movementsPersonal).subscribe();
        return fiexd.next();
    }

    @Override
    public Flux<FixedTermAccount> cardFixed(Card card) {
        Flux<FixedTermAccount> fixed = webClientBuilder.build().post()
                .uri(urlfc)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(card),Card.class)
                .retrieve()
                .bodyToFlux(FixedTermAccount.class);
        return fixed;
    }

    @Override
    public Flux<CurrentAccountPersonal> cardCurrentPersonal(Card card) {
        Flux<CurrentAccountPersonal> current = webClientBuilder.build().post()
                .uri(urlcc)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(card),Card.class)
                .retrieve()
                .bodyToFlux(CurrentAccountPersonal.class);
        return current;
    }

    @Override
    public Mono<CurrentAccountPersonal> saveCurrentPersonal(MovementsPersonal movementsPersonal) {
        if(movementsPersonal.getCreateAt()==null){
            movementsPersonal.setCreateAt(new Date());
        }
        movementsPersonal.setTypemovements("Account Current Personal");

        Flux<CurrentAccountPersonal> fiexd = webClientBuilder.build().put()
                .uri(urlcs)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(movementsPersonal),Card.class)
                .retrieve()
                .bodyToFlux(CurrentAccountPersonal.class);
        log.info("saldo modificado en la cuenta corriente personal");
        dao.save(movementsPersonal).subscribe();
        return fiexd.next();
    }
}
