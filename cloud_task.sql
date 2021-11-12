/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : 127.0.0.1:3306
 Source Schema         : cloud_task

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 04/11/2021 10:16:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `event_publisher_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动人发布人username',
  `event_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动名称',
  `activities` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动内容',
  `activity_fraction` int(0) NOT NULL COMMENT '活动加分',
  `activity_location` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动地点',
  `activity_plate` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动属于板块',
  `event_registration_start_time` bigint(0) NOT NULL COMMENT '活动开始报名时间',
  `event_registration_end_time` bigint(0) NOT NULL COMMENT '活动结束报名时间',
  `event_registration_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动报名地点',
  `event_start_time` bigint(0) NOT NULL COMMENT '活动开始时间',
  `event_end_time` bigint(0) NOT NULL COMMENT '活动结束时间',
  `activity_organizer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动承办单位',
  `promotional_graphics` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '宣传图片',
  `page_views` int(0) NOT NULL COMMENT '浏览量',
  `likes` int(0) NOT NULL COMMENT '点赞量',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动or比赛',
  `release_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (6, '1a5376ad727d65213a79f3108541cf95012969a0d3064f108b5dd6e7f8c19b89', '笨笨学院象棋比赛', '为了激发学生的其他兴趣，所以特此举办象棋比赛', 9, '教学楼1栋广场', '社团', 1582128000000, 1582819200000, '教学楼1栋广场', 1582992000000, 1583337600000, '笨笨学院象棋社', 'http://onlywyj.gitee.io/image_bed/cloud_task/Chess.jpg', 623, 18, '比赛', '2020-03-18 13:23:50');
INSERT INTO `activity` VALUES (15, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', '“以青春昂扬之姿， 向新时代致敬” ——第十一届“移通好闹钟”', '## 一、活动主题\n以青春昂扬之姿，向新时代致敬\n以青春昂扬之姿——展现当代大学生朝气与能力\n向新时代致敬——勇担时代新青年责任与使命\n## 二、活动背景\n一个暑假过去，不少同学在这安逸的假期中变得懒散赖床，到如今上课早起，身体虽然坐在教室中，但脑袋却昏昏沉沉，学习效率低下。青年强则国强，作为当代大学生、时代新青年的我们，又怎么能这样放任自己沉沦下去，浑浑噩噩度过一个又一个学期？\n所以“移通好闹钟”诞生了，我们应该养成早起的好习惯，展现出当代大学生特有的朝气与能力，勇担时代新青年的责任与使命。 \n## 三、活动目的及意义\n习近平主席说：青年的价值取向决定了未来整个社会的价值取向，而青年又处在价值观形成和确立的时期，抓好这一时期的价值观养成十分重要。这就像穿衣服扣扣子一样，如果第一颗扣子扣错了，剩余的扣子都会扣错。人生的扣子应该从第一颗开始就要扣好。\n早起作为一项小习惯，可需要的毅力的却不小，得到的收益也绝对不小，它不仅能磨练人的意志，更能让一天的时间在清晨中就安排妥当，对未来大学生自身发展具有极大的好处。', 3, '操场（或者是食堂、教室） ', '校园社团', 1583769600000, 1585584000000, '一二教广场、V观大数据、晓英才', 1585584000000, 1585843200000, '笨笨学院计算机学院大数据与软件学院团总支', 'http://onlywyj.gitee.io/image_bed/cloud_task/playground.jpg', 373, 32, '活动', '2020-03-21 21:37:28');
INSERT INTO `activity` VALUES (16, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', '中国好声音校园选拔赛', '啊实打实阿萨德阿萨德', 3, '笨笨学院', '艺术与修养', 1583164800000, 1585065600000, '笨笨学院', 1584892800000, 1585670400000, '笨笨学院', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/2fd26bb99b723337a2f8eaba84f7d5bb.jpg?thumb=1&w=370&h=225&f=webp&q=90', 188, 45, '活动', '2020-03-21 21:41:31');
INSERT INTO `activity` VALUES (17, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', '笨笨市数据库程序设计大赛', '### 一、组织机构\n\n主办单位: 笨笨计算机学会\n\n承办单位: 笨笨学院\n\n\n### 二、竞赛方式\n\n参赛对象\n\n竞赛面向在校全日制本科生。\n\n参赛要求\n\n参赛作品应遵守我国相关的法律、法规及道德规范，内容积极，健康向上，构思新颖；参赛作品制作软件不限，规模大小不限；参赛作品应界面友好，功能实用；参赛作品必须是原创的、参赛者独立完成的，不能侵犯他人知识产权；参赛作品必须是未公开参加过其他校级及其以上竞赛的作品；参赛作品必须与数据库技术相关；参赛作品必须有规范详细的设计报告。\n\n组队及报名方式\n\n组队方式：每个参赛队最多由三人组成，可以有一位指导老师；每个参赛队最多提交一件作品，每位同学只能参加一个参赛队，每位老师可以指导多个参赛队。\n\n报名方式：我校参赛队请于2017年5月1日至30日期间，登录我校科技竞赛管理系统（http://js.cqupt.edu.cn:81）报名，并将报名表以附件形式上传（学生可以用统一身份认证方式登录或以学号为账号，密码为身份证后六位进行登陆，登录后点击赛事报名进行报名）。\n\n初赛方式\n\n我校初赛于2017年6月16日（16周五）在信科大楼S108举行。初赛方式为系统演示及简单答辩。排名前5的参赛队进入决赛，其余优胜队获得校级奖项。\n\n决赛方式及奖项设置\n\n决赛于2017年6月25日在重庆邮电大学举行。参赛队应提交设计报告、程序源码、演示文件（如PPT、视频）等资料，具体提交方式赛前通知。决赛采用现场答辩的形式进行，每件作品的答辩时间不超过15分钟，包括作品宣讲、系统演示和专家提问等环节。评分主要考察以下几个方面：', 6, '笨笨学院', '校园社团', 1584288000000, 1585584000000, '笨笨学院', 1584288000000, 1585584000000, '笨笨学院大学', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/a8dd25cab48c60fc6387b9001eddc3f9.jpg?thumb=1&w=370&h=225&f=webp&q=90', 507, 66, '比赛', '2020-03-22 22:40:04');
INSERT INTO `activity` VALUES (18, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', '2021笨笨歌唱比赛报名', '大赛简介\n百好利网络音乐擂台赛，不限年龄，不限性别，喜欢音乐爱好者的一个民间赛事，提供给喜爱音乐的朋友可以有一个展示竞技的平台。在平台上展示自己美妙的歌声。为爱好唱歌的选手提供一个圆梦电视的舞台，全国赛的冠亚季军及十佳选手将直接推送参与电视台节目录制。\n\n大赛主旨\n\n百好利网络音乐擂台赛赛事活动以传播音乐为目的。大赛为民间歌手提供一个展示的舞台，通过竞赛活动、将热爱音乐，好歌声分享给大众，通过擂台赛实现上电视的梦想舞台。\n\n大赛主题\n让歌声一生相伴\n\n大赛口号\n圆梦舞台！唱响未来！\n\n赛事安排\n1.各赛区线上网络评选：\n\n符合条件报名选手进行网上参加评选，评选时间为即日起至12月10日。\n\n全国各赛区选出网络人气前10名选手。12月12日至12月25日全国网络决赛。\n\n各赛区前十选手进行全国PK赛，全国赛的冠亚季军及十佳选手100%参与电视节目录制播放。2020年1月安排录制，请参赛选手注意行程安排。（具体录制由栏目组安排，省级以上电视媒体播放）\n\n备注：选手唱功为基础必备条件，进入全国赛选手参赛视频我们将由评审委员会专家评审审核，通过后方可进入全国决赛。若选手因个人原因（含）不能参与录制视同放弃，视为主办方履行完义务。', 3, '笨笨学院', '艺术与修养', 1584979200000, 1585584000000, '微信公众号', 1585584000000, 1585929600000, '笨笨学院计算机工程', 'https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/4c8e1995064837.5e8e46b32c14f.jpg', 209, 88, '比赛', '2020-03-22 22:42:50');
INSERT INTO `activity` VALUES (20, '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', '21届本校生', '#文娱社招新', 3, '笨笨学院', '校园社团', 1582473600000, 1584720000000, '操场', 1585411200000, 1585929600000, '笨笨学院', 'https://cdn.pixabay.com/photo/2014/11/14/21/24/young-girl-531252_960_720.jpg', 204, 90, '活动', '2020-03-26 21:12:15');
INSERT INTO `activity` VALUES (21, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', '志愿者服务', '#志愿服务', 1, '笨笨学院', '志愿服务', 1592841600000, 1592755200000, '操场', 1592236800000, 1592150400000, '笨笨学院', 'https://cdn.pixabay.com/photo/2016/05/03/16/10/morning-1369446_960_720.jpg', 324, 100, '比赛', '2020-06-24 21:30:47');

-- ----------------------------
-- Table structure for carousel
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jump_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carousel
-- ----------------------------
INSERT INTO `carousel` VALUES (3, 'http://onlywyj.gitee.io/image_bed/cloud_task/carousel_01.jpg', 'www.baidu.com');
INSERT INTO `carousel` VALUES (4, 'https://s1.ax1x.com/2020/03/22/8oKKgS.jpg', 'https://www.baidu.com');

-- ----------------------------
-- Table structure for certification
-- ----------------------------
DROP TABLE IF EXISTS `certification`;
CREATE TABLE `certification`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `original_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请人没加密账号',
  `application_sector` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请的部门认证',
  `agree` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '等待审核' COMMENT '通过否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of certification
