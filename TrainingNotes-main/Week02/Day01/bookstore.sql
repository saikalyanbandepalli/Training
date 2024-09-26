-- Drop existing tables if they exist
DROP TABLE IF EXISTS order_details;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS books;

-- Create Authors Table
CREATE TABLE authors (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    biography TEXT
);

-- Create Books Table
CREATE TABLE books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_id INT NOT NULL,
    genre VARCHAR(50),
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (author_id) REFERENCES authors(author_id)
);

-- Create Customers Table
CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    shipping_address TEXT
);

-- Create Orders Table
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    order_date DATE NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    status ENUM('pending', 'shipped', 'delivered') DEFAULT 'pending',
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

-- Create Order Details Table
CREATE TABLE order_details (
    order_id INT,
    book_id INT,
    quantity INT,
    PRIMARY KEY (order_id, book_id),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (book_id) REFERENCES books(book_id)
);

-- Create Inventory Table
CREATE TABLE inventory (
    book_id INT PRIMARY KEY,
    quantity INT DEFAULT 0,
    FOREIGN KEY (book_id) REFERENCES books(book_id)
);

-- Insert Sample Data (Optional)
INSERT INTO authors (name, biography) VALUES
    ('J.K. Rowling', 'British author, best known for the Harry Potter series.'),
    ('Stephen King', 'American author of horror, supernatural fiction, suspense, crime, science-fiction, and fantasy novels.'),
    ('Agatha Christie', 'English writer known for her detective novels.');

INSERT INTO books (title, author_id, genre, price) VALUES
    ('Harry Potter and the Philosopher''s Stone', 1, 'Fantasy', 15.99),
    ('Harry Potter and the Chamber of Secrets', 1, 'Fantasy', 16.99),
    ('Harry Potter and the Prisoner of Azkaban', 1, 'Fantasy', 17.99),
    ('The Shining', 2, 'Horror', 12.99),
    ('It', 2, 'Horror', 14.99),
    ('Murder on the Orient Express', 3, 'Mystery', 10.99);

INSERT INTO customers (email, name, shipping_address) VALUES
    ('john.doe@example.com', 'John Doe', '123 Main St, Anytown, USA'),
    ('jane.smith@example.com', 'Jane Smith', '456 Oak Ave, Somewhere, USA');

INSERT INTO orders (customer_id, order_date, total_amount, status) VALUES
    (1, '2024-06-25', 32.98, 'shipped'),
    (2, '2024-06-26', 10.99, 'delivered');

INSERT INTO order_details (order_id, book_id, quantity) VALUES
    (1, 1, 1),
    (1, 2, 1),
    (2, 6, 1);

INSERT INTO inventory (book_id, quantity) VALUES
    (1, 10),
    (2, 5),
    (3, 8),
    (4, 3),
    (5, 7),
    (6, 12);
