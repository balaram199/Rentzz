use grabassetdb;

insert into user_rental_packages( user_rental_package_id, user_id,rental_package_id,purchase_dt,status,created_by,created_dt,last_modified_by,last_modified_dt) values
(2,3,5,'2017-12-20','EXP','System', '2017-12-20','System','2018-01-05'),
(3,2,4,'2018-01-22','NEW','System', '2018-01-22','System','2018-01-22'),
(4,5,1,'2018-01-15','ACT','System','2018-01-15','System','2018-01-22'),
(5,3,2,'2018-01-23','ACT','System','2018-01-23','System','2018-01-23'),
(6,5,2,'2018-01-22','ACT','System','2018-01-22','System','2018-01-22'),
(7,8,3,'2018-01-01','EXP','System','2018-01-01','System','2018-01-21'),
(8,5,3,'2017-12-20','NEW','System','2017-12-20','System','2017-12-20'),
(9,5,4,'2018-01-20','NEW','System','2018-01-20','System','2018-01-20'),
(10,7,6,'2017-12-20','EXP','System', '2017-12-20','System','2018-01-24');
