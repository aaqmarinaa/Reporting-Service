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

/*Table structure for table `detail_laporan` */

DROP TABLE IF EXISTS `detail_laporan`;

CREATE TABLE `detail_laporan` (
  `id_detail` varchar(5) NOT NULL,
  `id_laporan` varchar(5) DEFAULT NULL,
  `nama_menu` varchar(50) DEFAULT NULL,
  `jumlah_terjual` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id_detail`),
  KEY `id_laporan` (`id_laporan`),
  CONSTRAINT `detail_laporan_ibfk_1` FOREIGN KEY (`id_laporan`) REFERENCES `laporan` (`id_laporan`),
  CONSTRAINT `id_laporan` FOREIGN KEY (`id_laporan`) REFERENCES `laporan` (`id_laporan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `detail_laporan` */

insert  into `detail_laporan`(`id_detail`,`id_laporan`,`nama_menu`,`jumlah_terjual`,`created_at`,`updated_at`,`deleted_at`) values ('1','1','Nasi Goreng',50,'2019-05-09 22:13:01',NULL,NULL),('2','1','Nasi Padang',10,'2019-05-09 22:13:35',NULL,NULL),('3','2','Soto',15,'2019-05-10 22:13:50',NULL,NULL),('4','2','Es Teh',17,'2019-05-10 22:14:10',NULL,NULL);

/*Table structure for table `laporan` */

DROP TABLE IF EXISTS `laporan`;

CREATE TABLE `laporan` (
  `id_laporan` varchar(5) NOT NULL,
  `tgl_laporan` date DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id_laporan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `laporan` */

insert  into `laporan`(`id_laporan`,`tgl_laporan`,`created_at`,`updated_at`,`deleted_at`) values ('1','2019-05-09','2019-05-09 22:13:07',NULL,NULL),('2','2019-05-10','2019-05-10 22:13:11',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
