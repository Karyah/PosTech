-- Excluir tabelas se existirem para garantir recriação correta
--DROP TABLE IF EXISTS reserva;
--DROP TABLE IF EXISTS sala;
--DROP TABLE IF EXISTS usuario;
--
-- Criação da tabela usuarios
--CREATE TABLE usuario (
--    id VARCHAR(36) PRIMARY KEY,
--    nome VARCHAR(100),
--    email VARCHAR(100),
--    cpf VARCHAR(14),
--    telefone VARCHAR(15)
--);
--
---- Criação da tabela salas
--CREATE TABLE salas (
--    id VARCHAR(36) PRIMARY KEY,
--    nome VARCHAR(100),
--    tipo_sala VARCHAR(50), -- nome da coluna ajustado para refletir a entidade
--    capacidade INT,
--    disponibilidade BOOLEAN DEFAULT TRUE
--);
--
---- Criação da tabela reservas
--CREATE TABLE reserva (
--    id VARCHAR(36) PRIMARY KEY,
--    usuario_id VARCHAR(36),
--    sala_id VARCHAR(36),
--    horario_inicio TIMESTAMP,
--    horario_fim TIMESTAMP,
--    duracao DOUBLE,
--    qtd_participantes INT,
--    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
--    FOREIGN KEY (sala_id) REFERENCES sala(id)
--);

-- Inserindo usuários
INSERT INTO usuario (id, nome, email, cpf, telefone) VALUES
('e2f4c27f-9a3b-4aef-83b3-bc2e12aa0b2b', 'João Silva', 'joao.silva@example.com', '123.456.789-09', '(11) 91234-5678'),
('1b1a3b46-7b12-4f8d-b5cf-fb916ea74a62', 'Maria Oliveira', 'maria.oliveira@example.com', '987.654.321-00', '(11) 99876-5432'),
('dd8aaf57-9d7e-4f41-a5b0-f87de45a32ef', 'Carlos Almeida', 'carlos.almeida@example.com', '111.222.333-44', '(11) 91111-1111'),
('2e378f9f-4a8f-48aa-8e2d-04960b7de60f', 'Ana Costa', 'ana.costa@example.com', '444.555.666-77', '(11) 92222-2222');

-- Inserindo salas
INSERT INTO sala (id, nome, tipo_sala, capacidade, disponibilidade) VALUES
('9782735c-77b2-4e75-8261-8f97e3b0a0b8', 'Sala A', 'SALA_DE_REUNIAO', 10, TRUE),
('ac653b3e-b128-466e-86c5-0349f421c2f3', 'Sala B', 'SALA_EXECUTIVA', 20, TRUE),
('36bce002-ccbc-4f55-b682-2e4c88bcfa71', 'Sala C', 'SALA_DE_CONFERENCIA', 30, TRUE),
('75d2af89-12b7-4c32-9f30-fd270fae7c79', 'Sala D', 'AUDITORIO', 5, FALSE);

-- Inserindo reservas (opcional)
INSERT INTO reserva (id, usuario_id, sala_id, horario_inicio, horario_fim, duracao, qtd_participantes) VALUES
('2f71d7da-b0e8-48f3-859b-b09e1b597627', 'e2f4c27f-9a3b-4aef-83b3-bc2e12aa0b2b', '9782735c-77b2-4e75-8261-8f97e3b0a0b8', '2024-10-30T10:00:00', '2024-10-30T12:00:00', 2.0, 10),
('b7c0ec47-e05b-4aa3-b47b-fb7c6875777d', '1b1a3b46-7b12-4f8d-b5cf-fb916ea74a62', 'ac653b3e-b128-466e-86c5-0349f421c2f3', '2024-10-30T14:00:00', '2024-10-30T16:00:00', 2.0, 15);
