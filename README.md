# springboot-vue
根据老师需求模仿运满满app
+ 前端技术栈(待补充)
  + vue
+ 后端技术栈
  + springboot
  + mybatis

### 基本环境需求
+ mysql数据库
+ vue安装（vue前装好node.js开发环境）
+ springboot开发环境


### 使用前注意
+ 确认pom.xml中的数据库版本号和主机使用的版本号是否一致
+ 在数据库中创建表login
    ```
        create database login;
    ```
+ 在表中创建数据结构
    ```
        用户数据表
        use login;
        CREATE TABLE IF NOT EXISTS `user` (
        `id` bigint(32) NOT NULL AUTO_INCREMENT,
        `username` varchar(255) DEFAULT NULL,
        `password` varchar(255) DEFAULT NULL,
        `UserPhone` bigint(32) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
        
        订单数据表
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

+ 跑服务（建议在终端中进行相应服务）
    + 在spring项目中下载好依赖（vscode的话右击maven下面的项目install就可以如果不进行这一步下面直接运行时也会自动下载依赖）
    + 进入货主端
        ```
            cd yun-item
            npm run serve
        ```
    + 进入司机端
        ```
            cd yun-driver
            npm run serve
        ```
    + 进入后端(第一次运行可能有点慢，配置springboot开发环境的步骤这里省略)
        ``` 
            cd yun-spring
            mvn spring-boot:run
        ```
+ 之后再浏览器根据item和driver前端反馈的地址进行访问是localhost:8080和8081（端口配置在vue.config.js中也可以删除让它选择默认端口，基本上也是8080和8081）
    

+ yun-item表示货主端的应用
+ yun-driver表示司机端的应用

+ 工作流程
    + 用户注册
    + 用户手机号认证（我的--myhome页面），订单是根据用户的电话来进行筛选的，所以在执行操作前必须先进行认证，填入手机号后点击上方未认证就可以完成认证，随意修改
    + 注意，测试起码需要两个用户，你可别两个用户名都一样，就算用户名一样你的手机号也别一样，正常情况没有两个手机号是一致的，虽然后端做了用户名匹配，不允许同名用户出现，手机号别出拐子，别问我为什么手机号不进行冲突检测，我懒
    + 货主端在发货页（对应item-page.vue处代码），点击发货按钮，填入相应字段，前端将会将这些字段包含用户名，用户号码发送至后端处理
    + 订单生成后的状态为1会在司机端的当天货源中显示，点击橙色图标订单状态会进行更改，变为状态2待确定状态
    + 货主端在订单-未确认处点击橙色图标完成订单状态更改为运输中
    + 司机端运输完成后再订单-运输中进行更改，订单状态改为未支付
    + 货主端支付完成订单状态改为未评价，评价点击完成后流程结束
