CREATE DATABASE db;

\c db

CREATE TABLE IF NOT EXISTS city(
    id         SERIAL,
    name       VARCHAR(255) NOT NULL,
    region     VARCHAR(255) NOT NULL,
    district   VARCHAR(255) NOT NULL,
    population INTEGER NOT NULL,
    foundation INTEGER NOT NULL,

    CONSTRAINT pk_city
        PRIMARY KEY (id),
    CONSTRAINT uq_city
        UNIQUE (name, region),
    CONSTRAINT ck_city
        CHECK (name != '' AND region != '' AND district != '')
)