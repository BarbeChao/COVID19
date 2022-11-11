/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.27 : Database - covid19
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`covid19` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `covid19`;

/*Table structure for table `covid19_data` */

DROP TABLE IF EXISTS `covid19_data`;

CREATE TABLE `covid19_data` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `local_confirm_add` int DEFAULT NULL,
  `nowConfirm` int DEFAULT NULL,
  `confirm` int DEFAULT NULL,
  `dead` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13871 DEFAULT CHARSET=utf8mb3;

/*Table structure for table `covid19_graphdata` */

DROP TABLE IF EXISTS `covid19_graphdata`;

CREATE TABLE `covid19_graphdata` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `local_confirmadd` int DEFAULT NULL COMMENT '新增本土确诊',
  `localinfectionadd` int DEFAULT NULL COMMENT '新增本土无症状',
  `date` varchar(20) DEFAULT NULL COMMENT '日期',
  `year` varchar(20) DEFAULT NULL COMMENT '年',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
