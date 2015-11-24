
Создание таблицы

CREATE TABLE `User` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL DEFAULT '',
  `age` int(8) unsigned NOT NULL,
  `isAdmin` bit NOT NULL,
  `createdDate` timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

Заполнение данными

INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (5,'Kolya',45,false,'2015-11-23 12:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (55,'Gena',45,true,'2015-11-03 08:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (1,'ter',45,false,'2015-11-23 12:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (2,'ert',45,true,'2015-11-03 08:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (3,'dfg',45,false,'2015-11-23 12:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (4,'cvb',45,true,'2015-11-03 08:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (6,'dfg',45,false,'2015-11-23 12:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (7,'rty',45,true,'2015-11-03 08:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (8,'fgh',45,false,'2015-11-23 12:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (9,'mbnm',45,true,'2015-11-03 08:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (10,'fgh',45,false,'2015-11-23 12:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (11,'Gertytna',45,true,'2015-11-03 08:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (12,'rty',45,false,'2015-11-23 12:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (13,'t',45,true,'2015-11-03 08:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (14,'rty',45,false,'2015-11-23 12:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (15,'Grtyena',45,true,'2015-11-03 08:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (16,'Koqwelya',45,false,'2015-11-23 12:23:46');
INSERT INTO `User`(`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES (17,'Geiopna',45,true,'2015-11-03 08:23:46');

Имя БД: test
Пользователь: root
Пароль: root
