use grabassetdb;

insert into product(product_id, product_img, product_img_filename, product_img_type, title, description, product_condition, age_in_months, category_id, security_deposit_amount, damage_cost, owner_ship_type, rental_amount, status, created_by, created_dt, last_modified_by, last_modified_dt) 
values(1, load_file('E:\\Grabasset\\product\\tcar.jpg'), 'tcar',  'jpg', 'Toy Car', 'For kids', 'MOD', 6, 3, 400, 200, 'O', 400, 'D', 'System', '2018-01-23', 'System', '2018-01-23' ),
(2, load_file('E:\\grabasset\\product\\train.jpg'), 'train',  'jpg', 'Train Toy', 'A red coloured train toy for children', 'OLD', 5, 3, 600, 300, 'L', 500, 'R', 'System', '2018-01-23', 'System', '2018-01-23' ),
(3, load_file('E:\\grabasset\\product\\doll.jpg'), 'doll',  'jpg', 'Barbie Doll', 'A beautiful barbie doll', 'NEW', 2, 3, 400, 300, 'O', 1000, 'A', 'System', '2018-01-23', 'System', '2018-01-23' ),
(4, load_file('E:\\grabasset\\product\\laptop.jpg'), 'laptop',  'jpg', 'HP Pavilion g6', 'Specifications: 1TB HDD - 4GB RAM', 'NEW', 3, 1, 1500, 800, 'L', 5000, 'A', 'System', '2018-01-23', 'System', '2018-01-23' ),
(5, load_file('E:\\grabasset\\product\\smartwatch.jpg'), 'smartwatch',  'jpg', 'iPhone Smartwatch', 'Specifications: Android OS - 6hrs backup', 'MOD', 6, 1, 1000, 500, 'O', 2000, 'R', 'System', '2018-01-23', 'System', '2018-01-23' ),
(6, load_file('E:\\grabasset\\product\\speaker.jpg'), 'speaker',  'jpg', 'iBall microwave', 'Dolby Digital 5.1', 'NEW', 4, 1, 700, 500, 'O', 800, 'A', 'System', '2018-01-23', 'System', '2018-01-23' ),
(7, load_file('E:\\grabasset\\product\\hammer.jpg'), 'hammer',  'jpg', 'Iron hammer ', 'Iron hammer with wooden handle', 'OLD', 10, 4, 150, 100, 'O', 200, 'A', 'System', '2018-01-23', 'System', '2018-01-23' ),
(8, load_file('E:\\grabasset\\product\\driller.jpg'), 'driller',  'jpg', 'Hand driller', 'Hand-held wireless driller', 'MOD', 8, 4, 500, 400, 'L', 800, 'R', 'System', '2018-01-23', 'System', '2018-01-23' ),
(9, load_file('E:\\grabasset\\product\\cutter.jpg'), 'cutter',  'jpg', 'Pipe cutter', 'Light weight pipe cutter', 'NEW', 10, 4, 200, 100, 'O', 200, 'A', 'System', '2018-01-23', 'System', '2018-01-23' ),
(10, load_file('E:\\grabasset\\product\\fan.jpg'), 'fan', 'jpg', 'Ceiling fan', 'Small portable ceiling fan suitable for small area', 'MOD', 7, 5, 200, 250, 'O', 500, 'A', 'System', '2018-01-23', 'System', '2018-01-23' ),
(11, load_file('E:\\grabasset\\product\\cooker.jpg'), 'cooker',  'jpg', 'Rice Cooker', 'Volume 5 ltrs with automated technology', 'NEW', 5, 5, 500, 300, 'O', 800, 'R', 'System', '2018-01-23', 'System', '2018-01-23' ),
(12, load_file('E:\\grabasset\\product\\cleaner.jpg'), 'cleaner',  'jpg', 'Vaccum Cleaner', 'Generic vaccum cleaner for regular purpose', 'OLD', 7, 5, 300, 400, 'O', 800, 'D', 'System', '2018-01-23', 'System', '2018-01-23' ),
(13, load_file('E:\\grabasset\\product\\car.jpg'), 'car',  'jpg', 'Toyota SUV', '7 seater - diesel engine - low maintenance', 'MOD', 12, 2, 5000, 2000, 'L', 2000, 'A', 'System', '2018-01-23', 'System', '2018-01-23' ),
(14, load_file('E:\\grabasset\\product\\scooty.jpg'), 'scooty',  'jpg', 'Honda Maestro', 'Good mileage - fuel efficient', 'NEW', 8, 2, 1000, 500, 'L', 400, 'R', 'System', '2018-01-23', 'System', '2018-01-23' ),
(15, load_file('E:\\grabasset\\product\\bike.jpg'), 'bike',  'jpg', 'Hero Glamour', 'Blue coloured with Fi tech - 120cc', 'NEW', 4, 2, 1000, 500, 'L', 500, 'R', 'System', '2018-01-23', 'System', '2018-01-23' );





