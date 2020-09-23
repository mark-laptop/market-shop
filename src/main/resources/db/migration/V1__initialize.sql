DROP TABLE products IF EXISTS;

CREATE TABLE products (id BIGSERIAL, title VARCHAR(255), price DECIMAL(15, 2) , PRIMARY KEY(id));

CREATE TABLE roles (id BIGSERIAL, title VARCHAR(50), PRIMARY KEY(id));

CREATE TABLE users (id BIGSERIAL, first_name VARCHAR(50), last_name VARCHAR(50), role_id BIGINT, PRIMARY KEY(id), FOREIGN KEY (role_id) REFERENCES roles (id));

INSERT INTO products (title, price) VALUES
('Milk', 65.5),
('Bread', 35.28),
('Chocolate', 130),
('Beer', 100),
('Fish', 125.5),
('Water', 65);

INSERT INTO roles (title) VALUES
('admin'),
('user');

INSERT INTO users (first_name, last_name, role_id) VALUES
('Tom', 'Smith', 1),
('John', 'Snow', 2),
('Bob', 'Rob', 2),
('Scot', 'Show', 2),
('Gary', 'Pupkin', 2),
('Jerry', 'Sumkin', 2);

