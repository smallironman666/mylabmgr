# MyLabMgr - 实验室管理系统

基于 Java 的实验室资源管理系统，采用经典 MVC 架构设计。

## 功能特性

- **用户认证**：安全的登录/登出功能，支持会话管理
- **资源管理**：完整的增删改查（CRUD）操作
- **分页展示**：高效的数据浏览，支持自定义每页显示条数
- **搜索筛选**：支持按名称、价格范围等多条件搜索
- **会话追踪**：在线用户统计和会话管理

## 技术栈

| 组件 | 技术 |
|------|------|
| 后端 | Java Servlet 4.0 |
| ORM | MyBatis 3.5.2 |
| 视图 | JSP + JSTL |
| 数据库 | MySQL 8.0+ |
| 日志 | Log4j 2.x |
| 构建 | Maven |

## 系统架构

```
┌─────────────────────────────────────────────────────────────┐
│                        表现层 (View)                         │
│                      JSP + JSTL 页面                         │
├─────────────────────────────────────────────────────────────┤
│                      控制层 (Controller)                     │
│                       Java Servlet                           │
├─────────────────────────────────────────────────────────────┤
│                      业务层 (Service)                        │
│                        业务逻辑实现                           │
├─────────────────────────────────────────────────────────────┤
│                      数据层 (DAO)                            │
│                     MyBatis Mapper                           │
├─────────────────────────────────────────────────────────────┤
│                        数据库                                │
│                        MySQL                                 │
└─────────────────────────────────────────────────────────────┘
```

## 项目结构

```
mylabmgr/
├── java/
│   └── com/quercus/
│       ├── servlet/          # 控制器（处理 HTTP 请求）
│       ├── service/          # 业务逻辑层
│       │   └── impl/         # 服务实现类
│       ├── mapper/           # MyBatis 数据访问层
│       ├── pojo/             # 数据模型（User、Flower）
│       └── util/             # 工具类
├── webapp/
│   ├── WEB-INF/
│   │   ├── web.xml           # Web 应用配置
│   │   └── lib/              # 依赖库
│   └── *.jsp                 # 视图模板
├── resources/
│   ├── mybatis.xml           # MyBatis 配置
│   ├── jdbc.properties       # 数据库连接配置
│   └── log4j.properties      # 日志配置
├── sql/
│   └── init.sql              # 数据库初始化脚本
└── pom.xml                   # Maven 构建配置
```

## 环境要求

- JDK 8 或更高版本
- Apache Tomcat 9.x 或兼容的 Servlet 容器
- MySQL 8.0+
- Maven 3.6+

## 快速开始

### 1. 克隆仓库

```bash
git clone https://github.com/yourusername/mylabmgr.git
cd mylabmgr
```

### 2. 初始化数据库

```bash
# 创建数据库和表
mysql -u root -p < sql/init.sql
```

### 3. 配置数据库连接

复制配置模板并填写数据库信息：

```bash
cp resources/jdbc.properties.template resources/jdbc.properties
```

编辑 `resources/jdbc.properties`：

```properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/mylabmgr?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
user=你的用户名
pwd=你的密码
```

### 4. 构建项目

```bash
mvn clean package
```

### 5. 部署到 Tomcat

将生成的 WAR 文件复制到 Tomcat 的 webapps 目录：

```bash
cp target/mylabmgr.war $TOMCAT_HOME/webapps/
```

### 6. 访问应用

打开浏览器访问：

```
http://localhost:8080/mylabmgr/login.jsp
```

默认测试账号：`admin` / `123456`

## API 接口

| 接口 | 方法 | 说明 |
|------|------|------|
| `/UserLoginServlet` | POST | 用户登录 |
| `/LoginOutSevlet` | GET | 用户登出 |
| `/FindAllFlower` | GET | 查询所有资源（分页） |
| `/FindOneFlower` | GET | 查询单个资源 |
| `/SaveFlower` | POST | 添加资源 |
| `/ChangeFlower` | POST | 修改资源 |
| `/RemoveFlower` | GET | 删除资源 |

## 配置说明

### MyBatis 配置

MyBatis 配置文件位于 `resources/mybatis.xml`，主要配置：

- 数据库连接池（POOLED 类型）
- Log4j 日志集成
- POJO 类型别名

### 日志配置

日志通过 `resources/log4j.properties` 配置：

- 日志级别：DEBUG
- 输出方式：控制台 + 文件

## 开发指南

### 从源码构建

```bash
# 编译
mvn compile

# 运行测试
mvn test

# 打包
mvn package

# 清理并安装
mvn clean install
```

### 代码规范

本项目遵循标准 Java 编码规范：

- 使用有意义的变量和方法命名
- 为公共方法添加 JavaDoc 注释
- 遵循 MVC 分层设计原则

## 参与贡献

欢迎贡献代码！请阅读 [CONTRIBUTING.md](CONTRIBUTING.md) 了解贡献流程和代码规范。

## 开源许可

本项目采用 MIT 许可证，详见 [LICENSE](LICENSE) 文件。

## 更新日志

### v1.0.0 (2021-12)

- 首次发布
- 用户认证系统
- 基础 CRUD 操作
- 分页功能
- 搜索筛选功能

## 作者

- **quercus** - *初始开发*

## 致谢

- MyBatis 社区提供的优秀 ORM 框架
- Apache 软件基金会提供的 Tomcat 及相关工具
