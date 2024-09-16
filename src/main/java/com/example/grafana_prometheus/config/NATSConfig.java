package com.example.grafana_prometheus.config;

import io.nats.client.Connection;
import io.nats.client.Nats;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class NATSConfig {

    @Bean
    public Connection natsConnection() throws IOException, InterruptedException {
        return Nats.connect("nats://localhost:4222");
    }
}