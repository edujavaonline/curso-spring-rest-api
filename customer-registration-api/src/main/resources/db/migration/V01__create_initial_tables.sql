CREATE TABLE state (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(80) NOT NULL,
    PRIMARY KEY (id)
) engine=InnoDB default charset=utf8;

CREATE TABLE city (
    id BIGINT NOT NULL AUTO_INCREMENT,
    state_id BIGINT NOT NULL,
    name VARCHAR(80) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_city_state FOREIGN KEY (state_id) REFERENCES state (id)
) engine=InnoDB default charset=utf8;

CREATE TABLE customer_register (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(80) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    gender VARCHAR(9),
    birth_date DATE NOT NULL,
    active TINYINT(1) NOT NULL,
    create_date DATETIME NOT NULL,
    update_date DATETIME NOT NULL,

    address_id_city BIGINT NOT NULL,
    address_zip_code VARCHAR(9) NOT NULL,
    address_street_name VARCHAR(100) NOT NULL,
    address_number VARCHAR(20) NOT NULL,
    address_complement VARCHAR(80),
    address_neighborhood VARCHAR(60) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_client_city FOREIGN KEY (address_id_city) REFERENCES city (id)
) engine=InnoDB default charset=utf8;

INSERT INTO state (name) VALUES
('Minas Gerais'),
('São Paulo'),
('Ceará');

INSERT INTO city (name, state_id) VALUES
('Uberlândia', 1),
('Belo Horizonte', 1),
('São Paulo', 2),
('Campinas', 2),
('Fortaleza', 3);

