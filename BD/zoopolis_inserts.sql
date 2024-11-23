								/**************** INSERT INTO CLASS TABLE ****************/
#Ádax
insert into class (cla_name, cla_order, cla_fam) values ('Mamíferos', 'Cetartiodactyla', 'Bovidae'); # select * from animalclass
#Águia-das-estepes
insert into class (cla_name, cla_order, cla_fam) values ('Aves', 'Accipitriformes', ' Accipitridae');
#Aligátor-americano
insert into class (cla_name, cla_order, cla_fam) values ('Répteis', 'Crocodylia', 'Alligatoridae');
#Anaconda-amarela
insert into class (cla_name, cla_order, cla_fam) values ('Répteis', 'Squamata', 'Boidae');
#Araçari-verde
insert into class (cla_name, cla_order, cla_fam) values ('Aves', 'Piciformes', 'Ramphastidae');
#Arara-azul-e-amarela
insert into class (cla_name, cla_order, cla_fam) values ('Aves', 'Psittaciformes', 'Psittacidae');


								/**************** INSERT INTO ANIMAL TABLE  ****************/

#Ádax                                
insert into animal (ani_name, ani_ci_name, ani_description, ani_weight, ani_height, ani_length, ani_cla_id)
values ('Ádax', 'Addax nasomaculatus',
        'Ambos os sexos têm um tufo de pelos castanhos na fronte e cornos. A pelagem de verão é branca e a de inverno tem um tom acastanhado. É o antílope melhor adaptado ao deserto, onde caminha facilmente com a ajuda de cascos largos na base.',
         100.0, 105.0, 160.0, 1);
        

#Águia-das-estepes
insert into animal (ani_name, ani_ci_name, ani_description, ani_weight, ani_height, ani_length, ani_cla_id)
values ('Águia-das-estepes', 'Aquila nipalensis',
        'Águia de porte médio-grande, em que a fêmea é maior do que o macho. Nos olhos, a íris é castanha; e as narinas são ovais, contrariamente a outras espécies. Aos 4 anos, a plumagem de adulto, castanho-escura, está completa. Os juvenis apresentam geralmente uma banda esbranquiçada nas tectrizes (penas de cobertura nas asas).',
        3.2, 76.0, 0, 2);


#Aligátor-americano
insert into animal (ani_name, ani_ci_name, ani_description, ani_weight, ani_height, ani_length, ani_cla_id)
values ('Aligátor-americano', 'Alligator mississippiensis',
        'Os dedos estão ligados por membranas interdigitais. As narinas na ponta do focinho permitem-lhe respirar enquanto o corpo está submerso. Distingue-se  do crocodilo (Crocodylus sp.) por ter o  4º dente na mandíbula. Este não é visível quando a boca do animal está fechada, já que encaixa numa concavidade no maxilar superior.',
		400, 0, 450.0, 3);
        
    


#Anaconda-amarela        
insert into animal (ani_name, ani_ci_name, ani_description, ani_weight, ani_height, ani_length, ani_cla_id)
values ('Anaconda-amarela', 'Eunectes notaeus',
        'A anaconda-amarela é a segunda maior espécie de boa na América do Sul. As fêmeas são maiores do que os machos. Apresenta escamas amareladas com um padrão de manchas arredondadas de cor negra e uma mancha escura em forma de ponta de flecha na cabeça. Os olhos e as narinas estão no topo da cabeça. Espécie não venenosa.',
		30, 0, 350.0, 4);


#Araçari-verde
insert into animal (ani_name, ani_ci_name, ani_description, ani_weight, ani_height, ani_length, ani_cla_id)
values ('Araçari-verde', 'Pteroglossus viridis',
        'Este é um pequeno tucano, com plumagem sobretudo verde escura e amarela com uma distinta mancha vermelha. O bico é colorido com amarelo, vermelho e preto. Há dimorfismo sexual: o macho tem as penas do pescoço e da cabeça de cor escura enquanto que as da fêmea são de cor castanha-avermelhada.',
		0.130, 0, 35, 5);
        


#Arara-azul-e-amarela
insert into animal (ani_name, ani_ci_name, ani_description, ani_weight, ani_height, ani_length, ani_cla_id)
values ('Arara-azul-e-amarela', 'Ara ararauna',
        'Apresenta pele nua, nas faces, de cor branca e com pequenas penas escuras, que formam riscas paralelas. Distingue-se pela plumagem verde na coroa e na fronte. Sendo considerada uma das mais bonitas espécies de arara. Machos, fêmeas e juvenis apresentam todos plumagem semelhante.',
		1.15, 0, 86, 6);
        
