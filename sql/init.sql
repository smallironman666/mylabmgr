-- MyLabMgr Database Initialization Script
-- Run this script to set up the database schema

-- Create database
CREATE DATABASE IF NOT EXISTS mylabmgr
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;

USE mylabmgr;

-- Create user table
CREATE TABLE IF NOT EXISTS `user` (
    `uid` INT PRIMARY KEY AUTO_INCREMENT COMMENT 'User ID',
    `uname` VARCHAR(50) NOT NULL COMMENT 'Username',
    `pwd` VARCHAR(100) NOT NULL COMMENT 'Password',
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation time',
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
    UNIQUE KEY `uk_uname` (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='User table';

-- Create flower (resource) table
CREATE TABLE IF NOT EXISTS `flower` (
    `id` INT PRIMARY KEY AUTO_INCREMENT COMMENT 'Resource ID',
    `name` VARCHAR(100) NOT NULL COMMENT 'Resource name',
    `price` DECIMAL(10, 2) NOT NULL DEFAULT 0.00 COMMENT 'Price',
    `production` VARCHAR(200) COMMENT 'Production place / Description',
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation time',
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
    INDEX `idx_name` (`name`),
    INDEX `idx_price` (`price`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Resource table';

-- Insert sample data for testing

-- Sample users (password: 123456)
INSERT INTO `user` (`uname`, `pwd`) VALUES
    ('admin', '123456'),
    ('user1', '123456'),
    ('user2', '123456');

-- Sample resources
INSERT INTO `flower` (`name`, `price`, `production`) VALUES
    ('Rose', 25.00, 'Yunnan, China'),
    ('Tulip', 18.50, 'Netherlands'),
    ('Sunflower', 12.00, 'United States'),
    ('Lily', 30.00, 'Japan'),
    ('Orchid', 45.00, 'Thailand'),
    ('Carnation', 15.00, 'Spain'),
    ('Lavender', 20.00, 'France'),
    ('Jasmine', 22.00, 'India'),
    ('Chrysanthemum', 16.00, 'China'),
    ('Peony', 35.00, 'China'),
    ('Daisy', 10.00, 'England'),
    ('Hydrangea', 28.00, 'Japan'),
    ('Magnolia', 40.00, 'Southern USA'),
    ('Iris', 18.00, 'Mediterranean'),
    ('Camellia', 32.00, 'East Asia');

-- Grant privileges (adjust as needed)
-- GRANT ALL PRIVILEGES ON mylabmgr.* TO 'your_user'@'localhost';
-- FLUSH PRIVILEGES;
