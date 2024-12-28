-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2024 at 02:06 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flightsdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id_account` bigint(20) NOT NULL,
  `confpassword` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id_account`, `confpassword`, `email`, `enabled`, `password`, `username`) VALUES
(1, 'admin', 'emanuele.cancelli1@gmail.com', b'0', 'admin', 'Emanuele'),
(2, '$2a$10$oMcZjhdl/YL3MCDKqKpcfOEBsU1Uxddd7213v1V4E0RCEydgGlGhS', 'emanuele.cancelli2@gmail.com', b'0', '$2a$10$V2T1A2MiGFe8ol80MrYX2e/z6VSUxmm6Mgv1G4l6HIpiOoPWtRvCG', 'Emanuele2');

-- --------------------------------------------------------

--
-- Table structure for table `cabin_details`
--

CREATE TABLE `cabin_details` (
  `company_id` int(11) NOT NULL,
  `baggage` varchar(255) DEFAULT NULL,
  `cabin_class` varchar(255) DEFAULT NULL,
  `cancellation` varchar(255) DEFAULT NULL,
  `fare` double DEFAULT NULL,
  `rebooking` varchar(255) DEFAULT NULL,
  `refund` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cabin_details`
--

INSERT INTO `cabin_details` (`company_id`, `baggage`, `cabin_class`, `cancellation`, `fare`, `rebooking`, `refund`) VALUES
(1, '18kg hand baggage, 32kg check-in baggage', 'BUSINESS', 'Cancellable', 599, 'Free change + difference', 'Refund if you missed your flight'),
(1, '12kg hand baggage, 23kg check-in baggage', 'ECONOMYFLEX', 'Cancellable', 241, 'Free change + difference', 'Refund if you missed your flight'),
(1, '12kg hand baggage', 'ECONOMYLIGHT', 'Not refundable', 130, 'Not cancellable', 'Not refundable if you missed your flight'),
(1, '12kg hand baggage, 23kg check-in baggage', 'ECONOMYSTANDARD', 'Not cancellable', 163, 'Change fee €70 + difference', 'Not refundable if you missed your flight'),
(2, '18kg hand baggage, 32kg check-in baggage', 'BUSINESS', 'Cancellable', 599, 'Free change + difference', 'Refund if you missed your flight'),
(2, '12kg hand baggage, 23kg check-in baggage', 'ECONOMYFLEX', 'Cancellable', 241, 'Free change + difference', 'Refund if you missed your flight'),
(2, '12kg hand baggage', 'ECONOMYLIGHT', 'Not refundable', 130, 'Not cancellable', 'Not refundable if you missed your flight'),
(2, '12kg hand baggage, 23kg check-in baggage', 'ECONOMYSTANDARD', 'Not cancellable', 163, 'Change fee €70 + difference', 'Not refundable if you missed your flight'),
(3, '18kg hand baggage, 32kg check-in baggage', 'BUSINESS', 'Cancellable', 599, 'Free change + difference', 'Refund if you missed your flight'),
(3, '12kg hand baggage, 23kg check-in baggage', 'ECONOMYFLEX', 'Cancellable', 241, 'Free change + difference', 'Refund if you missed your flight'),
(3, '12kg hand baggage', 'ECONOMYLIGHT', 'Not refundable', 130, 'Not cancellable', 'Not refundable if you missed your flight'),
(3, '12kg hand baggage, 23kg check-in baggage', 'ECONOMYSTANDARD', 'Not cancellable', 163, 'Change fee €70 + difference', 'Not refundable if you missed your flight'),
(4, '18kg hand baggage, 32kg check-in baggage', 'BUSINESS', 'Cancellable', 599, 'Free change + difference', 'Refund if you missed your flight'),
(4, '12kg hand baggage, 23kg check-in baggage', 'ECONOMYFLEX', 'Cancellable', 241, 'Free change + difference', 'Refund if you missed your flight'),
(4, '12kg hand baggage', 'ECONOMYLIGHT', 'Not refundable', 130, 'Not cancellable', 'Not refundable if you missed your flight'),
(4, '12kg hand baggage, 23kg check-in baggage', 'ECONOMYSTANDARD', 'Not cancellable', 163, 'Change fee €70 + difference', 'Not refundable if you missed your flight');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `id_company` int(11) NOT NULL,
  `company_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`id_company`, `company_name`) VALUES