#Arara-de-asa-verde
insert into animal (ani_name, ani_ci_name, ani_description, ani_weight, ani_height, ani_length, ani_cla_id)
values ('Arara-de-asa-verde', 'Ara chloropterus',
        'A plumagem é vermelho-vivo com pele nua branca na face, onde tem pequenas penas vermelhas. As asas apresentam penas verdes e azuis. A parte superior das penas caudais é azul e vermelha. É muito semelhante com a arara-escarlate (Ara macao), que se distingue pelas penas amarelas nas asas e pela pele nua na face.',
		1.5, 0, 92, 6);
        

#Arara-de-fronte-vermelha
insert into animal (ani_name, ani_ci_name, ani_description, ani_weight, ani_height, ani_length, ani_cla_id)
values ('Arara-de-fronte-vermelha', 'Ara rubrogenys',
        'Distingue-se pela coloração viva, onde sobressaem a fronte e a coroa vermelhas. Em torno dos olhos e na base do bico tem pele nua rosada. Não existe dimorfismo sexual evidente, machos e fêmeas não se distinguem por observação.',
		0.550, 0, 60, 6);
        
#Arara-escarlate
insert into animal (ani_name, ani_ci_name, ani_description, ani_weight, ani_height, ani_length, ani_cla_id)
values ('Arara-escarlate', 'Ara macao',
        'A cor da íris muda com a idade, sendo castanha nos juvenis e amarela nos adultos. As penas supra-alares são amarelas marginadas a verde e a extremidade das asas é azul. Esta disposição das cores, permite distingui-la de outras espécies de araras, em especial da Arara-de-asa-verde (Ara chloropterus).',
		1.2, 0, 86, 6);
        
#Arara-jacinta
insert into animal (ani_name, ani_ci_name, ani_description, ani_weight, ani_height, ani_length, ani_cla_id)
values ('Arara-jacinta', 'Anodorhynchus hyacinthinus',
        'É a maior espécie de Arara. A coloração forte em azul-cobalto, contrastante com a pele nua amarela em torno dos olhos e da mandíbula inferior distingue-a de todas as outras. O bico é grande, preto e particularmente encurvado e pontiagudo.',
		1.5, 0, 100, 6);
                   
								/**************** INSERT INTO AREA TABLE  ****************/
                                
INSERT INTO area (area_name) VALUES
('Savanna'),
('Jungle'),
('Desert'),
('Mountain'),
('Arctic'),
('Wetlands'),
('Grassland'),
('Oceanic');
                               
                               
                               /**************** INSERT INTO SUB_AREA TABLE  ****************/

INSERT INTO sub_area (sa_area_id, sa_name) VALUES
(1, 'Elephant Habitat'),
(1, 'Lion Enclosure'),
(2, 'Monkey Island'),
(3, 'Reptile Dome'),
(4, 'Snow Leopard Ridge'),
(5, 'Penguin Pool'),
(6, 'Frog Swamp'),
(7, 'Shark Tank');


								
							/**************** INSERT INTO ENCLOSURE TABLE  ****************/
                            
INSERT INTO enclosure (enc_name, enc_sup_amount, enc_aniclass, enc_lat, enc_long, enc_mapsid, enc_sa_id) VALUES
('Elephant Enclosure', 3, 'Mammalia', -1.2921, 36.8219, 'MAPID_001', 1),
('Lion Habitat', 5, 'Mammalia', -1.2931, 36.8220, 'MAPID_002', 2),
('Monkey Forest', 20, 'Primates', -1.2945, 36.8230, 'MAPID_003', 3),
('Reptile House', 15, 'Reptilia', -1.2950, 36.8240, 'MAPID_004', 4),
('Penguin Pool', 12, 'Aves', -1.2960, 36.8250, 'MAPID_005', 5),
('Shark Aquarium', 2, 'Pisces', -1.2970, 36.8260, 'MAPID_006', 7),
('Frog Swamp', 30, 'Amphibia', -1.2980, 36.8270, 'MAPID_007', 6),
('Arctic Exhibit', 4, 'Mammalia', -1.2990, 36.8280, 'MAPID_008', 5);


							/**************** INSERT INTO AE TABLE  ****************/
                            
