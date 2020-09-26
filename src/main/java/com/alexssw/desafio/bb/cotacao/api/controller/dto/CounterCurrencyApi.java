package com.alexssw.desafio.bb.cotacao.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CounterCurrencyApi implements Serializable {
    @JsonProperty("id")
    private String id;
    @JsonProperty("requestTimestamp")
    private String requestTimestamp;
    @JsonProperty("dataCotacao")
    private String dateQuotation;
    @JsonProperty("cotacaoCompra")
    private BigDecimal purchasePrice;
    @JsonProperty("cotacaoVenda")
    private BigDecimal salesQuote;
    @JsonProperty("dataHoraCotacao")
    private String dateTimeQuotation;
}
