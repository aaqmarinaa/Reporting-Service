/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.1.31-MariaDB : Database - reports
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`reports` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `reports`;

/*Table structure for table `laporan_customer` */

DROP TABLE IF EXISTS `laporan_customer`;

CREATE TABLE `laporan_customer` (
  `id_lap_cust` int(11) NOT NULL AUTO_INCREMENT,
  `id_cust` int(11) DEFAULT NULL,
  `tgl_transaksi` date DEFAULT NULL,
  `id_order` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id_lap_cust`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `laporan_customer` */

insert  into `laporan_customer`(`id_lap_cust`,`id_cust`,`tgl_transaksi`,`id_order`,`created_at`,`updated_at`) values (1,1,'2019-05-20',1,NULL,NULL),(2,1,'2019-05-20',2,NULL,NULL),(3,2,'2019-05-20',3,NULL,NULL),(4,3,'2019-05-22',5,NULL,'2019-05-20 04:58:40'),(5,2,'2019-05-21',5,NULL,NULL),(6,1,'2019-05-21',6,NULL,NULL);

/*Table structure for table `laporan_driver` */

DROP TABLE IF EXISTS `laporan_driver`;

CREATE TABLE `laporan_driver` (
  `id_lap_driver` int(11) NOT NULL AUTO_INCREMENT,
  `id_driver` int(11) DEFAULT NULL,
  `tgl_transaksi` date DEFAULT NULL,
  `id_order` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id_lap_driver`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `laporan_driver` */

insert  into `laporan_driver`(`id_lap_driver`,`id_driver`,`tgl_transaksi`,`id_order`,`created_at`,`updated_at`) values (1,1,'2019-05-20',1,NULL,NULL),(2,1,'2019-05-20',2,NULL,NULL),(3,2,'2019-05-20',3,NULL,NULL),(4,1,'2019-05-20',4,NULL,NULL),(5,3,'2019-05-21',5,NULL,NULL),(6,4,'2019-05-21',6,NULL,NULL);

/*Table structure for table `laporan_restaurant` */

DROP TABLE IF EXISTS `laporan_restaurant`;

CREATE TABLE `laporan_restaurant` (
  `id_lap_rest` int(11) NOT NULL AUTO_INCREMENT,
  `id_rest` int(11) DEFAULT NULL,
  `tgl_transaksi` date DEFAULT NULL,
  `id_order` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id_lap_rest`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `laporan_restaurant` */

insert  into `laporan_restaurant`(`id_lap_rest`,`id_rest`,`tgl_transaksi`,`id_order`,`created_at`,`updated_at`) values (1,1,'2019-05-20',1,NULL,NULL),(2,2,'2019-05-20',2,NULL,NULL),(3,3,'2019-05-20',3,NULL,NULL),(4,2,'2019-05-20',4,NULL,NULL),(5,1,'2019-05-21',5,NULL,NULL),(6,3,'2019-05-21',6,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
