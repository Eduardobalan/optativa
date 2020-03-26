create table public.tb_pessoa
(
    ps_tipo_pessoa       varchar(20)  not null,
    ps_id                bigserial    not null,
    ps_dthr_alteracao    timestamp,
    ps_dthr_cadastro     timestamp,
    ps_usuario_alteracao varchar(255),
    ps_usuario_cadastro  varchar(255),
    ps_apelido           varchar(255),
    ps_nome              varchar(255) not null
);

ALTER TABLE tb_pessoa ADD CONSTRAINT pk_tb_pessoa PRIMARY KEY (ps_id);