CREATE TABLE owner_house
(
    person_id int4 not null,
    house_id  int4 not null,

    PRIMARY KEY (person_id, house_id)
);

INSERT INTO owner_house (person_id, house_id)
VALUES (2, 1),
       (1, 2);
