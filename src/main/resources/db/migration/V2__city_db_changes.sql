alter table persons
    add column gender varchar(10);

update persons
set gender = persons.gender;
commit;