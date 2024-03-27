create table if not exists order_tb(
    id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description VARCHAR,
    person_id INT NOT NULL,
    order_created_date TIMESTAMP
)