package com.alexssw.desafio.bb.cotacao.api.controller;

import com.alexssw.desafio.bb.cotacao.api.controller.dto.CounterCurrencyApi;
import com.alexssw.desafio.bb.cotacao.api.service.CounterCurrencyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;

@Validated
@RestController
@RequestMapping(value = "cotacao")
@Api(value = "Desafio BB Cotação Dollar ", tags = {"Cotação Moeda Dollar"})
@Slf4j
public class CounterCurrencyController {

    private static final String DOLLAR_QUOTE_CHALLENGE_HEALTH_CHECK = "Desafio BB Cotação do Dollar - Health Check";
    private static final String DATE_PATTERN = "MM-dd-yyyy";

    @Autowired
    private CounterCurrencyService counterCurrencyService;
    private ModelMapper mapper = new ModelMapper();

    @RequestMapping(value = "/health",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> healthCheckReport() {
        return ResponseEntity.ok(DOLLAR_QUOTE_CHALLENGE_HEALTH_CHECK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "200 Ok."),
            @ApiResponse(code = 401, message = "401 Unauthorized."),
            @ApiResponse(code = 403, message = "403 Forbidden."),
            @ApiResponse(code = 404, message = "404 Not Found."),
            @ApiResponse(code = 500, message = "500 Internal Server Error."),
    })
    @ApiOperation(value = "Dollar Quote")
    @RequestMapping(value = "/dollar",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CounterCurrencyApi getAdjustViewReport(
            @RequestParam(name = "targetDate") @DateTimeFormat(pattern = DATE_PATTERN) LocalDate targetDate)
            throws IOException {
        return mapper.map(counterCurrencyService.getCounterCurrency(targetDate), CounterCurrencyApi.class);
    }
}
