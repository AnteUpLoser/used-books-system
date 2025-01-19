/*
 Navicat MySQL Data Transfer

 Source Server         : base
 Source Server Type    : MySQL
 Source Server Version : 50724 (5.7.24)
 Source Host           : localhost:3306
 Source Schema         : used_books_system

 Target Server Type    : MySQL
 Target Server Version : 50724 (5.7.24)
 File Encoding         : 65001

 Date: 19/01/2025 20:41:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publish_from` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pages` int(255) NULL DEFAULT NULL,
  `word_count` int(255) NULL DEFAULT NULL,
  `isbn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '平凡的世界', '路遥', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1452409015i/28501384.jpg', '中国出版社', 324, 10241024, '1894738921');
INSERT INTO `book` VALUES (2, '摆渡人', '（英）克萊兒·麥克福爾', 'https://im2.book.com.tw/image/getImage?i=https://www.books.com.tw/img/CN1/176/52/CN11765203.jpg&v=6345b8bck&w=348&h=348', '文艺出版社', 256, 10241024, 'td2Y7bGBYi');
INSERT INTO `book` VALUES (3, 'Wu Zhiyuan', 'XxQp6VNk7T', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1452409015i/28501384.jpg', 'TDr5AHSq4D', 256, 10241024, 'tWlgLfm9lc');
INSERT INTO `book` VALUES (4, 'Koon Sum Wing', 'SA4UE6AOqw', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1452409015i/28501384.jpg', '8Y2cayPO92', 256, 10241024, 'tOQ8wmkqxn');
INSERT INTO `book` VALUES (5, 'Diane Gonzalez', 'xKh6MGIwIb', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1452409015i/28501384.jpg', 'lKKwjn5Ifi', 256, 10241024, 'kIjRttQ609');
INSERT INTO `book` VALUES (6, 'Sit Tin Lok', 'n5WFxW4rX5', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1452409015i/28501384.jpg', 'AS0zkDajMy', 256, 10241024, 'YyCrfYEBt3');
INSERT INTO `book` VALUES (7, 'Huang Jialun', '8AU8EcSeBC', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1452409015i/28501384.jpg', 'A6b172HtnS', 256, 10241024, 'XseoVSy3LN');
INSERT INTO `book` VALUES (8, 'Liao Kwok Kuen', 'prkRWqjfKQ', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1452409015i/28501384.jpg', 'oREXZAPU07', 256, 10241024, 'CryBNJy4GX');
INSERT INTO `book` VALUES (9, 'Sato Kenta', '4yJP89nWBw', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1452409015i/28501384.jpg', 'XHRIo1NoW9', 256, 10241024, 'NYW7S0pO3i');
INSERT INTO `book` VALUES (10, 'Hayashi Seiko', 'mdhu8YTBhX', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1452409015i/28501384.jpg', 'GAc19enCPu', 256, 10241024, 'NVLMMvngWa');
INSERT INTO `book` VALUES (15, 'Murata Ryota', '5QO5Ytt58v', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1452409015i/28501384.jpg', 'LPAQl0anYQ', 256, 10241024, '1nrenqmLv0');
INSERT INTO `book` VALUES (16, '1', '1', 'https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1452409015i/28501384.jpg', '1', 1, 1, '1');
INSERT INTO `book` VALUES (17, '平凡的世界', '玉华', NULL, '你好中国出版社', 123123, 123123, '1278389124');
INSERT INTO `book` VALUES (18, '123', '12', NULL, '12', 3, 123, '123');

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info`  (
  `book_id` int(11) NOT NULL,
  `serial_no` int(11) NULL DEFAULT NULL COMMENT '系统内该二手书编号',
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `delete_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES (1, NULL, 0.00, '17:23:27', NULL, '13:35:58', 0, 0);
INSERT INTO `book_info` VALUES (2, 449, 160.35, '11:02:23', '2002-05-22', '15:59:32', 2, 0);
INSERT INTO `book_info` VALUES (3, 620, 266.38, '12:46:07', '2023-06-09', '12:17:39', 2, 0);
INSERT INTO `book_info` VALUES (4, 616, 362.88, '17:13:19', '2001-09-20', '17:23:47', 2, 0);
INSERT INTO `book_info` VALUES (5, 973, 220.20, '17:25:16', '2021-06-01', '09:34:29', 2, 0);
INSERT INTO `book_info` VALUES (6, 630, 746.07, '15:56:50', '2002-02-12', '15:40:02', 2, 0);
INSERT INTO `book_info` VALUES (7, 463, 759.31, '17:13:39', '2006-10-16', '17:29:48', 2, 0);
INSERT INTO `book_info` VALUES (8, 274, 120.56, '11:45:23', '2014-04-12', '17:45:52', 2, 0);
INSERT INTO `book_info` VALUES (9, 870, 982.33, '15:21:45', '2023-07-06', '09:45:30', 2, 0);
INSERT INTO `book_info` VALUES (10, 820, 550.00, '09:17:40', '2020-01-19', '16:34:32', 2, 0);
INSERT INTO `book_info` VALUES (15, NULL, 29.99, NULL, NULL, NULL, 100, NULL);
INSERT INTO `book_info` VALUES (16, NULL, 1.00, NULL, NULL, NULL, 1, NULL);
INSERT INTO `book_info` VALUES (17, NULL, 99.00, NULL, NULL, NULL, 2, NULL);
INSERT INTO `book_info` VALUES (18, NULL, 123.00, NULL, NULL, NULL, 123, NULL);

-- ----------------------------
-- Table structure for book_kind
-- ----------------------------
DROP TABLE IF EXISTS `book_kind`;
CREATE TABLE `book_kind`  (
  `kind_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`kind_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_kind
-- ----------------------------
INSERT INTO `book_kind` VALUES (1, '人文地理');

-- ----------------------------
-- Table structure for book_kind_related
-- ----------------------------
DROP TABLE IF EXISTS `book_kind_related`;
CREATE TABLE `book_kind_related`  (
  `book_id` int(11) NOT NULL,
  `kind_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`, `kind_id`) USING BTREE,
  INDEX `删除专栏时候级联删除book中的`(`kind_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_kind_related
-- ----------------------------
INSERT INTO `book_kind_related` VALUES (1, 1);

-- ----------------------------
-- Table structure for book_tag
-- ----------------------------
DROP TABLE IF EXISTS `book_tag`;
CREATE TABLE `book_tag`  (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_tag
-- ----------------------------
INSERT INTO `book_tag` VALUES (1, '人文');
INSERT INTO `book_tag` VALUES (2, '科学');
INSERT INTO `book_tag` VALUES (3, '生活');
INSERT INTO `book_tag` VALUES (4, '地理');
INSERT INTO `book_tag` VALUES (5, '文学');
INSERT INTO `book_tag` VALUES (6, '传记');
INSERT INTO `book_tag` VALUES (7, '历史');
INSERT INTO `book_tag` VALUES (8, '教材');
INSERT INTO `book_tag` VALUES (9, '小说');
INSERT INTO `book_tag` VALUES (10, '教育');
INSERT INTO `book_tag` VALUES (11, '心理学');
INSERT INTO `book_tag` VALUES (12, '工具');

-- ----------------------------
-- Table structure for book_tag_related
-- ----------------------------
DROP TABLE IF EXISTS `book_tag_related`;
CREATE TABLE `book_tag_related`  (
  `book_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`, `tag_id`) USING BTREE,
  INDEX `删除tag的时候把它相关的book删掉`(`tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_tag_related
-- ----------------------------
INSERT INTO `book_tag_related` VALUES (1, 1);
INSERT INTO `book_tag_related` VALUES (1, 2);
INSERT INTO `book_tag_related` VALUES (1, 3);

-- ----------------------------
-- Table structure for bulletin
-- ----------------------------
DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE `bulletin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知内容',
  `notify_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布时间',
  `update_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  `delete_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除时间',
  `is_delete` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '是否已被删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bulletin
-- ----------------------------
INSERT INTO `bulletin` VALUES (1, '1', '1', '1719133476', '1719133476', NULL, NULL);
INSERT INTO `bulletin` VALUES (2, '1', '1', '1719133522', '1719133522', '1719136497', 1);
INSERT INTO `bulletin` VALUES (3, '1', '1', '1719135513', '1719135513', '1719160188', 1);
INSERT INTO `bulletin` VALUES (4, '1', '1', '1719135556', '1719135556', '1719320331', 1);
INSERT INTO `bulletin` VALUES (5, '震惊，今晚维护服务器', '因为后端程序员太菜了，今晚宣布维护服务器，网站暂停服务至凌晨5点', '1719135821', '1719135821', '1719634960', 1);
INSERT INTO `bulletin` VALUES (6, '今晚是happy night', '震惊，今晚是狂欢之夜', '1719160217', '1719160217', '1719320332', 1);
INSERT INTO `bulletin` VALUES (7, '123', '123', '1719160896', '1719160896', '1719320333', 1);
INSERT INTO `bulletin` VALUES (8, '123123', '123123', '1719160918', '1719160918', '1719320333', 1);
INSERT INTO `bulletin` VALUES (9, 'fgr', 'efrrfgrf', '1719320077', '1719320077', '1719320334', 1);
INSERT INTO `bulletin` VALUES (10, 'wwreu', 'dvfdv', '1719320324', '1719320324', '1719320335', 1);
INSERT INTO `bulletin` VALUES (11, '11', '啊是第三方', '1719587477', '1719587477', '1719638786', 1);
INSERT INTO `bulletin` VALUES (12, 'DVD v', '十分出色的丰富的', '1719587565', '1719587565', '1719635019', 1);
INSERT INTO `bulletin` VALUES (13, '是的VS的', '四川省DVD是v', '1719587576', '1719587576', '1719587582', 1);
INSERT INTO `bulletin` VALUES (14, '维护公告', '今晚不停服维护 8：00- 9：00\n', '1719635003', '1719635003', NULL, 0);
INSERT INTO `bulletin` VALUES (15, '后端太菜，服务器崩溃', '你好', '1719638806', '1719638806', '1719727568', 1);
INSERT INTO `bulletin` VALUES (16, '致亲爱的书虫', '感谢您使用我们的网站，祝您在这个网站找到您喜爱的书籍', '1719666293', '1719666293', NULL, 0);
INSERT INTO `bulletin` VALUES (17, '你哈', '你好\n', '1719727580', '1719727580', NULL, 0);

-- ----------------------------
-- Table structure for user_blacklist
-- ----------------------------
DROP TABLE IF EXISTS `user_blacklist`;
CREATE TABLE `user_blacklist`  (
  `uid` int(11) NULL DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原因',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_blacklist
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `memo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '超级管理员松爷', '123', 'super admin');

-- ----------------------------
-- Table structure for user_issue
-- ----------------------------
DROP TABLE IF EXISTS `user_issue`;
CREATE TABLE `user_issue`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `issue` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_issue
-- ----------------------------
INSERT INTO `user_issue` VALUES (1, 1, 'Catherine Ellis', 'RM1SZfiJ7g', '2013-05-01 03:33:03');
INSERT INTO `user_issue` VALUES (2, 2, 'Clifford Jackson', '5S1iMuTr63', '2005-03-11 13:40:51');
INSERT INTO `user_issue` VALUES (3, 3, 'Sherry Washington', 'dryjLDUTP1', '2012-03-20 00:44:20');
INSERT INTO `user_issue` VALUES (4, 4, 'Yang Zhennan', 'RjlhDKJsZS', '2000-07-07 04:48:52');
INSERT INTO `user_issue` VALUES (5, 5, 'Zhou Rui', 'BTYPMJXbEI', '2002-11-24 12:46:48');
INSERT INTO `user_issue` VALUES (6, 6, 'Matsuda Daichi', 'eWoMCao6mE', '2001-11-10 14:23:54');
INSERT INTO `user_issue` VALUES (7, 7, 'Yeow Hiu Tung', 'lqcuQpjLfA', '2016-09-13 11:26:28');
INSERT INTO `user_issue` VALUES (8, 8, 'Matsui Shino', 'IETJlBYBLt', '2019-12-01 02:54:14');
INSERT INTO `user_issue` VALUES (9, 9, 'Okamoto Sara', 'zEAfgzgH6F', '2002-09-22 22:24:19');
INSERT INTO `user_issue` VALUES (10, 10, 'Ellen Alvarez', 'rz9CVjj4Ai', '2017-04-02 16:42:05');
INSERT INTO `user_issue` VALUES (11, 11, 'Sano Yota', 'wyfP9gUtLa', '2022-03-02 17:12:42');
INSERT INTO `user_issue` VALUES (12, 12, 'Yuen Chi Ming', 'uzBuJ177Nf', '2022-10-06 18:41:28');
INSERT INTO `user_issue` VALUES (13, 13, 'Ma Siu Wai', 'YVTKLpvhK8', '2007-08-27 08:36:30');
INSERT INTO `user_issue` VALUES (14, 14, 'Endo Aoi', 'kVxzny6JOX', '2005-12-18 18:32:37');
INSERT INTO `user_issue` VALUES (15, 15, 'Ueno Aoshi', 'ZactPUhGK8', '2012-04-25 13:43:02');
INSERT INTO `user_issue` VALUES (16, 16, 'Hui Lai Yan', 'nOZxF6S3bW', '2015-03-07 07:28:55');
INSERT INTO `user_issue` VALUES (17, 17, 'Kondo Hazuki', 'WatbstIk6S', '2022-04-17 20:17:15');
INSERT INTO `user_issue` VALUES (18, 18, 'Cheung Chi Ming', 'RlojPIOk1O', '2002-12-20 12:09:42');
INSERT INTO `user_issue` VALUES (19, 19, 'Crystal Walker', 'ehBEDyVl7w', '2001-02-13 08:37:25');
INSERT INTO `user_issue` VALUES (20, 20, 'Ruth Wells', 'JQLdO7WGmU', '2010-01-18 17:39:39');
INSERT INTO `user_issue` VALUES (21, 21, 'Sheh Chun Yu', 'l7jFZwZ4sI', '2024-04-02 11:47:16');
INSERT INTO `user_issue` VALUES (22, 22, 'Cheng Wai San', '72iy3lu5ri', '2015-10-28 12:45:35');
INSERT INTO `user_issue` VALUES (23, 23, 'Matsui Ryota', 'htlFDsTbn1', '2021-08-14 00:11:55');
INSERT INTO `user_issue` VALUES (24, 24, 'Matsumoto Yuna', 'ELFBSG10Gp', '2008-11-05 11:10:28');
INSERT INTO `user_issue` VALUES (25, 25, 'Wong Ka Keung', 'k544GzzDlo', '2016-09-10 23:36:32');
INSERT INTO `user_issue` VALUES (26, 26, 'Tamura Minato', '01Rf1cjN23', '2012-01-03 12:01:41');
INSERT INTO `user_issue` VALUES (27, 27, 'Yue Wing Kuen', 'BpRZamXIeY', '2014-09-16 17:43:38');
INSERT INTO `user_issue` VALUES (28, 28, 'Masuda Kenta', 'Oc0NNXbycO', '2023-10-21 16:38:02');
INSERT INTO `user_issue` VALUES (29, 29, 'Yin Ziyi', 'oDeoXDiMpH', '2021-11-21 01:22:27');
INSERT INTO `user_issue` VALUES (30, 30, 'Cui Xiuying', 'p3rGnbwbou', '2011-06-23 09:54:59');
INSERT INTO `user_issue` VALUES (31, 31, 'Lu Xiaoming', '7LAjSmvA8S', '2000-05-10 06:19:06');
INSERT INTO `user_issue` VALUES (32, 32, 'Takeuchi Sakura', 'V3tqnXgxgM', '2016-06-17 14:48:44');
INSERT INTO `user_issue` VALUES (33, 33, 'Sharon Hicks', 'AYVo4cI5eu', '2011-06-25 01:03:30');
INSERT INTO `user_issue` VALUES (34, 34, 'Kinoshita Seiko', 'ArReIupBib', '2014-08-09 06:15:16');
INSERT INTO `user_issue` VALUES (35, 35, 'Edward Howard', 'cuEESRD7DU', '2021-06-16 15:35:03');
INSERT INTO `user_issue` VALUES (36, 36, 'Yao Lu', 'j34kac44qd', '2014-07-23 11:21:05');
INSERT INTO `user_issue` VALUES (37, 37, 'Norma Lopez', 'GDucimrP5d', '2014-08-12 10:36:37');
INSERT INTO `user_issue` VALUES (38, 38, 'Mo Xiaoming', '9nlyubfE7N', '2000-01-28 13:14:18');
INSERT INTO `user_issue` VALUES (39, 39, 'To Yun Fat', 'YM6FYTPzXJ', '2022-10-29 09:07:03');
INSERT INTO `user_issue` VALUES (40, 40, 'Fong Hui Mei', 'tzRSjqWNys', '2017-08-23 11:19:45');
INSERT INTO `user_issue` VALUES (41, 41, 'Siu Fu Shing', '1zpYfp2l2y', '2017-05-20 09:02:27');
INSERT INTO `user_issue` VALUES (42, 42, 'Deng Jialun', 'h9LLxNPmvK', '2014-06-03 01:14:09');
INSERT INTO `user_issue` VALUES (43, 43, 'Marie Sanders', 'i5w7xGSzoj', '2010-04-04 21:37:44');
INSERT INTO `user_issue` VALUES (44, 44, 'Goto Minato', '2ydl8e5eCv', '2013-08-18 06:18:38');
INSERT INTO `user_issue` VALUES (45, 45, 'April Foster', '8C3oRzkPIt', '2011-08-15 18:27:22');
INSERT INTO `user_issue` VALUES (46, 46, 'Mo Wai Man', 'TlYdnn72cl', '2006-01-03 04:01:33');
INSERT INTO `user_issue` VALUES (47, 47, 'Kojima Itsuki', 'ysfxIzLfrr', '2016-10-05 07:13:17');
INSERT INTO `user_issue` VALUES (48, 48, 'Gu Jiehong', 'WPTDhQ47mR', '2001-01-22 15:37:46');
INSERT INTO `user_issue` VALUES (49, 49, 'Gong Jiehong', 'yyl47TRs3R', '2014-12-07 16:49:49');
INSERT INTO `user_issue` VALUES (50, 50, 'Stephanie Castillo', 'jL0ead6XLy', '2005-04-27 13:32:59');
INSERT INTO `user_issue` VALUES (51, 51, 'Sun Jialun', '0b5R0h5v1m', '2018-09-04 01:15:47');
INSERT INTO `user_issue` VALUES (52, 52, 'Willie Brown', 'GS5TOAumGp', '2019-06-24 10:28:00');
INSERT INTO `user_issue` VALUES (53, 53, 'Emily Collins', 'hGtQcsTbTp', '2000-09-20 19:29:45');
INSERT INTO `user_issue` VALUES (54, 54, 'Kobayashi Ayato', 'yDzXtiNS6e', '2012-04-01 23:44:43');
INSERT INTO `user_issue` VALUES (55, 55, 'Qin Jialun', 'Heoz8Y15d0', '2024-03-24 02:23:52');
INSERT INTO `user_issue` VALUES (56, 56, 'Shimada Kazuma', 'EiGhIApJer', '2016-08-31 22:16:30');
INSERT INTO `user_issue` VALUES (57, 57, 'Kudo Riku', 'or6gGvIK9w', '2017-08-26 18:27:34');
INSERT INTO `user_issue` VALUES (58, 58, 'Che Suk Yee', 'dvI2oIbF4V', '2001-12-31 03:48:25');
INSERT INTO `user_issue` VALUES (59, 59, 'Roy Alexander', 'hYn5Cut8Qr', '2022-08-30 05:27:13');
INSERT INTO `user_issue` VALUES (60, 60, 'Edith Burns', 'OP9J2rgNPb', '2007-03-31 04:37:49');
INSERT INTO `user_issue` VALUES (61, 61, 'Abe Yuto', '7XqxcFOJOx', '2012-10-13 16:15:03');
INSERT INTO `user_issue` VALUES (62, 62, 'Harada Aoi', 'CLGbT76euw', '2018-11-10 00:30:05');
INSERT INTO `user_issue` VALUES (63, 63, 'Ichikawa Rin', 'HCpfjrz7Wu', '2014-10-01 02:33:25');
INSERT INTO `user_issue` VALUES (64, 64, 'Janice Henry', 'rJm5Ck86rp', '2018-03-06 22:09:54');
INSERT INTO `user_issue` VALUES (65, 65, 'Kinoshita Hazuki', 'bV1aJIBAoc', '2018-12-14 00:27:04');
INSERT INTO `user_issue` VALUES (66, 66, 'Yuen Ka Ling', 'Z1Irg6H231', '2018-06-30 10:32:05');
INSERT INTO `user_issue` VALUES (67, 67, 'Cynthia Sanchez', 'BivM0nXJjO', '2001-06-03 14:32:43');
INSERT INTO `user_issue` VALUES (68, 68, 'Qian Rui', '6SBg05gUtm', '2024-02-20 01:09:53');
INSERT INTO `user_issue` VALUES (69, 69, 'Hayashi Eita', '9meOXp4psA', '2001-12-21 00:16:20');
INSERT INTO `user_issue` VALUES (70, 70, 'Long Xiaoming', 'FL0hJ8HbuW', '2003-12-07 06:03:59');
INSERT INTO `user_issue` VALUES (71, 71, 'Song Jiehong', 'mssiiqd2BH', '2002-05-06 06:34:22');
INSERT INTO `user_issue` VALUES (72, 72, 'Yamashita Ayato', 'JIuTqzR4Qw', '2005-05-26 02:18:04');
INSERT INTO `user_issue` VALUES (73, 73, 'Nomura Sara', '3ZTmEELOkp', '2001-11-26 01:30:39');
INSERT INTO `user_issue` VALUES (74, 74, 'Miura Mitsuki', '3rW41mRUJT', '2021-08-07 06:31:24');
INSERT INTO `user_issue` VALUES (75, 75, 'Susan Griffin', 'azpvGwY2Ri', '2008-12-16 17:44:04');
INSERT INTO `user_issue` VALUES (76, 76, 'Marie Graham', 'B2KofoDOYp', '2017-08-27 02:41:03');
INSERT INTO `user_issue` VALUES (77, 77, 'Kimura Mio', 'Wd6sVBQfjX', '2006-03-10 00:21:30');
INSERT INTO `user_issue` VALUES (78, 78, 'Bradley Hughes', '4TvMGtvm2s', '2021-05-13 21:23:22');
INSERT INTO `user_issue` VALUES (79, 79, 'Tanaka Sakura', 'j9GaiwmupE', '2011-09-08 13:47:46');
INSERT INTO `user_issue` VALUES (80, 80, 'Murata Eita', '9XgmMucgu6', '2010-01-28 22:01:02');
INSERT INTO `user_issue` VALUES (81, 81, 'Xia Shihan', 'jInGHCqtYt', '2008-08-14 14:08:28');
INSERT INTO `user_issue` VALUES (82, 82, 'Yang Xiuying', '8S8QfI12XM', '2023-04-08 19:53:43');
INSERT INTO `user_issue` VALUES (83, 83, 'Kudo Ikki', 'MWgbkx0pgp', '2022-07-26 11:45:38');
INSERT INTO `user_issue` VALUES (84, 84, 'Kinoshita Ayato', '69Zi4ecMvw', '2003-10-21 15:24:53');
INSERT INTO `user_issue` VALUES (85, 85, 'Marjorie Patel', 'TkUTzpuln5', '2010-08-03 08:34:18');
INSERT INTO `user_issue` VALUES (86, 86, 'Chang Lan', '9yvGb5Ffci', '2014-04-04 08:48:02');
INSERT INTO `user_issue` VALUES (87, 87, 'Kenneth Cruz', 'ReU7MtI2lA', '2004-04-16 03:02:29');
INSERT INTO `user_issue` VALUES (88, 88, 'Christina Henderson', '6naGwvQq6g', '2011-04-27 09:04:37');
INSERT INTO `user_issue` VALUES (89, 89, 'Shi Zhennan', 'hJyIalP9Jj', '2012-04-16 03:01:59');
INSERT INTO `user_issue` VALUES (90, 90, 'Lei Ziyi', 'QIp0U4wzI0', '2010-11-27 20:39:27');
INSERT INTO `user_issue` VALUES (91, 91, 'Guo Ziyi', '8mkI726UXk', '2006-07-23 04:44:26');
INSERT INTO `user_issue` VALUES (92, 92, 'Sakurai Shino', 'Op8j7xbQXs', '2007-03-26 09:59:45');
INSERT INTO `user_issue` VALUES (93, 93, 'Liao Zhiyuan', 'Jl4d3gIjfi', '2014-09-18 07:01:24');
INSERT INTO `user_issue` VALUES (94, 94, 'Gao Jiehong', 'wv9gpP0nT0', '2019-09-30 00:50:16');
INSERT INTO `user_issue` VALUES (95, 95, 'Lo Yun Fat', '0LEApg86cK', '2002-06-22 00:14:57');
INSERT INTO `user_issue` VALUES (96, 96, 'Ichikawa Hikari', '5nrSlCcqZM', '2023-12-05 15:08:34');
INSERT INTO `user_issue` VALUES (97, 97, 'Ma Jialun', 'sha2lP0E5C', '2013-08-01 01:50:35');
INSERT INTO `user_issue` VALUES (98, 98, 'Tse Sai Wing', 'VaOHzBiymV', '2011-01-02 07:09:10');
INSERT INTO `user_issue` VALUES (99, 99, 'Xiong Jiehong', 'qRVc6XPNHQ', '2011-02-08 18:20:25');
INSERT INTO `user_issue` VALUES (100, 100, 'Martin Lewis', 'KuD53RCNBz', '2009-03-19 10:54:11');

SET FOREIGN_KEY_CHECKS = 1;
