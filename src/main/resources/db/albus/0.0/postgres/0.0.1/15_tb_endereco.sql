create table public.tb_endereco
(
    en_id                bigserial not null,
    en_dthr_alteracao    timestamp,
    en_dthr_cadastro     timestamp,
    en_usuario_alteracao varchar(255),
    en_usuario_cadastro  varchar(255),
    en_bairro            varchar(255),
    en_complemento       varchar(255),
    en_logradouro        varchar(255),
    en_numero            varchar(255),
    en_referencia        varchar(255),
    en_tipo_endereco     varchar(255),
    mu_id                bigint,
    ps_id                bigint
);

ALTER TABLE tb_endereco ADD CONSTRAINT pk_tb_endereco PRIMARY KEY (en_id);

ALTER TABLE tb_endereco ADD CONSTRAINT fk_mu_id_in_tb_endereco FOREIGN KEY (mu_id) REFERENCES public.tb_municipio;

ALTER TABLE tb_endereco ADD CONSTRAINT fk_ps_id_in_tb_endereco FOREIGN KEY (ps_id) REFERENCES public.tb_pessoa