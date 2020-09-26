/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.alexssw.desafio.bb.cotacao.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan({"com.alexssw.desafio.bb.cotacao.api"})
public class CounterCurrencyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CounterCurrencyApplication.class);
    }
}
