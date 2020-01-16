# springboot-vue
根据老师需求模仿运满满app
+ 前端技术栈(待补充)
  + vue
  + axios
  + mock(老师要看前端生活所迫。。。)
+ 后端技术栈
  + springboot
  + mybatis

### 使用前注意
+ 确认pom.xml中的数据库版本号和主机使用的版本号是否一致
+ 在数据库中创建表login
    ```
        create database login;
    ```
+ 在表中创建数据结构
    ```
        use login;
        CREATE TABLE IF NOT EXISTS `user` (
        `id` bigint(32) NOT NULL AUTO_INCREMENT,
        `username` varchar(255) DEFAULT NULL,
        `password` varchar(255) DEFAULT NULL,
        `UserPhone` bigint(32) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
        
        CREATE TABLE IF NOT EXISTS `order` (
            `id` bigint(32) NOT NULL AUTO_INCREMENT,
            `ItemName` varchar(20) DEFAULT NULL,
            `ItemerName` varchar(20) DEFAULT NULL,
            `ItemerPhone` bigint(32) DEFAULT NULL,
            `DriverName` varchar(20) DEFAULT NULL,
            `DriverPhone` bigint(32) DEFAULT NULL,
            `CarSize` varchar(30) DEFAULT NULL,
            `OrderStatus` int(5) DEFAULT 1, 
            `Origin` varchar(10) DEFAULT NULL,
            `Destination` varchar(10) DEFAULT NULL,
            PRIMARY KEY (`id`)
        )ENGINE=InnoDB DEFAULT CHARSET=utf8;
    ```
+ 将application.yml中的数据库用户名与密码与本机的数据库匹配

+ 使用mock服务
    ```
        cd mockServer
        node server.js
    ```
