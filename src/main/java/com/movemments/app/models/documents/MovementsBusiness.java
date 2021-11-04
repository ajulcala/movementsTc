package com.movemments.app.models.documents;

import com.movemments.app.models.dto.Card;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Document(collection="movements_business")
public class MovementsBusiness {
    @Id
    private String id;
    private String typemovements;
    private Integer condition; //0 - retiro/ 1 - deposito
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
    private Double amount;
    private Card card;
}
