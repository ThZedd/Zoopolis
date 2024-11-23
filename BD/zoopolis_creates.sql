/* Tabela para cadastro de animais */
create table animal (
					ani_id int not null auto_increment,		-- Identificador único do animal
					ani_name VARCHAR(60) not null, 			-- Nome do animal
					ani_ci_name VARCHAR(60), 				-- Nome científico do animal
					ani_description mediumtext, 			-- Descrição do animal
					ani_weight float, 						-- Peso do animal
					ani_height float, 						-- Altura do animal
                    ani_length float,						-- Comprimento do animal
					ani_cla_id INT,							-- ID da classe associada ao animal
                    imageURL varchar(255),					-- URL da imagem do animal
					primary key (ani_id)	
);

/* Tabela para classes de animais */
create table class (
					cla_id int not null auto_increment,		-- Identificador único da classe
					cla_name VARCHAR(60) not null, 			-- Nome da classe 
					cla_order VARCHAR(30), 					-- Ordem da classe
					cla_fam VARCHAR(30), 					-- Família da classe
					primary key (cla_id)	
);

/* Tabela para registros de animais em enclosures */
create table ae (
					ae_id int not null auto_increment,		-- Identificador único do registro
					ae_ani_id int, 							-- ID do animal
					ae_enc_id int,     						-- ID do enclosure
                    ae_dt_in datetime, 						-- Data/hora de entrada do animal no enclosure
                    ae_dt_out datetime, 					-- Data/hora de saída do animal do enclosure
					primary key (ae_id)	
);

/* Tabela para detalhes de enclosures */
create table enclosure (
					enc_id int not null auto_increment,		-- Identificador único do enclosure
					enc_name VARCHAR(60) not null, 			-- Nome do enclosure
					enc_sup_amount int, 					-- Quantidade de animais suportado
					enc_aniclass VARCHAR(30),				-- Classe de animais suportada
                    enc_lat DOUBLE NOT NULL,				-- Latitude do enclosure (localização)
					enc_long DOUBLE NOT NULL,				-- Longitude do enclosure (localização)
                    enc_mapsid VARCHAR(255),				-- ID do mapa associado
					enc_sa_id int, 			#				-- ID da sub-área associada
					primary key (enc_id)	
);

/* Tabela para sub-áreas dentro de uma área */
create table sub_area (
					sa_id int not null auto_increment,		-- Identificador único da sub-área
					sa_area_id int,							-- ID da área associada			
					sa_name VARCHAR(30),      				-- Nome da sub-área
					primary key (sa_id)	
);

/* Tabela para áreas principais do zoológico */
create table area (
					area_id int not null auto_increment,	-- Identificador único da área
					area_name VARCHAR(30),      			-- Nome da área
					primary key (area_id)	
);

/* Tabela para atividades realizadas no zoológico */
create table activity (
					ac_id int not null auto_increment,		-- Identificador único da atividade
					ac_name VARCHAR(50), 					-- Nome da atividade
                    ac_schedule datetime,					-- Horário agendado da atividade
                    ac_cap int,								-- Capacidade de espectadores
                    ac_area_id int, #						-- ID da área onde a atividade ocorre
					primary key (ac_id)	
);

/* Tabela para registro de visitas de pessoas */
create table visited (
					vi_id int not null auto_increment,		-- Identificador único do registro de visita
					vi_per_id int,							-- ID da pessoa que realizou a visita
                    vi_sa_id int,							-- ID da sub-área visitada
                    vi_dtime datetime not null,				-- Data/hora da visita
					primary key (vi_id)	
);

/* Tabela para cadastro de pessoas */
create table person (
					per_id int not null auto_increment,		-- Identificador único da pessoa
					per_name VARCHAR(60) not null, 			-- Nome da pessoa	
					per_email VARCHAR(30),					-- Email da pessoa
 					per_password VARCHAR(30),				-- Senha de acesso
					per_gender CHAR(1) not null, 			-- Gênero (M/F/Outro)	
					per_bdate date not null, 				-- Data de nascimento	
					primary key (per_id)	
);

/* Tabela para registro de animais favoritos */
create table favorite (
					fav_id int not null auto_increment,		-- Identificador único do favorito
                    fav_animal bool, 						-- Indica se é um animal favorito
					fav_ani_id int, #						-- ID do animal favorito
                    fav_per_id int, #						-- ID da pessoa que favoritou
					primary key (fav_id)	
);

/* Tabela para quiosques */
create table kiosk (
					kio_id int not null auto_increment,		-- Identificador único do quiosque
					kio_name VARCHAR(30),					-- Nome do quiosque
                    kio_area_id int, #						-- ID da área onde o quiosque está localizado
					primary key (kio_id)	
);

