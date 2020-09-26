package com.alexssw.desafio.bb.cotacao.api.model.dto;

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
public class CounterCurrencyDto implements Serializable {
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
