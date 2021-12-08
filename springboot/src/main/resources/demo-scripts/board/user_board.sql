DROP TABLE IF EXISTS USER_BOARD;
CREATE TABLE `USER_BOARD` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
    `title` varchar(30) DEFAULT NULL COMMENT 'Title',
    `contents` varchar(255) DEFAULT NULL COMMENT 'Contents',
    `views` int DEFAULT '0' COMMENT 'Views',
    `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'is deleted',
    `create_id` varchar(20) DEFAULT NULL COMMENT 'Creator Id',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Create Time',
    `update_id` varchar(20) DEFAULT NULL COMMENT 'Updater Id',
    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update Time',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='User Board'
;