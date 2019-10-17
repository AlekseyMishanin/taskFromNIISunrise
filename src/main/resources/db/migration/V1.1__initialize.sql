DROP TABLE IF EXISTS users;

CREATE TABLE users(
    id bigserial primary key,
    first_name varchar (255) not  null unique
);

INSERT INTO users(first_name) VALUES
    ('Ivan'),    ('Aleksey'),    ('Fedor');

DROP TABLE IF EXISTS phones;

CREATE TABLE phones(
    id bigserial primary key,
    phone varchar (255) not  null,
    user_id bigint not null,
    foreign key (user_id)
    references users(id)
);

INSERT INTO phones(phone, user_id) VALUES
    ('89261111111', 1),
    ('89262222222', 1),
    ('89263333333', 2),
    ('89264444444', 3),
    ('89265555555', 3);
