/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : ins_system

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2019-08-01 14:51:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `insured`
-- ----------------------------
DROP TABLE IF EXISTS `insured`;
CREATE TABLE `insured` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_id` int(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `number_id` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `insured_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of insured
-- ----------------------------
INSERT INTO `insured` VALUES ('27', '28', '小涛', '350322196401013000', '1', '1964-01-01', '15932165498', '11111@qq.com', '浙工大');
INSERT INTO `insured` VALUES ('28', '29', '小凡', '350322199401052000', '1', '1994-01-05', '15932165498', '1289419779@qq.com', '浙工大');
INSERT INTO `insured` VALUES ('29', '30', '小伟', '350322196401011000', '2', '1964-01-01', '15932165498', '12000@qq.com', '浙工大');
INSERT INTO `insured` VALUES ('30', '31', '老林', '350322195902021111', '1', '1959-02-02', '15957163109', '11111@qq.com', '浙工大');
INSERT INTO `insured` VALUES ('31', '32', '小林', '350322199406012222', '1', '1994-06-01', '15932165498', '12000@qq.com', '浙工大');
INSERT INTO `insured` VALUES ('32', '33', '小凡', '350322199401011020', '1', '1994-01-01', '15957163109', '1289419779@qq.com', '浙工大');
INSERT INTO `insured` VALUES ('33', '34', '小明', '350300200402013100', '1', '2004-02-01', '13711111111', '11111@qq.com', '北京');
INSERT INTO `insured` VALUES ('34', '35', '啊达', '350322196403020001', '1', '1964-03-02', '15921365478', '11111@qq.com', '浙工大');
INSERT INTO `insured` VALUES ('35', '36', '阿剑', '350322199605010003', '1', '1996-05-01', '13912300000', '11111@qq.com', '浙工大');
INSERT INTO `insured` VALUES ('36', '37', '阿宝', '350322200406011017', '1', '2004-06-01', '15957163216', '11111@qq.com', '浙工大');
INSERT INTO `insured` VALUES ('47', '38', '小明', '350321199403053000', '1', '1994-03-05', '13500000000', '1111@qq.com', '浙工大');
INSERT INTO `insured` VALUES ('48', '39', '老红', '350322196403062001', '2', '1964-03-06', '13700000000', '12000@qq.com', '浙工大');
INSERT INTO `insured` VALUES ('49', '40', '小林', '350322200906014123', '1', '2009-06-01', '15900000012', '11111@qq.com', '浙工大');
INSERT INTO `insured` VALUES ('51', '42', '大红', '350322198409013214', '2', '1984-09-01', '13511111111', '12000@qq.com', '浙工大');

