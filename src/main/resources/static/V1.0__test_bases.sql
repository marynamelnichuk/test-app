USE tests_db;
CREATE TABLE test_bases (
	test_base_id INT PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR(100),
    owner_id INT,
	created_date DATETIME DEFAULT CURRENT_TIMESTAMP
);