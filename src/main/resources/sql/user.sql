-- jan_dev.`user` definition

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_nm` varchar(100) DEFAULT NULL,
  `user_pas` varchar(100) DEFAULT NULL,
  `user_log` varchar(100) DEFAULT NULL,
  `user_del` varchar(100) DEFAULT NULL,
  `user_creatTime` datetime DEFAULT NULL,
  `user_tel` varchar(100) DEFAULT NULL,
  `user_mail` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;