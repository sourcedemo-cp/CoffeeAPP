/*
SQLyog Ultimate v9.20 
MySQL - 5.6.23-log : Database - coffeeapp
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`coffeeapp` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `coffeeapp`;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `EMPLOYEE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EMPLOYEE_CITY` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EMPLOYEE_ADDRESS` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EMPLOYEE_TELEPHONE` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SHIFT` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `WORK_DATE` datetime DEFAULT NULL,
  `EMPLOYEE_SEX` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `USER_NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PASSWORD` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `employee` */

insert  into `employee`(`EMPLOYEE_ID`,`EMPLOYEE_NAME`,`EMPLOYEE_CITY`,`EMPLOYEE_ADDRESS`,`EMPLOYEE_TELEPHONE`,`SHIFT`,`WORK_DATE`,`EMPLOYEE_SEX`,`USER_NAME`,`PASSWORD`) values (1,'Cuong Nguyen','Danang','Viet Nam','123456','1','2015-04-08 11:34:59','Nam','cuongn','123456'),(2,'b','bb','bbb','1','b',NULL,'male','b','123'),(3,'c','cc','ccc','c','cc',NULL,'c','c','123'),(10,'fsadf','dfsadf','dfsdf','fasdf','adfas',NULL,'asdf','asdf','asdfsdf');

/*Table structure for table `orderdetail` */

DROP TABLE IF EXISTS `orderdetail`;

CREATE TABLE `orderdetail` (
  `ORDER_ID` int(11) DEFAULT NULL,
  `PRODUCT_ID` int(11) unsigned DEFAULT NULL,
  `PAYMENT` int(11) unsigned DEFAULT NULL,
  `QUANTITY` int(11) unsigned DEFAULT NULL,
  `ORDERDETAIL_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ORDERDETAIL_ID`),
  KEY `FK_oderdetail_oder` (`ORDER_ID`),
  KEY `FK_oderdetail_product` (`PRODUCT_ID`),
  CONSTRAINT `FK_oderdetail` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`) ON DELETE SET NULL,
  CONSTRAINT `FK_oderdetail_order` FOREIGN KEY (`ORDER_ID`) REFERENCES `orders` (`ORDER_ID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `orderdetail` */

insert  into `orderdetail`(`ORDER_ID`,`PRODUCT_ID`,`PAYMENT`,`QUANTITY`,`ORDERDETAIL_ID`) values (1,1,12000,2,1);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `ORDER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRODUCT_ID` int(11) DEFAULT NULL,
  `DATE_PAYMENT` datetime DEFAULT NULL,
  `EMPLOYEE_ID` int(11) DEFAULT NULL,
  `TABLE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ORDER_ID`),
  KEY `FK_order` (`PRODUCT_ID`),
  KEY `FK_order_employee` (`EMPLOYEE_ID`),
  KEY `FK_tables` (`TABLE_ID`),
  CONSTRAINT `FK_order_employee` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employee` (`EMPLOYEE_ID`) ON DELETE SET NULL,
  CONSTRAINT `FK_order_tables` FOREIGN KEY (`TABLE_ID`) REFERENCES `tables` (`TABLE_ID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `orders` */

insert  into `orders`(`ORDER_ID`,`PRODUCT_ID`,`DATE_PAYMENT`,`EMPLOYEE_ID`,`TABLE_ID`) values (1,1,'2015-04-03 09:37:11',1,1);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `PRODUCT_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PRODUCT_QUANTITY` int(11) unsigned DEFAULT NULL,
  `PRODUCT_PRICE` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `product` */

insert  into `product`(`PRODUCT_ID`,`PRODUCT_NAME`,`PRODUCT_QUANTITY`,`PRODUCT_PRICE`) values (1,'cafeDen',100,6000),(2,'cafeSua',110,7000),(3,'stingDau',80,10000),(4,'stingVang',50,10000),(5,'pepsi',80,11000),(6,'coca',75,11000),(7,'redbull',11,15000),(8,'duty',48,12000),(9,'c2',39,14000),(10,'khoang',61,50000);

/*Table structure for table `tables` */

DROP TABLE IF EXISTS `tables`;

CREATE TABLE `tables` (
  `TABLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TABLE_NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TABLE_QUANTITY` int(11) unsigned DEFAULT NULL,
  `TABLE_POSITION` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`TABLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tables` */

insert  into `tables`(`TABLE_ID`,`TABLE_NAME`,`TABLE_QUANTITY`,`TABLE_POSITION`) values (1,'table 1',10,'1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