-- ----------------------------
-- Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `link_no` varchar(20) DEFAULT NULL COMMENT '流水号',
  `proposal_no` varchar(20) DEFAULT NULL COMMENT '投保单号',
  `policy_no` varchar(20) DEFAULT NULL COMMENT '保单号',
  `holder_id` int(10) DEFAULT NULL COMMENT '投保人id',
  `product_id` int(10) DEFAULT NULL,
  `product_name` varchar(20) DEFAULT NULL,
  `product_code` varchar(20) DEFAULT NULL,
  `total_amount` bigint(30) DEFAULT NULL COMMENT '总保额（分）',
  `total_price` bigint(30) DEFAULT NULL COMMENT '总保费',
  `policy_num` int(5) DEFAULT NULL,
  `begin_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `check_status` int(5) DEFAULT NULL COMMENT '状态：1未核保；2核保通过；3核保失败;4待支付；5已支付；6支付失败',
  `scheme_id` int(10) DEFAULT NULL,
  `policy_url` varchar(20) DEFAULT NULL COMMENT '电子保单链接',
  `sys_flag` int(5) NOT NULL DEFAULT '0' COMMENT '系统标记：0无效；1有效',
  `edite_time` datetime DEFAULT NULL COMMENT '修改日期',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `order_type` int(5) NOT NULL DEFAULT '0' COMMENT '订单类型：0在线生成；1人工完成',
  `note` varchar(50) DEFAULT NULL COMMENT '备注',
  `is_cancel` int(5) NOT NULL DEFAULT '0' COMMENT '是否退保：0否；1是',
  `cancel_time` datetime DEFAULT NULL COMMENT '退保时间',
  PRIMARY KEY (`id`),
  KEY `holder_id` (`holder_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `order_info_ibfk_1` FOREIGN KEY (`holder_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_info_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('28', '120190430184608702', '220190430184606958', '320190430184632707', '8', '14', '寿险', 'lll', '1000000', '300', '1', '2019-04-30 00:00:00', '2020-04-30 00:00:00', '5', '81', null, '0', null, '2019-04-30 18:46:06', '0', null, '0', null);
INSERT INTO `order_info` VALUES ('29', '120190430184909122', '220190430184907517', '320190430184911763', '8', '15', '旅游险', 'ccc', '500000', '3', '1', '2019-04-30 00:00:00', '2019-05-07 00:00:00', '5', '91', null, '0', null, '2019-04-30 18:49:07', '0', null, '0', null);
INSERT INTO `order_info` VALUES ('30', '120190430185035874', '220190430185034051', '320190430185049090', '10', '14', '寿险', 'lll', '2000000', '550', '1', '2019-04-30 00:00:00', '2020-04-30 00:00:00', '5', '84', null, '0', null, '2019-04-30 18:50:34', '0', null, '0', null);
INSERT INTO `order_info` VALUES ('31', '120190507130437536', '220190507130435527', '320190507130515864', '11', '14', '寿险', 'lll', '1000000', '300', '1', '2019-05-07 00:00:00', '2020-05-07 00:00:00', '5', '81', null, '0', null, '2019-05-07 13:04:35', '0', null, '0', null);
INSERT INTO `order_info` VALUES ('32', '120190507132456478', '220190507132106282', '320190507132503132', '11', '17', '尊享一生', 'hhh', '1000000', '100', '1', '2019-05-07 00:00:00', '2020-05-07 00:00:00', '5', '105', null, '0', null, '2019-05-07 13:21:06', '0', null, '0', null);
INSERT INTO `order_info` VALUES ('33', '120190507152840403', '220190507152833440', '320190507152904356', '10', '15', '旅游险', 'ccc', '500000', '3', '1', '2019-05-07 00:00:00', '2019-05-14 00:00:00', '5', '91', null, '0', null, '2019-05-07 15:28:33', '0', null, '0', null);
INSERT INTO `order_info` VALUES ('34', '120190519120920570', '220190519120839020', '320190519121028137', '10', '13', '安保一生', 'fff', '1000000', '200', '1', '2019-05-19 00:00:00', '2020-05-19 00:00:00', '5', '78', null, '0', null, '2019-05-19 12:08:39', '0', null, '0', null);
INSERT INTO `order_info` VALUES ('35', '120190527230803080', '220190527230800727', '320190527230816619', '11', '16', '人寿', 'www', '1000000', '400', '1', '2019-05-27 00:00:00', '2021-05-27 00:00:00', '5', '100', null, '0', null, '2019-05-27 23:08:00', '0', null, '0', null);
INSERT INTO `order_info` VALUES ('36', '120190527231037704', '220190527231035899', '320190527231041869', '11', '15', '旅游险', 'ccc', '100000', '2', '1', '2019-05-27 00:00:00', '2019-06-03 00:00:00', '5', '90', null, '0', null, '2019-05-27 23:10:35', '0', null, '0', null);
INSERT INTO `order_info` VALUES ('37', '120190527234148036', '220190527231958041', '320190527233238724', '11', '13', '安保一生', 'fff', '1000000', '100', '1', '2019-05-27 00:00:00', '2020-05-27 00:00:00', '4', '77', null, '0', null, '2019-05-27 23:19:58', '0', null, '0', null);
INSERT INTO `order_info` VALUES ('38', '120190610163723525', '220190610163632744', null, '8', '13', '安保一生', 'fff', '1000000', '300', '1', null, null, '6', '79', null, '0', null, '2019-06-10 16:36:32', '0', null, '0', null);
INSERT INTO `order_info` VALUES ('39', '120190610212930853', '220190610212928813', '320190610213518267', '11', '21', '康乐老年险', 'sss', '1000000', '500', '1', '2019-06-10 00:00:00', null, '5', '161', null, '0', null, '2019-06-10 21:29:28', '0', null, '0', null);
INSERT INTO `order_info` VALUES ('40', '120190610214108291', '220190610214105621', '320190610214115515', '11', '22', '意外保障', 'yyy', '100000', '100', '1', '2019-06-10 00:00:00', '2020-06-10 00:00:00', '5', '165', null, '0', null, '2019-06-10 21:41:05', '0', null, '0', null);
INSERT INTO `order_info` VALUES ('42', '120190610224127476', '220190610224124410', '320190610224148195', '10', '21', '康乐老年险', 'sss', '1000000', '300', '1', '2019-06-10 00:00:00', null, '5', '157', null, '0', null, '2019-06-10 22:41:24', '0', null, '0', null);

-- ----------------------------
-- Table structure for `pay`
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) DEFAULT NULL,
  `user_phone` varchar(20) DEFAULT NULL,
  `user_password` varchar(20) DEFAULT NULL,
  `account` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_phone` (`user_phone`),
  CONSTRAINT `pay_ibfk_1` FOREIGN KEY (`user_phone`) REFERENCES `user` (`phone`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pay
-- ----------------------------
INSERT INTO `pay` VALUES ('1', '老李', '13900000000', '123', '1203');
INSERT INTO `pay` VALUES ('2', '小红', '13700000000', '000', '847');
INSERT INTO `pay` VALUES ('3', '老林', '15957163109', '123456', '498');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL COMMENT '商品标识码',
  `name` varchar(20) DEFAULT NULL COMMENT '商品名称',
  `seller_id` int(10) DEFAULT NULL COMMENT '卖家id',
  `type_code` varchar(20) DEFAULT NULL COMMENT '商品类别',
  `title` varchar(50) DEFAULT NULL COMMENT '商品销售标题',
  `short_title` varchar(20) DEFAULT NULL COMMENT '短标题',
  `imgPath` varchar(100) DEFAULT NULL COMMENT '图片路径',
  `max_insurant` int(5) DEFAULT NULL COMMENT '最多被保人个数',
  `hesitate_day` int(10) DEFAULT NULL COMMENT '犹豫截止期',
  `introduce` varchar(1000) DEFAULT NULL COMMENT '介绍',
  `notice` varchar(1000) DEFAULT NULL COMMENT '购买须知',
  `compensation_note` varchar(1000) DEFAULT NULL COMMENT '理赔说明',
  `question` varchar(1000) DEFAULT NULL COMMENT '常见问题',
  `create_time` datetime DEFAULT NULL COMMENT '商品创建日期',
  `edite_time` datetime DEFAULT NULL COMMENT '商品最后一次被修改日期',
  `sys_flag` int(5) NOT NULL DEFAULT '0' COMMENT '系统标记：0失效；1有效',
  PRIMARY KEY (`id`),
  KEY `seller_id` (`seller_id`),
  KEY `code` (`code`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('13', 'fff', '安保一生', '1', 'yiliao', '安全保障您一生', '做您最忠实的健康保镖', 'images/1c9230d02d454ec1bdda7a81123ccf71.png', null, null, '哈哈哈哈哈哈', '呵呵呵呵呵呵呵', '嘻嘻嘻嘻嘻个嘻嘻嘻嘻嘻', '哦哦哦哦哦哦', null, null, '0');
INSERT INTO `product` VALUES ('14', 'lll', '一生医保', '1', 'yiliao', '为您的健康添加一份保障', '做您最忠实的健康保镖', 'images/4371dede3dae45a6bd5adfe67bca722b.jpg', null, null, '哈哈哈哈哈', '呵呵呵呵', '嘻嘻嘻嘻嘻', '哦哦哦哦哦', null, null, '0');
INSERT INTO `product` VALUES ('15', 'ccc', '旅游险', '1', 'lvyou', '保障您的旅程', '安心游玩', 'images/702e69c485f8436b9db33f2aeece932e.jpg', null, null, '哈哈哈哈', '呵呵呵', '哦哦哦', '嘻嘻嘻', null, null, '0');
INSERT INTO `product` VALUES ('16', 'www', '人寿', '2', 'renshou', '为您的人生添加一份保障', '做您最忠实的寿命保镖', 'images/6d3bf5ad290c4e559e2193c537604722.jpg', null, null, '哈哈哈哈', '哦哦哦哦哦', '呵呵呵呵', '嘻嘻嘻嘻', null, null, '0');
INSERT INTO `product` VALUES ('17', 'hhh', '尊享一生', '1', 'yiliao', '成人重大疾病保险', '30种重疾 最高100万保障', 'images/18125935874f4eab98d6a1396b3248d3.jpg', null, null, '哈哈哈哈哈哈哈哈', '嘻嘻嘻嘻嘻嘻嘻嘻嘻', '哦哦哦哦噢噢噢哦哦', '呵呵呵呵呵呵呵呵', null, null, '0');
INSERT INTO `product` VALUES ('21', 'sss', '康乐老年险', '1', 'renshou', '养老', '品质生活早规划', 'images/9415492329f84e90928b7c1ce6f375d3.png', null, null, '身故有保障：被保险人身故，我们向身故保险金受益人给付身故保险金。\r\n保证领取：20年/30年。\r\n领取灵活：领取年龄灵活可选（55/60/65）。', '被保人年龄需在11-70岁（包括11岁和70岁）。\r\n投被保人的关系：被保人为未成年人，投保人的关系仅限为其父母；被保人为成年人，投保人的关系可以为本人、父母、配偶以及子女', '被保人因意外伤害导致身故，给付被保人身故当日合同的保单账户价值与基本保险金额之和。\r\n被保人因意外伤害以外的原因身故，给付被保险人合同的保单账户价值与基本保险金额之和，扣除身故前180日内增加的基本保险金额。', '可以续保吗？\r\n答：本保险产品不支持续保。\r\n赔付金额的内容有哪些？\r\n答：保险金额包括基本保险金额、持续奖金。', null, null, '0');
INSERT INTO `product` VALUES ('22', 'yyy', '意外保障', '1', 'yiwai', '意外险', '放心生活，放心浪', 'images/cbcc9e74d63d40d498a81050aa06c8ea.jpg', null, null, '哈哈哈哈哈哈哈哈哈哈哈', '嘻嘻嘻嘻嘻嘻', '呵呵呵呵呵', '哦哦哦哦哦哦', null, null, '0');
INSERT INTO `product` VALUES ('23', 'qqq', '疾病卫士', '2', 'yiliao', '医疗险', '为您的健康作保障', 'images/62c3a82de0e8400da4bb2d256fef343b.png', null, null, '哈哈哈哈哈', '嘻嘻嘻', '呵呵呵', '哦哦哦', null, null, '0');
INSERT INTO `product` VALUES ('24', 'yi', '健康保障', '1', 'yiliao', '疾病医疗', '做您最忠实的健康保镖', 'images/6b977b7465834c02805e99d2c6189abe.jpg', null, null, '哈哈哈哈哈哈', '嘻嘻嘻嘻', '呵呵呵', '哦哦', null, null, '0');
INSERT INTO `product` VALUES ('25', 'lcf', '一生', '1', 'renshou', '安全保障您一生', '做您最忠实的健康保镖', 'images/c6c51fceb8be400eab68f67e23cde0a1.jpg', null, null, '哈哈哈哈哈', '嘻嘻嘻', '呵呵呵', '哦哦哦', null, null, '0');

-- ----------------------------
-- Table structure for `product_scheme`
-- ----------------------------
DROP TABLE IF EXISTS `product_scheme`;
CREATE TABLE `product_scheme` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `product_code` varchar(20) DEFAULT NULL,
  `age_range` varchar(20) DEFAULT NULL,
  `coverage` varchar(20) DEFAULT NULL COMMENT '保额',
  `has_social` varchar(10) DEFAULT NULL COMMENT '有无社保',
  `deadline` varchar(20) DEFAULT NULL COMMENT '保障期限',
  `price` bigint(20) DEFAULT NULL COMMENT '保费',
  PRIMARY KEY (`id`),
  KEY `product_code` (`product_code`),
  CONSTRAINT `product_scheme_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `product` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=219 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_scheme
-- ----------------------------
INSERT INTO `product_scheme` VALUES ('77', 'fff', '11-20', '1000000', 'yes', '1年', '100');
INSERT INTO `product_scheme` VALUES ('78', 'fff', '11-20', '1000000', 'no', '1年', '200');
INSERT INTO `product_scheme` VALUES ('79', 'fff', '21-30', '1000000', 'yes', '1年', '300');
INSERT INTO `product_scheme` VALUES ('80', 'fff', '21-30', '1000000', 'no', '1年', '400');
INSERT INTO `product_scheme` VALUES ('81', 'lll', '51-60', '1000000', 'off', '1年', '300');
INSERT INTO `product_scheme` VALUES ('82', 'lll', '51-60', '1000000', 'off', '2年', '400');
INSERT INTO `product_scheme` VALUES ('83', 'lll', '51-60', '2000000', 'off', '1年', '500');
INSERT INTO `product_scheme` VALUES ('84', 'lll', '51-60', '2000000', 'off', '2年', '550');
INSERT INTO `product_scheme` VALUES ('85', 'lll', '61-70', '1000000', 'off', '1年', '600');
INSERT INTO `product_scheme` VALUES ('86', 'lll', '61-70', '1000000', 'off', '2年', '750');
INSERT INTO `product_scheme` VALUES ('87', 'lll', '61-70', '2000000', 'off', '1年', '800');
INSERT INTO `product_scheme` VALUES ('88', 'lll', '61-70', '2000000', 'off', '2年', '850');
INSERT INTO `product_scheme` VALUES ('89', 'ccc', '21-30', '100000', 'off', '7天', '1');
INSERT INTO `product_scheme` VALUES ('90', 'ccc', '21-30', '100000', 'off', '15天', '2');
INSERT INTO `product_scheme` VALUES ('91', 'ccc', '21-30', '500000', 'off', '7天', '3');
INSERT INTO `product_scheme` VALUES ('92', 'ccc', '21-30', '500000', 'off', '15天', '4');
INSERT INTO `product_scheme` VALUES ('93', 'ccc', '31-40', '100000', 'off', '7天', '5');
INSERT INTO `product_scheme` VALUES ('94', 'ccc', '31-40', '100000', 'off', '15天', '6');
INSERT INTO `product_scheme` VALUES ('95', 'ccc', '31-40', '500000', 'off', '7天', '7');
INSERT INTO `product_scheme` VALUES ('96', 'ccc', '31-40', '500000', 'off', '15天', '8');
INSERT INTO `product_scheme` VALUES ('97', 'www', '51-60', '500000', 'off', '2年', '100');
INSERT INTO `product_scheme` VALUES ('98', 'www', '51-60', '500000', 'off', '3年', '200');
INSERT INTO `product_scheme` VALUES ('99', 'www', '51-60', '1000000', 'off', '2年', '300');
INSERT INTO `product_scheme` VALUES ('100', 'www', '51-60', '1000000', 'off', '3年', '400');
INSERT INTO `product_scheme` VALUES ('101', 'www', '61-70', '500000', 'off', '2年', '500');
INSERT INTO `product_scheme` VALUES ('102', 'www', '61-70', '500000', 'off', '3年', '600');
INSERT INTO `product_scheme` VALUES ('103', 'www', '61-70', '1000000', 'off', '2年', '700');
INSERT INTO `product_scheme` VALUES ('104', 'www', '61-70', '1000000', 'off', '3年', '800');
INSERT INTO `product_scheme` VALUES ('105', 'hhh', '21-30', '1000000', 'yes', '1年', '100');
INSERT INTO `product_scheme` VALUES ('106', 'hhh', '21-30', '1000000', 'no', '1年', '150');
INSERT INTO `product_scheme` VALUES ('107', 'hhh', '21-30', '2000000', 'yes', '1年', '200');
INSERT INTO `product_scheme` VALUES ('108', 'hhh', '21-30', '2000000', 'no', '1年', '250');
INSERT INTO `product_scheme` VALUES ('109', 'hhh', '31-40', '1000000', 'yes', '1年', '300');
INSERT INTO `product_scheme` VALUES ('110', 'hhh', '31-40', '1000000', 'no', '1年', '350');
INSERT INTO `product_scheme` VALUES ('111', 'hhh', '31-40', '2000000', 'yes', '1年', '400');
INSERT INTO `product_scheme` VALUES ('112', 'hhh', '31-40', '2000000', 'no', '1年', '450');
INSERT INTO `product_scheme` VALUES ('113', 'hhh', '41-50', '1000000', 'yes', '1年', '500');
INSERT INTO `product_scheme` VALUES ('114', 'hhh', '41-50', '1000000', 'no', '1年', '550');
INSERT INTO `product_scheme` VALUES ('115', 'hhh', '41-50', '2000000', 'yes', '1年', '600');
INSERT INTO `product_scheme` VALUES ('116', 'hhh', '41-50', '2000000', 'no', '1年', '650');
INSERT INTO `product_scheme` VALUES ('153', 'sss', '11-20', '1000000', 'yes', 'off', '100');
INSERT INTO `product_scheme` VALUES ('154', 'sss', '11-20', '1000000', 'no', 'off', '110');
INSERT INTO `product_scheme` VALUES ('155', 'sss', '21-30', '1000000', 'yes', 'off', '200');
INSERT INTO `product_scheme` VALUES ('156', 'sss', '21-30', '1000000', 'no', 'off', '220');
INSERT INTO `product_scheme` VALUES ('157', 'sss', '31-40', '1000000', 'yes', 'off', '300');
INSERT INTO `product_scheme` VALUES ('158', 'sss', '31-40', '1000000', 'no', 'off', '330');
INSERT INTO `product_scheme` VALUES ('159', 'sss', '41-50', '1000000', 'yes', 'off', '400');
INSERT INTO `product_scheme` VALUES ('160', 'sss', '41-50', '1000000', 'no', 'off', '440');
INSERT INTO `product_scheme` VALUES ('161', 'sss', '51-60', '1000000', 'yes', 'off', '500');
INSERT INTO `product_scheme` VALUES ('162', 'sss', '51-60', '1000000', 'no', 'off', '550');
INSERT INTO `product_scheme` VALUES ('163', 'sss', '61-70', '1000000', 'yes', 'off', '600');
INSERT INTO `product_scheme` VALUES ('164', 'sss', '61-70', '1000000', 'no', 'off', '660');
INSERT INTO `product_scheme` VALUES ('165', 'yyy', '1-10', '100000', 'off', '1年', '100');
INSERT INTO `product_scheme` VALUES ('166', 'yyy', '1-10', '100000', 'off', '2年', '120');
INSERT INTO `product_scheme` VALUES ('167', 'yyy', '11-20', '100000', 'off', '1年', '130');
INSERT INTO `product_scheme` VALUES ('168', 'yyy', '11-20', '100000', 'off', '2年', '140');
INSERT INTO `product_scheme` VALUES ('169', 'yyy', '21-30', '100000', 'off', '1年', '150');
INSERT INTO `product_scheme` VALUES ('170', 'yyy', '21-30', '100000', 'off', '2年', '160');
INSERT INTO `product_scheme` VALUES ('171', 'yyy', '31-40', '100000', 'off', '1年', '170');
INSERT INTO `product_scheme` VALUES ('172', 'yyy', '31-40', '100000', 'off', '2年', '180');
INSERT INTO `product_scheme` VALUES ('173', 'yyy', '1-10', '100000', 'no', '1年', '100');
INSERT INTO `product_scheme` VALUES ('174', 'yyy', '1-10', '100000', 'no', '2年', '120');
INSERT INTO `product_scheme` VALUES ('175', 'yyy', '11-20', '100000', 'no', '1年', '130');
INSERT INTO `product_scheme` VALUES ('176', 'yyy', '11-20', '100000', 'no', '2年', '140');
INSERT INTO `product_scheme` VALUES ('177', 'yyy', '21-30', '100000', 'no', '1年', '150');
INSERT INTO `product_scheme` VALUES ('178', 'yyy', '21-30', '100000', 'no', '2年', '160');
INSERT INTO `product_scheme` VALUES ('179', 'yyy', '31-40', '100000', 'no', '1年', '170');
INSERT INTO `product_scheme` VALUES ('180', 'yyy', '31-40', '100000', 'no', '2年', '180');
INSERT INTO `product_scheme` VALUES ('181', 'yyy', '1-10', '100000', 'off', '1年', '100');
INSERT INTO `product_scheme` VALUES ('182', 'yyy', '1-10', '100000', 'off', '2年', '120');
INSERT INTO `product_scheme` VALUES ('183', 'yyy', '11-20', '100000', 'off', '1年', '130');
INSERT INTO `product_scheme` VALUES ('184', 'yyy', '11-20', '100000', 'off', '2年', '140');
INSERT INTO `product_scheme` VALUES ('185', 'yyy', '21-30', '100000', 'off', '1年', '150');
INSERT INTO `product_scheme` VALUES ('186', 'yyy', '21-30', '100000', 'off', '2年', '160');
INSERT INTO `product_scheme` VALUES ('187', 'yyy', '31-40', '100000', 'off', '1年', '170');
INSERT INTO `product_scheme` VALUES ('188', 'yyy', '31-40', '100000', 'off', '2年', '180');
INSERT INTO `product_scheme` VALUES ('189', 'qqq', '11-20', '500000', 'off', '1年', '200');
INSERT INTO `product_scheme` VALUES ('190', 'qqq', '11-20', '500000', 'off', '2年', '300');
INSERT INTO `product_scheme` VALUES ('191', 'qqq', '21-30', '500000', 'off', '1年', '400');
INSERT INTO `product_scheme` VALUES ('192', 'qqq', '21-30', '500000', 'off', '2年', '500');
INSERT INTO `product_scheme` VALUES ('193', 'qqq', '31-40', '500000', 'off', '1年', '550');
INSERT INTO `product_scheme` VALUES ('194', 'qqq', '31-40', '500000', 'off', '2年', '600');
INSERT INTO `product_scheme` VALUES ('195', 'yi', '41-50', '100000', 'yes', '1年', '488');
INSERT INTO `product_scheme` VALUES ('196', 'yi', '41-50', '100000', 'no', '1年', '510');
INSERT INTO `product_scheme` VALUES ('197', 'yi', '41-50', '500000', 'yes', '1年', '550');
INSERT INTO `product_scheme` VALUES ('198', 'yi', '41-50', '500000', 'no', '1年', '580');
INSERT INTO `product_scheme` VALUES ('199', 'yi', '51-60', '100000', 'yes', '1年', '600');
INSERT INTO `product_scheme` VALUES ('200', 'yi', '51-60', '100000', 'no', '1年', '620');
INSERT INTO `product_scheme` VALUES ('201', 'yi', '51-60', '500000', 'yes', '1年', '640');
INSERT INTO `product_scheme` VALUES ('202', 'yi', '51-60', '500000', 'no', '1年', '660');
INSERT INTO `product_scheme` VALUES ('203', 'yi', '61-70', '100000', 'yes', '1年', '680');
INSERT INTO `product_scheme` VALUES ('204', 'yi', '61-70', '100000', 'no', '1年', '700');
INSERT INTO `product_scheme` VALUES ('205', 'yi', '61-70', '500000', 'yes', '1年', '720');
INSERT INTO `product_scheme` VALUES ('206', 'yi', '61-70', '500000', 'no', '1年', '740');
INSERT INTO `product_scheme` VALUES ('207', 'lcf', '11-20', '500000', 'yes', '1年', '100');
INSERT INTO `product_scheme` VALUES ('208', 'lcf', '11-20', '500000', 'no', '1年', '200');
INSERT INTO `product_scheme` VALUES ('209', 'lcf', '11-20', '500000', 'yes', '2年', '1');
INSERT INTO `product_scheme` VALUES ('210', 'lcf', '11-20', '500000', 'no', '2年', '300');
INSERT INTO `product_scheme` VALUES ('211', 'lcf', '21-30', '500000', 'yes', '1年', '400');
INSERT INTO `product_scheme` VALUES ('212', 'lcf', '21-30', '500000', 'no', '1年', '500');
INSERT INTO `product_scheme` VALUES ('213', 'lcf', '21-30', '500000', 'yes', '2年', '600');
INSERT INTO `product_scheme` VALUES ('214', 'lcf', '21-30', '500000', 'no', '2年', '700');
INSERT INTO `product_scheme` VALUES ('215', 'lcf', '31-40', '500000', 'yes', '1年', '800');
INSERT INTO `product_scheme` VALUES ('216', 'lcf', '31-40', '500000', 'no', '1年', '900');
INSERT INTO `product_scheme` VALUES ('217', 'lcf', '31-40', '500000', 'yes', '2年', '30');
INSERT INTO `product_scheme` VALUES ('218', 'lcf', '31-40', '500000', 'no', '2年', '1000');

-- ----------------------------
-- Table structure for `seller`
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `company` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller
-- ----------------------------
INSERT INTO `seller` VALUES ('1', '医保', '123', '中国医保');
INSERT INTO `seller` VALUES ('2', '人寿', '123456', '中国人寿');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `number_id` varchar(30) DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL COMMENT '性别',
  `address` varchar(50) DEFAULT NULL COMMENT '住址',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `password` varchar(20) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('7', '王三', '35032200000000000', '15900000000', '1', '浙工大', '1289419779@qq.com', '654321', null);
INSERT INTO `user` VALUES ('8', '老李', '35032200000000001', '13900000000', '1', '浙工大', '11111@qq.com', '123', null);
INSERT INTO `user` VALUES ('10', '小红', '33333333333333333', '13700000000', '2', '浙工大', '12000@qq.com', '000', null);
INSERT INTO `user` VALUES ('11', '老林', '35032200000000002', '15957163109', '1', '浙工大', '1289419779@qq.com', '123456', null);
