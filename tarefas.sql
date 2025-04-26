-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26/04/2025 às 02:57
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `tarefas`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `board`
--

CREATE TABLE `board` (
  `cod_board` int(11) NOT NULL,
  `titulo_board` varchar(30) DEFAULT NULL,
  `estado_board` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `board`
--

INSERT INTO `board` (`cod_board`, `titulo_board`, `estado_board`) VALUES
(2, 'Projeto X', 'Ativo'),
(3, 'Projeto X', 'Ativo'),
(4, 'Projeto X', 'Ativo'),
(5, 'Projeto X', 'Ativo'),
(6, 'Projeto X', 'Ativo');

-- --------------------------------------------------------

--
-- Estrutura para tabela `card`
--

CREATE TABLE `card` (
  `cod_card` int(11) NOT NULL,
  `cod_board` int(11) DEFAULT NULL,
  `titulo_card` varchar(30) DEFAULT NULL,
  `desc_card` varchar(100) DEFAULT NULL,
  `estado_card` varchar(30) DEFAULT NULL,
  `data_criacao` date DEFAULT NULL,
  `bloqueado` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `board`
--
ALTER TABLE `board`
  ADD PRIMARY KEY (`cod_board`);

--
-- Índices de tabela `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`cod_card`),
  ADD KEY `fk_card_board` (`cod_board`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `board`
--
ALTER TABLE `board`
  MODIFY `cod_board` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `card`
--
ALTER TABLE `card`
  MODIFY `cod_card` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `card`
--
ALTER TABLE `card`
  ADD CONSTRAINT `fk_card_board` FOREIGN KEY (`cod_board`) REFERENCES `board` (`cod_board`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
