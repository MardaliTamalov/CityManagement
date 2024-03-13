create table cars
(
    id           int4 generated by default as identity,
    brand        varchar(100) not null,
    model        varchar(100) not null,
    number       varchar(100) not null,
    release_year int4         not null,
    primary key (id)
);
insert into cars(brand, model, number, release_year)
VALUES ('BMW', 'X5', 'С545СС777', 2020),
       ('Audi', 'A4', 'Ф323МР77', 2019);