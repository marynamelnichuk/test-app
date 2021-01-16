USE tests_db;
CREATE TABLE test_results (
	test_result_id INT PRIMARY KEY,
    user_id INT,
    completed_date DATETIME DEFAULT CURRENT_TIMESTAMP
);