/* Tabela para estoques de quiosques */
create table stock (
					stock_id int not null auto_increment,		-- Identificador único do estoque
					stock_amount int,							-- Quantidade em estoque
                    stock_kio_id int, #							-- ID do quiosque associado
                    stock_pro_id int, #							-- ID do produto associado
					primary key (stock_id)	
);

/* Tabela para produtos disponíveis */
create table product (
					pro_id int not null auto_increment,			-- Identificador único do produto
					pro_name VARCHAR(100),						-- Nome do produto
                    pro_barcode bigint, #						-- Código de barras do produto
                    pro_price decimal(10,2), #					-- Preço do produto
					primary key (pro_id)	
);


alter table animal 
add constraint animal_fk_class
foreign key (ani_cla_id) references class(cla_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table ae 
add constraint ae_fk_animal
foreign key (ae_ani_id) references animal(ani_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table ae 
add constraint ae_fk_enclosure
foreign key (ae_enc_id) references enclosure(enc_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table enclosure 
add constraint enclosure_fk_sub_area
foreign key (enc_sa_id) references sub_area(sa_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table sub_area
add constraint sub_area_fk_area
foreign key (sa_area_id) references area(area_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table activity
add constraint activity_fk_area
foreign key (ac_area_id) references area(area_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table visited
add constraint visited_fk_person
foreign key (vi_per_id) references person(per_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table visited
add constraint visited_fk_sub_area
foreign key (vi_sa_id) references sub_area(sa_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table favorite
add constraint favorite_fk_animal
foreign key (fav_ani_id) references animal(ani_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table favorite
add constraint favorite_fk_person
foreign key (fav_per_id) references person(per_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table kiosk
add constraint kiosk_fk_area
foreign key (kio_area_id) references area(area_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table stock
add constraint stock_fk_kiosk
foreign key (stock_kio_id) references kiosk(kio_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table stock
add constraint stock_fk_product
foreign key (stock_pro_id) references product(pro_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table product add constraint unique_barcode unique (pro_barcode);

alter table product add constraint chk_barcode check (pro_barcode > 0);

alter table person add constraint unique_email unique (per_email);

/************ VIEWS ************/

/* View para Animais e Suas Classes (animalclass) */

create view animalclass as
select *
from class
inner join animal on ani_cla_id = cla_id;

/* View para Atividades e Áreas (activity_area_view) */

create view activity_area_view as
select 
    ac.ac_id, 
    ac.ac_name, 
    ac.ac_schedule, 
    ac.ac_cap as capacity, 
    a.area_name as area_name
from activity ac
inner join area a on ac.ac_area_id = a.area_id;

/*View para Visitas e Informações de Pessoas (visit_details_view)*/

create view visit_details_view as
select 
    v.vi_id, 
    v.vi_dtime as visit_time, 
    p.per_name, 
    p.per_email, 
    sa.sa_name as sub_area_name
from visited v
inner join person p on v.vi_per_id = p.per_id
inner join sub_area sa on v.vi_sa_id = sa.sa_id;

/*View para Produtos e Estoques (product_stock_view)*/

create view product_stock_view as
select 
    p.pro_id, 
    p.pro_name, 
    p.pro_price, 
    s.stock_amount, 
    k.kio_name as kiosk_name
from stock s
inner join product p on s.stock_pro_id = p.pro_id
inner join kiosk k on s.stock_kio_id = k.kio_id;

/*View para Animais Favoritos de Pessoas (favorite_animals_view)*/

create view favorite_animals_view as
select 
    f.fav_id, 
    f.fav_animal, 
    a.ani_name, 
    p.per_name
from favorite f
inner join animal a on f.fav_ani_id = a.ani_id
inner join person p on f.fav_per_id = p.per_id;

/*View para Enclosures e Animais (enclosure_animals_view)*/

create view enclosure_animals_view as
select 
    e.enc_name, 
    e.enc_lat, 
    e.enc_long, 
    e.enc_mapsid, 
    a.ani_name
from enclosure e
inner join ae ae on e.enc_id = ae.ae_enc_id
inner join animal a on ae.ae_ani_id = a.ani_id;

/*View para Sub-Áreas e Atividades (sub_area_activities_view))*/

create view sub_area_activities_view as
select 
    sa.sa_name, 
    ac.ac_name, 
    ac.ac_schedule
from sub_area sa
inner join area a on sa.sa_area_id = a.area_id
inner join activity ac on ac.ac_area_id = a.area_id;

/*View para Estoque de Quiosques (kiosk_stock_view)*/

create view kiosk_stock_view as
select 
    k.kio_name, 
    p.pro_name, 
    s.stock_amount
from stock s
inner join product p on s.stock_pro_id = p.pro_id
inner join kiosk k on s.stock_kio_id = k.kio_id;





