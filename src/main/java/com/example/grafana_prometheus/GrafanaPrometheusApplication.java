package com.example.grafana_prometheus;

import io.nats.client.Connection;
import io.nats.client.Message;
import io.nats.client.impl.NatsMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

@RestController
@SpringBootApplication
public class GrafanaPrometheusApplication {

	@Autowired
	private Connection natsConnection;

	final static Logger logger = LoggerFactory.getLogger(GrafanaPrometheusApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GrafanaPrometheusApplication.class, args);
	}

	@GetMapping("/something")
	public ResponseEntity<String> createLogs() {
		logger.warn("Just checking");
		return ResponseEntity.ok().body("All Ok");
	}

	@GetMapping("/path1")
	public ResponseEntity<String> path1() throws InterruptedException {
		logger.warn("Just checking path1");

		Message request = NatsMessage.builder()
				.subject("grafana.sub")
				.data("eventJson".getBytes(StandardCharsets.UTF_8))
				.build();

		Message replyMessage = natsConnection.request(request, Duration.ofSeconds(5));
		return ResponseEntity.ok().body("All Ok from Path1");
	}
}
