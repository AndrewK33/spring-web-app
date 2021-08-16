BEGIN;


CREATE TABLE IF NOT EXISTS hibernate_homework.customers
(
    id bigint NOT NULL,
    name "text",
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS hibernate_homework.products
(
    id bigint NOT NULL,
    title "text",
    price "text",
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS hibernate_homework.customers_orders
(
    customers_id bigint NOT NULL,
    products_id bigint NOT NULL
);

ALTER TABLE hibernate_homework.customers_orders
    ADD FOREIGN KEY (customers_id)
    REFERENCES hibernate_homework.customers (id)
    NOT VALID;


ALTER TABLE hibernate_homework.customers_orders
    ADD FOREIGN KEY (products_id)
    REFERENCES hibernate_homework.products (id)
    NOT VALID;

END;