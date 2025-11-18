/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50506
 Source Host           : localhost:3306
 Source Schema         : 2522

 Target Server Type    : MySQL
 Target Server Version : 50506
 File Encoding         : 65001

 Date: 15/03/2025 15:26:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for degrees
-- ----------------------------
DROP TABLE IF EXISTS `degrees`;
CREATE TABLE `degrees`  (
  `degree_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '证书编号',
  `student_id` int(11) NOT NULL COMMENT '学生编号',
  `org_id` int(11) NOT NULL COMMENT '关联编号',
  `degree_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学位名称',
  `issue_date` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '颁发日期',
  `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '有效' COMMENT '证书状态',
  PRIMARY KEY (`degree_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学位证书' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of degrees
-- ----------------------------
INSERT INTO `degrees` VALUES (1, 1, 1, '计算机科学学士', '2022-06-01', '有效');
INSERT INTO `degrees` VALUES (2, 2, 1, '数学学士', '2022-06-01', '有效');
INSERT INTO `degrees` VALUES (3, 3, 2, '物理学学士', '2022-07-01', '有效');
INSERT INTO `degrees` VALUES (4, 4, 2, '化学学士', '2022-07-01', '有效');
INSERT INTO `degrees` VALUES (5, 5, 3, '生物学学士', '2022-08-01', '有效');
INSERT INTO `degrees` VALUES (6, 1, 4, '文学学士', '2022-09-01', '有效');
INSERT INTO `degrees` VALUES (7, 2, 4, '历史学学士', '2022-09-01', '有效');
INSERT INTO `degrees` VALUES (8, 3, 5, '哲学学士', '2022-10-01', '有效');
INSERT INTO `degrees` VALUES (9, 4, 5, '经济学学士', '2022-10-01', '有效');
INSERT INTO `degrees` VALUES (10, 5, 1, '管理学学士', '2022-11-01', '有效');
INSERT INTO `degrees` VALUES (11, 1, 6, '企业技术培训认证证书', '2023-03-15', '有效');
INSERT INTO `degrees` VALUES (12, 2, 7, '企业营销技能认证证书', '2023-04-20', '有效');
INSERT INTO `degrees` VALUES (13, 3, 8, '企业项目管理认证证书', '2023-05-25', '有效');
INSERT INTO `degrees` VALUES (14, 4, 9, '企业数据分析认证证书', '2023-06-30', '有效');
INSERT INTO `degrees` VALUES (15, 5, 10, '企业人工智能应用认证证书', '2023-07-10', '有效');
INSERT INTO `degrees` VALUES (16, 1, 6, '企业项目管理认证', '2023-01-15', '有效');
INSERT INTO `degrees` VALUES (17, 2, 6, '企业市场营销认证', '2023-02-20', '有效');
INSERT INTO `degrees` VALUES (18, 3, 7, '企业数据分析认证', '2023-03-25', '有效');
INSERT INTO `degrees` VALUES (19, 4, 7, '企业人力资源管理认证', '2023-04-30', '有效');
INSERT INTO `degrees` VALUES (20, 5, 8, '企业财务管理认证', '2023-05-10', '有效');
INSERT INTO `degrees` VALUES (21, 1, 8, '企业供应链管理认证', '2023-06-18', '有效');
INSERT INTO `degrees` VALUES (22, 2, 9, '企业信息技术服务认证', '2023-07-22', '有效');
INSERT INTO `degrees` VALUES (23, 3, 9, '企业质量控制认证', '2023-08-28', '有效');
INSERT INTO `degrees` VALUES (24, 4, 10, '企业创新管理认证', '2023-09-12', '有效');
INSERT INTO `degrees` VALUES (25, 5, 10, '企业领导力认证', '2023-10-17', '有效');

-- ----------------------------
-- Table structure for organizations
-- ----------------------------
DROP TABLE IF EXISTS `organizations`;
CREATE TABLE `organizations`  (
  `org_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机构编号',
  `org_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '机构名称',
  `org_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '机构类型',
  `contact_email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系邮箱',
  `contact_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`org_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '机构企业' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of organizations
-- ----------------------------
INSERT INTO `organizations` VALUES (1, '教育机构A', '教育机构', 'instA@example.com', '1234567890');
INSERT INTO `organizations` VALUES (2, '教育机构B', '教育机构', 'instB@example.com', '0987654321');
INSERT INTO `organizations` VALUES (3, '教育机构C', '教育机构', 'instC@example.com', '1357924680');
INSERT INTO `organizations` VALUES (4, '教育机构D', '教育机构', 'instD@example.com', '2468135790');
INSERT INTO `organizations` VALUES (5, '教育机构E', '教育机构', 'instE@example.com', '3692581470');
INSERT INTO `organizations` VALUES (6, '企业X', '企业', 'entX@example.com', '4567891230');
INSERT INTO `organizations` VALUES (7, '企业Y', '企业', 'entY@example.com', '7891234560');
INSERT INTO `organizations` VALUES (8, '企业Z', '企业', 'entZ@example.com', '8529637410');
INSERT INTO `organizations` VALUES (9, '企业W', '企业', 'entW@example.com', '9638527410');
INSERT INTO `organizations` VALUES (10, '企业V', '企业', 'entV@example.com', '1472583690');

-- ----------------------------
-- Table structure for user_institution_bindings
-- ----------------------------
DROP TABLE IF EXISTS `user_institution_bindings`;
CREATE TABLE `user_institution_bindings`  (
  `binding_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '信息编号',
  `student_id` int(11) NOT NULL COMMENT '学生编号',
  `org_id` int(11) NOT NULL COMMENT '机构编号',
  `bind_date` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '绑定时间',
  PRIMARY KEY (`binding_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_institution_bindings
-- ----------------------------
INSERT INTO `user_institution_bindings` VALUES (1, 1, 1, '2025-03-06 10:41:54');
INSERT INTO `user_institution_bindings` VALUES (2, 2, 1, '2025-02-27 10:41:54');
INSERT INTO `user_institution_bindings` VALUES (3, 3, 2, '2025-02-24 10:41:54');
INSERT INTO `user_institution_bindings` VALUES (4, 4, 2, '2025-02-28 10:41:54');
INSERT INTO `user_institution_bindings` VALUES (5, 5, 3, '2025-02-26 10:41:54');
INSERT INTO `user_institution_bindings` VALUES (6, 1, 4, '2025-03-08 10:41:54');
INSERT INTO `user_institution_bindings` VALUES (7, 2, 4, '2025-02-28 10:41:54');
INSERT INTO `user_institution_bindings` VALUES (8, 3, 5, '2025-02-20 10:41:54');
INSERT INTO `user_institution_bindings` VALUES (9, 4, 5, '2025-03-07 10:41:54');
INSERT INTO `user_institution_bindings` VALUES (10, 5, 1, '2025-02-14 10:41:54');
INSERT INTO `user_institution_bindings` VALUES (11, 21, 6, '2025-02-14 10:41:54');
INSERT INTO `user_institution_bindings` VALUES (12, 22, 6, '2025-02-14 10:41:54');
INSERT INTO `user_institution_bindings` VALUES (13, 23, 6, '2025-02-14 10:41:54');
INSERT INTO `user_institution_bindings` VALUES (14, 24, 6, '2025-02-14 10:41:54');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户角色',
  `permissions` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '用户权限',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `created_at` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, 'student01', '123456', '学生', '无', 'student01@example.com', '2025-03-09 10:41:24');
INSERT INTO `userinfo` VALUES (2, 'student02', '123456', '学生', '无', 'student02@example.com', '2025-02-25 10:41:24');
INSERT INTO `userinfo` VALUES (3, 'student03', '123456', '学生', '无', 'student03@example.com', '2025-03-06 10:41:24');
INSERT INTO `userinfo` VALUES (4, 'student04', '123456', '学生', '无', 'student04@example.com', '2025-02-21 10:41:24');
INSERT INTO `userinfo` VALUES (5, 'student05', '123456', '学生', '无', 'student05@example.com', '2025-02-24 10:41:24');
INSERT INTO `userinfo` VALUES (6, 'institution01', '123456', '教育机构', '无', 'institution01@example.com', '2025-02-13 10:41:24');
INSERT INTO `userinfo` VALUES (7, 'institution02', '123456', '教育机构', '无', 'institution02@example.com', '2025-02-12 10:41:24');
INSERT INTO `userinfo` VALUES (8, 'enterprise01', '123456', '企业', '无', 'enterprise01@example.com', '2025-03-10 10:41:24');
INSERT INTO `userinfo` VALUES (9, 'enterprise02', '123456', '企业', '无', 'enterprise02@example.com', '2025-02-24 10:41:24');
INSERT INTO `userinfo` VALUES (10, 'admin', '123456', '管理员', '无', 'admin01@example.com', '2025-02-23 10:41:24');
INSERT INTO `userinfo` VALUES (21, 'student06', '123456', '学生', '无', 'student06@example.com', '2025-02-25 10:41:24');
INSERT INTO `userinfo` VALUES (22, 'student07', '123456', '学生', '无', 'student07@example.com', '2025-02-25 10:41:24');
INSERT INTO `userinfo` VALUES (23, 'student08', '123456', '学生', '无', 'student08@example.com', '2025-02-25 10:41:24');
INSERT INTO `userinfo` VALUES (24, 'student09', '123456', '学生', '无', 'student09@example.com', '2025-02-25 10:41:24');
INSERT INTO `userinfo` VALUES (25, 'student10', '123456', '学生', '无', 'student10@example.com', '2025-02-25 10:41:24');

SET FOREIGN_KEY_CHECKS = 1;
