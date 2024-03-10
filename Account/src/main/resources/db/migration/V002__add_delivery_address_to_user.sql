CREATE SEQUENCE IF NOT EXISTS hc_account.delivery_address_seq START WITH 1 INCREMENT BY 1;


CREATE TABLE hc_account.delivery_addresses
(
    id           BIGINT PRIMARY KEY,
    house_number VARCHAR(255) NOT NULL,
    street       VARCHAR(255) NOT NULL,
    city         VARCHAR(255) NOT NULL,
    state        VARCHAR(255) NOT NULL,
    zip_code     VARCHAR(255) NOT NULL,
    country      VARCHAR(255) NOT NULL
);

CREATE TABLE hc_account.user_delivery_address
(
    user_id    BIGINT NOT NULL,
    delivery_address_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, delivery_address_id),
    FOREIGN KEY (user_id) REFERENCES hc_account.users (id),
    FOREIGN KEY (delivery_address_id) REFERENCES hc_account.delivery_addresses (id)
);
