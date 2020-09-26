package com.alexssw.desafio.bb.cotacao.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CounterCurrencyApi {
    private String id;
    private LocalDateTime timestamp;
    private LocalDate dateCounterCurrency;
    private BigDecimal purchasePrice;
    private BigDecimal salesQuote;
}
