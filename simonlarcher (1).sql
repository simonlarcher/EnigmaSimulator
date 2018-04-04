-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Erstellungszeit: 21. Mrz 2018 um 14:23
-- Server Version: 5.5.59-MariaDB
-- PHP-Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `simonlarcher`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `reflektor`
--

CREATE TABLE IF NOT EXISTS `reflektor` (
  `ref_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `code` varchar(30) NOT NULL,
  UNIQUE KEY `ref_id` (`ref_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Daten für Tabelle `reflektor`
--

INSERT INTO `reflektor` (`ref_id`, `name`, `code`) VALUES
(1, 'Reflektor 1 (Standard)', 'EJMZALYXVBWFCRQUONTSPIKHGD'),
(2, 'Reflektor 2', 'YRUHQSLDPXNGOKMIEBFZCWVJAT'),
(3, 'Reflektor 3', 'FVPJIAOYEDRZXWGCTKUQSBNMHL');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `rotor`
--

CREATE TABLE IF NOT EXISTS `rotor` (
  `rot_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `code` varchar(30) NOT NULL,
  `sprungpunkt` varchar(1) DEFAULT NULL,
  UNIQUE KEY `rot_id` (`rot_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Daten für Tabelle `rotor`
--

INSERT INTO `rotor` (`rot_id`, `name`, `code`, `sprungpunkt`) VALUES
(1, 'Rotor 1', 'EKMFLGDQVZNTOWYHXUSPAIBRCJ', 'Q'),
(2, 'Rotor 2', 'AJDKSIRUXBLHWTMCQGZNPYFVOE', 'E'),
(3, 'Rotor 3', 'BDFHJLCPRTXVZNYEIWGAKMUSQO', 'V'),
(4, 'Rotor 4', 'ESOVPZJAYQUIRHXLNFTGKDCMWB', 'J'),
(5, 'Rotor 5', 'VZBRGITYUPSDNHLXAWMJQOFECK', 'Z');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
