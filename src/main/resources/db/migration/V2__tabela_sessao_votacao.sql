-- Create a table session within the schema
CREATE TABLE "votacao".sessao (
    id BIGSERIAL PRIMARY KEY,
    pauta_id INTEGER REFERENCES "votacao".pauta(id) ON DELETE CASCADE,
    data_criacao TIMESTAMP,
    data_fechamento TIMESTAMP
);