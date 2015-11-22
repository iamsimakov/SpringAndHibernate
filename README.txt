
Создание таблицы

CREATE TABLE `User` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL DEFAULT '',
  `age` int(8) unsigned NOT NULL,
  `isAdmin` bit NOT NULL,
  `createDate` timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createDate`) VALUES (5,'Kolya',45,false,'2015-11-23 12:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createDate`) VALUES (5,'Gena',45,true,'2015-11-03 08:23:46');

http://localhost:8080/SpringMVCHibernate/users