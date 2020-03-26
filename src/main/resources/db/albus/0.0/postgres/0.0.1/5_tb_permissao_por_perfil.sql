CREATE TABLE tb_permissao_por_perfil
(
  pf_id                BIGINT NOT NULL,
  pe_id                BIGINT NOT NULL,
  pp_dthr_alteracao    TIMESTAMP,
  pp_dthr_cadastro     TIMESTAMP,
  pp_usuario_alteracao VARCHAR(255),
  pp_usuario_cadastro  VARCHAR(255)
);

ALTER TABLE tb_permissao_por_perfil ADD CONSTRAINT pk_tb_permissao_por_perfil PRIMARY KEY (pf_id, pe_id);

ALTER TABLE tb_permissao_por_perfil ADD CONSTRAINT fk_pf_id_in_tb_permissao_por_perfil FOREIGN KEY (pf_id) REFERENCES tb_perfil;

ALTER TABLE tb_permissao_por_perfil ADD CONSTRAINT fk_pe_id_in_tb_permissao_por_perfil FOREIGN KEY (pe_id) REFERENCES tb_permissao;

