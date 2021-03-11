create table tb_category (id uuid not null, image_uri varchar(255), nome varchar(255), primary key (id));
create table tb_institution (id uuid not null, description varchar(255), email varchar(255), image_uri varchar(255), nome varchar(255), payment_type varchar(255), phone varchar(255), web_site varchar(255), category_id uuid, primary key (id));
create table tb_user (id uuid not null, email varchar(255), name varchar(255), password varchar(255), perfil_image varchar(255), primary key (id));
alter table if exists tb_institution add constraint FKph984wpmdbdnxffv6pqylhl2m foreign key (category_id) references tb_category;
