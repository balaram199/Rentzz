use grabassetdb;


insert into rental_package (rental_package_id, package_logo, package_logo_filename, package_logo_type, package_nm, description, duration_in_hours, no_of_products, is_swappable, validity_in_days, amount, status, created_by, created_dt, last_modified_by, last_modified_dt) values
(1, 'E:\\Grabasset\\rental_package\\indoorgames.png', 'indoorgames', 'png', 'indoor toys', 'for below 10 years', '40', '3', true, '30', '500.00', 'i','System', '2018-01-10', 'System','2018-01-23'),
(2, 'E:\\Grabasset\\rental_package\\outdoorgames.jpg', 'outdoorgames', 'jpg', 'outdoor toys', 'for 10+ years', '20', '4', true, '10', '800.00', 'e','System', '2018-01-22', 'System','2018-01-23'),
(3, 'E:\\Grabasset\\rental_package\\lighttools.jpg', 'lighttools', 'jpg', 'light tools', 'daily purpose tools', '15', '2', true, '20', '1600.00', 'a','System', '2017-01-22', 'System','2018-01-10'),
(4, 'E:\\Grabasset\\rental_package\\industrailtools.jpg', 'industrail tools', 'jpg', 'heavy tools', 'industrial tools', '10', '3', true, '30', '2750.00', 'a','System', '2017-10-22', 'System','2018-01-15'),
(5, 'E:\\Grabasset\\rental_package\\cars.jpg', 'cars', 'jpeg', 'cars', 'contains low budget cars', '40', '2', true, '15', '3300.00', 'e','System', '2017-11-22', 'System','2018-01-20'),
(6, 'E:\\Grabasset\\rental_package\\bikes.jpg', 'bikes', 'jpg', 'bikes', 'contains normal bikes', '40', '3', true, '30', '1900.00', 'a','System', '2017-01-22', 'System','2018-01-02'),
(7, 'E:\\Grabasset\\rental_package\\Electronic.jpg', 'electronic', 'jpg', 'electronics', 'contains normal laptops', '30', '4', true, '25', '2050.00', 'i','System', '2017-11-22', 'System','2018-01-09');
