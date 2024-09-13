-- Create a table associate within the schema
CREATE TABLE "votacao".associado (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    data_atualizacao TIMESTAMP
);