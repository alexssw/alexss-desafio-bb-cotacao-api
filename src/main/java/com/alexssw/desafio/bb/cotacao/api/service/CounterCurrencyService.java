package com.alexssw.desafio.bb.cotacao.api.service;

import com.alexssw.desafio.bb.cotacao.api.model.dto.CounterCurrencyDto;
import com.alexssw.desafio.bb.cotacao.api.model.dto.TypeDollarQuoteDto;
import lombok.NonNull;
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

    public CounterCurrencyDto getCounterCurrency(@NonNull final LocalDate targetDate) throws IOException {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String quoteDate = targetDate.format(format);
        TypeDollarQuoteDto typeDollarQuoteDto = oLindaBCBService.getTypeDollarQuoteDto(quoteDate);

        String requestTimestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        BigDecimal purchasePrice = BigDecimal.valueOf((Double) typeDollarQuoteDto.getValue()
                .get(0).get(PURCHASE_PRICE));
        BigDecimal salesQuote = BigDecimal.valueOf((Double) typeDollarQuoteDto.getValue().get(0).get(SALES_PRICE));
        String dateTimeQuotation = String.valueOf(typeDollarQuoteDto.getValue().get(0).get(DATE_TIME_QUOTATION));

        CounterCurrencyDto counterCurrencyDto = CounterCurrencyDto.builder()
                .id(UUID.randomUUID().toString())
                .requestTimestamp(requestTimestamp)
                .dateQuotation(quoteDate)
                .purchasePrice(purchasePrice)
                .salesQuote(salesQuote)
                .dateTimeQuotation(dateTimeQuotation)
                .build();

        return counterCurrencyDto;

    }
}
