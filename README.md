# MyLabMgr - Laboratory Management System

A Java-based laboratory management system for managing laboratory resources, built with classic MVC architecture.

## Features

- **User Authentication**: Secure login/logout functionality with session management
- **Resource Management**: Complete CRUD operations for laboratory resources
- **Pagination Support**: Efficient data browsing with configurable page sizes
- **Search & Filter**: Multi-condition search by name, price range, etc.
- **Session Tracking**: Online user count and session management

## Tech Stack

| Component | Technology |
|-----------|------------|
| Backend | Java Servlet 4.0 |
| ORM | MyBatis 3.5.2 |
| View | JSP + JSTL |
| Database | MySQL 8.0+ |
| Logging | Log4j 2.x |
| Build | Maven |

## Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                      Presentation Layer                      │
│                    (JSP + JSTL Views)                        │
├─────────────────────────────────────────────────────────────┤
│                      Controller Layer                        │
│                   (Java Servlets)                            │
├─────────────────────────────────────────────────────────────┤
│                       Service Layer                          │
│               (Business Logic Implementation)                │
├─────────────────────────────────────────────────────────────┤
│                    Data Access Layer                         │
│                  (MyBatis Mappers)                           │
├─────────────────────────────────────────────────────────────┤
│                        Database                              │
│                       (MySQL)                                │
└─────────────────────────────────────────────────────────────┘
```

## Project Structure

```
mylabmgr/
├── java/
│   └── com/quercus/
│       ├── servlet/          # Controllers (HTTP request handlers)
│       ├── service/          # Business logic layer
│       │   └── impl/         # Service implementations
│       ├── mapper/           # MyBatis data access layer
│       ├── pojo/             # Data models (User, Flower)
│       └── util/             # Utility classes
├── webapp/
│   ├── WEB-INF/
│   │   ├── web.xml           # Web application configuration
│   │   └── lib/              # Dependencies
│   └── *.jsp                 # View templates
├── resources/
│   ├── mybatis.xml           # MyBatis configuration
│   ├── jdbc.properties       # Database connection (use template)
│   └── log4j.properties      # Logging configuration
├── sql/
│   └── init.sql              # Database initialization script
└── pom.xml                   # Maven build configuration
```

## Prerequisites

- JDK 8 or higher
- Apache Tomcat 9.x or compatible servlet container
- MySQL 8.0+
- Maven 3.6+

## Quick Start

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/mylabmgr.git
cd mylabmgr
```

### 2. Database Setup

```bash
# Create database and tables
mysql -u root -p < sql/init.sql
```

### 3. Configure Database Connection

Copy the template configuration and update with your database credentials:

```bash
cp resources/jdbc.properties.template resources/jdbc.properties
```

Edit `resources/jdbc.properties`:

```properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/mylabmgr?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai
user=your_username
pwd=your_password
```

### 4. Build the Project

```bash
mvn clean package
```

### 5. Deploy to Tomcat

Copy the generated WAR file to Tomcat's webapps directory:

```bash
cp target/mylabmgr.war $TOMCAT_HOME/webapps/
```

### 6. Access the Application

Open your browser and navigate to:

```
http://localhost:8080/mylabmgr/login.jsp
```

## API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/UserLoginServlet` | POST | User authentication |
| `/LoginOutSevlet` | GET | User logout |
| `/FindAllFlower` | GET | List all resources (paginated) |
| `/FindOneFlower` | GET | Get single resource by ID |
| `/SaveFlower` | POST | Create new resource |
| `/ChangeFlower` | POST | Update existing resource |
| `/RemoveFlower` | GET | Delete resource by ID |

## Configuration

### MyBatis Configuration

The MyBatis configuration is located in `resources/mybatis.xml`. Key settings:

- Connection pooling (POOLED)
- Log4j integration for SQL logging
- Type aliases for POJO classes

### Logging

Logging is configured via `resources/log4j.properties`. Default settings:

- Log level: DEBUG
- Output: Console + File

## Development

### Building from Source

```bash
# Compile
mvn compile

# Run tests
mvn test

# Package
mvn package

# Clean build
mvn clean install
```

### Code Style

This project follows standard Java coding conventions:

- Use meaningful variable and method names
- Add JavaDoc comments for public methods
- Follow MVC separation of concerns

## Contributing

Contributions are welcome! Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Changelog

### v1.0.0 (2021-12)

- Initial release
- User authentication system
- Basic CRUD operations
- Pagination support
- Search and filter functionality

## Author

- **quercus** - *Initial work*

## Acknowledgments

- MyBatis community for the excellent ORM framework
- Apache Software Foundation for Tomcat and related tools
