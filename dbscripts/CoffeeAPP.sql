/*
SQLyog Ultimate v9.20 
MySQL - 5.5.16 : Database - coffeeapp
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
  `EMPLOYEE_ADDRESS` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EMPLOYEE_TELEPHONE` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EMPLOYEE_SEX` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `USER_NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PASSWORD` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `employee` */

insert  into `employee`(`EMPLOYEE_ID`,`EMPLOYEE_NAME`,`EMPLOYEE_ADDRESS`,`EMPLOYEE_TELEPHONE`,`EMPLOYEE_SEX`,`USER_NAME`,`PASSWORD`) values (1,'Cuong Nguyen','Da nang','0987612415','Nam','c','1'),(3,'Nguyen Thuy Nguyen','Da nang','0985698745','Nam','nguyen','1'),(5,'Vo Dinh Hieu','Da nang','098541234','Nam','h','123456'),(7,'Hoang Thuy Linh','Hanoi','0123456789','Nữ','linhht','1');

/*Table structure for table `orderdetail` */

DROP TABLE IF EXISTS `orderdetail`;

CREATE TABLE `orderdetail` (
  `ORDER_ID` int(11) DEFAULT NULL,
  `PRODUCT_ID` int(11) unsigned DEFAULT NULL,
  `QUANTITY` int(11) unsigned DEFAULT NULL,
  `ORDERDETAIL_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ORDERDETAIL_ID`),
  KEY `FK_oderdetail_oder` (`ORDER_ID`),
  KEY `FK_oderdetail_product` (`PRODUCT_ID`),
  CONSTRAINT `FK_oderdetail` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`) ON DELETE SET NULL,
  CONSTRAINT `FK_oderdetail_order` FOREIGN KEY (`ORDER_ID`) REFERENCES `orders` (`ORDER_ID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `orderdetail` */

insert  into `orderdetail`(`ORDER_ID`,`PRODUCT_ID`,`QUANTITY`,`ORDERDETAIL_ID`) values (NULL,1,2,1),(NULL,2,3,2),(NULL,3,4,3),(2,1,1,4),(2,2,2,5),(2,4,3,6),(2,6,2,7),(4,1,2,8),(4,2,1,9),(3,1,1,10),(3,2,1,11),(NULL,4,2,12),(NULL,7,1,14),(2,9,2,15),(4,9,2,16),(7,2,1,17),(7,3,2,18),(8,2,2,19),(8,9,5,20);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `ORDER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATE_PAYMENT` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `TABLE_ID` int(11) DEFAULT NULL,
  `IS_PAY` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ORDER_ID`),
  KEY `FK_tables` (`TABLE_ID`),
  CONSTRAINT `FK_order_tables` FOREIGN KEY (`TABLE_ID`) REFERENCES `tables` (`TABLE_ID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `orders` */

insert  into `orders`(`ORDER_ID`,`DATE_PAYMENT`,`TABLE_ID`,`IS_PAY`) values (2,'2015-04-14 18:02:06',1,1),(3,'2015-04-14 18:14:31',2,1),(4,'2015-04-14 23:48:16',1,1),(6,'2015-04-15 01:20:49',2,0),(7,'2015-04-15 01:22:28',1,1),(8,'2015-04-15 01:24:05',5,1),(10,'2015-04-15 01:25:21',14,0);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `PRODUCT_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PRODUCT_QUANTITY` int(11) unsigned DEFAULT NULL,
  `PRODUCT_PRICE` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `product` */

insert  into `product`(`PRODUCT_ID`,`PRODUCT_NAME`,`PRODUCT_QUANTITY`,`PRODUCT_PRICE`) values (1,'Cafe Đen',100,5000),(2,'Cafe Sữa',100,6000),(3,'Sting Vàng',100,6000),(4,'Sting Dâu',50,6000),(5,'Pepsi',80,7000),(6,'Coca Cola',75,7000),(7,'Red Bull',100,12000),(9,'C2',50,8000),(10,'Nước khoáng lạc',61,6000),(11,'Nước khoáng ngọt',100,6000),(12,'Trà gừng',50,8000),(13,'Nước chanh',15,7000),(14,'adad',15,15000),(16,'sd12',12,15000),(17,'Yomost',12,10000),(18,'Sữa đậu nành',50,6000),(19,'Nước mía',10,5000);

/*Table structure for table `tables` */

DROP TABLE IF EXISTS `tables`;

CREATE TABLE `tables` (
  `TABLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TABLE_NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TABLE_QUANTITY` int(11) unsigned DEFAULT NULL,
  `TABLE_POSITION` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`TABLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tables` */

insert  into `tables`(`TABLE_ID`,`TABLE_NAME`,`TABLE_QUANTITY`,`TABLE_POSITION`) values (1,'Bàn 1',10,'1'),(2,'Bàn 2',NULL,NULL),(5,'Bàn 3',NULL,NULL),(6,'Bàn 4',NULL,NULL),(7,'Bàn 5',NULL,NULL),(8,'Bàn 6',NULL,NULL),(9,'Bàn 7',NULL,NULL),(10,'Bàn 8',NULL,NULL),(11,'Bàn 9',NULL,NULL),(12,'Bàn 10',NULL,NULL),(13,'Bàn 11',NULL,NULL),(14,'Bàn 12',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
