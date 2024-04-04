alter table cars add column status varchar;
update cars set status = 'ACTIVE' where id = 1;
update cars set  status = 'ACTIVE' where id = 2;