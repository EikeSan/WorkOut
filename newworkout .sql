-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 30-Jun-2016 às 05:41
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `newworkout`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `email` varchar(20) NOT NULL,
  `id` int(20) NOT NULL,
  `nome` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`email`, `id`, `nome`) VALUES
('bombinha@hot', 4, 'teste'),
('dasda', 4, 'teste'),
('diogofb93@hail.com', 4, 'teste'),
('dsada', 4, 'brilll'),
('dsadas', 4, 'dasdas'),
('gordinho@gmail.com', 3, 'Gordinho'),
('gordo@hotmail.com', 4, 'Gordo'),
('mb@hotmail.com', 4, 'tt'),
('novo@email.com', 4, 'novo'),
('teste@gmail.com', 3, 'teste'),
('teste@ttt.com', 1, 'dio');

-- --------------------------------------------------------

--
-- Estrutura da tabela `events`
--

CREATE TABLE `events` (
  `event_id` int(11) NOT NULL,
  `event_name` varchar(127) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `ID_PERSONAL` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `events`
--

INSERT INTO `events` (`event_id`, `event_name`, `start_date`, `end_date`, `ID_PERSONAL`) VALUES
(1, 'teste', '2016-06-24 05:45:00', '2016-06-24 08:25:00', 1),
(3, 'Event from db #3', '2016-06-25 05:00:00', '2016-06-26 09:00:00', 4),
(4, 'teste', '2016-06-22 03:35:00', '2016-06-25 03:40:00', 0),
(5, 'teste salvar', '2016-06-25 03:50:00', '2016-06-25 10:05:00', 4),
(6, 'teste rafa', '2016-06-28 03:15:00', '2016-06-28 03:20:00', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `personal`
--

CREATE TABLE `personal` (
  `id` int(20) NOT NULL,
  `nome` varchar(20) DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `personal`
--

INSERT INTO `personal` (`id`, `nome`, `senha`, `email`) VALUES
(1, 'admin', 'admin', 'admin@admin.com'),
(3, 'Rafa', 'rafa', 'mrafaf@hotmail.com'),
(4, 'Maromba', 'bomba', 'maromba@email.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `peso`
--

CREATE TABLE `peso` (
  `peso` int(20) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `email` varchar(20) NOT NULL,
  `id_peso` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `peso`
--

INSERT INTO `peso` (`peso`, `data`, `email`, `id_peso`) VALUES
(60, '2016-06-23 17:58:10', 'gordinho@gmail.com', 1),
(78, '2016-06-25 03:59:59', 'gordo@hotmail.com', 2),
(110, '2016-06-25 04:59:37', 'novo@email.com', 5),
(70, '2016-06-29 14:19:36', 'gordinho@gmail.com', 6),
(5, '2016-06-29 15:19:00', 'gordinho@gmail.com', 7),
(100, '2016-06-29 14:41:37', 'gordinho@gmail.com', 8),
(70, '2016-06-29 14:54:03', 'gordinho@gmail.com', 10),
(12, '2016-06-29 15:08:07', 'gordinho@gmail.com', 12),
(10, '2016-06-29 15:09:15', 'gordinho@gmail.com', 13),
(22, '2016-06-29 15:26:13', 'gordinho@gmail.com', 14),
(12, '2016-06-29 19:24:36', 'gordinho@gmail.com', 18),
(40, '2016-06-29 23:20:50', 'novo@email.com', 19),
(40, '2016-06-29 23:21:27', 'novo@email.com', 20),
(45, '2016-06-29 23:21:27', 'novo@email.com', 21),
(50, '2016-06-29 23:21:27', 'novo@email.com', 22),
(53, '2016-06-29 23:21:27', 'novo@email.com', 23),
(55, '2016-06-29 23:21:27', 'novo@email.com', 24),
(60, '2016-06-29 23:21:27', 'novo@email.com', 25);

-- --------------------------------------------------------

--
-- Estrutura da tabela `treino`
--

CREATE TABLE `treino` (
  `email` varchar(20) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `exercicio` varchar(20) NOT NULL,
  `id_treino` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `treino`
--

INSERT INTO `treino` (`email`, `tipo`, `exercicio`, `id_treino`) VALUES
('gordinho@gmail.com', 'Aerobico', 'teste1', 1),
('gordo@hotmail.com', 'teste', 'teste2', 2),
('gordo@hotmail.com', 'Resistencia', 'correr', 3),
('mb@hotmail.com', 'Resistencia', 'correr', 4),
('novo@email.com', 'Resistencia', 'correr', 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`email`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`event_id`);

--
-- Indexes for table `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `peso`
--
ALTER TABLE `peso`
  ADD PRIMARY KEY (`peso`,`data`,`email`),
  ADD UNIQUE KEY `ID_PESO` (`id_peso`),
  ADD KEY `email` (`email`);

--
-- Indexes for table `treino`
--
ALTER TABLE `treino`
  ADD PRIMARY KEY (`email`,`tipo`,`exercicio`),
  ADD UNIQUE KEY `id_treino` (`id_treino`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `event_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `personal`
--
ALTER TABLE `personal`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `peso`
--
ALTER TABLE `peso`
  MODIFY `id_peso` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `treino`
--
ALTER TABLE `treino`
  MODIFY `id_treino` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `aluno_ibfk_1` FOREIGN KEY (`id`) REFERENCES `personal` (`id`);

--
-- Limitadores para a tabela `peso`
--
ALTER TABLE `peso`
  ADD CONSTRAINT `peso_ibfk_1` FOREIGN KEY (`email`) REFERENCES `aluno` (`email`);

--
-- Limitadores para a tabela `treino`
--
ALTER TABLE `treino`
  ADD CONSTRAINT `treino_ibfk_1` FOREIGN KEY (`email`) REFERENCES `aluno` (`email`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