INSERT INTO ae (ae_id, ae_ani_id, ae_enc_id, ae_dt_in, ae_dt_out) VALUES
(1, 1, 1, '2024-11-22 10:00:00', '2024-11-22 12:00:00'),
(2, 2, 2, '2024-11-22 11:30:00', '2024-11-22 13:30:00'),
(3, 3, 3, '2024-11-22 12:00:00', '2024-11-22 14:00:00'),
(4, 4, 4, '2024-11-22 13:15:00', '2024-11-22 15:15:00'),
(5, 1, 5, '2024-11-22 14:45:00', '2024-11-22 16:45:00'),
(6, 2, 6, '2024-11-22 15:30:00', '2024-11-22 17:30:00'),
(7, 3, 7, '2024-11-22 16:15:00', '2024-11-22 18:15:00'),
(8, 4, 8, '2024-11-22 17:00:00', '2024-11-22 19:00:00');


							/**************** INSERT INTO ACTIVITY TABLE  ****************/
                            
INSERT INTO activity (ac_name, ac_schedule, ac_cap, ac_area_id) VALUES
('Elephant Feeding', '2024-11-23 10:00:00', 50, 1),
('Lion Roar Show', '2024-11-23 12:00:00', 40, 1),
('Monkey Playtime', '2024-11-23 14:00:00', 60, 2),
('Reptile Interaction', '2024-11-23 11:00:00', 20, 3),
('Penguin Parade', '2024-11-23 15:00:00', 30, 5),
('Shark Feeding', '2024-11-23 16:00:00', 25, 7),
('Frog Night Sounds', '2024-11-23 18:00:00', 15, 6),
('Arctic Education', '2024-11-23 13:00:00', 50, 5);


							/**************** INSERT INTO PERSON TABLE  ****************/
                            
                            
INSERT INTO person (per_name, per_email, per_password, per_gender, per_bdate) VALUES
('Alice Johnson', 'alice@example.com', 'alice123', 'F', '1990-05-14'),
('Bob Smith', 'bob@example.com', 'bob123', 'M', '1985-08-22'),
('Charlie Brown', 'charlie@example.com', 'charlie123', 'M', '1992-12-05'),
('Diana Prince', 'diana@example.com', 'diana123', 'F', '1987-07-19'),
('Edward Stark', 'edward@example.com', 'edward123', 'M', '1995-03-21'),
('Fiona Green', 'fiona@example.com', 'fiona123', 'F', '1993-11-09'),
('George Wilson', 'george@example.com', 'george123', 'M', '1989-06-15'),
('Helen Carter', 'helen@example.com', 'helen123', 'F', '1991-01-30');

							/**************** INSERT INTO VISITED TABLE  ****************/

INSERT INTO visited (vi_per_id, vi_sa_id, vi_dtime) VALUES
(1, 1, '2024-11-22 10:00:00'),
(2, 2, '2024-11-22 11:30:00'),
(3, 3, '2024-11-22 12:00:00'),
(4, 4, '2024-11-22 13:15:00'),
(5, 5, '2024-11-22 14:45:00'),
(6, 6, '2024-11-22 15:30:00'),
(7, 7, '2024-11-22 16:15:00'),
(8, 5, '2024-11-22 17:00:00');


							/**************** INSERT INTO FAVORITE TABLE  ****************/
                            
INSERT INTO favorite (fav_animal, fav_ani_id, fav_per_id) VALUES
(true, 1, 1),
(false, NULL, 2),
(true, 2, 3),
(true, 3, 4),
(false, NULL, 5),
(true, 4, 6),
(false, NULL, 8);

							/**************** INSERT INTO KIOSK TABLE  ****************/
                            
INSERT INTO kiosk (kio_name, kio_area_id) VALUES
('Savanna Snacks', 1),
('Jungle Juices', 2),
('Desert Delights', 3),
('Mountain Munchies', 4),
('Arctic Bites', 5),
('Wetland Wonders', 6),
('Grassland Grub', 7),
('Oceanic Eats', 8);


							/**************** INSERT INTO PRODUCT TABLE  ****************/
                            
INSERT INTO product (pro_name, pro_barcode, pro_price) VALUES
('Water Bottle', 1234567890123, 2.50),
('Chips Pack', 1234567890124, 1.75),
('Soda Can', 1234567890125, 1.25),
('Sandwich', 1234567890126, 3.50),
('Fruit Cup', 1234567890127, 2.00),
('Candy Bar', 1234567890128, 1.00),
('Ice Cream', 1234567890129, 2.75),
('Popcorn', 1234567890130, 1.50);


							/**************** INSERT INTO STOCK TABLE  ****************/
                            
INSERT INTO stock (stock_amount, stock_kio_id, stock_pro_id) VALUES
(100, 1, 1),
(150, 2, 2),
(200, 3, 3),
(80, 4, 4),
(60, 5, 5),
(110, 6, 6),
(140, 7, 7),
(50, 8, 8);
