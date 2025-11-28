# Contributing to MyLabMgr

Thank you for your interest in contributing to MyLabMgr! This document provides guidelines and steps for contributing.

## Code of Conduct

By participating in this project, you agree to maintain a respectful and inclusive environment for everyone.

## How to Contribute

### Reporting Bugs

Before creating a bug report, please check existing issues to avoid duplicates.

When creating a bug report, include:

- **Clear title** describing the issue
- **Steps to reproduce** the behavior
- **Expected behavior** vs actual behavior
- **Environment details** (Java version, Tomcat version, OS, etc.)
- **Screenshots** if applicable

### Suggesting Features

Feature requests are welcome! Please:

1. Check if the feature has already been requested
2. Provide a clear description of the feature
3. Explain the use case and benefits
4. Consider how it fits with the project's goals

### Pull Requests

1. **Fork** the repository
2. **Create a branch** for your feature or fix:
   ```bash
   git checkout -b feature/your-feature-name
   # or
   git checkout -b fix/issue-description
   ```
3. **Make your changes** following our coding standards
4. **Test** your changes thoroughly
5. **Commit** with clear, descriptive messages:
   ```bash
   git commit -m "Add: brief description of the feature"
   # or
   git commit -m "Fix: brief description of the fix"
   ```
6. **Push** to your fork:
   ```bash
   git push origin feature/your-feature-name
   ```
7. **Create a Pull Request** against the `main` branch

## Development Setup

### Prerequisites

- JDK 8 or higher
- Maven 3.6+
- MySQL 8.0+
- Apache Tomcat 9.x

### Local Development

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/mylabmgr.git
   cd mylabmgr
   ```

2. Set up the database:
   ```bash
   mysql -u root -p < sql/init.sql
   ```

3. Configure database connection:
   ```bash
   cp resources/jdbc.properties.template resources/jdbc.properties
   # Edit jdbc.properties with your database credentials
   ```

4. Build the project:
   ```bash
   mvn clean compile
   ```

5. Deploy to Tomcat and test

## Coding Standards

### Java Code Style

- Use **4 spaces** for indentation (no tabs)
- Follow **Java naming conventions**:
  - Classes: `PascalCase`
  - Methods/variables: `camelCase`
  - Constants: `UPPER_SNAKE_CASE`
- Add **JavaDoc** comments for public classes and methods
- Keep methods **focused and concise**

### Example

```java
/**
 * Retrieves a flower by its unique identifier.
 *
 * @param id the unique identifier of the flower
 * @return the Flower object, or null if not found
 */
public Flower findFlowerById(Integer id) {
    // Implementation
}
```

### Commit Messages

Use clear, descriptive commit messages:

- `Add:` for new features
- `Fix:` for bug fixes
- `Update:` for modifications to existing features
- `Remove:` for deleted code/features
- `Refactor:` for code restructuring
- `Docs:` for documentation changes

### File Organization

- Place Java source files in appropriate packages under `java/com/quercus/`
- Keep JSP files in `webapp/`
- Configuration files go in `resources/`
- SQL scripts belong in `sql/`

## Testing

Before submitting a PR:

1. Ensure the project builds without errors:
   ```bash
   mvn clean compile
   ```

2. Test all affected functionality manually

3. Verify no regression in existing features

## Questions?

Feel free to open an issue for any questions about contributing.

Thank you for contributing to MyLabMgr!
