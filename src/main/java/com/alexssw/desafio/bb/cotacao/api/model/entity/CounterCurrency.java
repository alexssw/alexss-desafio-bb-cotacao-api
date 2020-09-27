package com.alexssw.desafio.bb.cotacao.api.model.entity;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "counter_currency", schema = "quote")
public class CounterCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "requestTimestamp", nullable = false)
    private LocalDateTime requestTimestamp;

    @NonNull
    @Temporal(TemporalType.DATE)
    @Column(name = "dateQuotation", nullable = false)
    private LocalDate dateQuotation;

    @NonNull
    @Column(name = "purchasePrice", nullable = false)
    private BigDecimal purchasePrice;

    @NonNull
    @Column(name = "salesQuote", nullable = false)
    private BigDecimal salesQuote;

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateTimeQuotation", nullable = false)
    private LocalDateTime dateTimeQuotation;

    public LocalDateTime getRequestTimestamp() {
        return requestTimestamp;
    }

    public void setRequestTimestamp(LocalDateTime requestTimestamp) {
        this.requestTimestamp = requestTimestamp;
    }

    public LocalDate getDateQuotation() {
        return dateQuotation;
    }

    public void setDateQuotation(LocalDate dateQuotation) {
        this.dateQuotation = dateQuotation;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSalesQuote() {
        return salesQuote;
    }

    public void setSalesQuote(BigDecimal salesQuote) {
        this.salesQuote = salesQuote;
    }

    public LocalDateTime getDateTimeQuotation() {
        return dateTimeQuotation;
    }

    public void setDateTimeQuotation(LocalDateTime dateTimeQuotation) {
        this.dateTimeQuotation = dateTimeQuotation;
    }
}
