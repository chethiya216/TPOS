-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 19, 2024 at 07:40 AM
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
-- Database: `tpos`
--

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE `brand` (
  `ID` int(11) NOT NULL,
  `Brand` varchar(255) NOT NULL,
  `Status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`ID`, `Brand`, `Status`) VALUES
(4, 'Samsung', 'Active'),
(5, 'Anker', 'Active'),
(6, 'Nelna', 'Active'),
(9, 'LG', 'Active'),
(10, 'Ritsbury', 'Active'),
(11, 'Nike', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `cashier`
--

CREATE TABLE `cashier` (
  `ID` int(11) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cashier`
--

INSERT INTO `cashier` (`ID`, `Username`, `Password`, `Status`) VALUES
(2, 'Che', '8800', 'Active'),
(3, 'Chethiya', '80230', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `ID` int(11) NOT NULL,
  `Category` varchar(30) NOT NULL,
  `Status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`ID`, `Category`, `Status`) VALUES
(16, 'mobile accessories', 'Active'),
(17, 'Chargers', 'Active'),
(18, 'Groceries', 'Active'),
(19, 'Fruits', 'Active'),
(20, 'sweets', 'Active'),
(21, 'Footwear', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ID` int(11) NOT NULL,
  `Product_Name` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Category` varchar(255) NOT NULL,
  `Brand` varchar(255) NOT NULL,
  `Cost_Price` int(11) NOT NULL,
  `Retail_Price` int(11) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Barcode` int(11) NOT NULL,
  `Status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ID`, `Product_Name`, `Description`, `Category`, `Brand`, `Cost_Price`, `Retail_Price`, `Qty`, `Barcode`, `Status`) VALUES
(16, 'Backcover', 'Leather backcover', 'mobile accessories', 'Samsung', 400, 500, 29, 13, 'Active'),
(17, 'Chicken', '1KG Chicken breasts', 'mobile accessories', 'ZTE', 900, 1000, 14, 11, 'Inactive'),
(18, 'Watermelon', 'Japanese watermelon', 'mobile accessories', 'ZTE', 100, 150, 36, 12, 'Active'),
(19, 'Bubbles ', 'Ritsbury bubbles dark chcocolate', 'sweets', 'Ritsbury', 85, 100, 93, 14, 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `ID` int(11) NOT NULL,
  `Date` varchar(255) NOT NULL,
  `Cashier` varchar(255) NOT NULL,
  `Sub_Total` int(11) NOT NULL,
  `Pay` int(11) NOT NULL,
  `Balance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`ID`, `Date`, `Cashier`, `Sub_Total`, `Pay`, `Balance`) VALUES
(6, '2024/09/01', '', 18000, 44444, 26444),
(7, '2024/09/01', '', 18000, 30000, 12000),
(8, '2024/09/01', '', 12000, 34444, 22444),
(9, '2024/09/01', '', 48000, 50000, 2000),
(10, '2024/09/01', '', 6000, 10000, 4000),
(11, '2024/09/06', '', 2000, 5000, 3000),
(12, '2024/09/06', '', 10000, 15000, 5000),
(13, '2024/09/06', '', 2000, 2000, 0),
(14, '2024/09/06', '', 300, 500, 200),
(15, '2024/09/06', '', 3000, 5000, 2000),
(16, '2024/09/06', '', 3000, 4000, 1000),
(17, '2024/09/06', '', 3000, 4000, 1000),
(18, '2024/09/06', '', 600, 1000, 400),
(19, '2024/09/06', '', 300, 500, 200),
(20, '2024/09/06', '', 3000, 6000, 3000),
(21, '2024/09/06', '', 150, 200, 50),
(22, '2024/09/06', '', 2000, 5000, 3000),
(23, '2024/09/09', 'Che', 300, 500, 200),
(24, '2024/09/17', 'che', 200, 500, 300),
(25, '2024/09/17', 'che', 200, 500, 300),
(26, '2024/09/18', 'Che', 450, 500, 50),
(27, '2024/09/18', '#', 150, 200, 50),
(28, '2024/09/18', '#', 100, 100, 0),
(29, '2024/09/18', '#', 100, 100, 0),
(30, '2024/09/18', '#', 100, 100, 0),
(31, '2024/09/18', '#', 150, 200, 50),
(32, '2024/09/18', '#', 150, 200, 50),
(33, '2024/09/18', '#', 500, 500, 0),
(34, '2024/09/18', '#', 150, 200, 50),
(35, '2024/09/18', '#', 300, 300, 0),
(36, '2024/09/18', '#', 450, 500, 50),
(37, '2024/09/18', '#', 300, 300, 0);

-- --------------------------------------------------------

--
-- Table structure for table `sales_product`
--

CREATE TABLE `sales_product` (
  `ID` int(11) NOT NULL,
  `Sales_ID` int(11) NOT NULL,
  `Product_ID` int(11) NOT NULL,
  `Sell_Price` int(11) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sales_product`
--

INSERT INTO `sales_product` (`ID`, `Sales_ID`, `Product_ID`, `Sell_Price`, `Qty`, `Total`) VALUES
(1, 8, 12, 6000, 2, 12000),
(2, 9, 12, 6000, 8, 48000),
(3, 10, 12, 6000, 1, 6000),
(4, 11, 13, 500, 4, 2000),
(5, 12, 11, 1000, 10, 10000),
(6, 13, 11, 1000, 2, 2000),
(7, 14, 12, 150, 2, 300),
(8, 15, 11, 1000, 3, 3000),
(9, 16, 11, 1000, 3, 3000),
(10, 17, 11, 1000, 3, 3000),
(11, 18, 12, 150, 4, 600),
(12, 19, 12, 150, 2, 300),
(13, 20, 11, 1000, 3, 3000),
(14, 21, 12, 150, 1, 150),
(15, 22, 11, 1000, 2, 2000),
(16, 23, 12, 150, 2, 300),
(17, 24, 14, 100, 2, 200),
(18, 25, 14, 100, 2, 200),
(19, 26, 12, 150, 3, 450),
(20, 27, 12, 150, 1, 150),
(21, 28, 14, 100, 1, 100),
(22, 29, 14, 100, 1, 100),
(23, 30, 14, 100, 1, 100),
(24, 31, 12, 150, 1, 150),
(25, 32, 12, 150, 1, 150),
(26, 33, 13, 500, 1, 500),
(27, 34, 12, 150, 1, 150),
(28, 35, 12, 150, 2, 300),
(29, 36, 12, 150, 3, 450),
(30, 37, 12, 150, 2, 300);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `cashier`
--
ALTER TABLE `cashier`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sales_product`
--
ALTER TABLE `sales_product`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `brand`
--
ALTER TABLE `brand`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `cashier`
--
ALTER TABLE `cashier`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `sales_product`
--
ALTER TABLE `sales_product`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