-- ----------------------------
INSERT INTO `certification` VALUES (3, '111111111', '校团委', '同意');
INSERT INTO `certification` VALUES (4, '222222222', '管理员', '同意');
INSERT INTO `certification` VALUES (5, '222222222', '管理员', '等待审核');
INSERT INTO `certification` VALUES (6, '123456788', '篮球社团', '同意');
INSERT INTO `certification` VALUES (7, '123456789', '管理员', '同意');
INSERT INTO `certification` VALUES (8, '111111111', '科技部', '等待审核');
INSERT INTO `certification` VALUES (9, '123123412', '篮球社团', '等待审核');
INSERT INTO `certification` VALUES (10, '123123412', '教务处', '等待审核');
INSERT INTO `certification` VALUES (11, '346399921', '教务处', '等待审核');
INSERT INTO `certification` VALUES (12, '123123412', '科技部', '等待审核');
INSERT INTO `certification` VALUES (13, '111222333', '管理员', '等待审核');
INSERT INTO `certification` VALUES (14, '111111111', '管理员', '等待审核');
INSERT INTO `certification` VALUES (15, '127213220', '羽毛球社团', '等待审核');
INSERT INTO `certification` VALUES (16, '191218057', '管理员', '等待审核');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `activity_id` int(0) NOT NULL COMMENT '被评论的id',
  `event_publisher_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论的账号',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论的内容',
  `comment_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论的时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (3, 4, '1a5376ad727d65213a79f3108541cf95012969a0d3064f108b5dd6e7f8c19b89', '5555', '2020-03-18 18:13:59');
