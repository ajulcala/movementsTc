package com.movemments.app.services;

import com.movemments.app.models.dao.MovementsBusinessDao;
import com.movemments.app.models.documents.MovementsBusiness;
import com.movemments.app.models.dto.Card;
import com.movemments.app.models.dto.CurrentAccountBusiness;
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
public class MovementsBusinessServiceImpl implements MovementsBusinessService{
    @Value("${config.base.businesscard}")
    private String urlcc;

    @Value("${config.base.businesssaldo}")
    private String urlcs;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private MovementsBusinessDao dao;

    @Override
    public Flux<MovementsBusiness> findAll() {
        return dao.findAll();
    }

    @Override
    public Mono<MovementsBusiness> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Flux<MovementsBusiness> findByCAard(Card card) {
        return dao.findByCard(card);
    }

    @Override
    public Flux<CurrentAccountBusiness> cardCurrentBusiness(Card card) {
        Flux<CurrentAccountBusiness> current = webClientBuilder.build().post()
                .uri(urlcc)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(card),Card.class)
                .retrieve()
                .bodyToFlux(CurrentAccountBusiness.class);
        return current;
    }

    @Override
    public Mono<CurrentAccountBusiness> saveCurrentBusiness(MovementsBusiness movementsBusiness) {
        if(movementsBusiness.getCreateAt()==null){
            movementsBusiness.setCreateAt(new Date());
        }
        movementsBusiness.setTypemovements("Account Current Business");

        Flux<CurrentAccountBusiness> fiexd = webClientBuilder.build().put()
                .uri(urlcs)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(movementsBusiness),Card.class)
                .retrieve()
                .bodyToFlux(CurrentAccountBusiness.class);
        log.info("modificado saldo de cuenta cooriente empresarial");
        dao.save(movementsBusiness).subscribe();
        return fiexd.next();
    }
}
