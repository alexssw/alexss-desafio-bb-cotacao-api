package com.alexssw.desafio.bb.cotacao.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeDollarQuoteDto implements Serializable {

    @JsonProperty("@odata.context")
    private String context;

    @JsonProperty("value")
    private List<Map<String, Object>> value;
}
