/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.28 : Database - webschooldb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`webschooldb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `webschooldb`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` char(50) NOT NULL COMMENT '用户ID',
  `user_name` char(50) DEFAULT NULL COMMENT '用户名',
  `phone` char(12) DEFAULT NULL COMMENT '手机号',
  `password` char(80) DEFAULT NULL COMMENT '密码',
  `email` char(80) DEFAULT NULL COMMENT '邮箱地址',
  `pic_url` text COMMENT '头像链接地址',
  `state` int(1) NOT NULL DEFAULT '1' COMMENT '0：无效 1：有效 ',
  `create_dt` datetime NOT NULL COMMENT '创建日期',
  `create_id` char(50) NOT NULL COMMENT '创建人',
  `update_dt` datetime DEFAULT NULL COMMENT '修改日期',
  `update_id` char(50) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`user_id`,`user_name`,`phone`,`password`,`email`,`pic_url`,`state`,`create_dt`,`create_id`,`update_dt`,`update_id`) values (1,'qinghai','qinghai','18513855991','123123','qinghai@hotmail.com',NULL,1,'2015-03-13 11:53:13','qinghai','2015-03-13 11:53:21','qinghai'),(4,'aaa','aaa','33333','123123','adsf',NULL,1,'2015-03-13 15:33:06','qinghai','2015-03-13 15:34:00','qinghai');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
