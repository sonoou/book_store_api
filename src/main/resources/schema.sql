-- Drop tables if they exist (clean start)
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

-- Create authors table
CREATE TABLE authors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    bio VARCHAR(500),
    nationality VARCHAR(50),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

-- Create books table
CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    isbn VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(1000),
    publication_year INT,
    price DECIMAL(10,2),
    genre VARCHAR(50),
    page_count INT,
    publisher VARCHAR(100),
    author_id BIGINT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);