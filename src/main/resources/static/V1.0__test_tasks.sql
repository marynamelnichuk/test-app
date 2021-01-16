USE tests_db;
CREATE TABLE test_tasks (
	test_task_id INT PRIMARY KEY,
    test_task_type INT NOT NULL,
    test_question VARCHAR(255),
    test_base INT,
    is_correct BOOLEAN DEFAULT FALSE,
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP
);
