USE tests_db;
CREATE TABLE test_tasks_types (
	test_taks_type_id INT PRIMARY KEY,
    name VARCHAR(100),
    one_option_correct BOOLEAN DEFAULT FALSE,
    several_option_correct BOOLEAN DEFAULT FALSE,
    yes_or_no BOOLEAN DEFAULT FALSE,
    is_short_response BOOLEAN DEFAULT FALSE
);
