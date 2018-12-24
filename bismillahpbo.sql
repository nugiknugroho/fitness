-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 24, 2018 at 01:45 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bismillahpbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `tempatlahir` varchar(50) NOT NULL,
  `tanggallahir` date NOT NULL,
  `id_gender` varchar(10) NOT NULL,
  `no_telp` int(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `password`, `nama`, `tempatlahir`, `tanggallahir`, `id_gender`, `no_telp`) VALUES
('admin', '21232f297a57a5a743894a0e4a801fc3', 'Administrator', 'Malang', '1998-09-09', 'Pria', 283783784),
('admin2', 'c84258e9c39059a89ab77d846ddab909', 'Administrator2', 'Malang', '1997-09-09', 'Wanita', 43644567),
('rutab', 'a8e8c4a70419c90f1a32d26a1fd4503e', 'Rutab', 'Malang', '2012-06-17', 'Pria', 90129),
('nugik', 'a5178fba733b8c99b89533a33a2f3e3b', 'Nugroho', 'Malang', '2012-01-10', 'Pria', 89768654),
('sunaryo', 'c2e0b70e960def025b658b7928b7f0f6', 'Sunaryo', 'Malang', '2012-03-13', 'Pria', 98767654),
('tegar', '1d31802d64bae29d88923d795fc73734', 'Tegar', 'Malang', '2012-05-17', 'Pria', 98775),
('ali', '86318e52f5ed4801abe1d13d509443de', 'Ali Akbar', 'Malang', '2012-03-17', 'Pria', 9865778);

-- --------------------------------------------------------

--
-- Table structure for table `gender`
--

