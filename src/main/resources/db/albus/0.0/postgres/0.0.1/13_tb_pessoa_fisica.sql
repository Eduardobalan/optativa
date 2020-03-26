create table public.tb_pessoa_fisica
(
    pf_cpf varchar(255),
    pf_rg  varchar(255),
    ps_id  bigint not null
);

ALTER TABLE tb_pessoa_fisica ADD CONSTRAINT pk_tb_pessoa_fisica PRIMARY KEY (ps_id);

ALTER TABLE tb_pessoa_fisica ADD CONSTRAINT fk_ps_id_in_tb_pessoa_fisica FOREIGN KEY (ps_id) REFERENCES public.tb_pessoa
