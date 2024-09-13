-- Create a table votes within the schema
CREATE TABLE "votacao".votos_sessao (
    id BIGSERIAL PRIMARY KEY,
    sessao_id INTEGER REFERENCES "votacao".sessao(id) ON DELETE CASCADE,
    associado_id INTEGER REFERENCES "votacao".associado(id) ON DELETE CASCADE,
    voto VARCHAR(3) NOT NULL,
    data_voto TIMESTAMP
);