CREATE TABLE `gender` (
  `id_gender` varchar(10) NOT NULL,
  `gender` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gender`
--

INSERT INTO `gender` (`id_gender`, `gender`) VALUES
('Pria', 'Pria'),
('Wanita', 'Wanita');

-- --------------------------------------------------------

--
-- Table structure for table `harga`
--

CREATE TABLE `harga` (
  `id_harga` varchar(10) NOT NULL,
  `idTipe` varchar(10) NOT NULL,
  `harga` int(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `harga`
--

INSERT INTO `harga` (`id_harga`, `idTipe`, `harga`) VALUES
('Bulan', 'Bulanan', 500000),
('Hari', 'Harian', 50000);

-- --------------------------------------------------------

--
-- Table structure for table `log_login`
--

CREATE TABLE `log_login` (
  `id` bigint(20) NOT NULL,
  `id_admin` varchar(50) NOT NULL,
  `waktu_login` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `waktu_logout` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `log_login`
--

INSERT INTO `log_login` (`id`, `id_admin`, `waktu_login`, `waktu_logout`) VALUES
(1, 'admin', '2017-12-03 09:52:19', '0000-00-00 00:00:00'),
(2, 'admin', '2017-12-03 09:54:52', '0000-00-00 00:00:00'),
(3, 'admin', '2017-12-03 09:57:46', '0000-00-00 00:00:00'),
(4, 'admin', '2017-12-03 14:07:17', '0000-00-00 00:00:00'),
(5, 'admin', '2017-12-03 14:08:13', '0000-00-00 00:00:00'),
(6, 'admin', '2017-12-03 14:09:08', '0000-00-00 00:00:00'),
(7, 'rutab', '2017-12-03 14:29:13', '0000-00-00 00:00:00'),
(8, 'nugik', '2017-12-03 22:16:52', '0000-00-00 00:00:00'),
(9, 'sunaryo', '2017-12-04 03:05:48', '0000-00-00 00:00:00'),
(10, 'nugik', '2017-12-04 06:20:14', '0000-00-00 00:00:00'),
(11, 'admin', '2017-12-04 06:28:09', '2017-12-04 06:28:15'),
(12, 'nugik', '2017-12-04 06:53:37', '2017-12-04 06:53:37'),
(13, 'admin', '2017-12-04 11:45:14', '2017-12-04 11:45:14'),
(14, 'admin', '2017-12-04 17:27:43', '2017-12-04 17:27:43'),
(15, 'admin', '2017-12-04 17:44:26', '2017-12-04 17:44:39'),
(16, 'admin', '2017-12-04 17:46:35', '2017-12-04 17:46:35'),
(17, 'nugik', '2017-12-05 00:02:58', '2017-12-05 00:03:36'),
(18, 'admin', '2017-12-05 00:08:15', '2017-12-05 00:08:15'),
(19, 'nugik', '2017-12-05 00:13:40', '2017-12-05 00:13:51'),
(20, 'admin', '2017-12-05 03:51:56', '2017-12-05 03:53:50'),
(21, 'admin', '2017-12-05 11:51:08', '2017-12-05 11:51:08'),
(22, 'nugik', '2017-12-05 18:15:45', '2017-12-05 18:15:45'),
(23, 'nugik', '2017-12-05 18:16:37', '2017-12-05 18:16:37'),
(24, 'nugik', '2017-12-05 18:18:12', '2017-12-05 18:18:12'),
(25, 'admin', '2017-12-06 03:00:45', '2017-12-06 03:01:01'),
(26, 'tegar', '2017-12-06 03:05:43', '2017-12-06 03:05:43'),
(27, 'nugik', '2017-12-06 03:07:40', '2017-12-06 03:07:47'),
(28, 'nugik', '2017-12-06 03:08:59', '2017-12-06 03:09:04'),
(29, 'admin', '2017-12-06 03:09:37', '2017-12-06 03:09:42'),
(30, 'admin', '2017-12-06 05:32:19', '2017-12-06 05:32:40'),
(31, 'admin', '2017-12-06 05:32:48', '2017-12-06 05:32:48'),
(32, 'admin', '2017-12-06 05:42:41', '2017-12-06 05:45:21'),
(33, 'ali', '2017-12-06 06:15:15', '2017-12-06 06:16:11'),
(34, 'admin', '2017-12-06 06:37:06', '2017-12-06 06:37:06'),
(35, 'admin', '2018-09-02 00:08:13', '2018-09-02 00:10:56'),
(36, 'admin', '2018-09-02 03:09:40', '2018-09-02 03:09:40'),
(37, 'nugik', '2018-11-23 11:45:20', '2018-11-23 11:45:20'),
(38, 'nugik', '2018-11-23 12:07:49', '2018-11-23 12:07:49');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `tempatlahir` varchar(100) NOT NULL,
  `tanggallahir` date NOT NULL,
  `id_gender` varchar(10) NOT NULL,
  `usia` int(10) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `no_telp` int(20) NOT NULL,
  `idTipe` varchar(10) NOT NULL,
  `id_harga` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `nama`, `tempatlahir`, `tanggallahir`, `id_gender`, `usia`, `alamat`, `no_telp`, `idTipe`, `id_harga`) VALUES
(12, 'Nugroho', 'Malang', '2012-10-14', 'Pria', 21, 'Malang', 213121, 'Bulanan', 'Bulan'),
(2, 'Tegar Aditya', 'Ponorog', '0009-05-06', 'Pria', 19, 'Ponorogo', 3903208, 'Bulanan', 'Bulan'),
(3, 'Rutab', 'Malang', '2012-05-17', 'Wanita', 21, 'Kediri', 920389283, 'Bulanan', 'Bulan'),
(123, 'Chuzaimah', 'Malang', '2012-05-17', 'Wanita', 31, 'Malang', 45353453, 'Bulanan', 'Bulan'),
(234, 'Hafid Rizqi', 'Malang', '2012-03-17', 'Pria', 12, 'Nganjuk', 76866556, 'Harian', 'Hari'),
(131, 'Ahmad Rizaz', 'Tuban', '2011-02-11', 'Pria', 21, 'Tuban', 98786754, 'Harian', 'Hari'),
(89, 'Anis', 'Malang', '2012-12-12', 'Wanita', 19, 'Malang	', 986557, 'Harian', 'Hari');

-- --------------------------------------------------------

--
-- Table structure for table `tipemember`
--

CREATE TABLE `tipemember` (
  `idTipe` varchar(10) NOT NULL,
  `Tipe` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipemember`
--

INSERT INTO `tipemember` (`idTipe`, `Tipe`) VALUES
('Bulanan', 'Bulanan'),
('Harian', 'Harian');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `gender`
--
ALTER TABLE `gender`
  ADD PRIMARY KEY (`id_gender`);

--
-- Indexes for table `harga`
--
ALTER TABLE `harga`
  ADD PRIMARY KEY (`id_harga`);

--
-- Indexes for table `log_login`
--
ALTER TABLE `log_login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tipemember`
--
ALTER TABLE `tipemember`
  ADD PRIMARY KEY (`idTipe`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `log_login`
--
ALTER TABLE `log_login`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1233;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
