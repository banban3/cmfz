/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : afteritem

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-10-26 21:15:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(40) NOT NULL,
  `name` varchar(30) default NULL,
  `password` varchar(16) default NULL,
  `limits` varchar(3) default NULL,
  `exit1` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'qwe', '123456', '1', null);

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` varchar(40) NOT NULL,
  `title` varchar(30) default NULL,
  `c_img` varchar(45) default NULL,
  `pub_date` datetime default NULL,
  `content` varchar(200) default NULL,
  `fid` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` varchar(40) NOT NULL,
  `title` varchar(15) default NULL,
  `img_url` varchar(50) default NULL,
  `desc` varchar(50) default NULL,
  `status` varchar(10) default NULL,
  `i_date` datetime default NULL,
  `exit1` varchar(15) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banner
-- ----------------------------

-- ----------------------------
-- Table structure for counter
-- ----------------------------
DROP TABLE IF EXISTS `counter`;
CREATE TABLE `counter` (
  `id` varchar(40) NOT NULL,
  `name` varchar(20) default NULL,
  `amount` int(11) default NULL,
  `c_date` date default NULL,
  `fid` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of counter
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` varchar(40) NOT NULL,
  `homework` varchar(15) default NULL,
  `score` varchar(15) default NULL,
  `user_id` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for goodvices
-- ----------------------------
DROP TABLE IF EXISTS `goodvices`;
CREATE TABLE `goodvices` (
  `id` varchar(40) NOT NULL,
  `name` varchar(30) default NULL,
  `pub_date` datetime default NULL,
  `n_count` int(11) default NULL,
  `img_url` varchar(45) default NULL,
  `rank` int(11) default NULL,
  `author` varchar(20) default NULL,
  `broadcast` varchar(15) default NULL,
  `context` varchar(250) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodvices
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(40) NOT NULL,
  `name` varchar(15) default NULL,
  `iconCls` varchar(20) default NULL,
  `href` varchar(30) default NULL,
  `p_id` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for sectionlist
-- ----------------------------
DROP TABLE IF EXISTS `sectionlist`;
CREATE TABLE `sectionlist` (
  `id` varchar(40) NOT NULL,
  `v_name` varchar(20) default NULL,
  `size` varchar(10) default NULL,
  `duratime` datetime default NULL,
  `downpath` varchar(50) default NULL,
  `uploadtime` datetime default NULL,
  `vices_id` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sectionlist
-- ----------------------------

-- ----------------------------
-- Table structure for teach
-- ----------------------------
DROP TABLE IF EXISTS `teach`;
CREATE TABLE `teach` (
  `id` varchar(40) NOT NULL,
  `name` varchar(25) default NULL,
  `head_img` varchar(30) default NULL,
  `sex` varchar(3) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teach
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(40) NOT NULL,
  `name` varchar(20) default NULL,
  `phone` varchar(15) default NULL,
  `password` varchar(16) default NULL,
  `salt` varchar(50) default NULL,
  `img_url` varchar(30) default NULL,
  `fname` varchar(20) default NULL,
  `sex` varchar(3) default NULL,
  `adderss` varchar(45) default NULL,
  `signature` varchar(100) default NULL,
  `status` varchar(5) default NULL,
  `c_date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
