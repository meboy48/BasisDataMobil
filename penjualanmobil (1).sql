-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 26, 2018 at 10:22 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penjualanmobil`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `countmobil` (IN `mobil` INT, OUT `total` INT)  Begin
Select count(kode_mobil)
INTO total
from transaksi
where mobil = kode_mobil; END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `hadiah` (IN `nam` VARCHAR(225), OUT `hadiah` VARCHAR(10))  BEGIN
declare jeneng varchar(255);
SELECT nama into jeneng
FROM transaksi
WHERE nama = nam;

IF jeneng like '%tri%' THEN
SET hadiah = 'HP';
ELSEIF jeneng like '%tek%' THEN
SET hadiah = 'Payung';
ELSEIF jeneng like '%feb%' THEN
SET hadiah = 'Tupperware';
END IF;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `faktur`
--

CREATE TABLE `faktur` (
  `no_faktur` int(10) NOT NULL,
  `kode_pembeli` int(10) NOT NULL,
  `kode_mobil` int(10) NOT NULL,
  `tgl_fktur` varchar(10) NOT NULL,
  `jam_fktur` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faktur`
--

INSERT INTO `faktur` (`no_faktur`, `kode_pembeli`, `kode_mobil`, `tgl_fktur`, `jam_fktur`) VALUES
(1, 1, 1, '19/2/2003', '20:10:44'),
(2, 2, 2, '16/2/2016', '20:20:10'),
(3, 3, 2, '16/2/2016', '20:20:10'),
(4, 4, 2, '20/2/2018', '10:10:10'),
(5, 5, 1, '19/02/2018', '10:10:50'),
(6, 5, 2, '21/2/11', '22:10:10');

-- --------------------------------------------------------

--
-- Table structure for table `mobil`
--

CREATE TABLE `mobil` (
  `kode_mobil` int(10) NOT NULL,
  `nama_mobil` varchar(20) NOT NULL,
  `merk` varchar(20) NOT NULL,
  `warna` varchar(20) NOT NULL,
  `tahun` int(10) NOT NULL,
  `harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mobil`
--

INSERT INTO `mobil` (`kode_mobil`, `nama_mobil`, `merk`, `warna`, `tahun`, `harga`) VALUES
(1, 'Avanza', 'Toyota', 'Hitam', 2016, 100000000),
(2, 'Xenia', 'Daihatsu', 'Putih', 2017, 150000000),
(3, 'Mustang GT', 'Ford', 'Biru', 1998, 56000000),
(4, 'Xw2Dr', 'Ferarri', 'Merah', 2005, 500000000);

-- --------------------------------------------------------

--
-- Table structure for table `pembeli`
--

CREATE TABLE `pembeli` (
  `kode_pembeli` int(10) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `pekerjaan` varchar(20) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `umur` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembeli`
--

INSERT INTO `pembeli` (`kode_pembeli`, `nama`, `pekerjaan`, `alamat`, `umur`) VALUES
(1, 'Triatmadja', 'Wirausaha', 'D.I Yogyakarta', 50),
(2, 'Eko Tekimusodo', 'Karyawan Swasta', 'D.I Yogyakarta', 40),
(3, 'Febrian Sukiem', 'Pegawai Negri', 'D.I Yogyakarta', 49),
(4, 'Arowidyo', 'mahasiswa', 'Jogja', 22),
(5, 'Triadini Sriwardani', 'Guru', 'Jakarta', 45),
(6, 'Tekinem', 'Pengacara', 'jakarta', 20);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `no_transaksi` int(10) NOT NULL,
  `no_faktur` int(10) NOT NULL,
  `tgl_fktur` varchar(10) NOT NULL,
  `jam_fktur` varchar(10) NOT NULL,
  `kode_pembeli` int(10) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `kode_mobil` int(10) NOT NULL,
  `nama_mobil` varchar(20) NOT NULL,
  `merk` varchar(20) NOT NULL,
  `warna` varchar(20) NOT NULL,
  `tahun` int(10) NOT NULL,
  `harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`no_transaksi`, `no_faktur`, `tgl_fktur`, `jam_fktur`, `kode_pembeli`, `nama`, `kode_mobil`, `nama_mobil`, `merk`, `warna`, `tahun`, `harga`) VALUES
(1, 1, '19/2/2003', '20:10:44', 1, 'Triatmadja', 1, 'Avanza', 'Toyota', 'Hitam', 2016, 100000000),
(2, 2, '16/2/2016', '20:20:10', 2, 'Eko Tekimusodo', 2, 'Xenia', 'Daihatsu', 'Putih', 2017, 150000000),
(3, 3, '16/2/2016', '20:20:10', 3, 'Febrian Sukiem', 2, 'Xenia', 'Daihatsu', 'Putih', 2017, 150000000),
(4, 4, '20/2/2018', '10:10:10', 4, 'Arowidyo', 2, 'Xenia', 'Daihatsu', 'Putih', 2017, 150000000),
(5, 5, '10/10/1990', '20:09:00', 6, 'Tekinem', 2, 'Xenia', 'Daihatsu', 'Putih', 2017, 150000000),
(6, 6, '21/2/11', '22:20:22', 5, 'Triadini ', 2, 'Xenia', 'Daihatsu', 'Putih', 2017, 150000000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `faktur`
--
ALTER TABLE `faktur`
  ADD PRIMARY KEY (`no_faktur`);

--
-- Indexes for table `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`kode_mobil`);

--
-- Indexes for table `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`kode_pembeli`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`no_transaksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
