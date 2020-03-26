CREATE TABLE tb_usuario
(
  us_id                BIGSERIAL    NOT NULL,
  us_login             VARCHAR(255) NOT NULL,
  us_nome              VARCHAR(255) NOT NULL,
  us_senha             VARCHAR(255) NOT NULL,
  us_situacao          VARCHAR(10)  NOT NULL,
  us_dthr_alteracao    TIMESTAMP,
  us_dthr_cadastro     TIMESTAMP,
  us_usuario_alteracao VARCHAR(255),
  us_usuario_cadastro  VARCHAR(255)
);

ALTER TABLE tb_usuario ADD CONSTRAINT pk_tb_usuario PRIMARY KEY (us_id);

INSERT INTO public.tb_usuario (us_id, us_dthr_alteracao, us_dthr_cadastro, us_usuario_alteracao, us_usuario_cadastro, us_login, us_nome, us_senha, us_situacao) VALUES (1, null, null, null, null, 'admin', 'admin', '$2a$10$ikCrbaJOKJz5dpJSKgUk5unw0yvRsTsdnyk6aCXKAZMDrc1ePVkmu', 'ATIVO');