-- Create a table subject within the schema
CREATE TABLE "votacao".pauta (
    id BIGSERIAL PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    data_atualizacao TIMESTAMP
);