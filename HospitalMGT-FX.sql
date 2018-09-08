-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 08, 2018 at 03:33 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `HospitalMGT-FX`
--

-- --------------------------------------------------------

--
-- Table structure for table `Appointment`
--

CREATE TABLE `Appointment` (
  `Appointment_ID` varchar(50) NOT NULL,
  `Doctor_ID` varchar(50) DEFAULT NULL,
  `Patient_ID` varchar(50) DEFAULT NULL,
  `Date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Appointment`
--

INSERT INTO `Appointment` (`Appointment_ID`, `Doctor_ID`, `Patient_ID`, `Date`) VALUES
('A01', 'D01', 'p01', '2018-09-11');

-- --------------------------------------------------------

--
-- Table structure for table `Doctor`
--

CREATE TABLE `Doctor` (
  `Doctor_ID` varchar(50) NOT NULL,
  `Doctor_Name` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Specialized_IN` varchar(50) DEFAULT NULL,
  `Salary` double(100,5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Doctor`
--

INSERT INTO `Doctor` (`Doctor_ID`, `Doctor_Name`, `Address`, `Specialized_IN`, `Salary`) VALUES
('D01', 'eqwe', 'qwe', 'eqw', 1223.00000),
('D02', 'asd', 'sada', 'da', 13231.00000),
('D03', 'sdad', 'asda', 'dad', 11111111.00000);

-- --------------------------------------------------------

--
-- Table structure for table `Patient`
--

CREATE TABLE `Patient` (
  `Patient_ID` varchar(50) NOT NULL,
  `Patient_NAME` varchar(50) DEFAULT NULL,
  `Patient_AGE` int(50) DEFAULT NULL,
  `Patient_Gender` varchar(50) DEFAULT NULL,
  `Patient_Address` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Patient`
--

INSERT INTO `Patient` (`Patient_ID`, `Patient_NAME`, `Patient_AGE`, `Patient_Gender`, `Patient_Address`) VALUES
('dasd', 'asdas', 12, 'dsad', 'sadasd'),
('p01', 'saS', 12, 'sS', 'SAsS');

-- --------------------------------------------------------

--
-- Table structure for table `Report`
--

CREATE TABLE `Report` (
  `Report_ID` varchar(50) NOT NULL,
  `Appointment_ID` varchar(50) DEFAULT NULL,
  `Patient_ID` varchar(50) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Details` varchar(250) DEFAULT NULL,
  `Treatments` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Report`
--

INSERT INTO `Report` (`Report_ID`, `Appointment_ID`, `Patient_ID`, `Date`, `Details`, `Treatments`) VALUES
('r01', 'A01', 'dasd', '2018-09-08', 'sd', 'dddsad');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Appointment`
--
ALTER TABLE `Appointment`
  ADD PRIMARY KEY (`Appointment_ID`),
  ADD KEY `Appointment_ibfk_1` (`Doctor_ID`),
  ADD KEY `Appointment_ibfk_2` (`Patient_ID`);

--
-- Indexes for table `Doctor`
--
ALTER TABLE `Doctor`
  ADD PRIMARY KEY (`Doctor_ID`);

--
-- Indexes for table `Patient`
--
ALTER TABLE `Patient`
  ADD PRIMARY KEY (`Patient_ID`);

--
-- Indexes for table `Report`
--
ALTER TABLE `Report`
  ADD PRIMARY KEY (`Report_ID`),
  ADD KEY `Report_ibfk_1` (`Appointment_ID`),
  ADD KEY `Report_ibfk_2` (`Patient_ID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Appointment`
--
ALTER TABLE `Appointment`
  ADD CONSTRAINT `Appointment_ibfk_1` FOREIGN KEY (`Doctor_ID`) REFERENCES `Doctor` (`Doctor_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Appointment_ibfk_2` FOREIGN KEY (`Patient_ID`) REFERENCES `Patient` (`Patient_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Report`
--
ALTER TABLE `Report`
  ADD CONSTRAINT `Report_ibfk_1` FOREIGN KEY (`Appointment_ID`) REFERENCES `Appointment` (`Appointment_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Report_ibfk_2` FOREIGN KEY (`Patient_ID`) REFERENCES `Patient` (`Patient_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
