package com.alexssw.desafio.bb.cotacao.api.service;

import com.alexssw.desafio.bb.cotacao.api.model.dto.CounterCurrencyDto;
import com.alexssw.desafio.bb.cotacao.api.model.dto.TypeDollarQuoteDto;
import com.alexssw.desafio.bb.cotacao.api.model.entity.CounterCurrency;
import com.alexssw.desafio.bb.cotacao.api.repository.CounterCurrencyRepository;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class CounterCurrencyService {

    private static final String PURCHASE_PRICE = "cotacaoCompra";
    private static final String SALES_PRICE = "cotacaoVenda";
    private static final String DATE_TIME_QUOTATION = "dataHoraCotacao";

    @Autowired
    OLindaBCBService oLindaBCBService;

    @Autowired
    CounterCurrencyRepository counterCurrencyRepository;

    private ModelMapper mapper = new ModelMapper();

    public CounterCurrencyDto getCounterCurrency(@NonNull final LocalDate targetDate) throws IOException {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String quoteDate = targetDate.format(format);
        TypeDollarQuoteDto typeDollarQuoteDto = oLindaBCBService.getTypeDollarQuoteDto(quoteDate);

        BigDecimal purchasePrice = BigDecimal.valueOf((Double) typeDollarQuoteDto.getValue()
                .get(0).get(PURCHASE_PRICE));
        final BigDecimal salesQuote = BigDecimal.valueOf((Double) typeDollarQuoteDto.getValue().get(0).get(SALES_PRICE));
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        final LocalDateTime dateTimeQuotation = LocalDateTime.parse(
                (CharSequence) typeDollarQuoteDto.getValue().get(0).get(DATE_TIME_QUOTATION), formatter);

        CounterCurrencyDto counterCurrencyDto = CounterCurrencyDto.builder()
                .id(UUID.randomUUID().toString())
                .requestTimestamp(LocalDateTime.now())
                .dateQuotation(targetDate)
                .purchasePrice(purchasePrice)
                .salesQuote(salesQuote)
                .dateTimeQuotation(dateTimeQuotation)
                .build();

        CounterCurrency counterCurrency = mapper.map(counterCurrencyDto, CounterCurrency.class);
        counterCurrencyRepository.save(counterCurrency);

        return counterCurrencyDto;

    }
}