INSERT INTO `comment` VALUES (4, 6, '1a5376ad727d65213a79f3108541cf95012969a0d3064f108b5dd6e7f8c19b89', '哈哈哈哈', '2020-03-18 19:42:31');
INSERT INTO `comment` VALUES (5, 1111, '1a5376ad727d65213a79f3108541cf95012969a0d3064f108b5dd6e7f8c19b89', 'Fucking \'round with me, you see', '2020-03-18 19:43:53');
INSERT INTO `comment` VALUES (8, 14, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', 'What all do you want from me?', '2020-03-21 10:33:36');
INSERT INTO `comment` VALUES (9, 14, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', 'AR\'s and them .223\'s', '2020-03-21 10:33:43');
INSERT INTO `comment` VALUES (10, 15, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', '少时诵诗书', '2020-03-22 14:37:21');
INSERT INTO `comment` VALUES (11, 16, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', 'I\'m hot, on 500 degrees', '2020-03-22 14:38:06');
INSERT INTO `comment` VALUES (12, 9, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', 'Heard he caught a body', '2020-03-22 22:47:31');
INSERT INTO `comment` VALUES (13, 9, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', 'sad阿萨德Well that does not mean ship to me', '2020-03-22 22:48:25');
INSERT INTO `comment` VALUES (14, 9, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', 'Got two on me', '2020-03-22 22:48:41');
INSERT INTO `comment` VALUES (15, 16, 'c3160e3801345cd7b525e1cc15fd4c2ac50269778a6390675dfbbeaa0d2402b4', 'nice!', '2020-03-22 23:28:06');
INSERT INTO `comment` VALUES (16, 11, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', 'got two on me', '2020-03-23 19:49:26');
INSERT INTO `comment` VALUES (17, 20, '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', '少壮不努力', '2020-03-26 21:12:34');
INSERT INTO `comment` VALUES (18, 20, '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', 'Blood Gang, yeah, suwoop on me', '2020-03-26 21:12:40');
INSERT INTO `comment` VALUES (19, 9, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', '哈哈哈', '2020-06-24 21:40:03');
INSERT INTO `comment` VALUES (20, 20, '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', '9', '2020-06-29 11:22:08');
INSERT INTO `comment` VALUES (21, 20, '42dd0a7fdcb47aad0f6bd98da39c42ba60c00dc0e01fcba36195c23b7f19143d', '000', '2020-06-29 11:28:58');
INSERT INTO `comment` VALUES (22, 10, '342e489174cc8579d038ea97683b010fee86de2c274d2a2eafcb595b213e643f', '买？', '2020-06-29 11:39:18');
INSERT INTO `comment` VALUES (23, 20, 'a232a4e7e064deccaca8543b224bfda1c7de5db05e19f090cff52882a6f58128', '冲冲冲', '2020-06-29 11:41:24');
INSERT INTO `comment` VALUES (24, 20, 'b9eb50471fde39c62895ce370d5b7471cdd6f1f70fed957de3948b5735dc6a67', '21321', '2020-06-29 20:33:13');
INSERT INTO `comment` VALUES (25, 20, 'b9eb50471fde39c62895ce370d5b7471cdd6f1f70fed957de3948b5735dc6a67', '21321', '2020-06-29 20:33:14');
INSERT INTO `comment` VALUES (26, 20, 'b9eb50471fde39c62895ce370d5b7471cdd6f1f70fed957de3948b5735dc6a67', '21321', '2020-06-29 20:33:15');
INSERT INTO `comment` VALUES (27, 20, 'b9eb50471fde39c62895ce370d5b7471cdd6f1f70fed957de3948b5735dc6a67', '21321', '2020-06-29 20:33:15');
INSERT INTO `comment` VALUES (28, 20, 'b9eb50471fde39c62895ce370d5b7471cdd6f1f70fed957de3948b5735dc6a67', '21321', '2020-06-29 20:33:15');
INSERT INTO `comment` VALUES (29, 16, '5a96e440b8c8f37dee3bce5f8b196363c6a6d31769f7db313a197e74334fb773', '2222222', '2020-07-01 10:32:01');

-- ----------------------------
-- Table structure for likes
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `activity_id` int(0) NOT NULL COMMENT '信息id',
  `event_publisher_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '点赞用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of likes
-- ----------------------------
INSERT INTO `likes` VALUES (1, 10, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601');
INSERT INTO `likes` VALUES (2, 7, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601');
INSERT INTO `likes` VALUES (15, 16, 'c3160e3801345cd7b525e1cc15fd4c2ac50269778a6390675dfbbeaa0d2402b4');
INSERT INTO `likes` VALUES (16, 11, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601');
INSERT INTO `likes` VALUES (17, 15, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601');
INSERT INTO `likes` VALUES (20, 9, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601');
INSERT INTO `likes` VALUES (21, 18, 'b671d50c69eee986bfcc87f24f20a6b441b0a970f3bac97f5cfb25a9df173944');

-- ----------------------------
-- Table structure for market
-- ----------------------------
DROP TABLE IF EXISTS `market`;
CREATE TABLE `market`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `event_publisher_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布人username',
  `picture_display` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片展示',
  `item_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物品名称',
  `item_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物品描述',
  `sold` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卖出没',
  `contact_details` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  `trading_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易地点',
  `price` int(0) NOT NULL COMMENT '价格',
  `time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布时间',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容描述',
  `view` int(0) NOT NULL DEFAULT 0 COMMENT '浏览量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of market
-- ----------------------------
INSERT INTO `market` VALUES (8, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/550177d2e54387521bce9e78cb2949dd.jpg?thumb=1&w=250&h=250&f=webp&q=90', '小米电子秤', '可承重300斤', 'f', '阿萨德as', '阿萨德阿萨德啊', 123, '2020-03-21', '阿萨德阿萨德啊实打实', 23);
INSERT INTO `market` VALUES (9, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', 'https://i8.mifile.cn/v1/a1/ef617fac-7489-436d-b74e-c43582f09633!250x250.jpg', '小米电视', '55英寸全面屏', 'f', '123123123', '阿萨德阿萨德阿萨德as', 123, '2020-03-22', '的阿萨德阿萨德阿萨德阿萨德as啊', 15);
INSERT INTO `market` VALUES (10, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/0099822e42b4428cb25c4cdebc6ca53d.jpg?thumb=1&w=250&h=250&f=webp&q=90', '小米10', '骁龙865处理器 / 1亿像素8K电影相机 ', 'f', '1898265546', '笨笨学院', 3999, '2020-03-22', '骁龙865处理器 / 1亿像素8K电影相机 / 双模5G / 新一代LPDDR5内存 / 对称式立体声 / 90Hz刷新率+180Hz采样率 / UFS 3.0高速存储 / 全面适配Wi-Fi 6 / 超强VC液冷散热 / 30W极速闪充+30W无线闪充+10W无线反充 / 4780mAh大电量 / 多功能NFC', 18);
INSERT INTO `market` VALUES (11, 'c3160e3801345cd7b525e1cc15fd4c2ac50269778a6390675dfbbeaa0d2402b4', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/c924c3f3436b6934495fd98f159ee3f7.jpg?thumb=1&w=250&h=250&f=webp&q=90', 'IPhone', 'iphoneX', 'f', '17602369611', '笨笨学院', 50, '2020-03-22', '**萨达萨达阿松大阿松大阿松大阿松大阿松大按时按时**', 15);
INSERT INTO `market` VALUES (12, 'ffe47fb87889d4aa94fc45ddf980fbaa3832f9014b3d857abd50cfc55ca7d58e', 'http://onlywyj.gitee.io/image_bed/cloud_task/computer.jpg', '电脑1', '我的电脑', 'f', '123123', '132323', 5000, '2020-07-01', '11111', 2);
INSERT INTO `market` VALUES (13, 'b671d50c69eee986bfcc87f24f20a6b441b0a970f3bac97f5cfb25a9df173944', 'http://localhost:9999/image/2402e6df-79b4-492c-b75c-b1e58fcf9877.jpg', '123456', '123456', 't', '123456', '123456', 123, '2021-03-15', '### 三级标题\n123123', 3);

-- ----------------------------
-- Table structure for market_comment
-- ----------------------------
DROP TABLE IF EXISTS `market_comment`;
CREATE TABLE `market_comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `activity_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `event_publisher_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of market_comment
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `session` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户登录态',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `certification` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户认证',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户头像地址',
  `original_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原账号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (8, '342e489174cc8579d038ea97683b010fee86de2c274d2a2eafcb595b213e643f', 'b671d50c69eee986bfcc87f24f20a6b441b0a970f3bac97f5cfb25a9df173944', '67db790755b7b9767087f267780cbd144cb56fb8178a5556e982568be6f4275d', '哈哈', '校团委', 'http://47.100.179.136:8080/ssm/image/b81886ff-ab25-4267-a474-af20a8af5110.jpg', '111111111');
INSERT INTO `user_info` VALUES (9, '11e3b00b3a1f8a1f66a35908c7a8ab34d8f93fcd6d377cea0db55dbaac05b601', 'b671d50c69eee986bfcc87f24f20a6b441b0a970f3bac97f5cfb25a9df173944', '3c84244df85db74dc3d41ad50feacf0c61aa70a8aa9904a0686a3d48be1ae596', 'Good', '管理员', 'https://img2.yuntouxiang.com/file/20190624/3f5101a6b6ade3782236c1f210c67645.jpg', '222222222');
INSERT INTO `user_info` VALUES (12, 'a232a4e7e064deccaca8543b224bfda1c7de5db05e19f090cff52882a6f58128', 'b671d50c69eee986bfcc87f24f20a6b441b0a970f3bac97f5cfb25a9df173944', '6c851cec9708be660f2e742f2be1a963baee8cd3b1fb18db130537c34da07d3e', '我不叫一奇', '0', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '330729122');
INSERT INTO `user_info` VALUES (13, '30a85c84b3f1b5984684196ee6916c4863069c9c828dc127952a93ac6212df90', 'b671d50c69eee986bfcc87f24f20a6b441b0a970f3bac97f5cfb25a9df173944', '8d82982fc5b199a9e3b68be8d6c309d2e9053ed6037702f9e257248c7e96f8f5', '一奇啊', '0', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '330722222');
INSERT INTO `user_info` VALUES (14, 'c3160e3801345cd7b525e1cc15fd4c2ac50269778a6390675dfbbeaa0d2402b4', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'c95187a6676d70cffd1eadeb91a36ce275c85ae07463d29dc63d6ffc22dd3b1e', 'Hello', '篮球社团', 'https://img2.yuntouxiang.com/file/20190622/42fafe6761663804d8ce484f8bac3a0c.jpg', '123456788');
INSERT INTO `user_info` VALUES (15, '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '643dcb0c30b8453ae1996356753da761600bdf8ab06e04412b10a1eac652ba67', 'asda', '管理员', 'https://img2.yuntouxiang.com/file/20160423/419902dafa403dbeee4c1f723fb21424.jpg', '123456789');
INSERT INTO `user_info` VALUES (16, '066512cd5cffbfcc8486a75923c1ea93e69b9061ae4d7447867179b59e2973a7', 'a1bd1312d23002be258c9bb4642bbea77580353869a8ee8844e6940b7e0278b7', 'ba718911be8c0f6efe96514a939b2762003505da47d5990eb91f8e37b90f10de', '1245', '0', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '140334468');
INSERT INTO `user_info` VALUES (19, '42dd0a7fdcb47aad0f6bd98da39c42ba60c00dc0e01fcba36195c23b7f19143d', '91b4d142823f7d20c5f08df69122de43f35f057a988d9619f6d3138485c9a203', '0d3a1d388679063441cdccf268032209d13a24b0525a0bdfcffdfa192d8d187b', 'demo', '0', 'http://47.100.179.136:8080/ssm/image/bd2f02f1-3838-4540-813a-a5597a5f1171.png', '123456780');
INSERT INTO `user_info` VALUES (20, 'a704e3c0c33ceeed8b7d945f4e22ef4280a38f22b5f09f3b05b2fbb309e96ec8', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', '9bf6bae7d7a280419eb7a0c9b25d79c7f1e45a9bcbf6c601a40eaaa4ebfe0abd', '191019121', '0', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '191019121');
INSERT INTO `user_info` VALUES (21, '170c1c3850adb035a49bb6b1826aac5b7346fdde47c1939351cadf21c5a88049', '481f6cc0511143ccdd7e2d1b1b94faf0a700a8b49cd13922a70b5ae28acaa8c5', 'b4d670b24e56f795c4f5326816a1a6bae72d7bbba02bcc65bd5f4818abcc9315', '阿斯蒂芬', '0', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '123123412');
INSERT INTO `user_info` VALUES (22, '1a5376ad727d65213a79f3108541cf95012969a0d3064f108b5dd6e7f8c19b89', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'dfbe5ec44a69642146d83967558afef4c5f02e6bd5ed99f2462344ed044a27bf', 'god', '0', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '111111111');
INSERT INTO `user_info` VALUES (23, 'b9eb50471fde39c62895ce370d5b7471cdd6f1f70fed957de3948b5735dc6a67', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '3266888e29609fad1dc983a31291187f633c6f3a92e2d077f0c0c10eb40fc1f2', '111', '0', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '346399921');
INSERT INTO `user_info` VALUES (24, '4371dcb467a53a58025367e59bbd29e9723dc2f2658adf456d17bccb3511f357', 'bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a', 'c8d166cb8df83f4a2732bfe4339f4a43f6bf0889cdd3fec2df5a55561d9a8b82', 'wjw111', '0', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '133333333');
INSERT INTO `user_info` VALUES (25, 'da5511d2baa83c2e753852f1f2fba11003ed0c46c96820c7589b243a8ddb787a', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '089c523b1ffec892bba8e58711ba9ce117c4b231c715ac428ef64a47a04b9bde', '111', '0', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '111222333');
INSERT INTO `user_info` VALUES (26, '5a96e440b8c8f37dee3bce5f8b196363c6a6d31769f7db313a197e74334fb773', '1a5376ad727d65213a79f3108541cf95012969a0d3064f108b5dd6e7f8c19b89', 'b34d53b497ff9e2201e367627ae3fc3e39a262cedecd0c9864a4778bffa77bad', '111111111', '0', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '232146423');
INSERT INTO `user_info` VALUES (27, 'ffe47fb87889d4aa94fc45ddf980fbaa3832f9014b3d857abd50cfc55ca7d58e', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', '884b87721a9fdb7e1c230bdcd231c738e328b587c77a4501ec7f09cb5b6dd433', 'wode', '0', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '127213220');
INSERT INTO `user_info` VALUES (28, 'bb0f6a26de562e481bcbfcc0380fe6ddc7f6bcb2a2fa5cda912087863efef205', 'ffec2b04828a94f08d28b1d93bd9702f0e3395930cc3f3593d1182beedc23561', '0', 'yyy', '0', 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png', '444444444');
INSERT INTO `user_info` VALUES (29, 'b671d50c69eee986bfcc87f24f20a6b441b0a970f3bac97f5cfb25a9df173944', 'b671d50c69eee986bfcc87f24f20a6b441b0a970f3bac97f5cfb25a9df173944', 'f9dc97112d73663ea60c2535f441e467e9ab842a203a017b50c25a6623e01462', 'Only', '0', 'http://onlywyj.gitee.io/image_bed/Author.png', '191218057');

SET FOREIGN_KEY_CHECKS = 1;
