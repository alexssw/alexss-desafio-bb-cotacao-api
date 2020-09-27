package com.alexssw.desafio.bb.cotacao.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CounterCurrencyApi implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("requestTimestamp")
    private LocalDateTime requestTimestamp;

    @JsonProperty("dataCotacao")
    private LocalDate dateQuotation;

    @JsonProperty("cotacaoCompra")
    private BigDecimal purchasePrice;

    @JsonProperty("cotacaoVenda")
    private BigDecimal salesQuote;

    @JsonProperty("dataHoraCotacao")
    private LocalDateTime dateTimeQuotation;

}
