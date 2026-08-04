-- Constructing SQL Aggregate Queries 

-- Query 1: Overall Order Metrics
select count(distinct order_id), avg(unit_price * quantity)
from order_items 
group by order_id 

-- Query 2: Order Summaries per customer 
select c.customer_id, c.customer_name, count(o.order_id) as num_orders
from customers c
left join orders o 
on c.customer_id = o.customer_id 
group by c.customer_id, c.customer_name
order by "NumOrders" desc; 

-- Query 3: High-Value Customers 
select c.customer_id, c.customer_name 
from customers c 
left join orders o 
on c.customer_id = o.customer_id 
left join order_items i 
on o.order_id = i.order_id 
group by c.customer_id, c.customer_name
having sum(i.quantity * i.unit_price) > 150

-- Query 4: Inventory Analysis 
select max(price) as highest_price, min(price) as lowest_price, 
avg(price) as average_price, COUNT(distinct product_name) as unique_count 
from products 

-- Query 5: Top-Selling Products 
select p.product_name, sum(o.quantity) as total_sold 
from order_items o  
join products p  
on o.product_id = p.product_id  
group by p.product_name  
order by sum(o.quantity) desc 
limit 3 


