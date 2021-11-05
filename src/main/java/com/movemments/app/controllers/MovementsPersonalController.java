package com.movemments.app.controllers;

import com.movemments.app.models.documents.MovementsPersonal;
import com.movemments.app.models.dto.Card;
import com.movemments.app.models.dto.CurrentAccountPersonal;
import com.movemments.app.models.dto.FixedTermAccount;
import com.movemments.app.models.dto.SavingsAccount;
import com.movemments.app.services.MovementsPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class MovementsPersonalController {

    @Autowired
    private MovementsPersonalService service;

    @GetMapping
    public Flux<MovementsPersonal> list(){
        return service.findAll();
    }

    @PostMapping("/movements")
    public Flux<MovementsPersonal> findbycard(@Valid @RequestBody Card card){
        return service.findByCard(card);
    }

    @PostMapping("/checkbalance/savings")
    public Flux<SavingsAccount> carSavings(@Valid @RequestBody Card card){
        return service.cardSavings(card);
    }

    @PostMapping("/checkbalance/fixed")
    public Flux<FixedTermAccount> carfixed(@Valid @RequestBody Card card){
        return service.cardFixed(card);
    }

    @PostMapping("/checkbalance/currentpersonal")
    public Flux<CurrentAccountPersonal> carCurrentPersonal(@Valid @RequestBody Card card){
        return service.cardCurrentPersonal(card);
    }

    @PostMapping("/setsavings")
    public Mono<SavingsAccount> saveMonen(@Valid @RequestBody MovementsPersonal movementsPersonal){
        return service.saveMon(movementsPersonal);
    }

    @PostMapping("/setfixed")
    public Mono<FixedTermAccount> saveFixed(@Valid @RequestBody MovementsPersonal movementsPersonal){
        return service.saveFixed(movementsPersonal);
    }

    @PostMapping("/setcurrentpersonal")
    public Mono<CurrentAccountPersonal> saveCurrentPersonal(@Valid @RequestBody MovementsPersonal movementsPersonal){
        return service.saveCurrentPersonal(movementsPersonal);
    }
}
