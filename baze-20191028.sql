-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 28, 2019 at 08:47 AM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `baze`
--

-- --------------------------------------------------------

--
-- Table structure for table `krovininiai`
--

CREATE TABLE `krovininiai` (
  `id` int(11) NOT NULL,
  `marke` varchar(20) COLLATE utf8_lithuanian_ci NOT NULL,
  `modelis` varchar(20) COLLATE utf8_lithuanian_ci NOT NULL,
  `metai` int(4) NOT NULL,
  `galia` int(11) NOT NULL,
  `nuotrauka` varchar(100) COLLATE utf8_lithuanian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Dumping data for table `krovininiai`
--

INSERT INTO `krovininiai` (`id`, `marke`, `modelis`, `metai`, `galia`, `nuotrauka`) VALUES
(1, 'Volvo', 'FH', 2000, 300, 'nera'),
(2, 'Volvo', 'VH', 2001, 400, 'nera'),
(3, 'Volvo', 'FM', 2018, 500, 'fm.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `lengvieji`
--

CREATE TABLE `lengvieji` (
  `id` int(11) NOT NULL,
  `marke` varchar(20) COLLATE utf8_lithuanian_ci NOT NULL,
  `modelis` varchar(20) COLLATE utf8_lithuanian_ci NOT NULL,
  `metai` int(4) NOT NULL,
  `savybe` varchar(20) COLLATE utf8_lithuanian_ci NOT NULL,
  `nuotrauka` varchar(100) COLLATE utf8_lithuanian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Dumping data for table `lengvieji`
--

INSERT INTO `lengvieji` (`id`, `marke`, `modelis`, `metai`, `savybe`, `nuotrauka`) VALUES
(1, 'Volvo', 'S60', 2019, 'sedanas', 'nera'),
(2, 'Volvo', 'V60', 2019, 'Universalas', 'nera'),
(3, 'BMW', 'E60', 2009, 'Sedanas', 'E60.jpg'),
(4, 'Opel', 'Crossland X', 2018, 'SUV', 'nera'),
(5, 'Audi', 'A6', 2009, 'Universalas', 'nera'),
(6, 'Volkswagen', 'Passat', 2009, 'Sedanas', 'Autofac.dll'),
(7, 'Dodge', 'Charger', 2018, 'Sedanas', 'charger.jpg'),
(8, 'Ferrari', 'F8', 2018, 'greitas', 'ff8.jpg'),
(9, 'Dodge', 'Viper', 2018, 'greitas', 'viper.jpg'),
(10, 'asd', 'asd', 111, 'asd', 'viper.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `mikroautobusai`
--

CREATE TABLE `mikroautobusai` (
  `id` int(11) NOT NULL,
  `marke` varchar(20) COLLATE utf8_lithuanian_ci NOT NULL,
  `modelis` varchar(20) COLLATE utf8_lithuanian_ci NOT NULL,
  `metai` int(4) NOT NULL,
  `vietos` int(1) NOT NULL,
  `nuotrauka` varchar(100) COLLATE utf8_lithuanian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Dumping data for table `mikroautobusai`
--

INSERT INTO `mikroautobusai` (`id`, `marke`, `modelis`, `metai`, `vietos`, `nuotrauka`) VALUES
(1, 'Opel', 'Vivaro', 2018, 8, 'nera'),
(4, 'Volkswagen', 'Transporter', 2019, 7, 'Transporter.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `specialus`
--

CREATE TABLE `specialus` (
  `id` int(11) NOT NULL,
  `marke` varchar(20) COLLATE utf8_lithuanian_ci NOT NULL,
  `modelis` varchar(20) COLLATE utf8_lithuanian_ci NOT NULL,
  `metai` int(4) NOT NULL,
  `paskirtis` varchar(20) COLLATE utf8_lithuanian_ci NOT NULL,
  `nuotrauka` varchar(100) COLLATE utf8_lithuanian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `krovininiai`
--
ALTER TABLE `krovininiai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lengvieji`
--
ALTER TABLE `lengvieji`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mikroautobusai`
--
ALTER TABLE `mikroautobusai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `specialus`
--
ALTER TABLE `specialus`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `krovininiai`
--
ALTER TABLE `krovininiai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `lengvieji`
--
ALTER TABLE `lengvieji`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `mikroautobusai`
--
ALTER TABLE `mikroautobusai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `specialus`
--
ALTER TABLE `specialus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
