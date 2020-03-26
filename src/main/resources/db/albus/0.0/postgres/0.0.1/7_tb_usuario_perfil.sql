CREATE TABLE tb_usuario_perfil
(
  pe_id                BIGINT NOT NULL,
  us_id                BIGINT NOT NULL,
  up_dthr_alteracao    TIMESTAMP,
  up_dthr_cadastro     TIMESTAMP,
  up_usuario_alteracao VARCHAR(255),
  up_usuario_cadastro  VARCHAR(255)
);

ALTER TABLE tb_usuario_perfil ADD CONSTRAINT pk_tb_usuario_perfil PRIMARY KEY (pe_id, us_id);

ALTER TABLE tb_usuario_perfil ADD CONSTRAINT fk_pe_id_in_tb_usuario_perfil FOREIGN KEY (pe_id) REFERENCES tb_perfil;

ALTER TABLE tb_usuario_perfil ADD CONSTRAINT fk_us_id_in_tb_usuario_perfil FOREIGN KEY (us_id) REFERENCES tb_usuario;

