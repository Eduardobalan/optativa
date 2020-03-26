create table public.tb_pessoa_juridica
(
    pj_cnpj varchar(255),
    ps_id   bigint not null
);

ALTER TABLE tb_pessoa_juridica ADD CONSTRAINT pk_tb_pessoa_juridica PRIMARY KEY (ps_id);

ALTER TABLE tb_pessoa_juridica ADD CONSTRAINT fk_ps_id_in_tb_pessoa_juridica FOREIGN KEY (ps_id) REFERENCES public.tb_pessoa;