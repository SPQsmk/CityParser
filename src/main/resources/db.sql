CREATE DATABASE db;

\c db

CREATE TABLE IF NOT EXISTS city(
    city_id    SERIAL,
    city_name  VARCHAR(255) NOT NULL,
    region     VARCHAR(255) NOT NULL,
    district   VARCHAR(255) NOT NULL,
    population INTEGER NOT NULL,
    foundation INTEGER NOT NULL,

    CONSTRAINT pk_city
        PRIMARY KEY (city_id),
    CONSTRAINT uq_city
        UNIQUE (city_name, region),
    CONSTRAINT ck_city
        CHECK (city_name != '' AND region != '' AND district != '')
)