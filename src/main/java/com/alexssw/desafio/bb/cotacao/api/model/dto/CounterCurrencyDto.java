package com.alexssw.desafio.bb.cotacao.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CounterCurrencyDto implements Serializable {

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
