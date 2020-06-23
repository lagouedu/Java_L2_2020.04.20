/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 127.0.0.1:3306
 Source Schema         : lagou

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 19/04/2020 17:49:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for r_resume
-- ----------------------------
DROP TABLE IF EXISTS `r_resume`;
CREATE TABLE `r_resume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `birthday` varchar(30) DEFAULT NULL COMMENT '出生日期',
  `work_year` varchar(100) DEFAULT NULL COMMENT '工作年限',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `status` varchar(80) DEFAULT NULL COMMENT '目前状态',
  `resumeName` varchar(500) DEFAULT NULL COMMENT '简历名称',
  `name` varchar(40) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL COMMENT '创建日期',
  `headPic` varchar(100) DEFAULT NULL COMMENT '头像',
  `isDel` int(2) DEFAULT NULL COMMENT '是否删除 默认值0-未删除 1-已删除',
  `updateTime` datetime DEFAULT NULL COMMENT '简历更新时间',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `isDefault` int(2) DEFAULT NULL COMMENT '是否为默认简历 0-默认 1-非默认',
  `highestEducation` varchar(20) DEFAULT '' COMMENT '最高学历',
  `deliverNearByConfirm` int(2) DEFAULT '0' COMMENT '投递附件简历确认 0-需要确认 1-不需要确认',
  `refuseCount` int(11) NOT NULL DEFAULT '0' COMMENT '简历被拒绝次数',
  `markCanInterviewCount` int(11) NOT NULL DEFAULT '0' COMMENT '被标记为可面试次数',
  `haveNoticeInterCount` int(11) NOT NULL DEFAULT '0' COMMENT '已通知面试次数',
  `oneWord` varchar(100) DEFAULT '' COMMENT '一句话介绍自己',
  `liveCity` varchar(100) DEFAULT '' COMMENT '居住城市',
  `resumeScore` int(3) DEFAULT NULL COMMENT '简历得分',
  `userIdentity` int(1) DEFAULT '0' COMMENT '用户身份1-学生 2-工人',
  `isOpenResume` int(1) DEFAULT '3' COMMENT '人才搜索-开放简历 0-关闭，1-打开，2-简历未达到投放标准被动关闭 3-从未设置过开放简历',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2195388 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_resume
-- ----------------------------
BEGIN;
INSERT INTO `r_resume` VALUES (2195320, '女', '1990', '2年', '199999999', 'test@testtest01.com', '我目前已离职，可快速到岗', '稻壳儿的简历', 'wps', '2015-04-24 13:40:14', 'images/myresume/default_headpic.png', 0, '2015-04-24 13:40:14', 1545132, 1, '本科', 0, 0, 0, 0, '', '广州', 15, 0, 3);
INSERT INTO `r_resume` VALUES (2195321, '女', '1990', '2年', '199999999', 'test@testtest01.com', '我目前已离职，可快速到岗', '稻壳儿的简历', 'wps', '2015-04-24 14:17:54', 'images/myresume/default_headpic.png', 0, '2015-04-24 14:20:35', 1545133, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195322, '女', '1990', '2年', '199999999', 'test@testtest01.com', '我目前已离职，可快速到岗', '稻壳儿的简历', 'wps', '2015-04-24 14:42:45', 'images/myresume/default_headpic.png', 0, '2015-04-24 14:43:34', 1545135, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195323, '女', '1990', '2年', '199999999', 'test@testtest01.com', '我目前已离职，可快速到岗', '稻壳儿的简历', 'wps', '2015-04-24 14:48:19', 'images/myresume/default_headpic.png', 0, '2015-04-24 14:50:34', 1545136, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195331, '女', '1990', '2年', '199999999', 'test@testtest01.com', '我目前已离职，可快速到岗', '稻壳儿的简历', 'wps', '2015-04-24 18:43:35', 'images/myresume/default_headpic.png', 0, '2015-04-24 18:44:08', 1545145, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195333, '女', '1990', '2年', '199999999', 'test@testtest01.com', '我目前已离职，可快速到岗', '稻壳儿的简历', 'wps', '2015-04-24 19:01:13', 'images/myresume/default_headpic.png', 0, '2015-04-24 19:01:14', 1545148, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195336, '女', '1990', '2年', '199999999', 'test@testtest01.com', '我目前已离职，可快速到岗', '稻壳儿的简历', 'wps', '2015-04-27 14:13:02', 'images/myresume/default_headpic.png', 0, '2015-04-27 14:13:02', 1545155, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195337, '女', '1990', '2年', '199999999', 'test@testtest01.com', '我目前已离职，可快速到岗', '稻壳儿的简历', 'wps', '2015-04-27 14:36:55', 'images/myresume/default_headpic.png', 0, '2015-04-27 14:36:55', 1545158, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195369, '女', '1990', '10年以上', '199999999', 'test@testtest01.com', '我目前已离职，可快速到岗', '稻壳儿', 'wps', '2015-05-15 18:08:19', 'images/myresume/default_headpic.png', 0, '2015-05-15 18:08:19', 1545346, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195374, '女', '1990', '1年', '199999999', 'test@testtest01.com', '我目前正在职，正考虑换个新环境', '稻壳儿', 'wps', '2015-06-04 17:53:37', 'images/myresume/default_headpic.png', 0, '2015-06-04 17:53:39', 1545523, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195375, '女', '1990', '1年', '199999999', 'test@testtest01.com', '我目前正在职，正考虑换个新环境', '稻壳儿', 'wps', '2015-06-04 18:11:06', 'images/myresume/default_headpic.png', 0, '2015-06-04 18:11:07', 1545524, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195376, '女', '1990', '1年', '199999999', 'test@testtest01.com', '我目前正在职，正考虑换个新环境', '稻壳儿', 'wps', '2015-06-04 18:12:19', 'images/myresume/default_headpic.png', 0, '2015-06-04 18:12:19', 1545525, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195377, '女', '1990', '1年', '199999999', 'test@testtest01.com', '我目前正在职，正考虑换个新环境', '稻壳儿', 'wps', '2015-06-04 18:13:28', 'images/myresume/default_headpic.png', 0, '2015-06-04 18:13:28', 1545526, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195378, '女', '1990', '1年', '199999999', 'test@testtest01.com', '我目前正在职，正考虑换个新环境', '稻壳儿', 'wps', '2015-06-04 18:15:16', 'images/myresume/default_headpic.png', 0, '2015-06-04 18:15:16', 1545527, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195379, '女', '1990', '1年', '199999999', 'test@testtest01.com', '我目前正在职，正考虑换个新环境', '稻壳儿', 'wps', '2015-06-04 18:23:06', 'images/myresume/default_headpic.png', 0, '2015-06-04 18:23:06', 1545528, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195380, '女', '1990', '1年', '199999999', 'test@testtest01.com', '我目前正在职，正考虑换个新环境', '稻壳儿', 'wps', '2015-06-04 18:23:38', 'images/myresume/default_headpic.png', 0, '2015-06-04 18:23:39', 1545529, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195381, '女', '1990', '1年', '199999999', 'test@testtest01.com', '我目前正在职，正考虑换个新环境', '稻壳儿', 'wps', '2015-06-04 18:27:33', 'images/myresume/default_headpic.png', 0, '2015-06-04 18:27:33', 1545530, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195382, '女', '1990', '1年', '199999999', 'test@testtest01.com', '我目前正在职，正考虑换个新环境', '稻壳儿', 'wps', '2015-06-04 18:31:36', 'images/myresume/default_headpic.png', 0, '2015-06-04 18:31:39', 1545531, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195383, '女', '1990', '1年', '199999999', 'test@testtest01.com', '我目前正在职，正考虑换个新环境', '稻壳儿', 'wps', '2015-06-04 18:36:48', 'images/myresume/default_headpic.png', 0, '2015-06-04 18:36:48', 1545532, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195384, '女', '1990', '1年', '199999999', 'test@testtest01.com', '我目前正在职，正考虑换个新环境', '稻壳儿', 'wps', '2015-06-04 19:15:15', 'images/myresume/default_headpic.png', 0, '2015-06-04 19:15:16', 1545533, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195385, '女', '1990', '1年', '199999999', 'test@testtest01.com', '我目前正在职，正考虑换个新环境', '稻壳儿', 'wps', '2015-06-04 19:28:53', 'images/myresume/default_headpic.png', 0, '2015-06-04 19:28:53', 1545534, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195386, '女', '1990', '1年', '199999999', 'test@testtest01.com', '我目前正在职，正考虑换个新环境', '稻壳儿', 'wps', '2015-06-04 19:46:42', 'images/myresume/default_headpic.png', 0, '2015-06-04 19:46:45', 1545535, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
INSERT INTO `r_resume` VALUES (2195387, '女', '1990', '1年', '199999999', 'test@testtest01.com', '我目前正在职，正考虑换个新环境', '稻壳儿', 'wps', '2015-06-04 19:48:16', 'images/myresume/default_headpic.png', 0, '2015-06-04 19:48:16', 1545536, 1, '本科', 0, 0, 0, 0, '', '广州', 65, 0, 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
