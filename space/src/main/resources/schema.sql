CREATE TABLE minute_stats (
    minute_start TIMESTAMP NOT NULL,
    unique_id_count INT NOT NULL,
    PRIMARY KEY (minute_start)
);