-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-12-2019 a las 11:52:03
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `musicos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `idgenero` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`idgenero`, `descripcion`) VALUES
(1, 'rock'),
(2, 'pop'),
(3, 'clasica'),
(4, 'neoclasica'),
(5, 'dsfsdf'),
(6, 'dsfsdf');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generosgrupo`
--

CREATE TABLE `generosgrupo` (
  `idgrupo` int(11) NOT NULL,
  `idgenero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

CREATE TABLE `grupo` (
  `idgrupo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `formacion` date NOT NULL,
  `desintegracion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `grupo`
--

INSERT INTO `grupo` (`idgrupo`, `nombre`, `formacion`, `desintegracion`) VALUES
(2, 'defw', '2000-01-01', NULL),
(32, 'defw', '2000-01-01', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `musico`
--

CREATE TABLE `musico` (
  `idmusico` int(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `instrumento` varchar(100) NOT NULL,
  `lugarnacimiento` varchar(100) NOT NULL,
  `fechanacimiento` date NOT NULL,
  `fechamuerte` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `musico`
--

INSERT INTO `musico` (`idmusico`, `nombre`, `instrumento`, `lugarnacimiento`, `fechanacimiento`, `fechamuerte`) VALUES
(3, 'asd', 'ad', 'asd', '2019-10-01', '2019-11-21'),
(4, 'ad', 'sad', 'ads', '2019-11-12', '2019-11-12'),
(5, 'asd', 'asd', 'asd', '2019-11-29', '2019-12-03'),
(6, 'asd', 'asd', 'asd', '2019-11-29', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `musicosgrupos`
--

CREATE TABLE `musicosgrupos` (
  `idgrupo` int(11) NOT NULL,
  `idmusico` int(11) NOT NULL,
  `instrumento` varchar(45) NOT NULL,
  `fechainicio` date NOT NULL,
  `fechafn` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`idgenero`);

--
-- Indices de la tabla `generosgrupo`
--
ALTER TABLE `generosgrupo`
  ADD PRIMARY KEY (`idgrupo`,`idgenero`),
  ADD KEY `generosgrupo_ibfk_1` (`idgenero`);

--
-- Indices de la tabla `grupo`
--
ALTER TABLE `grupo`
  ADD PRIMARY KEY (`idgrupo`);

--
-- Indices de la tabla `musico`
--
ALTER TABLE `musico`
  ADD PRIMARY KEY (`idmusico`);

--
-- Indices de la tabla `musicosgrupos`
--
ALTER TABLE `musicosgrupos`
  ADD PRIMARY KEY (`idgrupo`,`idmusico`),
  ADD KEY `musicosgrupos_ibfk_2` (`idmusico`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `generosgrupo`
--
ALTER TABLE `generosgrupo`
  ADD CONSTRAINT `generosgrupo_ibfk_1` FOREIGN KEY (`idgenero`) REFERENCES `genero` (`idgenero`) ON DELETE CASCADE;

--
-- Filtros para la tabla `musicosgrupos`
--
ALTER TABLE `musicosgrupos`
  ADD CONSTRAINT `musicosgrupos_ibfk_1` FOREIGN KEY (`idgrupo`) REFERENCES `grupo` (`idgrupo`) ON DELETE CASCADE,
  ADD CONSTRAINT `musicosgrupos_ibfk_2` FOREIGN KEY (`idmusico`) REFERENCES `musico` (`idmusico`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
