create table cards (c_id bigint not null auto_increment, c_cvv integer, c_exp_date date, c_contactless boolean, c_number varchar(16), c_u_id bigint not null, primary key (c_id));
create table users (u_id bigint not null, u_address varchar(255), u_email varchar(255), u_first_name varchar(255), u_last_name varchar(255), primary key (u_id));
ALTER TABLE users ADD CONSTRAINT uk_email UNIQUE(u_email);
alter table cards add constraint fk_c_u_id foreign key (c_u_id) references users;