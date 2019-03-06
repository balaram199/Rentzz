use grabassetdb;


insert into rent(rent_id,user_rental_package_id,rented_dt,security_deposit_paid,late_fee,is_swaped,status,created_by,created_dt,last_modified_by,last_modified_dt)values
(1,4,'2018-01-23 17:00',7800.00,500,false,'rented','System','2018-01-23', 'System', '2018-01-23'),
(2,2,'2018-01-23 9:00',6570.00,200,false,'rented','System','2018-01-23', 'System', '2018-01-23'),
(3,3,'2018-01-23 12:30',7657.00,160,true,'rented','System','2018-01-23', 'System', '2018-01-23'),
(4,4,'2018-01-23 10:00',60785.00,500,false,'rented','System','2018-01-23', 'System', '2018-01-23'),
(5,5,'2018-01-23 11:00',6330.00,300,true,'rented','System', '2018-01-23', 'System', '2018-01-23'),
(6,6,'2018-01-23 08:00',6500.00,550,false,'rented','System', '2018-01-23', 'System', '2018-01-23'),
(7,7,'2018-01-23 14:00',9690.00,800,true,'rented','System','2018-01-23', 'System', '2018-01-23');