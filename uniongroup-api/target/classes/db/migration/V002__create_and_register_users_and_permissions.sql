CREATE TABLE `user` (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(150) NOT NULL,
    create_date datetime NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permission (
    id BIGINT NOT NULL AUTO_INCREMENT,
    description VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_permission (
    user_id BIGINT NOT NULL AUTO_INCREMENT,
    permission_id BIGINT(20) NOT NULL,
    PRIMARY KEY (user_id, permission_id),
    FOREIGN KEY (user_id) REFERENCES `user` (id),
    FOREIGN KEY (permission_id) REFERENCES permission (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (name, email, password, create_date) VALUES
('Administrador', 'admin@brasilprev.com', '$2a$10$c5nWDWSoMhGAEhNvylY5LOU9isboQp47MLMhO3oyhB7S4exrxK4oG', utc_timestamp),
('Eduardo Santos', 'edusantos@brasilprev.com', '$2a$10$OdP3NvKjtMOrJ4fg5jZUu.C8zH5fsvTApu8ZRoz9d46Gnb767coSy', utc_timestamp);

INSERT INTO permission (description) VALUES
('ROLE_REGISTER_CLIENT'),
('ROLE_SEARCH_CLIENT'),
('ROLE_ACTIVE/INACTIVE_CLIENT'),
('ROLE_SEARCH_CITY'),
('ROLE_SEARCH_STATE');


-- admin
INSERT INTO user_permission (user_id, permission_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5);


-- eduardo
INSERT INTO user_permission (user_id, permission_id) VALUES
(2, 2),
(2, 4),
(2, 5);

