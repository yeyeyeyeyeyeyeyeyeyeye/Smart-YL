/*
 Navicat Premium Dump SQL

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80039 (8.0.39)
 Source Host           : localhost:3306
 Source Schema         : yl

 Target Server Type    : MySQL
 Target Server Version : 80039 (8.0.39)
 File Encoding         : 65001

 Date: 11/04/2025 12:35:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '活动ID',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '活动名称',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '活动内容',
  `place` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地点',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `max_participants` int NOT NULL COMMENT '最多人数',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for activity_enroll
-- ----------------------------
DROP TABLE IF EXISTS `activity_enroll`;
CREATE TABLE `activity_enroll`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '报名ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `activity_id` bigint NOT NULL COMMENT '活动ID',
  `enrolled_at` datetime NOT NULL COMMENT '报名时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_enroll_user`(`user_id` ASC) USING BTREE,
  INDEX `fk_enroll_activity`(`activity_id` ASC) USING BTREE,
  CONSTRAINT `fk_enroll_activity` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_enroll_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity_enroll
-- ----------------------------

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型（系统/社区/机构）',
  `target_role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '目标角色（all/admin/user等）',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of announcement
-- ----------------------------

-- ----------------------------
-- Table structure for health_record
-- ----------------------------
DROP TABLE IF EXISTS `health_record`;
CREATE TABLE `health_record`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `date` date NOT NULL COMMENT '日期',
  `blood_pressure` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '血压（如120/80）',
  `heart_rate` int NOT NULL COMMENT '心率',
  `temperature` decimal(4, 1) NOT NULL COMMENT '体温',
  `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_healthrecord_user`(`user_id` ASC) USING BTREE,
  CONSTRAINT `fk_healthrecord_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of health_record
-- ----------------------------

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `ip_address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '登录IP',
  `login_time` datetime NOT NULL COMMENT '登录时间',
  `user_agent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '设备信息',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_loginlog_user`(`user_id` ASC) USING BTREE,
  CONSTRAINT `fk_loginlog_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_log
-- ----------------------------

-- ----------------------------
-- Table structure for message_board
-- ----------------------------
DROP TABLE IF EXISTS `message_board`;
CREATE TABLE `message_board`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '留言ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '留言内容',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `reply` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '管理员回复内容',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_messageboard_user`(`user_id` ASC) USING BTREE,
  CONSTRAINT `fk_messageboard_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message_board
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '新闻ID',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '新闻标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '新闻内容',
  `published_at` datetime NOT NULL COMMENT '发布时间',
  `source` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '来源',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for nursing_home
-- ----------------------------
DROP TABLE IF EXISTS `nursing_home`;
CREATE TABLE `nursing_home`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '机构ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '机构名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '机构介绍',
  `longitude` double NULL DEFAULT NULL COMMENT '地图经度',
  `latitude` double NULL DEFAULT NULL COMMENT '地图纬度',
  `level` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评级等级',
  `created_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nursing_home
-- ----------------------------
INSERT INTO `nursing_home` VALUES (1, '幸福养老院', '北京市朝阳区幸福路123号', '010-12345678', '提供专业的养老服务，舒适的环境和丰富的娱乐活动', 116.405285, 39.904989, '五星', '2025-04-11 09:36:37');
INSERT INTO `nursing_home` VALUES (2, '安康老年公寓', '上海市浦东新区安康路456号', '021-23456789', '为老年人提供贴心的护理服务，温馨的居住环境', 121.473701, 31.230416, '四星', '2025-04-11 09:36:37');
INSERT INTO `nursing_home` VALUES (3, '紫薇养老中心', '广州市天河区紫薇路789号', '020-34567890', '现代化设施，全天候护理，关注老年人身心健康', 113.264385, 23.129112, '三星', '2025-04-11 09:36:37');
INSERT INTO `nursing_home` VALUES (4, '白云敬老院', '广州市白云区敬老路101号', '020-45678901', '专注老年人护理，提供个性化照顾', 113.258414, 23.156527, '五星', '2025-04-11 09:36:37');
INSERT INTO `nursing_home` VALUES (5, '蓝天老人之家', '深圳市福田区蓝天路202号', '0755-56789012', '给老年人一个温暖的家，周到的医疗和护理服务', 114.057868, 22.543096, '四星', '2025-04-11 09:36:37');
INSERT INTO `nursing_home` VALUES (6, '和平养老院', '成都市武侯区和平街303号', '028-67890123', '环境优美，医疗护理设备先进', 104.073302, 30.577404, '三星', '2025-04-11 09:36:37');
INSERT INTO `nursing_home` VALUES (7, '长寿之家', '杭州市西湖区长寿路404号', '0571-78901234', '提供尊贵的养老服务，全天候健康监测', 120.155072, 30.274084, '五星', '2025-04-11 09:36:37');
INSERT INTO `nursing_home` VALUES (8, '阳光养老中心', '南京市建邺区阳光路505号', '025-89012345', '全天候护理，宽敞明亮的生活空间', 118.796077, 32.060255, '四星', '2025-04-11 09:36:37');
INSERT INTO `nursing_home` VALUES (9, '天福老年护理院', '武汉市江汉区天福路606号', '027-90123456', '专业护理，丰富的康复活动', 114.305537, 30.591428, '三星', '2025-04-11 09:36:37');
INSERT INTO `nursing_home` VALUES (10, '晨曦老年公寓', '重庆市渝中区晨曦街707号', '023-23456789', '提供24小时护理，舒适的居住环境', 106.571365, 29.56471, '四星', '2025-04-11 09:36:37');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名(如 admin, user, service)',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'user', '普通用户（老人、家属）');
INSERT INTO `role` VALUES (2, 'comadmin', '社区管理员(常务管理，客服)');
INSERT INTO `role` VALUES (3, 'sysadmin', '系统管理员');
INSERT INTO `role` VALUES (4, 'staff', '职工（护工，医生）');

-- ----------------------------
-- Table structure for service_appointment
-- ----------------------------
DROP TABLE IF EXISTS `service_appointment`;
CREATE TABLE `service_appointment`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '预约ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `service_id` bigint NOT NULL COMMENT '服务项目ID',
  `appointment_time` datetime NOT NULL COMMENT '预约时间',
  `status` tinyint NOT NULL COMMENT '状态（0待处理，1已确认，2已完成，3已取消）',
  `note` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '备注说明',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_appointment_user`(`user_id` ASC) USING BTREE,
  INDEX `fk_appointment_service`(`service_id` ASC) USING BTREE,
  CONSTRAINT `fk_appointment_service` FOREIGN KEY (`service_id`) REFERENCES `service_item` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_appointment_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service_appointment
-- ----------------------------

-- ----------------------------
-- Table structure for service_item
-- ----------------------------
DROP TABLE IF EXISTS `service_item`;
CREATE TABLE `service_item`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '服务项目ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '服务名称',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '服务介绍',
  `price` decimal(10, 2) NOT NULL COMMENT '单次价格',
  `home_id` bigint NOT NULL COMMENT '所属机构ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_service_home`(`home_id` ASC) USING BTREE,
  CONSTRAINT `fk_service_home` FOREIGN KEY (`home_id`) REFERENCES `nursing_home` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of service_item
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '加密密码',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像路径',
  `role_id` bigint NULL DEFAULT NULL COMMENT '角色ID',
  `status` tinyint NULL DEFAULT 1 COMMENT '状态(0禁用/1启用)',
  `created_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user_role`(`role_id` ASC) USING BTREE,
  CONSTRAINT `fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'sysadmin', 'encrypted_password_example', 'sysadmin', '123456789', '/avatars/johndoe.jpg', 3, 1, '2025-04-09 09:01:31');
INSERT INTO `user` VALUES (2, 'user', 'user', 'user', '123456789', '/avatars/johndoe.jpg', 1, 1, '2025-04-09 09:02:16');
INSERT INTO `user` VALUES (3, 'comadmin', 'comadmin', 'comadmin', '123456789', '/avatars/johndoe.jpg', 2, 1, '2025-04-09 09:03:36');
INSERT INTO `user` VALUES (4, 'staff', 'staff', 'staff', '123456789', '/avatars/johndoe.jpg', 4, 1, '2025-04-09 09:03:56');

SET FOREIGN_KEY_CHECKS = 1;
