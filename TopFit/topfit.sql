-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 27-Fev-2019 às 14:04
-- Versão do servidor: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `topfit`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos`
--

CREATE TABLE `alunos` (
  `id_aluno` varchar(99) NOT NULL,
  `data_cadastro` date NOT NULL,
  `nome` varchar(99) NOT NULL,
  `data_nascimento` date NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `cpf` varchar(16) NOT NULL,
  `rua` varchar(99) NOT NULL,
  `NumDaCasa` int(5) NOT NULL,
  `bairro` varchar(99) NOT NULL,
  `cidade` varchar(58) NOT NULL,
  `cep` varchar(20) NOT NULL,
  `uf` char(2) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `observacao` text NOT NULL,
  `email` varchar(50) NOT NULL,
  `img` longblob NOT NULL,
  `idade` varchar(3) NOT NULL,
  `pagamento` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `frequencia`
--

CREATE TABLE `frequencia` (
  `id_aluno` varchar(99) NOT NULL,
  `nome` varchar(99) NOT NULL,
  `data` date NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE `funcionarios` (
  `id_func` varchar(99) NOT NULL,
  `data_cadastro` date NOT NULL,
  `nome` varchar(99) NOT NULL,
  `data_nascimento` date NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `cpf` varchar(16) NOT NULL,
  `rua` varchar(99) NOT NULL,
  `NumDaCasa` varchar(5) NOT NULL,
  `bairro` varchar(99) NOT NULL,
  `cidade` varchar(58) NOT NULL,
  `cep` varchar(20) NOT NULL,
  `uf` char(2) NOT NULL,
  `telefone` varchar(99) NOT NULL,
  `celular` varchar(99) NOT NULL,
  `observacao` text NOT NULL,
  `email` varchar(99) NOT NULL,
  `img` longblob NOT NULL,
  `idade` varchar(3) NOT NULL,
  `apelido` varchar(50) NOT NULL,
  `estado_civil` varchar(50) NOT NULL,
  `funcao` varchar(99) NOT NULL,
  `salario` varchar(99) NOT NULL,
  `usuario` varchar(99) NOT NULL,
  `senha` varchar(99) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `matriculas`
--

CREATE TABLE `matriculas` (
  `id` varchar(99) NOT NULL,
  `id_aluno` varchar(99) NOT NULL,
  `nome` varchar(99) NOT NULL,
  `id_modalidade` varchar(99) NOT NULL,
  `modalidade` varchar(99) NOT NULL,
  `valor` float NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `modalidade`
--

CREATE TABLE `modalidade` (
  `id_modalidade` varchar(99) NOT NULL,
  `modalidade` varchar(99) NOT NULL,
  `preco` float(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamentos`
--

CREATE TABLE `pagamentos` (
  `recibo` int(99) NOT NULL,
  `id_aluno` varchar(99) NOT NULL,
  `descricao` varchar(99) NOT NULL,
  `valor` float(5,2) NOT NULL,
  `data` date NOT NULL,
  `hora` time NOT NULL,
  `data_vencimento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`id_aluno`);

--
-- Indexes for table `frequencia`
--
ALTER TABLE `frequencia`
  ADD KEY `id_aluno` (`id_aluno`);

--
-- Indexes for table `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`id_func`);

--
-- Indexes for table `matriculas`
--
ALTER TABLE `matriculas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_aluno` (`id_aluno`),
  ADD KEY `id_modalidade` (`id_modalidade`);

--
-- Indexes for table `modalidade`
--
ALTER TABLE `modalidade`
  ADD PRIMARY KEY (`id_modalidade`);

--
-- Indexes for table `pagamentos`
--
ALTER TABLE `pagamentos`
  ADD PRIMARY KEY (`recibo`),
  ADD KEY `id_aluno` (`id_aluno`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pagamentos`
--
ALTER TABLE `pagamentos`
  MODIFY `recibo` int(99) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `frequencia`
--
ALTER TABLE `frequencia`
  ADD CONSTRAINT `frequencia_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `alunos` (`id_aluno`);

--
-- Limitadores para a tabela `matriculas`
--
ALTER TABLE `matriculas`
  ADD CONSTRAINT `matriculas_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `alunos` (`id_aluno`),
  ADD CONSTRAINT `matriculas_ibfk_2` FOREIGN KEY (`id_modalidade`) REFERENCES `modalidade` (`id_modalidade`);

--
-- Limitadores para a tabela `pagamentos`
--
ALTER TABLE `pagamentos`
  ADD CONSTRAINT `pagamentos_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `alunos` (`id_aluno`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
