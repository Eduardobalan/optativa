CREATE TABLE tb_permissao
(
  pe_id                BIGSERIAL    NOT NULL,
  pe_acao              VARCHAR(255) NOT NULL,
  pe_chave             VARCHAR(255) NOT NULL,
  pe_descricao         VARCHAR(255),
  pe_nome              VARCHAR(255) NOT NULL,
  mo_id                BIGINT       NOT NULL,
  pe_dthr_alteracao    TIMESTAMP,
  pe_dthr_cadastro     TIMESTAMP,
  pe_usuario_alteracao VARCHAR(255),
  pe_usuario_cadastro  VARCHAR(255)
);

ALTER TABLE tb_permissao ADD CONSTRAINT pk_tb_permissao PRIMARY KEY (pe_id);

ALTER TABLE tb_permissao ADD CONSTRAINT fk_mo_id_in_tb_permissao FOREIGN KEY (mo_id) REFERENCES tb_modulo;

