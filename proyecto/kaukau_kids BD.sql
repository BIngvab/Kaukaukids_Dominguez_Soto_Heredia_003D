-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-05-2026 a las 02:49:32
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `kaukau_kids`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE `eventos` (
  `id_evento` int(11) NOT NULL,
  `nombre_evento` varchar(100) DEFAULT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `cantidad_ninos` int(11) DEFAULT NULL,
  `cantidad_adultos` int(11) DEFAULT NULL,
  `estado` enum('Pendiente','Confirmado','Pagado','Finalizado') DEFAULT 'Pendiente',
  `id_cliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `eventos`
--

INSERT INTO `eventos` (`id_evento`, `nombre_evento`, `fecha`, `hora`, `direccion`, `cantidad_ninos`, `cantidad_adultos`, `estado`, `id_cliente`) VALUES
(1, 'Cumpleaños Mateo', '2026-06-20', '15:00:00', 'Maipu 123', 20, 15, 'Pendiente', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento_servicios`
--

CREATE TABLE `evento_servicios` (
  `id_evento_servicio` int(11) NOT NULL,
  `id_evento` int(11) DEFAULT NULL,
  `id_servicio` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `evento_servicios`
--

INSERT INTO `evento_servicios` (`id_evento_servicio`, `id_evento`, `id_servicio`, `cantidad`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 1),
(3, 1, 4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `minuta`
--

CREATE TABLE `minuta` (
  `id_minuta` int(11) NOT NULL,
  `comida` varchar(100) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `id_evento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `minuta`
--

INSERT INTO `minuta` (`id_minuta`, `comida`, `cantidad`, `id_evento`) VALUES
(1, 'Completos', 30, 1),
(2, 'Bebidas', 40, 1),
(3, 'Torta', 1, 1),
(4, 'Cupcakes', 25, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `id_pago` int(11) NOT NULL,
  `monto` decimal(10,2) DEFAULT NULL,
  `fecha_pago` date DEFAULT NULL,
  `metodo_pago` varchar(50) DEFAULT NULL,
  `estado` enum('Pendiente','Pagado') DEFAULT 'Pendiente',
  `id_evento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pagos`
--

INSERT INTO `pagos` (`id_pago`, `monto`, `fecha_pago`, `metodo_pago`, `estado`, `id_evento`) VALUES
(1, 175000.00, '2026-06-15', 'Transferencia', 'Pagado', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_rol` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_rol`, `nombre`) VALUES
(1, 'Administrador'),
(2, 'Cliente'),
(3, 'Staff'),
(4, 'Supervisor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `id_servicio` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`id_servicio`, `nombre`, `descripcion`, `precio`) VALUES
(1, 'Inflable', 'Juego inflable para niños', 50000.00),
(2, 'DJ', 'Musica y animacion DJ', 80000.00),
(3, 'Pintacaritas', 'Servicio de maquillaje infantil', 30000.00),
(4, 'Payaso', 'Show de payaso infantil', 45000.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `staff`
--

CREATE TABLE `staff` (
  `id_staff` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `especialidad` enum('Animacion','DJ','Servicio','Supervisor') DEFAULT NULL,
  `disponibilidad` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `staff`
--

INSERT INTO `staff` (`id_staff`, `id_usuario`, `especialidad`, `disponibilidad`) VALUES
(4, 5, 'DJ', 1),
(5, 6, 'Animacion', 1),
(6, 7, 'Supervisor', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareas`
--

CREATE TABLE `tareas` (
  `id_tarea` int(11) NOT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `estado` enum('Pendiente','En Progreso','Completada') DEFAULT 'Pendiente',
  `hora_inicio` datetime DEFAULT NULL,
  `hora_termino` datetime DEFAULT NULL,
  `id_evento` int(11) DEFAULT NULL,
  `id_staff` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tareas`
--

INSERT INTO `tareas` (`id_tarea`, `titulo`, `descripcion`, `estado`, `hora_inicio`, `hora_termino`, `id_evento`, `id_staff`) VALUES
(1, 'Configurar sonido', 'Preparar sistema DJ y audio', 'Pendiente', '2026-06-20 14:00:00', '2026-06-20 15:00:00', 1, 4),
(2, 'Animacion infantil', 'Realizar juegos y dinamicas', 'Pendiente', '2026-06-20 15:00:00', '2026-06-20 17:00:00', 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre`, `correo`, `password`, `id_rol`) VALUES
(1, 'Alexander', 'alex@gmail.com', '123456', 1),
(5, 'Matias DJ', 'matias@gmail.com', '123456', 3),
(6, 'Camila Animadora', 'camila@gmail.com', '123456', 3),
(7, 'Diego Supervisor', 'diego@gmail.com', '123456', 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`id_evento`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `evento_servicios`
--
ALTER TABLE `evento_servicios`
  ADD PRIMARY KEY (`id_evento_servicio`),
  ADD KEY `id_evento` (`id_evento`),
  ADD KEY `id_servicio` (`id_servicio`);

--
-- Indices de la tabla `minuta`
--
ALTER TABLE `minuta`
  ADD PRIMARY KEY (`id_minuta`),
  ADD KEY `id_evento` (`id_evento`);

--
-- Indices de la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD PRIMARY KEY (`id_pago`),
  ADD KEY `id_evento` (`id_evento`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`id_servicio`);

--
-- Indices de la tabla `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id_staff`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD PRIMARY KEY (`id_tarea`),
  ADD KEY `id_evento` (`id_evento`),
  ADD KEY `id_staff` (`id_staff`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_usuario_rol` (`id_rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `eventos`
--
ALTER TABLE `eventos`
  MODIFY `id_evento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `evento_servicios`
--
ALTER TABLE `evento_servicios`
  MODIFY `id_evento_servicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `minuta`
--
ALTER TABLE `minuta`
  MODIFY `id_minuta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `pagos`
--
ALTER TABLE `pagos`
  MODIFY `id_pago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `servicios`
--
ALTER TABLE `servicios`
  MODIFY `id_servicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `staff`
--
ALTER TABLE `staff`
  MODIFY `id_staff` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tareas`
--
ALTER TABLE `tareas`
  MODIFY `id_tarea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `eventos`
--
ALTER TABLE `eventos`
  ADD CONSTRAINT `eventos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `evento_servicios`
--
ALTER TABLE `evento_servicios`
  ADD CONSTRAINT `evento_servicios_ibfk_1` FOREIGN KEY (`id_evento`) REFERENCES `eventos` (`id_evento`),
  ADD CONSTRAINT `evento_servicios_ibfk_2` FOREIGN KEY (`id_servicio`) REFERENCES `servicios` (`id_servicio`);

--
-- Filtros para la tabla `minuta`
--
ALTER TABLE `minuta`
  ADD CONSTRAINT `minuta_ibfk_1` FOREIGN KEY (`id_evento`) REFERENCES `eventos` (`id_evento`);

--
-- Filtros para la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD CONSTRAINT `pagos_ibfk_1` FOREIGN KEY (`id_evento`) REFERENCES `eventos` (`id_evento`);

--
-- Filtros para la tabla `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD CONSTRAINT `tareas_ibfk_1` FOREIGN KEY (`id_evento`) REFERENCES `eventos` (`id_evento`),
  ADD CONSTRAINT `tareas_ibfk_2` FOREIGN KEY (`id_staff`) REFERENCES `staff` (`id_staff`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
