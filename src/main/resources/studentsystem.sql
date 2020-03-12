/*
 Navicat Premium Data Transfer

 Source Server         : 华为云
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 139.159.159.72:3306
 Source Schema         : studentsystem

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 12/03/2020 23:20:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', '123456', '小活');

-- ----------------------------
-- Table structure for t_homework
-- ----------------------------
DROP TABLE IF EXISTS `t_homework`;
CREATE TABLE `t_homework`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `from_id` int(11) NOT NULL COMMENT '是谁发布的作业',
  `content` varchar(2555) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `files` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deadline` datetime(0) NOT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `format` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '格式',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'N' COMMENT '状态',
  `original_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件原始名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_homework
-- ----------------------------
INSERT INTO `t_homework` VALUES (18, 171543234, '相关代码如下：\n```java\n  //创建目录\n        File folder = new File(realPath);\n        if (!folder.isDirectory()){\n            folder.mkdirs();\n        }\n        //更改名字\n        String oldName = multipartFile.getOriginalFilename();\n        int length = oldName.length();\n        String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf(\".\"), length);\n        String url = realPath + \'\\\\\' + newName;\n        //存储文件\n        try {\n            multipartFile.transferTo(new File(folder,newName));\n        } catch (Exception e) {\n            e.printStackTrace();\n            return UploadResult.error();\n        }\n        return UploadResult.Success(\"/ssm/file/get/\"+newName);\n```', 'e9583c1a-eba0-40d3-a039-225cbb5de2d4.doc;', '2019-10-31 00:00:00', '2019-11-02 00:17:47', 'Java实验报告五', 'zip', 'Y', NULL);
INSERT INTO `t_homework` VALUES (19, 171543234, '![](/ssm/file/get/0547b437-d66a-4ab3-a39a-de1102f4ea65.jpg)', 'eebc76d1-f99c-4d60-ac00-95cf1130e3b5.doc;', '2019-10-31 00:00:00', '2019-11-02 00:17:48', 'java实验报告五', 'zip', 'Y', 'eebc76d1-f99c-4d60-ac00-95cf1130e3b5.doc;');
INSERT INTO `t_homework` VALUES (20, 171543234, '![](/ssm/file/get/9290df63-3da9-42a5-b55b-8848b08e23d9.jpg)', '5b1473e7-a6aa-4541-aadc-e18fe5611378.doc;', '2019-10-31 00:00:00', '2019-10-27 20:18:22', 'Java实验报告六', 'zip', 'N', '171543234-刘辉彬-实验报告1.doc;');
INSERT INTO `t_homework` VALUES (22, 171543234, '###参考代码如下', '77cfbbb6-3ae4-49dc-a57d-fc305f0611d7.doc;cbffd3e0-5e31-4ca0-afd5-49606fd5cde2.doc;', '2019-11-01 00:00:00', '2019-10-27 22:29:27', '软件工程实验报告', 'zip', 'N', '171543234-刘辉彬-实验报告1.doc;171543234-刘辉彬-实验报告2.doc;');
INSERT INTO `t_homework` VALUES (23, 171543234, '###参考代码如下\n```java\n public Object getByName(@PathVariable String name, HttpServletResponse response){\n        String pathName = realPath + \"\\\\\" + name;\n        File file = new File(pathName);\n        try {\n            FileInputStream fileInputStream = new FileInputStream(file);\n            byte[] bytes = new byte[fileInputStream.available()];\n            fileInputStream.read(bytes);\n            int length = name.length();\n            String suffix = name.substring(name.lastIndexOf(\".\"), length);\n            response.setStatus(200);\n            response.setContentType(\"image/\"+suffix);\n            ServletOutputStream outputStream=response.getOutputStream();\n            outputStream.write(bytes);\n            outputStream.flush();\n            return null;\n        } catch (FileNotFoundException e) {\n            e.printStackTrace();\n        } catch (IOException e) {\n            e.printStackTrace();\n        }\n        return null;\n    }\n```', 'cef90c01-6a07-41b4-93db-f4f3332b8ddd.doc;53500b75-4a02-4e88-a66c-afd6737612b1.doc;', '2019-11-01 00:00:00', '2019-10-27 22:33:35', '软件工程实验报告二', 'zip', 'N', '171543234-刘辉彬-实验报告1.doc;171543234-刘辉彬-实验报告2.doc;');
INSERT INTO `t_homework` VALUES (24, 171543234, '麻烦请按时提交，谢谢了', '6197ff10-83fa-4944-b00d-e891f6734011.doc;ca1c6156-8a02-4e33-84f6-b5c7585efb1f.doc;', '2019-10-31 00:00:00', '2019-10-27 23:44:22', '软件工程实验报告三', 'docx', 'N', '171543234-刘辉彬-实验报告2.doc;171543234-刘辉彬-实验报告1.doc;');
INSERT INTO `t_homework` VALUES (25, 171543234, '![](/ssm/file/get/d5048b2d-2fc7-4cbb-be68-42ae3c0d59de.png)', 'bccaf35c-8c2e-4728-9f80-fb3654a3eff7.zip;', '2019-10-31 00:00:00', '2019-11-02 00:17:49', '程序设计实验一', 'zip', 'Y', 'fly-3.0.zip;');
INSERT INTO `t_homework` VALUES (26, 171543234, '###相关代码\n```java\n User user = JSON.parseObject(json, User.class);\n        ResponseResult responseResult = userService.loginUser(user);\n        User user1 = userService.getUser(user.getId());\n        request.getSession().setAttribute(\"user\", user1);\n        return responseResult;\n```', '7a5a59a3-c002-439d-97f5-7f9ecb363f48.doc;', '2019-10-31 00:00:00', '2019-10-29 15:49:49', '计算机网络实验报告一', 'docx', 'N', '171543234-刘辉彬-实验报告1.doc;');
INSERT INTO `t_homework` VALUES (27, 171543234, '```java\n  System.out.println(title);\n        String originalFilename = multipartFile.getOriginalFilename();\n        User user = userMapper.findById(fromId);\n        String fromName = user.getUsername();\n        System.out.println(username);\n        System.out.println(userId);\no```', 'f96b96e1-d65e-4f03-918c-43f3d002fc44.doc;', '2019-10-30 00:00:00', '2019-11-02 00:17:50', '数据结构实验一', 'docx', 'Y', '171543234-刘辉彬-实验报告1.doc;');
INSERT INTO `t_homework` VALUES (28, 171543234, '```java\n  User user = JSON.parseObject(json, User.class);\n        ResponseResult responseResult = userService.loginUser(user);\n        User user1 = userService.getUser(user.getId());\n        request.getSession().setAttribute(\"user\", user1);\n        return responseResult;\n```', '87866809-01b8-4ca1-b2e1-fdea102382ec.doc;', '2019-11-08 00:00:00', '2019-10-29 16:00:37', '数据结构实验二', 'docx', 'N', '171543234-刘辉彬-实验报告1.doc;');
INSERT INTO `t_homework` VALUES (29, 171543234, '###请按时提交', '34c2f1c0-0d73-4ec3-aedc-096f4a958eaa.doc;', '2019-10-31 00:00:00', '2019-10-29 16:39:19', '数据结构实验三', 'docx', 'N', '171543234-刘辉彬-实验报告1.doc;');
INSERT INTO `t_homework` VALUES (30, 171543234, '```java\n\n    @GetMapping(\"/allWork\")\n    public ResponseResult allWork(String userId) {\n        System.out.println(userId);\n        List<Homework> allWorkByUserId = homeworkService.findAllWorkByUserId(userId);\n        return ResponseResult.Success(200, \"查询成功\", allWorkByUserId);\n    }\n\n```', 'bf5b3cf8-2666-4f15-82b2-70353a5f1ec2.docx;', '2019-10-31 00:00:00', '2019-11-02 00:17:51', '数据结构实验三', 'docx', 'Y', '1_作业-后端(1)(3).docx;');
INSERT INTO `t_homework` VALUES (31, 171543234, '', '', '2019-11-08 00:00:00', '2019-11-01 22:37:54', '111', 'zip', 'N', '');
INSERT INTO `t_homework` VALUES (32, 171543234, '###请大家尽快提交', '2b05ccff-4aa6-4fdb-af69-c9c1e50ef7c4.docx;', '2019-11-08 00:00:00', '2019-11-02 08:44:28', '项目课程设计实验一', 'docx', 'N', '1_作业-后端(1)(3).docx;');
INSERT INTO `t_homework` VALUES (33, 171543234, '###请大家按照图片要求，尽快提交自己的作业\n![](/ssm/file/get/ad0a8a1a-d006-47ad-8668-ed86d4d0b10f.png)', 'eeeb3d23-5bdd-48d9-8017-38fe3f1d777e.docx;', '2019-11-21 00:00:00', '2019-11-02 08:52:29', '项目课程设计实验二', 'zip', 'N', '1_作业-后端(1)(3).docx;');
INSERT INTO `t_homework` VALUES (34, 171543234, '###参考代码如下\n```java\n   //获取发布人的姓名以及相对应的作业名\n        ArrayList<String> list = new ArrayList<>();\n        User user = userService.getUser(fromId);\n        String username = user.getUsername();\n        //打包作业 start\n        List<UserWork> workList = userWorkService.findWorkListByWorkId(workId);\n        for (UserWork userWork : workList) {\n            String file = userWork.getFile();\n            if (file == null) {\n                continue;\n            }\n            String path = realPath + \"\\\\\" + username + \"\\\\\" + title + \"\\\\\" + file;\n            System.out.println(path);\n            list.add(path);\n        }\n        String zipPath = realPath + \"\\\\\" + username + \"\\\\\" + title + \"\\\\\" + title + \".zip\";\n        File file = new File(zipPath);\n        if (file.exists()) {\n            file.delete();\n        }\n        file = new File(zipPath);\n        ZipUtils zipUtils = new ZipUtils();\n        zipUtils.zipFileCreate(list, file);\n        //打包作业 end\n        String packagename = title + \".zip\";\n        return ResponseResult.Success(200, \"打包成功\", packagename);\n    }\n```', 'd4e64fbb-2314-4177-a5d5-06d7bb648b7f.docx;', '2019-11-30 00:00:00', '2019-11-02 08:57:49', '项目课程设计实验三', 'docx', 'N', '1_作业-后端(1)(3).docx;');
INSERT INTO `t_homework` VALUES (35, 171543234, '###参考代码如下\n```java\n   //获取发布人的姓名以及相对应的作业名\n        ArrayList<String> list = new ArrayList<>();\n        User user = userService.getUser(fromId);\n        String username = user.getUsername();\n        //打包作业 start\n        List<UserWork> workList = userWorkService.findWorkListByWorkId(workId);\n        for (UserWork userWork : workList) {\n            String file = userWork.getFile();\n            if (file == null) {\n                continue;\n            }\n            String path = realPath + \"\\\\\" + username + \"\\\\\" + title + \"\\\\\" + file;\n            System.out.println(path);\n            list.add(path);\n        }\n        String zipPath = realPath + \"\\\\\" + username + \"\\\\\" + title + \"\\\\\" + title + \".zip\";\n        File file = new File(zipPath);\n        if (file.exists()) {\n            file.delete();\n        }\n        file = new File(zipPath);\n        ZipUtils zipUtils = new ZipUtils();\n        zipUtils.zipFileCreate(list, file);\n        //打包作业 end\n        String packagename = title + \".zip\";\n        return ResponseResult.Success(200, \"打包成功\", packagename);\n    }\n```', '69372891-058c-4644-8998-f650d4b619e3.docx;', '2019-11-30 00:00:00', '2019-11-02 09:00:29', '项目课程设计实验四', 'docx', 'N', '1_作业-后端(1)(3).docx;');
INSERT INTO `t_homework` VALUES (36, 171543234, '###参考代码如下\n```\n   //获取发布人的姓名以及相对应的作业名\n        ArrayList<String> list = new ArrayList<>();\n        User user = userService.getUser(fromId);\n        String username = user.getUsername();\n        //打包作业 start\n        List<UserWork> workList = userWorkService.findWorkListByWorkId(workId);\n        for (UserWork userWork : workList) {\n            String file = userWork.getFile();\n            if (file == null) {\n                continue;\n            }\n            String path = realPath + \"\\\\\" + username + \"\\\\\" + title + \"\\\\\" + file;\n            System.out.println(path);\n            list.add(path);\n        }\n        String zipPath = realPath + \"\\\\\" + username + \"\\\\\" + title + \"\\\\\" + title + \".zip\";\n        File file = new File(zipPath);\n        if (file.exists()) {\n            file.delete();\n        }\n        file = new File(zipPath);\n        ZipUtils zipUtils = new ZipUtils();\n        zipUtils.zipFileCreate(list, file);\n        //打包作业 end\n        String packagename = title + \".zip\";\n        return ResponseResult.Success(200, \"打包成功\", packagename);\n    }\n```', '72311fa6-f5aa-4c48-9c68-e8389f9569ca.docx;', '2019-11-30 00:00:00', '2019-11-02 09:02:55', '项目课程设计实验五', 'docx', 'N', '1_作业-后端(1)(3).docx;');
INSERT INTO `t_homework` VALUES (37, 171543234, '###参考代码如下\n```java\n   //获取发布人的姓名以及相对应的作业名\n        ArrayList<String> list = new ArrayList<>();\n        User user = userService.getUser(fromId);\n        String username = user.getUsername();\n        //打包作业 start\n        List<UserWork> workList = userWorkService.findWorkListByWorkId(workId);\n        for (UserWork userWork : workList) {\n            String file = userWork.getFile();\n            if (file == null) {\n                continue;\n            }\n            String path = realPath + \"\\\\\" + username + \"\\\\\" + title + \"\\\\\" + file;\n            System.out.println(path);\n            list.add(path);\n        }\n        String zipPath = realPath + \"\\\\\" + username + \"\\\\\" + title + \"\\\\\" + title + \".zip\";\n        File file = new File(zipPath);\n        if (file.exists()) {\n            file.delete();\n        }\n        file = new File(zipPath);\n        ZipUtils zipUtils = new ZipUtils();\n        zipUtils.zipFileCreate(list, file);\n        //打包作业 end\n        String packagename = title + \".zip\";\n        return ResponseResult.Success(200, \"打包成功\", packagename);\n    }\n```', '29438b97-dfbe-4265-b008-cd817e4edf8d.docx;', '2019-11-30 00:00:00', '2019-11-02 09:04:20', '项目课程设计实验六', 'docx', 'N', '1_作业-后端(1)(3).docx;');
INSERT INTO `t_homework` VALUES (38, 171543234, '###参考代码\n``java\n   //获取发布人的姓名以及相对应的作业名\n        ArrayList<String> list = new ArrayList<>();\n        User user = userService.getUser(fromId);\n        String username = user.getUsername();\n        //打包作业 start\n        List<UserWork> workList = userWorkService.findWorkListByWorkId(workId);\n        for (UserWork userWork : workList) {\n            String file = userWork.getFile();\n            if (file == null) {\n                continue;\n            }\n            String path = realPath + \"\\\\\" + username + \"\\\\\" + title + \"\\\\\" + file;\n            System.out.println(path);\n            list.add(path);\n        }\n        String zipPath = realPath + \"\\\\\" + username + \"\\\\\" + title + \"\\\\\" + title + \".zip\";\n        File file = new File(zipPath);\n        if (file.exists()) {\n            file.delete();\n        }\n        file = new File(zipPath);\n        ZipUtils zipUtils = new ZipUtils();\n        zipUtils.zipFileCreate(list, file);\n        //打包作业 end\n        String packagename = title + \".zip\";\n        return ResponseResult.Success(200, \"打包成功\", packagename);\n    }\n```', '280ebd23-664a-49d7-b098-0ac38b19739e.docx;', '2019-11-30 00:00:00', '2019-11-02 09:33:06', '数据库', 'docx', 'N', '1_作业-后端(1)(3).docx;');

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(2555) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES (1, '171543234', '这不是演戏', '一般通知', '2019-11-02 01:22:09');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '普通学生',
  `level` smallint(11) NULL DEFAULT 0,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '普通学生', 0, '交作业，查看作业');
INSERT INTO `t_role` VALUES (2, '课代表', 1, '交作业，收作业，发布作业');
INSERT INTO `t_role` VALUES (3, '班长', 2, '分配角色');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sys_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role`(`role_id`) USING BTREE,
  CONSTRAINT `role` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('171543212', '曾尚希', '4320302lp', 'MTcxNTQzMjEy%%%NDMyMDMwMmxw', 2);
INSERT INTO `t_user` VALUES ('171543227', '梁志活', 'a123456789', 'MTcxNTQzMjI3%%%YTEyMzQ1Njc4OQ==', 2);
INSERT INTO `t_user` VALUES ('171543231', '林楚锋', '123456', 'MTcxNTQzMjMx%%%QWxvbmcxOTg5dg==', 1);
INSERT INTO `t_user` VALUES ('171543234', '刘辉彬', '1111', 'MTcxNTQzMjM0%%%bGl1MDY2MzIzNTMxMzA=', 3);
INSERT INTO `t_user` VALUES ('171543237', '邱佳全', 'qiujiaquan123', 'MTcxNTQzMjM3%%%cWl1amlhcXVhbjEyMw==', 1);
INSERT INTO `t_user` VALUES ('171543243', '杨翔俊', 'yang171543243', 'MTcxNTQzMjQz%%%eWFuZzE3MTU0MzI0Mw==', 1);
INSERT INTO `t_user` VALUES ('171543244', '杨著浩', 'kl689322', 'MTcxNTQzMjQ0%%%a2w2ODkzMjI=', 1);
INSERT INTO `t_user` VALUES ('171543247', '张家豪', '1', 'MTcxNTQzMjQ3%%%MTIzNDU2YWE=', 2);

-- ----------------------------
-- Table structure for t_userwork
-- ----------------------------
DROP TABLE IF EXISTS `t_userwork`;
CREATE TABLE `t_userwork`  (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '学生ID',
  `homework_id` bigint(20) NOT NULL COMMENT '作业ID',
  `file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '作业状态',
  `commit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `modified_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `work_id`(`homework_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `work_id` FOREIGN KEY (`homework_id`) REFERENCES `t_homework` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_userwork
-- ----------------------------
INSERT INTO `t_userwork` VALUES (17, '171543244', 18, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (18, '171543247', 18, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (19, '171543234', 19, '171543234-刘辉彬-程序设计实验一.zip', 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (20, '171543244', 19, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (21, '171543247', 19, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (22, '171543234', 20, '171543234-刘辉彬-程序设计实验一.zip', 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (23, '171543244', 20, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (24, '171543247', 20, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (28, '171543234', 22, '171543234-刘辉彬-程序设计实验一.zip', 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (29, '171543244', 22, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (30, '171543247', 22, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (31, '171543234', 23, '171543234-刘辉彬-软件工程实验报告二.zip', 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (33, '171543247', 23, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (34, '171543234', 24, '171543234-刘辉彬-程序设计实验一.zip', 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (35, '171543244', 24, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (36, '171543247', 24, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (37, '171543231', 25, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (38, '171543234', 25, '171543234-刘辉彬-程序设计实验一.zip', 'Y', '2019-10-25 10:38:30', '2019-11-01 23:58:25');
INSERT INTO `t_userwork` VALUES (39, '171543244', 25, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (40, '171543247', 25, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (41, '171543231', 26, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (42, '171543234', 26, '171543234-刘辉彬-计算机网络实验报告一.docx', 'Y', NULL, '2019-10-30 00:51:33');
INSERT INTO `t_userwork` VALUES (43, '171543244', 26, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (44, '171543247', 26, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (45, '171543231', 27, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (46, '171543234', 27, '171543234-刘辉彬-数据结构实验一.docx', 'Y', NULL, '2019-10-29 22:33:17');
INSERT INTO `t_userwork` VALUES (47, '171543244', 27, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (48, '171543247', 27, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (49, '171543231', 28, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (50, '171543234', 28, '171543234-刘辉彬-数据结构实验二.doc', 'Y', NULL, '2019-10-29 17:08:51');
INSERT INTO `t_userwork` VALUES (51, '171543244', 28, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (52, '171543247', 28, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (53, '171543231', 29, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (54, '171543234', 29, '171543234-刘辉彬-数据结构实验三.doc', 'Y', '2019-10-29 16:39:31', '2019-10-29 16:41:21');
INSERT INTO `t_userwork` VALUES (55, '171543244', 29, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (56, '171543247', 29, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (57, '171543227', 30, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (58, '171543231', 30, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (59, '171543234', 30, '171543234-刘辉彬-数据结构实验三.docx', 'Y', '2019-10-31 14:10:06', NULL);
INSERT INTO `t_userwork` VALUES (60, '171543244', 30, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (61, '171543247', 30, '171543247-张家豪-数据结构实验三.docx', 'Y', '2019-11-01 00:02:07', NULL);
INSERT INTO `t_userwork` VALUES (62, '171543227', 31, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (63, '171543231', 31, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (64, '171543234', 31, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (65, '171543237', 31, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (66, '171543244', 31, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (67, '171543247', 31, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (68, '171543227', 32, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (69, '171543231', 32, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (70, '171543234', 32, '171543234-刘辉彬-项目课程设计实验一.doc', 'Y', '2019-11-02 08:46:11', NULL);
INSERT INTO `t_userwork` VALUES (71, '171543237', 32, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (72, '171543244', 32, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (73, '171543247', 32, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (74, '171543227', 33, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (75, '171543231', 33, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (76, '171543234', 33, '171543234-刘辉彬-项目课程设计实验二.zip', 'Y', '2019-11-02 08:53:01', NULL);
INSERT INTO `t_userwork` VALUES (77, '171543237', 33, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (78, '171543244', 33, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (79, '171543247', 33, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (80, '171543227', 34, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (81, '171543231', 34, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (82, '171543234', 34, '171543234-刘辉彬-项目课程设计实验三.docx', 'Y', '2019-11-09 16:54:13', NULL);
INSERT INTO `t_userwork` VALUES (83, '171543237', 34, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (84, '171543244', 34, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (85, '171543247', 34, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (86, '171543227', 35, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (87, '171543231', 35, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (88, '171543234', 35, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (89, '171543237', 35, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (90, '171543244', 35, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (91, '171543247', 35, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (92, '171543227', 36, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (93, '171543231', 36, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (94, '171543234', 36, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (95, '171543237', 36, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (96, '171543244', 36, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (97, '171543247', 36, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (98, '171543227', 37, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (99, '171543231', 37, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (100, '171543234', 37, '171543234-刘辉彬-项目课程设计实验六.docx', 'Y', '2019-11-02 09:05:04', NULL);
INSERT INTO `t_userwork` VALUES (101, '171543237', 37, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (102, '171543244', 37, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (103, '171543247', 37, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (104, '171543212', 38, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (105, '171543227', 38, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (106, '171543231', 38, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (107, '171543234', 38, '171543234-刘辉彬-数据库.docx', 'Y', '2019-11-02 09:33:43', NULL);
INSERT INTO `t_userwork` VALUES (108, '171543237', 38, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (109, '171543243', 38, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (110, '171543244', 38, NULL, 'N', NULL, NULL);
INSERT INTO `t_userwork` VALUES (111, '171543247', 38, NULL, 'N', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
