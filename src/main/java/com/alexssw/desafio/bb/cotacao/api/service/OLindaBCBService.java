package com.alexssw.desafio.bb.cotacao.api.service;

import com.alexssw.desafio.bb.cotacao.api.model.dto.TypeDollarQuoteDto;
import com.alexssw.desafio.bb.cotacao.api.model.util.ParameterStringBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class OLindaBCBService {

    private static final String GET = "GET";
    private static final String DATA_COTACAO_KEY = "%40dataCotacao";
    private static final String FORMAT_KEY = "%24format";
    private static final String DEFAULT_JSON_FORMAT = "json";
    private static final String CONTENT_TYPE_KEY = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json";

    @Value("${olinda.service.url}")
    private String targetURL;

    @Value("${olinda.service.connect.timeout}")
    private Integer targetConnectTimeout;

    @Value("${olinda.service.read.timeout}")
    private Integer targetReadTimeout;

    ObjectMapper mapper;

    @PostConstruct
    public void init() {
        mapper = new ObjectMapper();
    }

    public TypeDollarQuoteDto getTypeDollarQuoteDto(String quoteDate) throws IOException {

        Map<String, String> parameters = new HashMap<>();
        parameters.put(DATA_COTACAO_KEY, String.format("'%s'", quoteDate));
        parameters.put(FORMAT_KEY, DEFAULT_JSON_FORMAT);

        String json = this.invokeService(parameters).toString();
        TypeDollarQuoteDto typeDollarQuoteDto = mapper.readValue(json, TypeDollarQuoteDto.class);
        return typeDollarQuoteDto;
    }

    private StringBuffer invokeService(@NonNull final Map<String, String> parameters) throws IOException {

        URL url = new URL(targetURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(GET);
        connection.setDoOutput(Boolean.TRUE);
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();
        Integer responseCode = connection.getResponseCode();

        StringBuffer response = new StringBuffer();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
        }
        connection.disconnect();
        return response;
    }
}
