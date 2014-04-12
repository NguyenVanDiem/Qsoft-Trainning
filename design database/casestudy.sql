-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2014 at 04:12 PM
-- Server version: 5.5.36
-- PHP Version: 5.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `casestudy`
--

-- --------------------------------------------------------

--
-- Table structure for table `contacts`
--

CREATE TABLE IF NOT EXISTS `contacts` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `main` tinyint(4) DEFAULT '0',
  `job_title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `contacts`
--

INSERT INTO `contacts` (`id`, `name`, `phone`, `email`, `main`, `job_title`) VALUES
(2, 'change contact name', 'change phone: +12312', 'change email', 0, 'CxO change');

-- --------------------------------------------------------

--
-- Table structure for table `contacts_orders`
--

CREATE TABLE IF NOT EXISTS `contacts_orders` (
  `contact_id` int(10) unsigned NOT NULL,
  `order_id` int(45) NOT NULL,
  PRIMARY KEY (`contact_id`,`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `contacts_orders`
--

INSERT INTO `contacts_orders` (`contact_id`, `order_id`) VALUES
(1001, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `avatar` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf16 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `name`, `address`, `phone`, `fax`, `avatar`) VALUES
(4, 'ngo dinh nguyen change', 'Tu Son change', '+76453', '+1342341', 'change'),
(5, 'Ngo Dinh Nguyen', 'TS-BN', '123516', '123516', 'avatar link');

-- --------------------------------------------------------

--
-- Table structure for table `customers_contacts`
--

CREATE TABLE IF NOT EXISTS `customers_contacts` (
  `customer_id` int(10) unsigned NOT NULL,
  `contact_id` int(45) NOT NULL,
  PRIMARY KEY (`customer_id`,`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `customers_contacts`
--

INSERT INTO `customers_contacts` (`customer_id`, `contact_id`) VALUES
(12, 10);

-- --------------------------------------------------------

--
-- Table structure for table `customers_orders`
--

CREATE TABLE IF NOT EXISTS `customers_orders` (
  `customer_id` int(11) NOT NULL,
  `order_id` varchar(45) NOT NULL,
  PRIMARY KEY (`customer_id`,`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `customers_orders`
--

INSERT INTO `customers_orders` (`customer_id`, `order_id`) VALUES
(456, '123');

-- --------------------------------------------------------

--
-- Table structure for table `customers_products`
--

CREATE TABLE IF NOT EXISTS `customers_products` (
  `customer_id` int(10) unsigned NOT NULL,
  `product_id` int(45) NOT NULL,
  PRIMARY KEY (`customer_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `customers_products`
--

INSERT INTO `customers_products` (`customer_id`, `product_id`) VALUES
(123, 456),
(123, 7189),
(321, 999);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `number` int(10) unsigned NOT NULL,
  `amount` double unsigned NOT NULL,
  `status` tinyint(4) NOT NULL,
  `created_date` date NOT NULL,
  `updated_date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number_UNIQUE` (`number`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf16 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `number`, `amount`, `status`, `created_date`, `updated_date`) VALUES
(2, 1000, 12000, 1, '1908-09-20', '1909-09-21');

-- --------------------------------------------------------

--
-- Table structure for table `orders_products`
--

CREATE TABLE IF NOT EXISTS `orders_products` (
  `order_id` int(10) unsigned NOT NULL,
  `product_id` int(45) NOT NULL,
  PRIMARY KEY (`order_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `orders_products`
--

INSERT INTO `orders_products` (`order_id`, `product_id`) VALUES
(1323, 1111);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `serial` int(11) NOT NULL,
  `year` int(4) NOT NULL,
  `model` varchar(45) NOT NULL,
  `manufacturer` varchar(45) NOT NULL,
  `price` double unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `serial_UNIQUE` (`serial`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf16 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `serial`, `year`, `model`, `manufacturer`, `price`) VALUES
(2, 110, 2014, 'New Model A', 'Viettel IDC', 196.2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
