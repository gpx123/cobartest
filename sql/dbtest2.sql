/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : dbtest2

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2015-04-16 13:33:44
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cont
-- ----------------------------
INSERT INTO `cont` VALUES ('10', '4636', 'gd', '2015-04-14 17:23:00');
