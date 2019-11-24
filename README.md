# springboot-vue
根据老师需求模仿运满满app
+ 前端技术栈(待补充)
  + vue
  + axios
+ 后端技术栈（目前的后端是clone别人的，调整了一下和前端匹配号就拿来用了，待补充）
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
        CREATE TABLE `user` (
        `id` bigint(32) NOT NULL AUTO_INCREMENT,
        `username` varchar(255) DEFAULT NULL,
        `password` varchar(255) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    ```
+ 将application.yml中的数据库用户名与密码与本机的数据库匹配
