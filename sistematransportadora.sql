create database sistematransportadora;

use sistematransportadora;

-- Tabela Tipos de Veículos
CREATE TABLE tipo_veiculo 
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) UNIQUE NOT NULL
);

INSERT INTO tipo_veiculo (nome) VALUES ('Aberto'), ('Baú'), ('Pick-up'), ('Carreta'), ('Carga');

-- Tabela Veículos
CREATE TABLE veiculos 
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome_veiculo VARCHAR(100) NOT NULL,
    placa VARCHAR(20) UNIQUE NOT NULL,
    modelo VARCHAR(50),
    tipo_id INT,
    altura_interna DOUBLE,
    largura_interna DOUBLE,
    comprimento_interno DOUBLE,
    capacidade_peso DOUBLE,
    observacoes TEXT,
    FOREIGN KEY (tipo_id) REFERENCES tipo_veiculo(id)
);

-- Tabela Grau de Fragilidade
CREATE TABLE grau_fragilidade 
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(20) UNIQUE NOT NULL
);

INSERT INTO grau_fragilidade (nome) VALUES ('Alta'), ('Média'), ('Baixa');

-- Tabela Produtos
CREATE TABLE produtos 
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    familia VARCHAR(100),
    tipo VARCHAR(50),
    lote VARCHAR(50),
    altura DOUBLE,
    largura DOUBLE,
    comprimento DOUBLE,
    peso DOUBLE,
    grau_fragilidade_id INT,
    observacoes TEXT,
    FOREIGN KEY (grau_fragilidade_id) REFERENCES grau_fragilidade(id)
);

-- Tabela Tipos de Embalagem
CREATE TABLE tipo_embalagem
 (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) UNIQUE NOT NULL
);

INSERT INTO tipo_embalagem (nome) VALUES ('Caixa'), ('Tambor'), ('Palete'), ('Saco');

-- Tabela Embalagens
CREATE TABLE embalagens 
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    produto_id INT,
    tipo_id INT,
    altura DOUBLE,
    largura DOUBLE,
    comprimento DOUBLE,
    peso DOUBLE,
    empilhavel BOOLEAN,
    observacoes TEXT,
    FOREIGN KEY (produto_id) REFERENCES produtos(id),
    FOREIGN KEY (tipo_id) REFERENCES tipo_embalagem(id)
);
select * from veiculos;
select * from tipo_veiculo order by id asc;
select * from produtos;
SELECT nome from tipo_embalagem,embalagens;
#drop database sistematransportadora;