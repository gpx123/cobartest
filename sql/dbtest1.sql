/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : dbtest1

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2015-04-16 13:33:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cont`
-- ----------------------------
DROP TABLE IF EXISTS `cont`;
CREATE TABLE `cont` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taobaoId` bigint(20) DEFAULT '0',
  `name` varchar(20) DEFAULT '',
  `upd_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cont
-- ----------------------------
INSERT INTO `cont` VALUES ('10', '2055', 'gd', '2015-04-14 17:22:22');
INSERT INTO `cont` VALUES ('11', '768', 'gd', '2015-04-14 17:23:30');
INSERT INTO `cont` VALUES ('12', '1403', 'gd', '2015-04-16 12:42:23');
INSERT INTO `cont` VALUES ('13', '9412', 'gd', '2015-04-16 12:46:08');
INSERT INTO `cont` VALUES ('14', '4214', 'gd', '2015-04-16 12:48:06');

-- ----------------------------
-- Table structure for `order_0`
-- ----------------------------
DROP TABLE IF EXISTS `order_0`;
CREATE TABLE `order_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taobaoId` bigint(20) DEFAULT '0',
  `name` varchar(20) DEFAULT '',
  `upd_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_0
-- ----------------------------
INSERT INTO `order_0` VALUES ('10', '2055', 'gd', '2015-04-14 17:22:22');
INSERT INTO `order_0` VALUES ('11', '768', 'gd', '2015-04-14 17:23:30');

-- ----------------------------
-- Table structure for `order_1`
-- ----------------------------
DROP TABLE IF EXISTS `order_1`;
CREATE TABLE `order_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taobaoId` bigint(20) DEFAULT '0',
  `name` varchar(20) DEFAULT '',
  `upd_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_1
-- ----------------------------

-- ----------------------------
-- Table structure for `order_2`
-- ----------------------------
DROP TABLE IF EXISTS `order_2`;
CREATE TABLE `order_2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taobaoId` bigint(20) DEFAULT '0',
  `name` varchar(20) DEFAULT '',
  `upd_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_2
-- ----------------------------
INSERT INTO `order_2` VALUES ('12', '2720', 'gd', '2015-04-16 12:50:11');
