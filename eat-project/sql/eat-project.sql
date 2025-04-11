/*
 Navicat Premium Data Transfer

 Source Server         : eat-project
 Source Server Type    : MySQL
 Source Server Version : 80036 (8.0.36)
 Source Host           : localhost:3306
 Source Schema         : eat-project

 Target Server Type    : MySQL
 Target Server Version : 80036 (8.0.36)
 File Encoding         : 65001

 Date: 30/03/2025 21:14:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int NULL DEFAULT NULL COMMENT '关联用户id',
  `pid` int NULL DEFAULT NULL COMMENT '关联产品id',
  `number` int NULL DEFAULT NULL COMMENT '产品数量',
  `tprice` double(10, 2) NULL DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ititle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图片标题',
  `iurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图片路径',
  `itype` int NULL DEFAULT NULL COMMENT '图片类型（1：欢迎界面 2：首页界面 3：产品界面）',
  `imsg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (1, '欢迎界面轮播图', 'http://10.4.27.70:1000/file/img/w1.png', 1, '欢迎界面轮播图');
INSERT INTO `image` VALUES (2, '欢迎界面轮播图', 'http://10.4.27.70:1000/file/img/w2.png', 1, '欢迎界面轮播图');
INSERT INTO `image` VALUES (3, '欢迎界面轮播图', 'http://10.4.27.70:1000/file/img/w3.png', 1, '欢迎界面轮播图');
INSERT INTO `image` VALUES (4, '欢迎界面轮播图', 'http://10.4.27.70:1000/file/img/w4.png', 1, '欢迎界面轮播图');
INSERT INTO `image` VALUES (5, '欢迎界面轮播图', 'http://10.4.27.70:1000/file/img/w5.png', 1, '欢迎界面轮播图');
INSERT INTO `image` VALUES (6, '首页轮播图', 'http://10.4.27.70:1000/file/img/i1.png', 2, '首页轮播图');
INSERT INTO `image` VALUES (7, '首页轮播图', 'http://10.4.27.70:1000/file/img/i2.png', 2, '首页轮播图');
INSERT INTO `image` VALUES (8, '首页轮播图', 'http://10.4.27.70:1000/file/img/i3.png', 2, '首页轮播图');
INSERT INTO `image` VALUES (9, '首页轮播图', 'http://10.4.27.70:1000/file/img/i4.png', 2, '首页轮播图');
INSERT INTO `image` VALUES (10, '产品界面轮播图', 'http://10.4.27.70:1000/file/img/pb1.png', 3, '产品界面轮播图');
INSERT INTO `image` VALUES (11, '产品界面轮播图', 'http://10.4.27.70:1000/file/img/pb2.png', 3, '产品界面轮播图');
INSERT INTO `image` VALUES (12, '产品界面轮播图', 'http://10.4.27.70:1000/file/img/pb3.png', 3, '产品界面轮播图');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '第一条通知', '这是第一条通知！！！', '2025-03-22 19:44:49', 1);
INSERT INTO `notice` VALUES (2, '第二条通知', '这是第二条通知！！！', '2025-03-22 19:45:45', 1);
INSERT INTO `notice` VALUES (3, '第三条通知', '这是第三条通知！！！', '2025-03-30 13:21:54', 1);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '产品名称',
  `typeid` int NULL DEFAULT NULL COMMENT '类型关联表id',
  `tprice` double(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `tintroduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '产品介绍',
  `pimageurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '玉脂蒸鲈鱼', 2, 15.00, '玉脂蒸鲈鱼', 'http://10.4.27.70:1000/file/exam/e3ecfba6-03a8-4732-b8a2-78b32fa226ef.png');
INSERT INTO `product` VALUES (2, '一口西多士', 3, 10.00, '一口西多士', 'http://10.4.27.70:1000/file/exam/5b53ceed-79c6-4803-9291-81ed5e54a905.png');
INSERT INTO `product` VALUES (3, '炙烤牛排', 3, 20.00, '炙烤牛排', 'http://10.4.27.70:1000/file/exam/d0fdd871-988b-4e9c-b16b-e32b33624b66.png');
INSERT INTO `product` VALUES (4, '如意菜心', 2, 6.00, '如意菜心', 'http://10.4.27.70:1000/file/exam/408baafc-e8e4-401c-8a41-c46c9bf97e72.png');
INSERT INTO `product` VALUES (5, '参枣双补鸡汤', 5, 8.00, '参枣双补鸡汤', 'http://10.4.27.70:1000/file/exam/1d658a7f-284f-45bd-a3b7-64e2842f3ff5.png');
INSERT INTO `product` VALUES (6, '广式腊味煎饺皇', 2, 8.00, '广式腊味煎饺皇', 'http://10.4.27.70:1000/file/exam/a6dfdf22-df4a-42fe-b9ce-69913828f5ec.png');
INSERT INTO `product` VALUES (7, '玉米排骨汤', 5, 8.00, '玉米排骨汤', 'http://10.4.27.70:1000/file/exam/bb66ac80-1b39-4c58-bbb5-375451b7f827.png');
INSERT INTO `product` VALUES (8, '咖喱牛肉饭', 3, 13.00, '咖喱牛肉饭', 'http://10.4.27.70:1000/file/exam/e0d6a09c-0d01-49a3-bc65-363854ee731e.png');
INSERT INTO `product` VALUES (9, '金汤龙纹鲍', 2, 15.00, '金汤龙纹鲍', 'http://10.4.27.70:1000/file/exam/bdd70cea-d2a1-432f-80b6-72074394a6b6.png');
INSERT INTO `product` VALUES (10, '透明虾冻水滴寿司', 6, 10.00, '透明虾冻水滴寿司', 'http://10.4.27.70:1000/file/exam/340dda06-7649-447c-b29f-e811ecf00a9c.png');
INSERT INTO `product` VALUES (11, '可乐鸡翅', 6, 12.00, '可乐鸡翅', 'http://10.4.27.70:1000/file/exam/2d99d3aa-e1d2-45ca-bbac-32297243b485.png');
INSERT INTO `product` VALUES (12, '铁板牛肉', 2, 20.00, '铁板牛肉', 'http://10.4.27.70:1000/file/exam/a73fdd45-592f-4eee-b44f-06a49d7fa6b6.png');
INSERT INTO `product` VALUES (13, '火焰山虾兵', 6, 18.00, '火焰山虾兵', 'http://10.4.27.70:1000/file/exam/fe130f1b-5717-4e1b-b052-835db3c00f75.png');
INSERT INTO `product` VALUES (14, '威尼斯红烩牛肉意面', 3, 15.00, '威尼斯红烩牛肉意面', 'http://10.4.27.70:1000/file/exam/579b72ad-beca-4244-af79-3694ca445ce0.png');
INSERT INTO `product` VALUES (15, '雪花肥牛', 1, 12.00, '雪花肥牛', 'http://10.4.27.70:1000/file/exam/8a4a446f-2e4b-4e48-8134-5f70183fd426.png');
INSERT INTO `product` VALUES (16, '虾滑', 1, 10.00, '虾滑', 'http://10.4.27.70:1000/file/exam/55b2c0e6-8116-4fb8-bd29-98bcc5912ae2.png');
INSERT INTO `product` VALUES (17, '鸳鸯锅底', 1, 50.00, '鸳鸯锅底', 'http://10.4.27.70:1000/file/exam/f28b3f85-9f7d-4ae5-85ea-9deec37772ec.png');
INSERT INTO `product` VALUES (18, '清汤锅底', 1, 50.00, '清汤锅底', 'http://10.4.27.70:1000/file/exam/e26cf482-8b9f-4c42-8561-1f6361a469d1.png');
INSERT INTO `product` VALUES (19, '牛油锅底', 1, 50.00, '牛油锅底', 'http://10.4.27.70:1000/file/exam/531ce74c-c00a-4c48-9b1f-6ce9ffc5c51b.png');
INSERT INTO `product` VALUES (20, '麻辣锅底', 1, 50.00, '麻辣锅底', 'http://10.4.27.70:1000/file/exam/dc4f5fe6-0481-4aca-a4f0-a72eab5ef922.png');
INSERT INTO `product` VALUES (21, '鱼籽福袋', 1, 6.00, '鱼籽福袋', 'http://10.4.27.70:1000/file/exam/a1741f04-2811-45f9-9a7e-262786a4ece8.png');
INSERT INTO `product` VALUES (22, '捞面', 1, 10.00, '捞面', 'http://10.4.27.70:1000/file/exam/6d223332-75f0-42f2-939b-fe8c62028b82.png');
INSERT INTO `product` VALUES (23, '龙眼桂花', 7, 6.00, '龙眼桂花', 'http://10.4.27.70:1000/file/exam/3de36432-790b-4faf-aef0-94cf7232f4aa.png');
INSERT INTO `product` VALUES (24, '桃胶鲜牛乳', 7, 6.00, '桃胶鲜牛乳', 'http://10.4.27.70:1000/file/exam/aeef34c1-2f35-4e00-aec3-d46cc4b842a1.png');
INSERT INTO `product` VALUES (25, '鸭屎香柠檬茶', 7, 6.00, '鸭屎香柠檬茶', 'http://10.4.27.70:1000/file/exam/8a147f4a-6942-4520-a6cd-9b837848ced8.png');
INSERT INTO `product` VALUES (26, '薄荷奶绿', 7, 6.00, '薄荷奶绿', 'http://10.4.27.70:1000/file/exam/9beacfc1-e77f-47ed-97c1-2b7870a40357.png');
INSERT INTO `product` VALUES (27, '凤凰单枞拿铁', 7, 6.00, '凤凰单枞拿铁', 'http://10.4.27.70:1000/file/exam/e98c8bf2-d6b2-4b5e-951e-6eb2ed494990.png');
INSERT INTO `product` VALUES (28, '芋泥啵啵奶茶', 7, 6.00, '芋泥啵啵奶茶', 'http://10.4.27.70:1000/file/exam/31f0e244-8350-4ab2-ab75-6e4246bc5f3b.png');
INSERT INTO `product` VALUES (29, '杨枝甘露', 7, 6.00, '杨枝甘露', 'http://10.4.27.70:1000/file/exam/1c2e4edc-31d7-439a-b314-1f36652ae623.png');
INSERT INTO `product` VALUES (30, '霸气青提', 7, 6.00, '霸气青提', 'http://10.4.27.70:1000/file/exam/56bfe6f8-906f-49bc-ba34-0b05662454e5.png');
INSERT INTO `product` VALUES (31, '鱼子酱', 4, 50.00, '鱼子酱', 'http://10.4.27.70:1000/file/exam/efcca319-bfd9-4125-92b8-5d170a3e3204.png');
INSERT INTO `product` VALUES (32, '大闸蟹', 4, 20.00, '大闸蟹', 'http://10.4.27.70:1000/file/exam/5e79de57-fff9-4530-85d7-256bd9c2d08f.png');
INSERT INTO `product` VALUES (33, '金枪鱼', 4, 40.00, '金枪鱼', 'http://10.4.27.70:1000/file/exam/613bcd21-f629-449c-aa34-57d3d87b8753.png');
INSERT INTO `product` VALUES (34, '三文鱼', 4, 20.00, '三文鱼', 'http://10.4.27.70:1000/file/exam/62feb72e-4637-4ca8-a0c8-e5b52a5e80f2.png');
INSERT INTO `product` VALUES (35, '鱿鱼', 4, 10.00, '鱿鱼', 'http://10.4.27.70:1000/file/exam/08cb8042-f8c9-4900-a752-1b020dada052.png');

-- ----------------------------
-- Table structure for productorder
-- ----------------------------
DROP TABLE IF EXISTS `productorder`;
CREATE TABLE `productorder`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `oid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '关联订单流水号',
  `pid` int NULL DEFAULT NULL COMMENT '关联产品id',
  `number` int NULL DEFAULT NULL COMMENT '购买产品数量',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '产品价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of productorder
-- ----------------------------
INSERT INTO `productorder` VALUES (8, '6ba5d12ea73a433c9651fd79d3c94f26', 15, 1, 12.00);
INSERT INTO `productorder` VALUES (9, '6ba5d12ea73a433c9651fd79d3c94f26', 16, 1, 10.00);
INSERT INTO `productorder` VALUES (10, 'f244c2d0192a4abdbd8afcbae050d8eb', 15, 1, 12.00);
INSERT INTO `productorder` VALUES (11, 'f244c2d0192a4abdbd8afcbae050d8eb', 16, 1, 10.00);
INSERT INTO `productorder` VALUES (12, '876558f3a41d48e3842c8593791d3695', 26, 1, 6.00);
INSERT INTO `productorder` VALUES (13, '876558f3a41d48e3842c8593791d3695', 27, 1, 6.00);
INSERT INTO `productorder` VALUES (14, '4e4c17d14a1c4d45b34a6c7e74579b3c', 1, 1, 15.00);
INSERT INTO `productorder` VALUES (15, '4e4c17d14a1c4d45b34a6c7e74579b3c', 4, 1, 6.00);
INSERT INTO `productorder` VALUES (16, '67d7d41c733844a188b4ddf2f8e3a77d', 23, 1, 6.00);
INSERT INTO `productorder` VALUES (17, '67d7d41c733844a188b4ddf2f8e3a77d', 1, 1, 15.00);
INSERT INTO `productorder` VALUES (18, '67d7d41c733844a188b4ddf2f8e3a77d', 6, 1, 8.00);
INSERT INTO `productorder` VALUES (19, '67d7d41c733844a188b4ddf2f8e3a77d', 16, 1, 10.00);
INSERT INTO `productorder` VALUES (20, '67d7d41c733844a188b4ddf2f8e3a77d', 17, 1, 50.00);
INSERT INTO `productorder` VALUES (21, 'c135a6178156439c931ac1e867645154', 15, 1, 12.00);
INSERT INTO `productorder` VALUES (22, 'c135a6178156439c931ac1e867645154', 16, 1, 10.00);
INSERT INTO `productorder` VALUES (23, 'c135a6178156439c931ac1e867645154', 4, 1, 6.00);
INSERT INTO `productorder` VALUES (24, 'c135a6178156439c931ac1e867645154', 33, 1, 40.00);
INSERT INTO `productorder` VALUES (25, 'c135a6178156439c931ac1e867645154', 32, 1, 20.00);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色名称',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色描述',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', '超级管理员', 'ADMIN');
INSERT INTO `sys_role` VALUES (2, '普通用户', '普通用户', 'USER');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名称',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户密码',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '个人简介',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  `role_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色',
  `salt` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '加盐',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '1' COMMENT '状态（正常/禁用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '6c19448e7694cec455edf277f69adfe6', 'weixu1', '12345@gmail.com', '1919810', '广东第二师范学院', 'http://localhost:1000/file/exam/228a5742-c28a-4f5e-9e85-772c985cfd35.jpg', 'ADMIN', 'BDFCECCDC45DA4C8', '2024-12-15 11:24:56', '男', '1');
INSERT INTO `sys_user` VALUES (2, 'user', '6146b4d55dc86eaa5a16a50d196524c2', '测试', '231@qq.com', '114514', '广东第二师范学院', 'http://localhost:1000/file/exam/33744e47-4755-409b-b071-58a2d956608c.jpg', 'USER', 'FF049908EF67A05B', '2024-12-15 19:24:56', '男', '1');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `typename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '类型名称',
  `timageurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '类型图片路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '火锅', 'http://localhost:1000/file/exam/8e7039d8-13e7-4e10-8b5f-630c6cd95ff4.png');
INSERT INTO `type` VALUES (2, '中餐', 'http://localhost:1000/file/exam/f6f020ea-877a-42fa-bb49-bfe21407baac.png');
INSERT INTO `type` VALUES (3, '西餐', 'http://localhost:1000/file/exam/1e1c06da-f17d-487f-9276-224a351bd54c.png');
INSERT INTO `type` VALUES (4, '海鲜', 'http://localhost:1000/file/exam/5e56f550-f08e-4215-a7e4-47695a423971.png');
INSERT INTO `type` VALUES (5, '汤品', 'http://localhost:1000/file/exam/2e15d996-122f-4413-badd-160405357ff0.png');
INSERT INTO `type` VALUES (6, '小吃', 'http://localhost:1000/file/exam/33e5a5da-ad81-48ed-b4e0-1b7b13862bb8.png');
INSERT INTO `type` VALUES (7, '饮料', 'http://localhost:1000/file/exam/e4b79ded-be8c-45b4-931c-ee3712ace5db.png');

-- ----------------------------
-- Table structure for user_order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `otype` int NULL DEFAULT NULL COMMENT '1：外卖 0：自取',
  `onumber` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '订单流水号',
  `uid` int NULL DEFAULT NULL COMMENT '关联用户id',
  `oprice` double(10, 2) NULL DEFAULT NULL COMMENT '订单价格',
  `paystate` int NULL DEFAULT NULL COMMENT '支付状态 0：未支付 1：已支付',
  `otime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付时间',
  `ostate` int NULL DEFAULT NULL COMMENT '订单状态 0：预定中（未收货） 1：已收货 2：退订',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_order
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
