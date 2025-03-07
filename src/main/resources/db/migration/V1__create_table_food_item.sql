CREATE TABLE tb_food_item (
    id serial PRIMARY KEY,
    name varchar(255) NOT NULL,
    category varchar(100) NOT NULL,
    quantity INT NOT NULL,
    validity DATE NOT NULL
);