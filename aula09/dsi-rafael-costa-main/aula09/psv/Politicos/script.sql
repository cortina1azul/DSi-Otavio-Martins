CREATE DATABASE IF NOT EXISTS politicos_pt;
USE politicos_pt;

CREATE TABLE IF NOT EXISTS politico (
    id            INT AUTO_INCREMENT PRIMARY KEY,
    nome          VARCHAR(100) NOT NULL,
    cargo         VARCHAR(50),
    uf            CHAR(2),
    ano_filiacao  INT
);
