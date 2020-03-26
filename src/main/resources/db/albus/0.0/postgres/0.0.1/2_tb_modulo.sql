CREATE TABLE tb_modulo
(
  mo_id                BIGSERIAL    NOT NULL,
  mo_descricao         VARCHAR(255),
  pr_id                BIGINT,
  mo_nome              VARCHAR(255) NOT NULL,
  mo_situacao          VARCHAR(10)  NOT NULL,
  mo_pai               BIGINT,
  mo_dthr_alteracao    TIMESTAMP,
  mo_dthr_cadastro     TIMESTAMP,
  mo_usuario_alteracao VARCHAR(255),
  mo_usuario_cadastro  VARCHAR(255)
);

ALTER TABLE tb_modulo ADD CONSTRAINT pk_tb_modulo PRIMARY KEY (mo_id);

ALTER TABLE tb_modulo ADD CONSTRAINT fk_mo_pai_in_tb_modulo FOREIGN KEY (mo_pai) REFERENCES tb_modulo;

