alter table houses add column person_id int;
update houses set person_id = 1 where id = 1;
update houses set person_id = 2 where id = 2;