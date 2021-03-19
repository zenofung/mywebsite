/*
 Navicat MySQL Data Transfer

 Source Server         : 霍驰
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 39.98.118.87:3306
 Source Schema         : website

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 19/03/2021 16:12:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app
-- ----------------------------
DROP TABLE IF EXISTS `app`;
CREATE TABLE `app`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `detail_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `meta_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `banner_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mobile_banner_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `wechat_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app
-- ----------------------------
INSERT INTO `app` VALUES (1, 'http://39.98.118.87/images/huochi/a0b19351-2147-4d0b-adf0-1ea4420aceb9.png', 'http://39.98.118.87/images/huochi/5026d0fe-6942-4670-8f1d-c64d50374db8.jpg', '逸身轻，app，逸身轻app ', '本页详细介绍逸身轻app，检测内容及使用方法，app可分析个人及家庭的健康指标，用户可随时了解身体健康情况，并预警，达到智能检测，健康预警的目的。', '逸身轻app_重庆恭逸科技有限公司', 'http://static.gongyitech.com/b141fa363393480a836e8e2569331fba', 'http://static.gongyitech.com/abcb542e7ae141dcaaff0d13fed9fc66', 'http://39.98.118.87/images/huochi/7734e8ae-5d6a-4d42-9ea4-78308a892f90.png');

-- ----------------------------
-- Table structure for banner_info
-- ----------------------------
DROP TABLE IF EXISTS `banner_info`;
CREATE TABLE `banner_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `report` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `activity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `activity_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `report_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_datetime` datetime(0) NOT NULL,
  `update_datetime` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banner_info
-- ----------------------------
INSERT INTO `banner_info` VALUES (1, '北京霍驰门窗有限公司官网pc版于12月28日正式上线！', '北京霍驰门窗活动敬请开启中！', '公司活动', '公司公告', '2018-12-24 14:08:21', '2021-03-03 10:00:17');

-- ----------------------------
-- Table structure for company_development
-- ----------------------------
DROP TABLE IF EXISTS `company_development`;
CREATE TABLE `company_development`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dev_date` datetime(0) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company_development
-- ----------------------------
INSERT INTO `company_development` VALUES (1, '项目发起', '以健康监测马桶为研发方向组建研发小组', '2015-08-14 06:06:08', 1);
INSERT INTO `company_development` VALUES (2, '恭逸元年', '公司正式成立单体体脂检测盖板研发成功', '2016-06-01 00:00:02', 1);
INSERT INTO `company_development` VALUES (3, '披荆斩棘', '体脂检测功能与智能盖板研发成功，尿流率检测装置研发成功，智能尿液检测盖板研发成功', '2017-09-14 06:07:24', 1);
INSERT INTO `company_development` VALUES (4, '厉兵秣马', '市场运营团队组建，产品量产前最后优化准备', '2018-09-14 06:08:02', 1);
INSERT INTO `company_development` VALUES (5, '正式运营', '直营和加盟体系，市场占有率达0.1%', '2019-08-14 06:08:35', 1);

-- ----------------------------
-- Table structure for company_info
-- ----------------------------
DROP TABLE IF EXISTS `company_info`;
CREATE TABLE `company_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime(0) NOT NULL,
  `update_datetime` datetime(0) NOT NULL,
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `company_purpose` text CHARACTER SET utf8 COLLATE utf8_bin,
  `description` text CHARACTER SET utf8 COLLATE utf8_bin,
  `link_man_id` int(11) DEFAULT NULL,
  `company_culture` text CHARACTER SET utf8 COLLATE utf8_bin,
  `company_manage` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `dev_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `manage_info` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `team` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `working_range` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `company_culture_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dev_phone_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `leader` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `work_team` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `work_range_pic` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `attract_content` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `attract_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mobile_banner_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company_info
-- ----------------------------
INSERT INTO `company_info` VALUES (1, '2018-12-05 10:18:34', '2021-03-19 12:32:22', '北京如日之升建筑材料有限公司', '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;一直以来，我们的技术和创意都来源于在木工手工业方面长久积攒的经验。尽管如此，在前进的道路上，我们一直铭记并奉行此行业的传统美德：持久、品质和将爱化作每一个细节。\n\n自我激励吧！', ' &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;霍驰门窗是强思特团队的守护者，团队是我们的生命，凭借智慧与努力，我们必须打造一支高素质、高效率、高收入的儒商团队。始终秉承：忠诚、爱心、责任、付出、感恩的理念，放飞梦想、把握机遇、创造价值。我坚信：星星之火、可以燎原。为成就共同的光荣与梦想，强思特人必须做到：伙伴足以同舟，共富足以聚人，量宽足以得人，律己足以服身先足以帅人。<br><br>公司目前的产品主要有<br>1、<strong>铝合金门窗</strong></a><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;是目前使用最为广泛的门窗材料，其优点非常明显：质轻、坚固、不易变形、金属质感、易于加工，可使用喷涂或电泳进行表面处理，可以任意色彩搭配建筑外形及居室内部空间，是建筑门窗选择最多的材料。<br><br>2、<strong>木窗</strong></a><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;是人类最早使用的窗体材料，具有自然、和谐、温馨、坚实的特点，需用优质木材，以及优良工艺制造，因此价格较高，多用于别墅等高档空间处理。劣质木窗则易于变形，影响使用毫无可取之处。<br><br>3、<strong>铝木窗</strong></a><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;由铝合金同木窗组合而成，取二者的优点，通常木窗在里，体现自然、温馨、高档，铝合金包在外面防水更好，喷涂颜色与建筑相搭配，铝木窗需要优质木材，工艺也较为繁复，价格较高，如不符合质量标准时间长了轻则产生裂缝，严重的变形影响使用。<br><br>4、<strong>断桥隔热窗</strong></a><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;铝合金窗的升级版，其原理是通过PVC隔热条将铝合金窗体型材分隔，以降低铝合金型材的导热系数，从而提高窗体的保温隔热，达到节能效果。<br><br>5、<strong>平开窗</strong></a><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其优点是密封性好，缺点是内开占用空间，外开有限制（国家规定10层以上不得使用）而且窗扇和配件成本都较高，窗扇也不能做得大。', 2, '<b>企业理念</b>:公司本着“诚信共赢，铸就品牌“的理念，坚持公开、公平、公正的原则，将产品的质量放在首位，为每一位用户提供最优质的产品。<br><br><b>企业使命</b>：以产品质量赢荣誉、以诚实经营求效益、以开拓创新求发展，坚守行业道德，追求专业性服务方向，遵从良性竞争规则，倡导行业典范，规范自律。<br><br><b>企业愿景</b>：为广大消费者提供一个专业、优质、实用、智能的门窗产品。<br><br><b>企业口号</b>：霍驰门窗，悦享生活。\n', '公司管理由总经理、董事、行政部、财务部、市场部、推广部、生产部、客户服务部、技术研发部、采购部、质量安全检测部门共同组成的一支高素质管理队伍', 'http://static.gongyitech.com/38081897f1264ba494d3dabba513b740', '门窗。', '公司研发团队凝聚了一批博士、教授、及专业人才。目前已获得100余项专利以及各项软件著作权。 公司服务贯穿于生产运营的每一个细节，力求做出让用户满意的产品。', '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;铝木门窗、不锈钢制品、玻璃制品、五金配件、建筑材料、装饰材料、阳光房、重型门的销售；铝型材料的销售、生产加工（限分支）及技术开发；钢结构工程、幕墙工程的设计、施工。(依法须经批准的项目，经相关部门批准后方可开展经营活动)', '企业文化', 'http://static.gongyitech.com/9d294f267d7a4421a16bf048dedfd944', '【蓝章礼】出生于1973年9月29日，博士，中国计算机学会高级会员，重庆交通大学交通信息化与智能化创新团队首席专家，重庆市人工智能协会会员。授权专利超100余项，三大检索文章约20篇，省部级以上项目9项。', '公司业务团队由运营团队和销售团队组成。成员充满朝气并具备创新意识，勇于迎接挑战。是一支高素质队伍。作为首个研究智能马桶加入健康元素的公司，积累了丰富的技术经验，走在行业前列。', 'http://39.98.118.87/images/huochi/793bf36f-d390-4e65-895a-2aed3b456de4.jpg', '<b><p><strong style=\"font-size:22px\">【公告信息】</strong></p></b><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公司本着将优惠性价比产品带入千千万万个家庭的目标，在全球各国和地区寻求招商合作，与业内同仁携手共同开辟门窗时代新天地。<br><br>咨询热线：023-62386151。<br><br>', 'DOOR WINDOW', 'http://static.gongyitech.com/3594a27b230642a79c0b4baf45512927', 'http://static.gongyitech.com/0187a699a4724d9f939f24fd81d780d0');

-- ----------------------------
-- Table structure for function_class
-- ----------------------------
DROP TABLE IF EXISTS `function_class`;
CREATE TABLE `function_class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime(0) NOT NULL,
  `update_datetime` datetime(0) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `function_class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `parent_id` int(11) DEFAULT 0,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'pc端',
  `english_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `class_code` int(11) DEFAULT 0,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机端案例图片',
  `mobile_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '跳转的产品类',
  `icon_pc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of function_class
-- ----------------------------
INSERT INTO `function_class` VALUES (1, '2019-01-07 21:39:40', '2021-03-08 17:24:43', '公寓民宅', '公共建筑', 0, 'http://39.98.118.87/images/huochi/shili1.jpg', '智能开启 净化新风', '融合优秀设计理念，将艺术空间与建筑功能结合，为城市发展提供有价值的产品与服务，打造更具人性化的公共空间。 ', 0, 'http://39.98.118.87/images/huochi/4740d33f-0760-40fd-97da-57a21f4cba02.jpg', '1', 'http://static.gongyitech.com/66df39a48b5b4d0997c0f0b08de42061');
INSERT INTO `function_class` VALUES (2, '2019-01-07 21:39:57', '2021-03-08 17:24:06', '公共建筑', '公寓民宅', 0, 'http://39.98.118.87/images/huochi/shili2.jpg', '隔热保温 防水密封', '延续德式的精工与实用，不论新房装修还是旧房改造，在解决透风渗水炎热寒冷的同时，为您的家居装饰增添更多亮丽色彩。', 0, 'http://39.98.118.87/images/huochi/shili2.jpg', '2', 'http://39.98.118.87/images/huochi/f4a7e739-43d9-4654-801e-594a2a70cc42.jpg');
INSERT INTO `function_class` VALUES (3, '2019-01-07 21:41:02', '2021-03-19 11:17:14', '私家别墅', '商业办公', 0, 'http://39.98.118.87/images/huochi/shili3.jpg', '自由扩展 无限可能', '建筑时光，利用门窗外观极大的可塑性和优异的结构性能，将艺术诠释在建筑外墙上，从而塑造出一个个标志性商业大楼。', 0, 'http://39.98.118.87/images/huochi/shili3.jpg', '3', 'http://39.98.118.87/images/huochi/ab18a1da-2979-4fb8-a043-132bc4c62d8e.jpg');
INSERT INTO `function_class` VALUES (4, '2019-01-07 21:41:22', '2021-03-08 17:26:15', '商业办公', '私家别墅', 0, 'http://39.98.118.87/images/huochi/shili4.jpg', '防撬守护 降音降噪', '创意无限，利用更大的造型空间，设计出独特的装饰风格，配置高性能的门窗材料，让空间更加安逸恬静。', 0, 'http://39.98.118.87/images/huochi/shili4.jpg', '4', 'http://static.gongyitech.com/f04d7b30073c4521b209929bc516e398');

-- ----------------------------
-- Table structure for hot_word
-- ----------------------------
DROP TABLE IF EXISTS `hot_word`;
CREATE TABLE `hot_word`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime(0) NOT NULL,
  `frequency` int(11) DEFAULT NULL,
  `style` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `update_datetime` datetime(0) NOT NULL,
  `word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 382 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hot_word
-- ----------------------------
INSERT INTO `hot_word` VALUES (363, '2021-03-03 16:45:08', 50, NULL, '2021-03-19 15:18:57', '门窗');
INSERT INTO `hot_word` VALUES (364, '2021-03-03 16:55:59', 43, NULL, '2021-03-19 15:32:56', '铝合金');
INSERT INTO `hot_word` VALUES (365, '2021-03-03 16:56:05', 40, NULL, '2021-03-19 15:50:20', '断桥铝');
INSERT INTO `hot_word` VALUES (366, '2021-03-03 16:56:12', 44, NULL, '2021-03-19 06:08:39', '系统窗');
INSERT INTO `hot_word` VALUES (367, '2021-03-03 16:56:58', 1, NULL, '2021-03-03 16:56:58', '节能门窗');
INSERT INTO `hot_word` VALUES (368, '2021-03-03 16:57:03', 1, NULL, '2021-03-03 16:57:03', '系统门窗');
INSERT INTO `hot_word` VALUES (369, '2021-03-03 16:57:13', 1, NULL, '2021-03-03 16:57:13', '智能门窗');
INSERT INTO `hot_word` VALUES (370, '2021-03-03 16:57:20', 1, NULL, '2021-03-03 16:57:20', '被动式门窗');
INSERT INTO `hot_word` VALUES (371, '2021-03-03 16:57:35', 1, NULL, '2021-03-03 16:57:35', '霍驰');
INSERT INTO `hot_word` VALUES (372, '2021-03-03 16:57:39', 1, NULL, '2021-03-03 16:57:39', '兴发');
INSERT INTO `hot_word` VALUES (373, '2021-03-06 13:44:03', 46, NULL, '2021-03-19 04:21:29', '智能马桶');
INSERT INTO `hot_word` VALUES (374, '2021-03-08 14:45:40', 1, NULL, '2021-03-08 14:45:40', '阳光房');
INSERT INTO `hot_word` VALUES (375, '2021-03-08 14:45:56', 1, NULL, '2021-03-08 14:45:56', '70系列');
INSERT INTO `hot_word` VALUES (376, '2021-03-08 14:46:02', 1, NULL, '2021-03-08 14:46:02', '60系列');
INSERT INTO `hot_word` VALUES (377, '2021-03-08 14:46:13', 7, NULL, '2021-03-18 22:02:58', '移门');
INSERT INTO `hot_word` VALUES (378, '2021-03-08 14:46:19', 1, NULL, '2021-03-08 14:46:19', '推拉门');
INSERT INTO `hot_word` VALUES (379, '2021-03-08 14:46:33', 1, NULL, '2021-03-08 14:46:33', '5金件');
INSERT INTO `hot_word` VALUES (380, '2021-03-16 21:11:40', 30, NULL, '2021-03-19 05:28:29', '全密封');
INSERT INTO `hot_word` VALUES (381, '2021-03-17 14:26:28', 10, NULL, '2021-03-18 22:00:22', '门');

-- ----------------------------
-- Table structure for links
-- ----------------------------
DROP TABLE IF EXISTS `links`;
CREATE TABLE `links`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `update_datetime` datetime(0) NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of links
-- ----------------------------
INSERT INTO `links` VALUES (6, '2019-03-18 11:47:42', '轻松装', '2021-03-06 12:01:29', 'http://www.qszhuang.com/');

-- ----------------------------
-- Table structure for maison
-- ----------------------------
DROP TABLE IF EXISTS `maison`;
CREATE TABLE `maison`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime(0) NOT NULL,
  `update_datetime` datetime(0) NOT NULL,
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `response` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int(11) DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, '2019-04-04 11:25:46', '2019-04-04 11:25:46', '1562626262626', '1ddd@qq.com', '1', '15666666666', NULL, 1);
INSERT INTO `message` VALUES (3, '2021-03-03 17:42:59', '2021-03-03 17:42:59', '654653结了婚快乐就好看', '1443786299@qq.com', 'admin', '17865655221', NULL, 0);

-- ----------------------------
-- Table structure for navigation
-- ----------------------------
DROP TABLE IF EXISTS `navigation`;
CREATE TABLE `navigation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime(0) NOT NULL,
  `update_datetime` datetime(0) NOT NULL,
  `nav_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nav_level` int(11) DEFAULT 1,
  `nav_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nav_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nav_keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nav_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `div_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `div_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of navigation
-- ----------------------------
INSERT INTO `navigation` VALUES (1, '2018-11-27 11:10:52', '2021-03-03 14:49:59', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 1, '首页', '/', '霍驰门窗', '霍驰门窗', '霍驰门窗', '霍驰门窗');
INSERT INTO `navigation` VALUES (2, '2018-11-27 11:11:45', '2021-03-03 14:41:22', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 3, '产品分类', '/product/list/1.html', '霍驰门窗', '产品中心1', NULL, NULL);
INSERT INTO `navigation` VALUES (4, '2018-11-27 11:18:07', '2021-03-03 17:08:39', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 7, '招商加盟', '/app.html', '霍驰门窗', '霍驰门窗', NULL, NULL);
INSERT INTO `navigation` VALUES (5, '2018-11-27 11:18:50', '2021-03-03 17:08:26', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 4, '新闻资讯', '/newsListPage.html', '霍驰门窗', '霍驰门窗', NULL, NULL);
INSERT INTO `navigation` VALUES (6, '2018-11-27 11:23:50', '2021-03-03 17:08:16', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 2, '关于我们', '/about.html', '霍驰门窗', '霍驰门窗', NULL, NULL);
INSERT INTO `navigation` VALUES (7, '2018-11-27 11:24:28', '2021-03-03 17:09:13', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 5, '经典案例', '/functionClass.html', '霍驰门窗', '霍驰门窗', NULL, NULL);
INSERT INTO `navigation` VALUES (8, '2018-12-27 15:07:47', '2021-03-03 17:09:29', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 8, '联系我们', '/message.html', '霍驰门窗', '霍驰门窗', NULL, NULL);
INSERT INTO `navigation` VALUES (9, '2018-12-27 15:07:47', '2021-03-03 17:10:05', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 9, '', '/product/list/4.html', '霍驰门窗', '霍驰门窗', NULL, NULL);
INSERT INTO `navigation` VALUES (10, '2018-12-27 15:07:47', '2021-03-03 17:10:15', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 10, '', '/product/list/2.html', '霍驰门窗', '霍驰门窗', NULL, NULL);
INSERT INTO `navigation` VALUES (11, '2018-12-27 15:07:47', '2021-03-03 17:09:50', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 11, '', '/product/list/5.html', '霍驰门窗', '霍驰门窗', NULL, NULL);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime(0) NOT NULL,
  `update_datetime` datetime(0) NOT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `news_class_id` int(11) DEFAULT NULL,
  `news_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `visit_num` int(11) DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `top` int(11) DEFAULT NULL,
  `mobile_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 347 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (79, '2018-12-25 09:47:54', '2019-01-08 17:31:57', '<p><strong>营销开具 团队亮相</strong></p>\n<p><span style=\"color: #222222; font-family: Consolas, \'Lucida Console\', \'Courier New\', monospace; font-size: 10pt; white-space: pre-wrap;\">面对2019年相对严峻的市场环境，全体经销商家人和营销团队无惧挑战，锐意进取，营销业绩实现了稳步增长。</span></p>\n<p><span style=\"color: #222222; font-family: Consolas, \'Lucida Console\', \'Courier New\', monospace; font-size: 10pt; white-space: pre-wrap;\"><img src=\"http://39.98.118.87/images/huochi/f860abc8-5857-4393-bf67-7aedc73a3c95.jpg\" alt=\"\" width=\"688\" height=\"348\" /></span></p>\n<p><span style=\"color: #222222; font-family: Consolas, \'Lucida Console\', \'Courier New\', monospace; font-size: 10pt; white-space: pre-wrap;\">中国是经济增长最快速的国家之一，也是全球最大的单体市场，国家品牌战略支持和消费升级趋势的利好，城镇化的推进、二手房交易的活跃、旧房翻新、二胎政策所释放的家装刚需，都让门窗市场大有可为。过去一年，霍驰门窗进入了全新发展阶段，在产品、品牌、渠道及管理上都取得了新的突破。</span></p>', '2020年1月5日，“新思维·新未来”新豪轩门窗第十七届品牌战略峰会暨全球新品发布会在佛山盛大举行，新豪轩门窗董事长冯文波先生携公司高层领导，与全国各地的经销商家人们、媒体朋友们，欢聚一堂，拓局、迎变、谋远，开启新门窗2020年的新征程。', '新思维', 1, '新思维·新未来 门窗第十七届品牌战略峰会暨全球新品发布会圆满成功！', 'admin', '', 98, 'http://39.98.118.87/images/huochi/025b9a6e-d46e-416e-93e0-38bc9ebf0504.jpg', 1, NULL);
INSERT INTO `news` VALUES (344, '2021-03-03 16:18:26', '2021-03-03 16:18:26', '<p style=\"border: 0px; margin: 0.63em 0px 1.8em; padding: 0px; font-size: 16px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; color: #191919; font-family: \'PingFang SC\', Arial, 微软雅黑, 宋体, simsun, sans-serif;\"><span style=\"color: #000000; font-size: 12pt;\">解决方案:</span></p>\n<p style=\"border: 0px; margin: 0.63em 0px 1.8em; padding: 0px; font-size: 16px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; color: #191919; font-family: \'PingFang SC\', Arial, 微软雅黑, 宋体, simsun, sans-serif;\"><span style=\"color: #000000; font-size: 12pt;\">1、已经变形的框进行修理再安装。</span></p>\n<p style=\"border: 0px; margin: 0.63em 0px 1.8em; padding: 0px; font-size: 16px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; color: #191919; font-family: \'PingFang SC\', Arial, 微软雅黑, 宋体, simsun, sans-serif;\"><span style=\"color: #000000; font-size: 12pt;\">2、框采用的材料厚度要按照国家规定，主要受力构件厚度不小于1.2MM。</span></p>\n<p style=\"border: 0px; margin: 0.63em 0px 1.8em; padding: 0px; font-size: 16px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; color: #191919; font-family: \'PingFang SC\', Arial, 微软雅黑, 宋体, simsun, sans-serif;\"><span style=\"color: #000000; font-size: 12pt;\">3、框四周填塞要适宜，防过量向内弯曲。</span></p>\n<p style=\"border: 0px; margin: 0.63em 0px 1.8em; padding: 0px; font-size: 16px; counter-reset: list-1 0 list-2 0 list-3 0 list-4 0 list-5 0 list-6 0 list-7 0 list-8 0 list-9 0; color: #191919; font-family: \'PingFang SC\', Arial, 微软雅黑, 宋体, simsun, sans-serif;\"><img src=\"http://39.98.118.87/images/huochi/1e714cae-097e-4208-baba-81177baaa6f8.png\" alt=\"\" width=\"836\" height=\"612\" /></p>', '安装锚固铁脚间距过大;或者是锚固铁脚所采用的材料过薄;锚固的方法不正确。', '窗框松动', 2, '门窗框松动', '', '', 0, 'http://39.98.118.87/images/huochi/b235f2eb-8b46-48e8-aa47-f8f1cbcc2429.png', 1, NULL);
INSERT INTO `news` VALUES (345, '2021-03-03 16:47:17', '2021-03-03 16:47:17', '<p style=\"box-sizing: border-box; padding: 0px; margin: 0px; color: #666666; font-size: 16px; font-family: \'Microsoft YaHei\';\"><span style=\"font-size: 12pt;\"><a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #666666; transition: all 0.3s ease 0s; outline: 0px;\" href=\"https://www.xinhaoxuan.com/\">随着人民生活水平的不断提高，对</a><a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/lvhejinmen/\" target=\"_blank\" rel=\"noopener\">铝合金门</a>窗的需求也越来越多。<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/\" target=\"_blank\" rel=\"noopener\">门窗</a>及其衍生<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/chanpin/\" target=\"_blank\" rel=\"noopener\">产品</a>的种类也在不断增多，档次逐步上升，例如隔热<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/\" target=\"_blank\" rel=\"noopener\">铝合金门窗</a>、断桥<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/lvhejinmen/\" target=\"_blank\" rel=\"noopener\">铝门</a>窗、铝木复合门窗、<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/mumen/\" target=\"_blank\" rel=\"noopener\">实木门</a>窗、阳光能源屋、玻璃幕墙、木质幕墙等等。下面就为大家介绍一下中国<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/\" target=\"_blank\" rel=\"noopener\">铝合金门窗品牌霍驰</a>门窗。</span></p>\n<p style=\"box-sizing: border-box; padding: 0px; margin: 0px; color: #666666; font-size: 16px; font-family: \'Microsoft YaHei\';\"><span style=\"font-size: 12pt;\">&nbsp;</span></p>\n<p style=\"box-sizing: border-box; padding: 0px; margin: 0px; color: #666666; font-size: 16px; font-family: \'Microsoft YaHei\';\"><span style=\"font-size: 12pt;\">中国铝合金门窗霍驰门窗，拥有一批强有力、触觉敏锐、富有时代感与创造精神的生产技术人员，拥有配套完善的生产设备，因而有着足以傲视同行的极雄厚的综合开发及生产能力。集团旗下有铝合金门公司、<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/jinggongmumen/\" target=\"_blank\" rel=\"noopener\">实木复合门</a>公司、喷涂木纹公司。</span></p>\n<p style=\"box-sizing: border-box; padding: 0px; margin: 0px; color: #666666; font-size: 16px; font-family: \'Microsoft YaHei\';\"><span style=\"font-size: 12pt;\">&nbsp;</span></p>\n<p style=\"box-sizing: border-box; padding: 0px; margin: 0px; color: #666666; font-size: 16px; font-family: \'Microsoft YaHei\';\"><span style=\"font-size: 12pt;\">一个品牌让消费者真正获得满足，除了优秀的品质，<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/kehufuwu/\" target=\"_blank\" rel=\"noopener\">服务</a>同样重要。中国铝合金门窗霍驰门窗提供的服务是消费者比较看重的，在这个方面，也比较建议大家先去进行咨询，将相关的<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/kehufuwu/\" target=\"_blank\" rel=\"noopener\">售后</a>等信息都问清楚了之后，才做真正的决定。霍驰<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/\" target=\"_blank\" rel=\"noopener\">门窗品牌</a>提供的服务质量比较高，不会在过程中出现不负责任的情况。</span></p>\n<p style=\"box-sizing: border-box; padding: 0px; margin: 0px; color: #666666; font-size: 16px; font-family: \'Microsoft YaHei\';\"><span style=\"font-size: 12pt;\"><img src=\"http://39.98.118.87/images/huochi/e1ca089f-e2b8-4daf-ab2c-29e2e3dbb205.jpg\" alt=\"\" width=\"1280\" height=\"809\" /></span></p>', '随着人民生活水平的不断提高，对铝合金门窗的需求也越来越多。', '霍驰门窗', 3, '中国铝合金门窗选霍驰门窗！', '', '', 0, 'http://39.98.118.87/images/huochi/c089b89c-a69a-4e7e-b78e-afe917543745.jpg', 1, NULL);
INSERT INTO `news` VALUES (346, '2021-03-03 16:52:03', '2021-03-03 16:52:03', '<p style=\"box-sizing: border-box; padding: 0px; margin: 0px; color: #666666; font-size: 16px; font-family: \'Microsoft YaHei\';\"><a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/\">现如今</a><a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/lvhejinmen/\" target=\"_blank\" rel=\"noopener\">铝合金门</a>窗定制越来越受消费者喜欢，随着人们生活水平的提高，更趋势于品质消费，使得定制<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/\" target=\"_blank\" rel=\"noopener\">门窗</a>的需求大量增加，在广东佛山为主的基地就有大量的<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/lvhejinmen/\" target=\"_blank\" rel=\"noopener\">铝门</a>窗厂家，所以选择时要考虑品质和<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/kehufuwu/\" target=\"_blank\" rel=\"noopener\">服务</a>都占优的一线<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/\" target=\"_blank\" rel=\"noopener\">铝门窗厂家</a>。</p>\n<p style=\"box-sizing: border-box; padding: 0px; margin: 0px; color: #666666; font-size: 16px; font-family: \'Microsoft YaHei\';\">&nbsp;</p>\n<p style=\"box-sizing: border-box; padding: 0px; margin: 0px; color: #666666; font-size: 16px; font-family: \'Microsoft YaHei\';\">众所周知，门窗是家家户户的必需品。因为它就像是家的眼睛，不仅可以遮挡风雨，还能保障安全。然而，在众多的门窗材料中，铝合金是业主们最喜欢的材质之一，因为它不但质量轻便而且十分耐用。那么怎么选择铝<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/\" target=\"_blank\" rel=\"noopener\">门窗厂</a>家<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/chanpin/\" target=\"_blank\" rel=\"noopener\">产品</a>呢？</p>\n<p style=\"box-sizing: border-box; padding: 0px; margin: 0px; color: #666666; font-size: 16px; font-family: \'Microsoft YaHei\';\">&nbsp;</p>\n<p style=\"box-sizing: border-box; padding: 0px; margin: 0px; color: #666666; font-size: 16px; font-family: \'Microsoft YaHei\';\"><a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/\" target=\"_blank\" rel=\"noopener\">铝合金门窗</a>具有质轻、坚固、不易变形等特点，且款式多样、色彩丰富，能搭配不同的家装风格，受到很多业主的青睐。门窗的密封性也是很多业主比较担心的问题，所以大家选购门窗要选择密封性比较好的<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/\" target=\"_blank\" rel=\"noopener\">铝门窗</a>厂家，像是<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/xinhaoxuan/\" target=\"_blank\" rel=\"noopener\">新豪轩</a>门窗的密封性就挺好的，配置了优质<a style=\"box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent; color: #111111; transition: all 0.3s ease 0s;\" href=\"https://www.xinhaoxuan.com/menchuangbaike/newsview-738.html\" target=\"_blank\" rel=\"noopener\">密封胶条</a>，夏天能阻止外部热量进入房间，冬天能防止室内热量散发流失，保温隔热的性能还不错，挺节能环保的。</p>\n<p style=\"box-sizing: border-box; padding: 0px; margin: 0px; color: #666666; font-size: 16px; font-family: \'Microsoft YaHei\';\">&nbsp;</p>\n<p style=\"box-sizing: border-box; padding: 0px; margin: 0px; color: #666666; font-size: 16px; font-family: \'Microsoft YaHei\';\">大家选购铝合金门窗，千万不能为了贪图蝇头小利，而选购一些质量不好的品牌，既不安全，也会给后期带来很多烦恼，最好还是选一些靠谱的品牌。</p>\n<p style=\"box-sizing: border-box; padding: 0px; margin: 0px; color: #666666; font-size: 16px; font-family: \'Microsoft YaHei\';\"><img src=\"http://39.98.118.87/images/huochi/7d1d492b-201d-49f5-a2c3-528a93918c38.jpg\" alt=\"\" width=\"1093\" height=\"1096\" /></p>', '众所周知，门窗是家家户户的必需品。因为它就像是家的眼睛，不仅可以遮挡风雨，还能保障安全。', '铝合金', 2, '铝门窗厂家怎么选产品？', '', '', 0, 'http://39.98.118.87/images/huochi/4acd8f42-3224-44b3-9309-c649edf243c6.jpg', 0, NULL);

-- ----------------------------
-- Table structure for news_class
-- ----------------------------
DROP TABLE IF EXISTS `news_class`;
CREATE TABLE `news_class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime(0) NOT NULL,
  `update_datetime` datetime(0) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `news_class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mobile_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `banner_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mobile_banner_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news_class
-- ----------------------------
INSERT INTO `news_class` VALUES (1, '2018-11-28 07:01:01', '2021-03-03 10:24:48', '为您提供门窗相关资讯,门窗行业新闻,以及系统门窗最新新闻,智能家居行业最新信息.', '行业新闻', 'http://static.gongyitech.com/bccbaf4ed13745fcb3eb5d880a576bc5', 'http://static.gongyitech.com/f59c79b44576461fa8f0e2a84608e4fa', 'http://static.gongyitech.com/342ef6b66b0f41488745230ae65a090e', '为您提供门窗相关资讯,门窗行业新闻,以及系统门窗最新新闻,智能家居行业最新信息.', 'http://static.gongyitech.com/3a38d7a1d5b746dfa9fc0442ae46bdd7');
INSERT INTO `news_class` VALUES (2, '2018-11-28 07:00:16', '2021-03-03 10:20:57', '1、锚固铁脚的间距不得大于600MM，铁脚必须经过防腐处理;\n2、锚固铁脚所采用的材料厚度不低于1.5MM，宽度不得小于25MM;\n3、根据不同的墙体材料采用不同的锚固防治方案，砖墙上不得采用锚固，多孔砖不得采用膨胀螺栓锚固。', '常见问题', 'http://39.98.118.87/images/huochi/362d780b-4ddb-4c19-bae3-1c92bb6671ac.jpg', 'http://static.gongyitech.com/571c46f649d54f6c9dc89209ef96c48f', 'http://static.gongyitech.com/342ef6b66b0f41488745230ae65a090e', '安装锚固铁脚间距过大;或者是锚固铁脚所采用的材料过薄;锚固的方法不正确。', 'http://static.gongyitech.com/3a38d7a1d5b746dfa9fc0442ae46bdd7');
INSERT INTO `news_class` VALUES (3, '2018-11-28 07:07:37', '2021-03-03 16:39:37', '北京霍驰门窗最新动态、咨询！', '霍驰新闻', 'http://39.98.118.87/images/huochi/87bb6b2c-50c9-41af-a556-a3e9bdacf0dd.jpg', 'http://static.gongyitech.com/735df18cf7814dc9acb1cc7fd970404c', 'http://static.gongyitech.com/342ef6b66b0f41488745230ae65a090e', '北京霍驰门窗最新动态、咨询！', 'http://static.gongyitech.com/3a38d7a1d5b746dfa9fc0442ae46bdd7');

-- ----------------------------
-- Table structure for patent_info
-- ----------------------------
DROP TABLE IF EXISTS `patent_info`;
CREATE TABLE `patent_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apply_date` datetime(0) DEFAULT NULL,
  `patent_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `patent_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `patentee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patent_info
-- ----------------------------
INSERT INTO `patent_info` VALUES (13, '2017-05-31 00:00:00', 'ZL  2017  1  0398947.6', '螺旋门窗专利', '霍驰门窗', 'http://static.gongyitech.com/75ff3eff58e741a689e443785ffc1f93', '发明专利证书');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime(0) NOT NULL,
  `update_datetime` datetime(0) NOT NULL,
  `detail` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `function_class_id` int(11) DEFAULT NULL,
  `keywords` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `main_description` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `attribute` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `product_class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `product_class_id` int(11) DEFAULT NULL,
  `long_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 84 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (56, '2018-12-25 16:51:40', '2021-03-19 13:52:40', '<p><img src=\"../../../images/huochi/37a77d78-56b7-46e8-8b58-ab089f421eba.jpg\" alt=\"\" width=\"750\" height=\"2003\" /></p>\n<p><img src=\"../../../images/huochi/a0943f22-f74a-4883-adee-2c1b81a03802.jpg\" alt=\"\" width=\"750\" height=\"1146\" /></p>\n<p><img src=\"../../../images/huochi/8e061a23-a2dd-4ace-8a17-2d543f711a49.jpg\" alt=\"\" width=\"750\" height=\"1127\" /></p>\n<p><img src=\"../../../images/huochi/b0b75d4c-c9b4-4708-9161-0c43552c6369.jpg\" alt=\"\" width=\"750\" height=\"1212\" /></p>', 3, '系统窗&断桥铝&铝合金&75窗扇', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 'http://39.98.118.87/images/huochi/9caf2af3-a60c-4543-8f5e-f0c9e05c03e6.jpg', '断桥铝门窗 隔音隔热窗户 封阳台 阳光房 平开推拉门窗', '型号: 75,材质: 断桥铝,产地: 中国大陆,省份: 北京市,颜色分类: 预约测量可抵300,同城服务: 同城卖家入户安装,尺玻璃类型: 中空玻璃,计价单位: 平方米,窗户打开方式: 内开内倒', '75窗扇平齐型号', 1, 'http://39.98.118.87/images/huochi/544ce00b-3f3c-4269-9a3d-4112b4308e1f.jpg');
INSERT INTO `product` VALUES (57, '2018-12-25 16:53:24', '2021-03-19 13:53:13', '<p><span style=\"display: inline !important; float: none; background-color: transparent; color: #727272; font-family: -apple-system,\'Helvetica Neue\',Helvetica,Arial,\'PingFang SC\',\'Hiragino Sans GB\',\'WenQuanYi Micro Hei\',\'Microsoft Yahei\',sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: left; text-decoration: none; text-indent: 0px; text-transform: none; -webkit-text-stroke-width: 0px; white-space: normal; word-spacing: 0px;\">&nbsp;<img src=\"../../../images/huochi/ffbb5823-8159-4f28-a73c-0e536e1f3e16.jpg\" alt=\"\" width=\"750\" height=\"2003\" /></span></p>\n<p><span style=\"display: inline !important; float: none; background-color: transparent; color: #727272; font-family: -apple-system,\'Helvetica Neue\',Helvetica,Arial,\'PingFang SC\',\'Hiragino Sans GB\',\'WenQuanYi Micro Hei\',\'Microsoft Yahei\',sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: left; text-decoration: none; text-indent: 0px; text-transform: none; -webkit-text-stroke-width: 0px; white-space: normal; word-spacing: 0px;\"><img src=\"../../../images/huochi/8e52e773-70d7-475b-a76b-1414a5619dbf.jpg\" alt=\"\" width=\"750\" height=\"1212\" /></span></p>\n<p><span style=\"display: inline !important; float: none; background-color: transparent; color: #727272; font-family: -apple-system,\'Helvetica Neue\',Helvetica,Arial,\'PingFang SC\',\'Hiragino Sans GB\',\'WenQuanYi Micro Hei\',\'Microsoft Yahei\',sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: left; text-decoration: none; text-indent: 0px; text-transform: none; -webkit-text-stroke-width: 0px; white-space: normal; word-spacing: 0px;\"><img src=\"../../../images/huochi/4a2113e3-f0e8-40c8-98c9-77c7d9edc61c.jpg\" alt=\"\" width=\"750\" height=\"2229\" /></span></p>', 1, '断桥铝&75窗扇', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 'http://39.98.118.87/images/huochi/3d5f80c6-006b-4659-a3b2-306784b93087.jpg', '窗纱一体98 108 118#德国断桥铝门窗', '型号: 75,材质: 铝合金,颜色分类: 预约测量|拍100抵货款300,同城服务: 同城卖家入户安装,玻璃类型: 中空玻璃,计价单位: 平方米,窗户打开方式: 外开下悬,特点功能：尿液检测', '75窗扇平齐型号', 1, 'http://39.98.118.87/images/huochi/f7852371-0a1e-4e52-a09b-e7662c60f0fa.jpg');
INSERT INTO `product` VALUES (59, '2018-12-25 16:54:57', '2021-03-19 13:41:41', '<p><img src=\"../../../images/huochi/b64e2644-2b28-4787-9aac-81f84c4a8046.png\" alt=\"\" width=\"698\" height=\"1085\" /></p>\n<p><img src=\"../../../images/huochi/19667df9-0354-43ef-9682-dd9036cdaace.png\" alt=\"\" width=\"698\" height=\"1124\" /></p>', 2, '全密封&系统窗', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 'http://39.98.118.87/images/huochi/bbe32364-42f7-4f50-9511-0b16b79693aa.jpg', '窗纱一体98 108 118#德国断桥铝门窗', '型号: 108,材质: 铝合金,同城服务: 同城卖家入户安装,材质: 铝合金,颜色分类: 预约测量|拍100抵货款300,窗户打开方式: 外开下悬', '72型号', 1, 'http://39.98.118.87/images/huochi/6114b1b8-47af-4358-9b2b-ca64f802024e.jpg');
INSERT INTO `product` VALUES (60, '2018-12-25 16:56:04', '2021-03-19 14:03:16', '<p><img src=\"../../../images/huochi/ee32433d-d369-4606-adb8-83e708852cab.jpg\" alt=\"\" width=\"691\" height=\"383\" /></p>\n<p><img src=\"../../../images/huochi/1b671db6-67d4-4ef8-b9b7-400fe519cd80.jpg\" alt=\"\" width=\"690\" height=\"333\" /></p>\n<p><img src=\"../../../images/huochi/e1368efa-7ec4-4f99-a961-5f51deec6265.jpg\" alt=\"\" width=\"689\" height=\"383\" /></p>', 5, '断桥铝&80系列', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 'http://39.98.118.87/images/huochi/d1aa4b3e-7c5e-4f90-aa21-f609d1329df0.jpg', '断桥铝合金窗户封阳台 推拉门窗移门 定制隔音隔热窗 阳光房', '材质: 断桥铝,产地: 中国大陆,同城服务: 同城卖家入户安装,玻璃类型: 中空玻璃,窗户打开方式: 外开,型号:80', '80型号', 1, 'http://39.98.118.87/images/huochi/195fda26-e4fe-485c-8475-b01754628c66.jpg');
INSERT INTO `product` VALUES (61, '2018-12-25 16:57:37', '2021-03-19 13:39:36', '<p><img src=\"../../../images/huochi/e363eae8-48b2-4566-9d16-2652f8e50a9b.jpg\" alt=\"\" width=\"747\" height=\"414\" /></p>\n<p><img src=\"../../../images/huochi/6c947941-e610-4a3e-b58e-e93e0fa5d8a3.jpg\" alt=\"\" width=\"749\" height=\"361\" /><img src=\"../../../images/huochi/e44498ca-0675-4fef-8f3d-36dda9b948a6.jpg\" alt=\"\" width=\"750\" height=\"417\" /></p>\n<p>&nbsp;</p>', 4, '72系列', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 'http://39.98.118.87/images/huochi/55e2a105-6a22-40a2-ac21-efac66ef1d3a.jpg', '断桥铝合金窗户封阳台 推拉门窗移门 定制隔音隔热窗 阳光房', '型号: 60,材质: 断桥铝,产地: 中国大陆,省份: 北京市,玻璃类型: 中空玻璃,计价单位: 平方米,窗户打开方式: 外开,计价单位: 平方米', '72型号', 1, 'http://39.98.118.87/images/huochi/9197e368-077f-4a87-ab14-2420c0afcb96.jpg');
INSERT INTO `product` VALUES (62, '2018-12-25 17:31:30', '2021-03-19 13:51:31', '<p><img src=\"../../../images/huochi/3cf9a6b2-d8be-45a6-b719-4cbca296c8e0.jpg\" alt=\"\" width=\"699\" height=\"551\" /></p>\n<p><img src=\"../../../images/huochi/5bf7bbca-c52a-4320-ae37-e72cd5d11441.jpg\" alt=\"\" width=\"697\" height=\"552\" /></p>\n<p><img src=\"../../../images/huochi/fbb3ed95-a6bb-4f63-bbcf-a6f74c84ba1f.jpg\" alt=\"\" width=\"693\" height=\"616\" /></p>\n<p><img src=\"../../../images/huochi/6b83ae5b-4198-4c51-bca9-16f46180566a.jpg\" alt=\"\" width=\"790\" height=\"420\" /></p>', NULL, '系统窗', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 'http://39.98.118.87/images/huochi/cd38770e-5bb5-45c9-9ea7-0325cb2dae7f.jpg', '断桥铝门窗 隔音隔热窗户 封阳台 阳光房 平开推拉门窗', '材质: 断桥铝,产地: 中国大陆,颜色分类: 预约测量可抵300,同城服务: 同城卖家入户安装,玻璃类型: 中空玻璃,窗户打开方式: 内开内倒,型号:70型材', '75型材', 1, 'http://39.98.118.87/images/huochi/3c5041d4-a8c1-4f20-9c5e-3550415b5fbf.jpg');
INSERT INTO `product` VALUES (70, '2018-12-25 17:37:58', '2021-03-19 13:49:21', '<p><img src=\"../../../images/huochi/d63cbf94-9585-4661-a21d-4b93211054b6.jpg\" alt=\"\" width=\"750\" height=\"610\" /></p>\n<p><img src=\"../../../images/huochi/e32f4270-d92f-47a3-a289-c5c52fe02b9a.jpg\" alt=\"\" width=\"790\" height=\"468\" /></p>\n<p><img src=\"../../../images/huochi/6414dd13-59b9-4098-9833-f60a384daa23.jpg\" alt=\"\" width=\"750\" height=\"990\" /></p>\n<p><img src=\"../../../images/huochi/347d7233-fdb0-4f8d-856b-5184285bddc0.jpg\" alt=\"\" width=\"750\" height=\"2003\" /></p>\n<p><img src=\"../../../images/huochi/c06b18f0-0bd7-4dd5-822d-94d71667eed2.jpg\" alt=\"\" width=\"750\" height=\"700\" /></p>', 3, '铝合金&门窗&断桥铝&75型材', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 'http://39.98.118.87/images/huochi/1f9f048a-4449-4f8f-9594-73c826ceab71.jpg', '桥铝门窗封阳台 铝合金窗户 隔音隔热窗户 阳光房', '材质: 铝合金,颜色分类: 预约测量,同城服务: 同城卖家入户安装,玻璃类型: 中空玻璃,计价单位: 平方米,窗户打开方式: 外开', '75型材', 2, 'http://39.98.118.87/images/huochi/2f4d358d-ca21-43e0-b58b-3907ec6c5dea.jpg');
INSERT INTO `product` VALUES (71, '2018-12-25 17:38:31', '2021-03-19 14:05:00', '<p><img src=\"../../../images/huochi/2873b39c-47a7-42fb-a612-44fe78f71efd.jpg\" alt=\"\" width=\"673\" height=\"378\" /></p>\n<p><img src=\"../../../images/huochi/19942034-5beb-4f7d-a93b-1fd1a097a2da.jpg\" alt=\"\" width=\"672\" height=\"398\" /></p>', 1, '全密封&75窗扇', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 'http://39.98.118.87/images/huochi/e799823c-af8a-44a1-937d-08b9cbbbe08f.jpg', '断桥铝门窗封阳台 铝合金窗户 隔音隔热窗户 阳光房', '材质: 铝合金,颜色分类: 预约测量,玻璃类型: 中空玻璃,窗户打开方式: 外开,型号:75窗扇', '75窗扇平齐型号', 2, 'http://39.98.118.87/images/huochi/c7135abd-dfba-4c4a-8100-fadb7f094f8c.jpg');
INSERT INTO `product` VALUES (72, '2018-12-25 17:47:28', '2021-03-19 13:48:45', '<p><img src=\"../../../images/huochi/98fe27a3-0366-4ff8-a16a-2414e30ea67a.jpg\" alt=\"\" width=\"790\" height=\"438\" /></p>\n<p><img src=\"../../../images/huochi/842d4b3a-5ffd-4fa7-be83-f2b19c102529.jpg\" alt=\"\" width=\"750\" height=\"916\" /></p>\n<p><img src=\"../../../images/huochi/979a9c4f-3190-42da-ae90-0f7245952a61.jpg\" alt=\"\" width=\"750\" height=\"1853\" /></p>\n<p><img src=\"../../../images/huochi/d90d8c80-f4ff-42ce-9eb6-9f23f95b313c.jpg\" alt=\"\" width=\"750\" height=\"990\" /></p>', 2, '密封窗&门窗&全密封&75型材', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 'http://39.98.118.87/images/huochi/8adc8b2c-8032-41ad-9323-3c8093508082.jpg', '75断桥铝门窗 隔音隔热平开推拉窗户封阳台 阳光房', '材质: 断桥铝,产地: 中国大陆,省份: 北京,颜色分类: 预约测量,同城服务: 同城卖家入户安装,玻璃类型: 钢化玻璃,计价单位: 平方米,窗户打开方式: 外开', '75型材', 2, 'http://39.98.118.87/images/huochi/fce4a2d8-bfe5-4701-8a5d-695b18ed418f.jpg');
INSERT INTO `product` VALUES (73, '2018-12-25 17:50:09', '2021-03-19 13:41:10', '<p><img src=\"../../../images/huochi/f54edbf2-128a-4ade-b536-2d78ccb14873.jpg\" alt=\"\" width=\"701\" height=\"570\" /></p>\n<p><img src=\"../../../images/huochi/15752a3a-9048-44a6-a957-1ae20b07f730.jpg\" alt=\"\" width=\"698\" height=\"899\" /></p>', 4, '系统窗&断桥铝', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 'http://39.98.118.87/images/huochi/9e822a36-ecd3-42ec-8eed-fb8ead65e23e.jpg', '72断桥铝门窗 隔音隔热平开推拉窗户封阳台 阳光房', '材质: 断桥铝,同城服务: 同城卖家入户安装,颜色分类: 预约测量,产地: 中国大陆,玻璃类型: 钢化玻璃,窗户打开方式: 外开,计价单位: 平方米', '72型号', 2, 'http://39.98.118.87/images/huochi/37c51339-2b01-44bf-adc8-af952d9640df.jpg');
INSERT INTO `product` VALUES (74, '2018-12-25 17:51:01', '2021-03-19 13:39:56', '<p><img src=\"../../../images/huochi/36f7fefd-c2cc-4f66-82e5-337729916bfe.jpg\" alt=\"\" width=\"741\" height=\"416\" /><img src=\"../../../images/huochi/eddda776-d1ff-45fd-a1c9-41a5a8fbab52.jpg\" alt=\"\" width=\"743\" height=\"440\" /></p>\n<p>&nbsp;</p>', 5, '60系列', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 'http://39.98.118.87/images/huochi/a3f5f0a4-2d1f-4288-8de2-6284ce812f87.jpg', '断桥铝门窗封阳台 铝合金窗户 隔音隔热窗户 阳光房', '材质: 铝合金,玻璃类型: 中空玻璃,窗户打开方式: 外开,计价单位: 平方米', '72型号', 2, 'http://39.98.118.87/images/huochi/ab3c3c82-a376-4430-9c60-bfc6626a6aa6.jpg');
INSERT INTO `product` VALUES (81, '2018-12-25 17:55:48', '2021-03-19 13:49:49', '<p><span style=\"color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px;\">&nbsp; &nbsp;&nbsp;<img src=\"../../../images/huochi/a38fa3e0-899a-41cc-9cec-f87352bcc9a4.jpg\" alt=\"\" width=\"750\" height=\"1853\" /></span></p>\n<p><span style=\"color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px;\"><img src=\"../../../images/huochi/f322ad99-69a1-46c5-8ba0-cc8267ba4830.jpg\" alt=\"\" width=\"750\" height=\"610\" /></span></p>\n<p><span style=\"color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px;\"><img src=\"../../../images/huochi/661c6db9-5e76-40ec-9a91-f581022f9ab1.jpg\" alt=\"\" width=\"790\" height=\"439\" /></span></p>\n<p><span style=\"color: #333333; font-family: \'PingFang SC\', \'Lantinghei SC\', \'Microsoft YaHei\', arial, 宋体, sans-serif, tahoma; font-size: 16px;\"><img src=\"../../../images/huochi/89c76654-7423-4dc9-9027-6f0333566e10.jpg\" alt=\"\" /></span></p>\n<p>&nbsp;</p>', NULL, '断桥铝', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 'http://39.98.118.87/images/huochi/a05abeb4-4098-4c01-939c-f14baf931bf5.jpg', '75断桥铝门窗 隔音隔热平开推拉窗户封阳台 阳光房', '材质: 断桥铝,产地: 中国大陆,省份: 北京市,颜色分类: 预约测量,同城服务: 同城卖家入户安装,玻璃类型: 钢化玻璃,计价单位: 平方米,窗户打开方式: 外开', '75型材', 2, 'http://39.98.118.87/images/huochi/3aae8f14-e89c-4c87-b068-4ded015d34c9.jpg');
INSERT INTO `product` VALUES (82, '2021-03-08 14:26:54', '2021-03-19 13:55:46', '<p><img src=\"../../../images/huochi/f194d201-f1aa-448d-927a-aa4164a717ea.jpg\" alt=\"\" width=\"707\" height=\"707\" /></p>\n<p><img src=\"../../../images/huochi/9cf03ba5-fd74-48f4-b688-609e8a306bfa.jpg\" alt=\"\" width=\"707\" height=\"707\" /></p>\n<p><img src=\"../../../images/huochi/acc0b265-79c3-42a8-b53d-5a68fbe93b1d.jpg\" alt=\"\" width=\"705\" height=\"705\" /></p>\n<p><img src=\"../../../images/huochi/1560fba0-efb8-4f97-a38e-759050838c51.jpg\" alt=\"\" width=\"707\" height=\"707\" /></p>', NULL, '铝合金&80型号', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 'http://39.98.118.87/images/huochi/198a7a37-f964-4401-8c54-a1a6d90cc78a.jpg', ' 窗纱一体98 108 118#德国断桥铝门窗', '品牌: 霍驰,材质: 铝合金,颜色分类: 预约测量|拍100抵货款300,同城服务: 同城卖家入户安装,玻璃类型: 中空玻璃,计价单位: 平方米,窗户打开方式: 外开下悬,型号:80', '80型号', 2, 'http://39.98.118.87/images/huochi/38e427b3-fc76-4cbb-99ad-d73ee20f2ac8.jpg');
INSERT INTO `product` VALUES (83, '2021-03-19 10:17:16', '2021-03-19 14:01:34', '<p><img src=\"../../../images/huochi/fd574d42-ab24-4236-8c7f-4dc33e09f02b.jpg\" alt=\"\" width=\"752\" height=\"313\" /></p>\n<p><img src=\"../../../images/huochi/30498673-2264-4ec6-9cb4-85bf1181ebd1.jpg\" alt=\"\" width=\"752\" height=\"313\" /></p>\n<p><img src=\"../../../images/huochi/c011344e-9a57-44bd-ad6a-9ab81ee30201.jpg\" alt=\"\" width=\"752\" height=\"315\" /></p>', NULL, '阳台窗&75窗扇', '霍驰门窗总部设立在北京，经营商遍布中国各地!主营断桥铝门窗, 铝包木门窗, 窗纱一体窗, 重型移门,封阳台, 阳光房等一系列产品。静音防风，保温隔热，是门窗行业中的知名品牌。', 'http://39.98.118.87/images/huochi/3996d2e8-76b1-42b2-8458-d7d1d8482813.jpg', '75#断桥铝合金窗户封阳台 推拉门窗 隔音隔热防盗窗 阳光房', '产地: 中国大陆,类型: 铝合金窗,玻璃类型: 中空玻璃,窗户打开方式: 内开内倒,型号:75窗扇', '75窗扇平齐型号', 4, '');

-- ----------------------------
-- Table structure for product_class
-- ----------------------------
DROP TABLE IF EXISTS `product_class`;
CREATE TABLE `product_class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime(0) NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `update_datetime` datetime(0) NOT NULL,
  `mobile_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mobile_banner_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_class
-- ----------------------------
INSERT INTO `product_class` VALUES (1, '2018-12-05 16:06:08', '75窗扇平齐型号', '75窗扇平齐型号', '2021-03-19 13:38:09', 'http://39.98.118.87/images/huochi/2e6155cf-2c9d-447a-81d4-e47d4b7e51a8.jpg', 'http://39.98.118.87/images/huochi/198330c2-e501-47ad-abae-5938bda78311.jpg', 'http://39.98.118.87/images/huochi/f901acf2-6820-4e75-b023-cefa1bf13346.jpg');
INSERT INTO `product_class` VALUES (2, '2018-12-07 13:45:30', '72型号', '72型号', '2021-03-19 13:37:19', 'http://39.98.118.87/images/huochi/60defeef-89ff-4699-b2a1-91f5bd4f5a9c.jpg', 'http://39.98.118.87/images/huochi/6dd33588-097d-489a-b7ae-b4212e7e4945.jpg', 'http://39.98.118.87/images/huochi/bbf29679-7597-4c4d-961d-19355b05fe66.jpg');
INSERT INTO `product_class` VALUES (4, '2021-03-03 09:38:56', '75型材', '75型材', '2021-03-19 13:37:42', 'http://39.98.118.87/images/huochi/f2bc9b8f-8aec-46b3-b4f7-e8668eec1b3c.jpg', 'http://39.98.118.87/images/huochi/bbe88757-cb40-4db0-89c7-b42eec0a3de2.jpg', 'http://39.98.118.87/images/huochi/1cec598d-bea2-4347-b034-5fa588c6374a.jpg');
INSERT INTO `product_class` VALUES (5, '2021-03-03 09:42:08', '80系列', '80型号', '2021-03-19 13:37:13', 'http://39.98.118.87/images/huochi/f8bbc025-8903-4bec-a9b7-3c92432f677d.jpg', 'http://39.98.118.87/images/huochi/a49504b4-698c-4373-8f2b-b9bac487c8f1.jpg', 'http://39.98.118.87/images/huochi/20a7a884-2757-4e95-8122-28af9efc7773.jpg');

-- ----------------------------
-- Table structure for product_function_relation
-- ----------------------------
DROP TABLE IF EXISTS `product_function_relation`;
CREATE TABLE `product_function_relation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `function_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 789 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_function_relation
-- ----------------------------
INSERT INTO `product_function_relation` VALUES (13, 2, 84);
INSERT INTO `product_function_relation` VALUES (14, 4, 84);
INSERT INTO `product_function_relation` VALUES (741, 2, 61);
INSERT INTO `product_function_relation` VALUES (742, 4, 74);
INSERT INTO `product_function_relation` VALUES (743, 1, 73);
INSERT INTO `product_function_relation` VALUES (744, 2, 73);
INSERT INTO `product_function_relation` VALUES (745, 3, 73);
INSERT INTO `product_function_relation` VALUES (746, 3, 59);
INSERT INTO `product_function_relation` VALUES (765, 2, 72);
INSERT INTO `product_function_relation` VALUES (766, 1, 70);
INSERT INTO `product_function_relation` VALUES (767, 2, 70);
INSERT INTO `product_function_relation` VALUES (768, 3, 70);
INSERT INTO `product_function_relation` VALUES (769, 4, 70);
INSERT INTO `product_function_relation` VALUES (770, 2, 81);
INSERT INTO `product_function_relation` VALUES (771, 1, 81);
INSERT INTO `product_function_relation` VALUES (772, 1, 62);
INSERT INTO `product_function_relation` VALUES (773, 2, 62);
INSERT INTO `product_function_relation` VALUES (774, 3, 62);
INSERT INTO `product_function_relation` VALUES (775, 3, 56);
INSERT INTO `product_function_relation` VALUES (776, 2, 57);
INSERT INTO `product_function_relation` VALUES (777, 4, 57);
INSERT INTO `product_function_relation` VALUES (778, 4, 82);
INSERT INTO `product_function_relation` VALUES (779, 3, 82);
INSERT INTO `product_function_relation` VALUES (780, 2, 82);
INSERT INTO `product_function_relation` VALUES (781, 1, 82);
INSERT INTO `product_function_relation` VALUES (782, 2, 83);
INSERT INTO `product_function_relation` VALUES (783, 1, 83);
INSERT INTO `product_function_relation` VALUES (784, 4, 83);
INSERT INTO `product_function_relation` VALUES (785, 1, 60);
INSERT INTO `product_function_relation` VALUES (786, 3, 60);
INSERT INTO `product_function_relation` VALUES (787, 4, 71);
INSERT INTO `product_function_relation` VALUES (788, 1, 71);

-- ----------------------------
-- Table structure for spanner
-- ----------------------------
DROP TABLE IF EXISTS `spanner`;
CREATE TABLE `spanner`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime(0) NOT NULL,
  `update_datetime` datetime(0) NOT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mobile_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `belong_to_who` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of spanner
-- ----------------------------
INSERT INTO `spanner` VALUES (2, '2018-12-27 11:48:46', '2021-03-03 15:31:59', 'http://39.98.118.87/images/huochi/73e3b525-42f1-45f4-83d5-fa8e159cc501.jpg', 'http://39.98.118.87/images/huochi/iphone1.jpg', NULL);
INSERT INTO `spanner` VALUES (10, '2019-01-16 12:46:36', '2021-03-03 15:37:44', 'http://39.98.118.87/images/huochi/c2e68ae0-37af-4007-b068-f7b71ee6dee0.jpg', 'http://39.98.118.87/images/huochi/iphone2.jpg', NULL);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime(0) DEFAULT NULL,
  `is_deleted` int(11) DEFAULT NULL,
  `menu_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `menu_level` int(11) DEFAULT NULL,
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `menu_pid` int(11) DEFAULT NULL,
  `menu_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `update_datetime` datetime(0) DEFAULT NULL,
  `update_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (33, '2019-02-21 19:44:57', 0, 'iconfont icon-caidan', 1, '后台首页', NULL, '/index', 0, '2019-02-21 19:44:57', NULL);
INSERT INTO `sys_menu` VALUES (34, '2019-02-21 19:45:54', 0, 'iconfont icon-xinwenguanli', 1, '资讯管理', NULL, '--', 0, '2019-02-21 19:45:54', NULL);
INSERT INTO `sys_menu` VALUES (35, '2019-02-21 19:46:37', 0, 'iconfont icon-liebiao', 2, '新闻列表', NULL, '/news/list', 34, '2019-02-21 19:46:37', NULL);
INSERT INTO `sys_menu` VALUES (36, '2019-02-21 19:46:55', 0, 'iconfont icon-jierushipeiqileixing', 2, '新闻分类', NULL, '/news/sort', 34, '2019-02-21 19:46:55', NULL);
INSERT INTO `sys_menu` VALUES (37, '2019-02-21 19:47:20', 0, 'iconfont icon-chanpinguanli', 1, '产品管理', NULL, '---', 0, '2019-02-21 19:47:20', NULL);
INSERT INTO `sys_menu` VALUES (38, '2019-02-21 19:47:49', 0, 'iconfont icon-liebiao', 2, '产品列表', NULL, '/product/list', 37, '2019-02-21 19:47:49', NULL);
INSERT INTO `sys_menu` VALUES (39, '2019-02-21 19:48:30', 0, 'iconfont icon-jierushipeiqileixing', 2, '产品分类', NULL, '/productClassSort', 37, '2019-02-21 19:48:30', NULL);
INSERT INTO `sys_menu` VALUES (40, '2019-02-21 19:49:07', 0, 'iconfont icon-chazhaobiaodanliebiao', 1, '经典案例', 0, '/function/list', 0, '2021-03-04 09:38:09', NULL);
INSERT INTO `sys_menu` VALUES (41, '2019-02-21 19:49:27', 0, 'iconfont icon-yonghu', 1, '关于我们', NULL, '-----', 0, '2019-02-21 19:49:27', NULL);
INSERT INTO `sys_menu` VALUES (42, '2019-02-21 19:49:51', 0, 'iconfont icon-gongsixinxi', 2, '公司信息', NULL, '/company', 41, '2019-02-21 19:49:51', NULL);
INSERT INTO `sys_menu` VALUES (43, '2019-02-21 19:50:18', 0, 'iconfont icon-icon', 2, '证书信息', NULL, '/patentInfo', 41, '2019-02-21 19:50:18', NULL);
INSERT INTO `sys_menu` VALUES (44, '2019-02-21 19:50:40', 0, 'iconfont icon-woxiangyaodegongnengicon', 1, '在线留言', NULL, '/message/list', 0, '2019-02-21 19:50:40', NULL);
INSERT INTO `sys_menu` VALUES (45, '2019-02-21 19:50:58', 0, 'iconfont icon-svg-', 1, '招商加盟', 0, '/app', 0, '2021-03-04 09:37:52', NULL);
INSERT INTO `sys_menu` VALUES (46, '2019-02-21 19:51:23', 0, 'iconfont icon-peizhiconfiguration15', 1, '系统管理', NULL, '----------', 0, '2019-02-21 20:08:31', NULL);
INSERT INTO `sys_menu` VALUES (47, '2019-02-21 19:51:48', 0, 'iconfont icon-liebiao', 2, '栏目信息', NULL, '/navInfo', 46, '2019-02-21 20:16:31', NULL);
INSERT INTO `sys_menu` VALUES (48, '2019-02-21 19:52:20', 0, 'iconfont icon-liebiao', 2, 'BANNER', NULL, '/banner', 46, '2019-02-21 19:52:20', NULL);
INSERT INTO `sys_menu` VALUES (49, '2019-02-21 19:53:04', 0, 'iconfont icon-yonghu', 2, '用户信息', NULL, '/user/list', 46, '2019-02-21 19:53:04', NULL);
INSERT INTO `sys_menu` VALUES (50, '2019-02-21 19:53:31', 0, 'iconfont icon-liebiao', 2, '其他信息', NULL, '/setting', 46, '2019-02-21 20:08:19', NULL);
INSERT INTO `sys_menu` VALUES (51, '2019-02-21 20:19:46', 0, 'iconfont icon-chazhaobiaodanliebiao', 2, '菜单管理', NULL, '/menu', 46, '2019-02-21 20:19:46', NULL);
INSERT INTO `sys_menu` VALUES (52, '2019-03-21 17:30:33', 0, 'iconfont icon-xinzengshangpin', 1, '店铺管理', NULL, '/shop', 0, '2019-03-21 17:30:33', NULL);
INSERT INTO `sys_menu` VALUES (53, '2019-03-21 18:11:07', 0, 'iconfont icon-woxiangyaodegongnengicon', 1, '热门词管理', NULL, '/keyword', 0, '2019-03-21 18:54:49', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` datetime(0) NOT NULL,
  `update_datetime` datetime(0) NOT NULL,
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `login_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `login_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `balance` double DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, '2018-12-12 23:25:08', '2021-03-19 10:23:02', '门头沟区曹各庄路30号', '53169555@qq.com', 'admin', '5710a9b7649f5224f5d733e17712fbbc', '', '', '张总', '', NULL, NULL, '', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
