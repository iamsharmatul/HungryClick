CREATE SCHEMA IF NOT EXISTS hc_account;

CREATE SEQUENCE IF NOT EXISTS hc_account.user_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE hc_account.users
(
    id         BIGINT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    gender     VARCHAR(255) NOT NULL,
    phone      VARCHAR(255) NOT NULL
);
