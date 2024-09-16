"# grafana-prometheus" 


1. Start Promethes and grafana docker compose file with prometheus config yaml file updated
2. Start Nats server in monitoring mode nats-server -m 8222
3. Start Nats prometheus exporter with params: docker run -p 7777:7777 natsio/prometheus-nats-exporter:latest -varz -connz -subz -healthz http://localhost:8222
4. Start Java Spring Boot App
5. Start Golang App
6. Monitor NATS Metrics via urls like: http://localhost:8222/varz; 
7. Prometheus URL: http://host.docker.internal:9090/ check the targets are up or not
8. Monitor prometheus metrics for NATS via http://localhost:7777/metrics
9. Configure Grafana dashboard with specific parameters: http://localhost:3000
