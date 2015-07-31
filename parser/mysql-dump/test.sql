/*
Navicat MySQL Data Transfer

Source Server         : testdb2
Source Server Version : 50619
Source Host           : 172.19.17.211:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2015-07-31 12:21:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `parquet`
-- ----------------------------
DROP TABLE IF EXISTS `parquet`;
CREATE TABLE `parquet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` char(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of parquet
-- ----------------------------
INSERT INTO `parquet` VALUES ('1', 'chinatelecom', '21.3', '2015-07-29 10:32:53');
INSERT INTO `parquet` VALUES ('2', 'chinaunicom', '15.7', '2015-07-29 10:33:21');

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '12');
INSERT INTO `test` VALUES ('2', '22');
INSERT INTO `test` VALUES ('3', '33');
INSERT INTO `test` VALUES ('4', '44');
INSERT INTO `test` VALUES ('5', '55');
INSERT INTO `test` VALUES ('6', '66');
INSERT INTO `test` VALUES ('7', '77');
INSERT INTO `test` VALUES ('8', '88');
INSERT INTO `test` VALUES ('9', '99');
