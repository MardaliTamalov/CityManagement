alter table person_service.public.persons add column status varchar;
update person_service.public.persons set status = 'ACTIVE' where id = 4;
update person_service.public.persons set  status = 'ACTIVE' where id = 5;
update person_service.public.persons set  status = 'ACTIVE' where id = 6;

alter table person_service.public.passport add column status varchar;
update person_service.public.passport set status = 'ACTIVE' where id = 1;
update person_service.public.passport set  status = 'ACTIVE' where id = 2;