package com.movemments.app.controllers;

import com.movemments.app.models.documents.MovementsBusiness;
import com.movemments.app.models.dto.Card;
import com.movemments.app.models.dto.CurrentAccountBusiness;
import com.movemments.app.services.MovementsBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("api/business")
public class MovementsBusinessController {
    @Autowired
    private MovementsBusinessService service;

    @GetMapping
    public Flux<MovementsBusiness> list(){
        return service.findAll();
    }

    @PostMapping("/movements")
    public Flux<MovementsBusiness> findbycard(@Valid @RequestBody Card card){
        return service.findByCAard(card);
    }

    @PostMapping("/checkbalance")
    public Flux<CurrentAccountBusiness> carBusiness(@Valid @RequestBody Card card){
        return service.cardCurrentBusiness(card);
    }

    @PostMapping("/setcurrentbusiness")
    public Mono<CurrentAccountBusiness> saveCurrentBusiness(@Valid @RequestBody MovementsBusiness movementsBusiness){
        return service.saveCurrentBusiness(movementsBusiness);
    }
}
