USE tests_db;
CREATE TABLE users (
	user_id INT PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(50),
    first_name VARCHAR(100),
    last_name VARCHAR(100)
);