(1, 'AIRFRANCE'),
(2, 'AIRARABIA'),
(3, 'QATARAIRWAYS'),
(4, 'EMIRATES');

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `id_flight` bigint(20) NOT NULL,
  `aircraft_type` varchar(255) DEFAULT NULL,
  `arrival_date` date DEFAULT NULL,
  `arrival_location` varchar(255) DEFAULT NULL,
  `arrival_time` time DEFAULT NULL,
  `back_date` date DEFAULT NULL,
  `back_time` time DEFAULT NULL,
  `connection_duration` time DEFAULT NULL,
  `departure_date` date DEFAULT NULL,
  `departure_location` varchar(255) DEFAULT NULL,
  `departure_time` time DEFAULT NULL,
  `flight_duration` time DEFAULT NULL,
  `flight_type` varchar(255) DEFAULT NULL,
  `travel_type` varchar(255) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`id_flight`, `aircraft_type`, `arrival_date`, `arrival_location`, `arrival_time`, `back_date`, `back_time`, `connection_duration`, `departure_date`, `departure_location`, `departure_time`, `flight_duration`, `flight_type`, `travel_type`, `company_id`) VALUES
(1, 'Airbus A320-200', '2025-04-16', 'Berlin, Tegel Airport (TXL)', '16:00:00', '2024-04-18', '12:00:00', '03:50:00', '2025-04-16', 'Paris, Paris Charles De Gaulle Airport (CDG)', '14:00:00', '02:00:00', 'CONNECTING', 'ROUNDTRIP', 1),
(2, 'Airbus A320-200', '2025-05-16', 'Berlin (TXL)', '20:00:00', '2025-05-18', '14:50:00', '02:55:00', '2025-05-16', 'London (LGW)', '18:00:00', '02:00:00', 'CONNECTING', 'ROUNDTRIP', 2),
(3, 'Airbus A350-1000', '2025-04-21', 'Paris, Paris Charles De Gaulle Airport (CDG)', '14:50:00', '2025-04-23', '09:50:00', '03:50:00', '2025-04-21', 'Doha, Hamad International Airport', '08:55:00', '06:55:00', 'CONNECTING', 'ROUNDTRIP', 3),
(4, 'Boeing 737-800', '2025-04-22', 'Chicago International Airport', '08:57:00', '2025-04-25', '12:50:00', '16:00:00', '2025-04-21', 'Doha, International Airport Hamad', '08:25:00', '23:59:00', 'CONNECTING', 'ROUNDTRIP', 3),
(5, 'Airbus A350-1000', '2025-05-16', 'Toronto International Airport Lester B. Pearson', '14:32:00', '2025-04-23', '13:55:00', '22:05:00', '2025-04-21', 'oha, International Airport Hamad', '07:45:00', '23:00:00', 'CONNECTING', 'ROUNDTRIP', 3),
(6, 'Airbus A320-200', '2025-04-21', 'Berlin (TXL)', '15:25:00', '2025-04-23', '10:25:00', NULL, '2025-04-21', 'Doha, International Airport Hamad', '10:25:00', '05:00:00', 'DIRECT', 'ROUNDTRIP', 2);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `inflight_infos`
--

CREATE TABLE `inflight_infos` (
  `company_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inflight_infos`
--

INSERT INTO `inflight_infos` (`company_id`, `description`, `title`) VALUES
(1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Inflight services'),
(1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Air France play app'),
(1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Business seat'),
(1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Economy seat'),
(2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Entertainment'),
(2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'First class dining'),
(2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Onboard Wi-Fi'),
(2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'First class'),
(2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Economy class'),
(3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Wireless streaming on board'),
(3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'The perfect temptation'),
(3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Meal service equipment'),
(3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Seat back and enjoy'),
(3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Air filtration system');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id_account`);

--
-- Indexes for table `cabin_details`
--
ALTER TABLE `cabin_details`
  ADD KEY `FKo5i1d7fhftjf3psjhf4ohn1do` (`company_id`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id_company`);

--
-- Indexes for table `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`id_flight`),
  ADD KEY `FK1gyrukpctenh75dryrx21vhxy` (`company_id`);

--
-- Indexes for table `inflight_infos`
--
ALTER TABLE `inflight_infos`
  ADD KEY `FK9s1bajtjqdmd84xrr14fshsn5` (`company_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id_account` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `flight`
--
ALTER TABLE `flight`
  MODIFY `id_flight` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cabin_details`
--
ALTER TABLE `cabin_details`
  ADD CONSTRAINT `FKo5i1d7fhftjf3psjhf4ohn1do` FOREIGN KEY (`company_id`) REFERENCES `company` (`id_company`);

--
-- Constraints for table `flight`
--
ALTER TABLE `flight`
  ADD CONSTRAINT `FK1gyrukpctenh75dryrx21vhxy` FOREIGN KEY (`company_id`) REFERENCES `company` (`id_company`);

--
-- Constraints for table `inflight_infos`
--
ALTER TABLE `inflight_infos`
  ADD CONSTRAINT `FK9s1bajtjqdmd84xrr14fshsn5` FOREIGN KEY (`company_id`) REFERENCES `company` (`id_company`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
