CREATE TABLE IF NOT EXISTS tb_banco
(
  bc_id                BIGSERIAL   NOT NULL,
  bc_codigo            VARCHAR(50) NOT NULL,
  bc_descricao         VARCHAR(255),
  bc_nome              VARCHAR(75) NOT NULL,
  bc_situacao          VARCHAR(10) NOT NULL,
  bc_dthr_alteracao    TIMESTAMP,
  bc_dthr_cadastro     TIMESTAMP,
  bc_usuario_alteracao VARCHAR(255),
  bc_usuario_cadastro  VARCHAR(255)
);

ALTER TABLE tb_banco ADD CONSTRAINT pk_tb_banco PRIMARY KEY (bc_id);

