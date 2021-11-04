package com.movemments.app.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CurrentAccountBusiness {
    private String id;
    private String naccount;//numero de cuenta
    private String currency; //tipo de moneda soles o dolares
    private String type; // tipo de cuenta
    private String ruc; //ruc de la empresa
    private Boolean maintenance; //true o false
    private Double mcommission; // comision si que hay mantenimiento
    private Boolean limittransaction; // limete de transacciones
    private Integer limit; //0 si no hay limite de transacciones
    private Double amount; //monto de la cuenta
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
    private Integer condition; //0 - retiro/ 1 - deposito
    private Card card;
    private List<Owners> owners; //titulares
    private List<Signatories> signatories; //firmantes
}
