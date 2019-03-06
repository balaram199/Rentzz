use grabassetdb;

insert into category(category_id,category_nm, description, category_img, category_img_filename, category_img_type,created_by, created_dt, last_modified_by, last_modified_dt) values 
(1, 'electronics', 'daily basis', load_file('E:\\Grabasset\\category\\electronics.jpg'),'electronics', 'jpg', 'system', '2018-01-24 00:00:00','system', '2018-01-24 00:00:00'),
(2, 'automobiles', 'truse of ansportation ', load_file('E:\\Grabasset\\category\\automobiles.jpg'),'automobiles', 'jpg','system', '2018-01-24 00:00:00', 'system', '2018-01-24 00:00:00'),
(3, 'toys', 'for kids', load_file('E:\\Grabasset\\category\\toys.jpg'), 'toys', 'jpg', 'system', '2018-01-24 00:00:00', 'system', '2018-01-24 00:00:00'),
(4, 'tools', 'repaire works', load_file('E:\\Grabasset\\category\\tools.jpg'), 'tools', 'jpg', 'system', '2018-01-24 00:00:00', 'system', '2018-01-24 00:00:00'),
(5, 'home appliances', 'use in home', load_file('E:\\Grabasset\\category\\home.png'), 'home', 'png', 'system', '2018-01-24 00:00:00', 'system', '2018-01-24 00:00:00');

