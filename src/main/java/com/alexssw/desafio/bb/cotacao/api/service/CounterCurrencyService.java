package com.alexssw.desafio.bb.cotacao.api.service;

import com.alexssw.desafio.bb.cotacao.api.model.dto.CounterCurrencyDto;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CounterCurrencyService {
    public CounterCurrencyDto getCounterCurrency(@NonNull final LocalDate targetDate) {
        return CounterCurrencyDto.builder().build();
    }
}
