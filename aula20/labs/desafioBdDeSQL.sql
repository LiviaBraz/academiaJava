-- 1) CREATE TABLES

CREATE TABLE departamentos (
    id SERIAL PRIMARY KEY,
    nome text
);

CREATE TABLE funcionarios (
    id SERIAL PRIMARY KEY,
    nome text,
    cargo text,
    salario numeric(10, 2),
    dataContratacao date,
    departamentoID int,
    FOREIGN KEY (departamentoID) REFERENCES departamentos(id)
);

-- 2) INSERTs

INSERT INTO departamentos (nome)
VALUES 
	('TI'),
	('Recursos Humanos'),
	('Financeiro'),
	('Vendas');

INSERT INTO funcionarios (nome, cargo, salario, dataContratacao, departamentoID)
VALUES
    ('João Silva', 'Gerente', 5000.00, '2020-01-01', 1),
    ('Maria Santos', 'Assistente', 2000.00, '2019-05-15', 2),
    ('Pedro Costa', 'Analista', 3000.00, '2020-03-20', 1),
    ('Ana Pereira', 'Gerente', 5000.00, '2021-01-01', 2);
    
-- 3) 

SELECT 
	*
FROM
	funcionarios;

-- 4)

SELECT
	*
FROM 
	funcionarios
WHERE
	salario > 3000;

-- 5)

UPDATE 
	funcionarios 
SET 
	salario = 3500
WHERE
	id = 3;

-- 6)

DELETE 
FROM 
	funcionarios
WHERE
	id = 2; 

-- 7)

SELECT
	nome, salario
FROM
	funcionarios
ORDER BY 
	salario DESC;

-- 8)

SELECT 
	cargo, AVG(salario)
FROM
	funcionarios
GROUP BY 
	1;

-- 9)

SELECT
	f.nome, d.nome
FROM
	funcionarios f
LEFT JOIN
	departamentos d
ON
	f.departamentoID = d.id;
	
-- 10)

SELECT
	d.nome AS departamento,
	COUNT(*) AS nroFuncionarios	
FROM
	funcionarios f
LEFT JOIN 
	departamentos d
ON
	f.departamentoID = d.id
GROUP BY 
	1;