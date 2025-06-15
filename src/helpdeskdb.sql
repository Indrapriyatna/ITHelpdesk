-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2025 at 02:47 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `helpdeskdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `kategori_masalah`
--

CREATE TABLE `kategori_masalah` (
  `id_kategori` int(11) NOT NULL,
  `nama_kategori` varchar(100) NOT NULL,
  `deskripsi` varchar(150) DEFAULT NULL,
  `prioritas` enum('Rendah','Sedang','Tinggi','Kritis') DEFAULT 'Sedang',
  `sla_jam` varchar(10) DEFAULT '24',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kategori_masalah`
--

INSERT INTO `kategori_masalah` (`id_kategori`, `nama_kategori`, `deskripsi`, `prioritas`, `sla_jam`, `created_at`) VALUES
(1, 'Perangkat Lunak', 'Software rusak dan tidak terpakai', 'Tinggi', '12', '2025-06-15 01:04:42'),
(2, 'Perangkat Keras', 'Printer tidak dapat mengeluarkan kertas', 'Rendah', '1', '2025-06-15 01:05:18');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id` int(11) NOT NULL,
  `nip` varchar(30) NOT NULL,
  `nama_pegawai` varchar(100) NOT NULL,
  `jabatan` varchar(100) NOT NULL,
  `no_telp` varchar(30) NOT NULL,
  `jenis_kelamin` enum('Laki-laki','Perempuan') NOT NULL,
  `join_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id`, `nip`, `nama_pegawai`, `jabatan`, `no_telp`, `jenis_kelamin`, `join_date`) VALUES
(1, '123456', 'John Doe', 'Manager', '081234567890', 'Laki-laki', '2025-01-01'),
(2, '12301380213', 'ahmad udin', 'spv', '080231040183', 'Perempuan', '2001-05-01'),
(5, 'dsf', 'fdsfds', 'sfsf', '009802759273', 'Laki-laki', '2025-05-06');

-- --------------------------------------------------------

--
-- Table structure for table `perangkat`
--

CREATE TABLE `perangkat` (
  `device_id` int(11) NOT NULL,
  `nama_perangkat` varchar(100) NOT NULL,
  `device_type` varchar(50) DEFAULT NULL,
  `serial_number` varchar(50) DEFAULT NULL,
  `merk` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  `tgl_pembelian` date DEFAULT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `perangkat`
--

INSERT INTO `perangkat` (`device_id`, `nama_perangkat`, `device_type`, `serial_number`, `merk`, `model`, `tgl_pembelian`, `status`) VALUES
(1, 'asdasdLaptop', 'Hardware', 'SN-137129391', 'Dell', 'razer 1312', '2025-05-01', 'dibeli'),
(2, 'fsdfodsih', 'fdsfosj', 'fodsfpods', 'sfjdsjfps', 'dfsjspf', '2025-05-21', 'ojsofjosj'),
(3, 'Switch', 'Network', 'SN-12391739', 'TP-LINK', 'TL-300', '2025-05-12', 'Pinjem wa ');

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE `tiket` (
  `id_tiket` int(11) NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `prioritas` enum('Rendah','Sedang','Tinggi','Kritis') DEFAULT 'Sedang',
  `status` enum('Baru','Dalam Proses','Selesai','Ditutup') DEFAULT 'Baru',
  `jatuh_tempo` datetime DEFAULT NULL,
  `perkiraan_selesai` datetime DEFAULT NULL,
  `catatan` text DEFAULT NULL,
  `user` varchar(50) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` enum('admin','user') NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `role`, `full_name`, `email`, `created_at`) VALUES
(3, 'Ahmad', 'ahmad123', 'admin', 'Ahmad Nurdin', 'ahmad@gmail.com', '2025-05-28 07:38:45'),
(4, 'yantonih', 'yanto123', 'admin', 'yanto ria', 'yanto@gmail.com', '2025-05-28 07:39:16'),
(12, 'redo', 'redo123', 'user', 'redo hardianto', 'redo@mail.com', '2025-06-12 15:24:48'),
(14, 'indraP', 'indra123', 'admin', 'Indra Priyatna', 'indra@mail.com', '2025-06-12 15:26:00'),
(15, 'adasd', 'adasda', 'admin', 'sdad', 'dasda@mail.com', '2025-06-12 15:26:16');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kategori_masalah`
--
ALTER TABLE `kategori_masalah`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `perangkat`
--
ALTER TABLE `perangkat`
  ADD PRIMARY KEY (`device_id`);

--
-- Indexes for table `tiket`
--
ALTER TABLE `tiket`
  ADD PRIMARY KEY (`id_tiket`),
  ADD KEY `id_kategori` (`id_kategori`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kategori_masalah`
--
ALTER TABLE `kategori_masalah`
  MODIFY `id_kategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `perangkat`
--
ALTER TABLE `perangkat`
  MODIFY `device_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tiket`
--
ALTER TABLE `tiket`
  MODIFY `id_tiket` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tiket`
--
ALTER TABLE `tiket`
  ADD CONSTRAINT `tiket_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori_masalah` (`id_kategori`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
