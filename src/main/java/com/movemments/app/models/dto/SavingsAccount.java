package com.movemments.app.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class SavingsAccount {
    private String id;
    private String naccount;//numero de cuenta
    private String currency; //tipo de moneda soles o dolares
    private String dni; //dni del usuario registrado
    private String type; // tipo de cuenta
    private Boolean maintenance; //true o false
    private Double mcommission; // comision si que hay mantenimiento
    private Boolean limittransaction; // limete de transacciones
    private Integer limit; //0 si no hay limite de transacciones
    private String frequency; // mensualmente/ monthly
    private Double amount; //monto de la cuenta
    private Integer condition; //atributo interno cambiante
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    private Card card;
}
