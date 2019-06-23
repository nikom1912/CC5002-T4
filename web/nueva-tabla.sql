CREATE TABLE comentario_foto_mascota(
    id                   int8           auto_increment,
    fecha                datetime       not null,
    comentario           varchar(512)   not null,
    foto_mascota         int(11)        not null,
    primary key(id),
    foreign key(foto_mascota) references foto_mascota(id)
) 
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;
