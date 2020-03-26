CREATE TABLE tb_pais
(
  pa_id                BIGSERIAL    NOT NULL,
  pa_nacionalidade     VARCHAR(100) NOT NULL,
  pa_nome              VARCHAR(100) NOT NULL,
  pa_sigla             VARCHAR(2),
  pa_dthr_alteracao    TIMESTAMP,
  pa_dthr_cadastro     TIMESTAMP,
  pa_usuario_alteracao VARCHAR(255),
  pa_usuario_cadastro  VARCHAR(255)
);

ALTER TABLE tb_pais ADD CONSTRAINT pk_tb_pais PRIMARY KEY (pa_id);

