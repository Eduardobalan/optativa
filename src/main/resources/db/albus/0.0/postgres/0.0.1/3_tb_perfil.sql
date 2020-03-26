CREATE TABLE tb_perfil
(
  pf_id                BIGSERIAL    NOT NULL,
  pf_descricao         VARCHAR(255),
  pf_nome              VARCHAR(255) NOT NULL,
  pf_situacao          VARCHAR(10)  NOT NULL,
  pf_dthr_alteracao    TIMESTAMP,
  pf_dthr_cadastro     TIMESTAMP,
  pf_usuario_alteracao VARCHAR(255),
  pf_usuario_cadastro  VARCHAR(255)
);

ALTER TABLE tb_perfil ADD CONSTRAINT pk_tb_perfil PRIMARY KEY (pf_id);

