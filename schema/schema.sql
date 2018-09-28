create table user
(
	id bigint auto_increment primary key,
	userAccount varchar(128) not null,
	passwd varchar(64) not null,
	createTime timestamp default CURRENT_TIMESTAMP not null,
	updateTime timestamp default CURRENT_TIMESTAMP not null on update current_timestamp ,
	state tinyint default '1' not null
)
;

