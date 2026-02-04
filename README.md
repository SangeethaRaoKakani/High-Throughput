# High Throughput Request Ingestion & Metrics Service

This Spring Boot REST application ingests high-volume requests, deduplicates IDs per calendar minute, optionally calls external HTTP endpoints, and records per-minute unique ID counts.

GitHub Repository:
https://github.com/SangeethaRaoKakani/High-Throughput/tree/master/space

---

##  Features

- High-throughput GET API
- Per-minute ID deduplication
- Optional outbound HTTP GET call
- Scheduled per-minute aggregation
- Persistent storage using H2
- Clean layered architecture

---

## Tech Stack

| Component | Technology |
|---------|-----------|
| Language | Java 8 |
| Framework | Spring Boot |
| Build Tool | Maven |
| Database | H2 (In-Memory) |
| ORM | Spring Data JPA |
| HTTP Client | WebClient |
| Scheduler | @Scheduled |

---

##  REST API

### Endpoint
