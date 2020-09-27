package com.alexssw.desafio.bb.cotacao.api.repository;

import com.alexssw.desafio.bb.cotacao.api.model.entity.CounterCurrency;
import org.springframework.data.repository.CrudRepository;

public interface CounterCurrencyRepository extends CrudRepository<CounterCurrency, Long> {

}
