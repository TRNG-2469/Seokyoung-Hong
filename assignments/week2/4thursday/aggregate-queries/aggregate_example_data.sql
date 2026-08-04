-- Sample data used for customers, products, orders, order ids 

CREATE TABLE customers (
    customer_id SERIAL PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    membership_tier VARCHAR(20) DEFAULT 'BRONZE'
);


CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    price NUMERIC(10,2) NOT NULL CHECK (price >= 0),
    stock_quantity INT NOT NULL CHECK (stock_quantity >= 0)
);

CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL REFERENCES customers(customer_id),
    order_date DATE NOT NULL,
    status VARCHAR(20) DEFAULT 'PENDING'
);

CREATE TABLE order_items (
    order_item_id SERIAL PRIMARY KEY,
    order_id INT NOT NULL REFERENCES orders(order_id),
    product_id INT NOT NULL REFERENCES products(product_id),
    quantity INT NOT NULL CHECK (quantity > 0),
    unit_price NUMERIC(10,2) NOT NULL CHECK (unit_price >= 0)
);

INSERT INTO customers (customer_name, email, membership_tier)
VALUES
('Alice Johnson', 'alice@email.com', 'GOLD'),
('Bob Smith', 'bob@email.com', 'SILVER'),
('Carol Davis', 'carol@email.com', 'BRONZE'),
('David Wilson', 'david@email.com', 'GOLD'),
('Emily Brown', 'emily@email.com', 'SILVER');

INSERT INTO products (product_name, price, stock_quantity)
VALUES
('Laptop', 1200.00, 10),
('Wireless Mouse', 30.00, 100),
('Mechanical Keyboard', 85.00, 50),
('Monitor', 250.00, 20),
('USB-C Hub', 45.00, 75),
('Headphones', 150.00, 30);

INSERT INTO orders (customer_id, order_date, status)
VALUES
(1, '2026-07-20', 'DELIVERED'),
(2, '2026-07-21', 'DELIVERED'),
(1, '2026-07-22', 'SHIPPED'),
(3, '2026-07-23', 'PENDING'),
(4, '2026-07-23', 'DELIVERED'),
(5, '2026-07-24', 'DELIVERED'),
(2, '2026-07-24', 'DELIVERED');

INSERT INTO order_items (order_id, product_id, quantity, unit_price)
VALUES
(1, 1, 1, 1200.00),
(1, 2, 2, 30.00),

(2, 3, 1, 85.00),
(2, 5, 2, 45.00),

(3, 4, 1, 250.00),
(3, 2, 1, 30.00),

(4, 6, 1, 150.00),

(5, 1, 1, 1200.00),
(5, 5, 3, 45.00),

(6, 3, 2, 85.00),
(6, 6, 1, 150.00),

(7, 2, 5, 30.00),
(7, 5, 1, 45.00);