delete from user;

INSERT IGNORE INTO `user`
(`id`, `name`,      `age`,  `email`,         `create_at`   )
VALUES
(   1,   'luo',       4,    'test1.com',      UNIX_TIMESTAMP()),
(   2,   'tj',        5,    'test2.com',      UNIX_TIMESTAMP()),
(   3,   'tangel',    6,    'test3.com',      UNIX_TIMESTAMP()),
(   4,   'hello',     7,    'test4.com',      UNIX_TIMESTAMP()),
(   5,   'jooq',      8,    'test5.com',      UNIX_TIMESTAMP()),
(   6,   'flyway',    9,    'test6.com',      UNIX_TIMESTAMP());