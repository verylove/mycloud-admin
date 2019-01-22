/*
Navicat MySQL Data Transfer

Source Server         : 192.168.52.147
Source Server Version : 50722
Source Host           : 192.168.52.147:3306
Source Database       : mycloud-admin

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-12-31 17:24:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `account_non_expired` tinyint(1) DEFAULT NULL COMMENT '账户没有超时',
  `account_non_locked` tinyint(1) DEFAULT NULL COMMENT '账户是否被锁定',
  `credentials_non_expired` tinyint(1) DEFAULT NULL COMMENT '凭证是否超时',
  `online` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'admin', '$2a$10$ELLZyWA2qOi0704eA.xOzurovNPNh3Fr8xxTGa3Gv9cML3nBFTrE6', '15920151245', null, null, '1', '1', '1', '1', '0');
INSERT INTO `account` VALUES ('2', 'guest', '$2a$10$HcTDZy0T8LYdgVuWtYoxE.RcH5doYSsR5lSby8x4pMvZTPwRfU/Ly', '13522586127', null, null, '1', '1', '1', '1', '0');

-- ----------------------------
-- Table structure for `account_roles`
-- ----------------------------
DROP TABLE IF EXISTS `account_roles`;
CREATE TABLE `account_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `aid` bigint(20) DEFAULT NULL,
  `rid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of account_roles
-- ----------------------------
INSERT INTO `account_roles` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `auth_permission`
-- ----------------------------
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE `auth_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url_pattern` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `mid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of auth_permission
-- ----------------------------
INSERT INTO `auth_permission` VALUES ('1', '/api-user/user/listpage', '用户列表', '4');
INSERT INTO `auth_permission` VALUES ('2', '/api-user/user/edit', '用户修改', '4');
INSERT INTO `auth_permission` VALUES ('3', '/api-user/user/add', '用户添加', '4');
INSERT INTO `auth_permission` VALUES ('4', '/api-user/user/remove', '用户删除', '4');
INSERT INTO `auth_permission` VALUES ('5', '/api-user/role/listpage', '角色列表', '5');
INSERT INTO `auth_permission` VALUES ('6', '/api-user/menu/getMenuList', '菜单列表', '6');
INSERT INTO `auth_permission` VALUES ('7', '/api-user/role/remove', '角色删除', '5');
INSERT INTO `auth_permission` VALUES ('8', '/api-user/role/edit', '修改角色', '5');
INSERT INTO `auth_permission` VALUES ('9', '/api-user/role/add', '添加角色', '5');
INSERT INTO `auth_permission` VALUES ('10', '/api-user/role/editrolemenu', '修改角色权限', '5');
INSERT INTO `auth_permission` VALUES ('11', '/api-user/menu/insertMenu', '添加权限', '3');
INSERT INTO `auth_permission` VALUES ('12', '/api-user/menu/updateMenu', '修改权限', '3');
INSERT INTO `auth_permission` VALUES ('13', '/api-user/menu/deleteMenu', '删除权限', '3');
INSERT INTO `auth_permission` VALUES ('14', '/api-user/authPermission/getAuthPermissionsList', '资源列表', '3');
INSERT INTO `auth_permission` VALUES ('16', '/api-user/authPermission/editAuthPermissions', '修改资源', '3');
INSERT INTO `auth_permission` VALUES ('17', '/api-user/authPermission/deleteAuthPermissions', '删除资源', '3');
INSERT INTO `auth_permission` VALUES ('20', '/api-user/authPermission/loadPermissions', '获取资源列表', '3');
INSERT INTO `auth_permission` VALUES ('21', '/api-user/role/editRolePermissions', '修改角色资源', '2');

-- ----------------------------
-- Table structure for `menus`
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `component` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `hidden` tinyint(4) DEFAULT NULL,
  `redirect` varchar(255) DEFAULT NULL,
  `always_show` tinyint(4) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `keepalive` tinyint(4) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES ('1', '用户管理', 'USER_MANAGE', '/user', '/Layout', 'user', 'user', '0', '/user/userinfo', '1', '1', '0', '0', null, null, null, null);
INSERT INTO `menus` VALUES ('2', '角色管理', 'USER_MANAGE', '/role', '/Layout', 'people', 'role', '0', '/role/roleinfo', '1', '1', '0', '0', null, null, null, null);
INSERT INTO `menus` VALUES ('3', '权限管理', 'USER_MANAGE', '/menu', '/Layout', 'TreeMean', 'menu', '0', '/menu/menuinfo', '1', '1', '0', '0', null, null, null, null);
INSERT INTO `menus` VALUES ('4', '用户信息', 'USER_MANAGE', 'userinfo', '/user/userinfo', 'shizhan', 'userinfo', '0', null, '1', '1', '0', '1', null, null, null, null);
INSERT INTO `menus` VALUES ('5', '角色信息', 'USER_MANAGE', 'roleinfo', '/role/roleinfo', 'shizhan', 'roleinfo', '0', 'undefined', '1', '1', '0', '2', null, null, null, null);
INSERT INTO `menus` VALUES ('6', '权限信息', 'USER_MANAGE', 'menuinfo', '/menu/menuinfo', 'list', 'menuinfo', '0', null, '1', '0', '0', '3', null, null, null, null);
INSERT INTO `menus` VALUES ('27', '权限测试', 'MENU_TEST', 'permissions', '/menu/permissions', 'list', 'permissions', '0', '/menu/permissions', '1', '1', '0', '3', null, null, null, null);
INSERT INTO `menus` VALUES ('46', '账户管理', 'ACCOUNT_MANAGE', 'account/accountinfo', '/account/accountinfo', 'user', 'accountinfo', '0', 'undefined', '1', '1', '0', '1', null, null, null, null);

-- ----------------------------
-- Table structure for `roles`
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', 'ROLE_ADMIN', '超级管理员');
INSERT INTO `roles` VALUES ('2', 'ROLE_EDITOR', '普通管理员');

-- ----------------------------
-- Table structure for `roles_menus`
-- ----------------------------
DROP TABLE IF EXISTS `roles_menus`;
CREATE TABLE `roles_menus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rid` bigint(20) DEFAULT NULL,
  `mid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of roles_menus
-- ----------------------------
INSERT INTO `roles_menus` VALUES ('5', '3', '4');
INSERT INTO `roles_menus` VALUES ('32', '2', '7');
INSERT INTO `roles_menus` VALUES ('33', '2', '8');
INSERT INTO `roles_menus` VALUES ('71', '1', '1');
INSERT INTO `roles_menus` VALUES ('72', '1', '4');
INSERT INTO `roles_menus` VALUES ('73', '1', '46');
INSERT INTO `roles_menus` VALUES ('74', '1', '2');
INSERT INTO `roles_menus` VALUES ('75', '1', '5');
INSERT INTO `roles_menus` VALUES ('76', '1', '3');
INSERT INTO `roles_menus` VALUES ('77', '1', '6');
INSERT INTO `roles_menus` VALUES ('78', '1', '27');

-- ----------------------------
-- Table structure for `roles_permission`
-- ----------------------------
DROP TABLE IF EXISTS `roles_permission`;
CREATE TABLE `roles_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rid` bigint(20) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of roles_permission
-- ----------------------------
INSERT INTO `roles_permission` VALUES ('50', '2', '1');
INSERT INTO `roles_permission` VALUES ('51', '2', '2');
INSERT INTO `roles_permission` VALUES ('52', '2', '3');
INSERT INTO `roles_permission` VALUES ('53', '2', '7');
INSERT INTO `roles_permission` VALUES ('54', '2', '8');
INSERT INTO `roles_permission` VALUES ('71', '1', '1');
INSERT INTO `roles_permission` VALUES ('72', '1', '4');
INSERT INTO `roles_permission` VALUES ('73', '1', '5');
INSERT INTO `roles_permission` VALUES ('74', '1', '6');
INSERT INTO `roles_permission` VALUES ('75', '1', '7');
INSERT INTO `roles_permission` VALUES ('76', '1', '8');
INSERT INTO `roles_permission` VALUES ('77', '1', '9');
INSERT INTO `roles_permission` VALUES ('78', '1', '10');
INSERT INTO `roles_permission` VALUES ('79', '1', '11');
INSERT INTO `roles_permission` VALUES ('80', '1', '12');
INSERT INTO `roles_permission` VALUES ('81', '1', '13');
INSERT INTO `roles_permission` VALUES ('82', '1', '14');
INSERT INTO `roles_permission` VALUES ('83', '1', '16');
INSERT INTO `roles_permission` VALUES ('84', '1', '17');
INSERT INTO `roles_permission` VALUES ('85', '1', '20');
INSERT INTO `roles_permission` VALUES ('86', '1', '21');
INSERT INTO `roles_permission` VALUES ('87', '1', '2');
INSERT INTO `roles_permission` VALUES ('88', '1', '3');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_del` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '超级游客', '123123', '我是超级管理员', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '17600363566', '1', '2018-05-02 16:04:09', '18', '沙河', null, null, null, null, '0');
INSERT INTO `users` VALUES ('2', '普通游客', '123456', '普通游客', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '13522586127', '0', '2018-08-10 10:40:16', '43', '昌平fds ', null, null, null, null, '0');
