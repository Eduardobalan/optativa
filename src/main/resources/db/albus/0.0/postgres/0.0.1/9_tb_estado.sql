CREATE TABLE tb_estado
(
  uf_id                BIGSERIAL   NOT NULL,
  uf_nome              VARCHAR(75) NOT NULL,
  uf_sigla             VARCHAR(2)  NOT NULL,
  pa_id                BIGINT,
  uf_dthr_alteracao    TIMESTAMP,
  uf_dthr_cadastro     TIMESTAMP,
  uf_usuario_alteracao VARCHAR(255),
  uf_usuario_cadastro  VARCHAR(255)
);

ALTER TABLE tb_estado ADD CONSTRAINT pk_tb_estado PRIMARY KEY (uf_id);

ALTER TABLE tb_estado ADD CONSTRAINT fk_pa_id_in_tb_estado FOREIGN KEY (pa_id) REFERENCES tb_pais;

-- ftp://geoftp.ibge.gov.br/organizacao_do_territorio/estrutura_territorial/areas_territoriais/2017/

INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (11, 'Rondônia', 'RO');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (12, 'Acre', 'AC');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (13, 'Amazonas', 'AM');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (14, 'Roraima', 'RR');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (15, 'Pará', 'PA');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (16, 'Amapá', 'AP');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (17, 'Tocantins', 'TO');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (21, 'Maranhão', 'MA');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (22, 'Piauí', 'PI');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (23, 'Ceará', 'CE');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (24, 'Rio Grande do Norte', 'RN');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (25, 'Paraíba', 'PB');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (26, 'Pernambuco', 'PE');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (27, 'Alagoas', 'AL');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (28, 'Sergipe', 'SE');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (29, 'Bahia', 'BA');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (31, 'Minas Gerais', 'MG');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (32, 'Espirito Santo', 'ES');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (33, 'Rio de Janeiro', 'RJ');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (35, 'São Paulo', 'SP');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (41, 'Paraná', 'PR');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (42, 'Santa Catarina', 'SC');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (43, 'Rio Grande do Sul', 'RS');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (50, 'Mato Grosso do Sul', 'MS');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (51, 'Mato Grosso', 'MT');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (52, 'Goiás', 'GO');
INSERT INTO public.tb_estado (uf_id, uf_nome, uf_sigla) VALUES (53, 'Distrito Federal', 'DF');

