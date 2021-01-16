CREATE TABLE users (
	user_id INT PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(50),
    first_name VARCHAR(100),
    last_name VARCHAR(100)
);

CREATE TABLE task_options (
	test_task_option_id INT PRIMARY KEY,
    task_option_value VARCHAR(255)
);

CREATE TABLE test_bases (
	test_base_id INT PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR(100),
    owner_id INT,
	created_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE test_results (
	test_result_id INT PRIMARY KEY,
    user_id INT,
    completed_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE test_results_tasks (
	test_result INT,
    task_id INT,
    response_id INT
);

CREATE TABLE test_tasks (
	test_task_id INT PRIMARY KEY,
    test_task_type INT NOT NULL,
    test_question VARCHAR(255),
    test_base INT,
    is_correct BOOLEAN DEFAULT FALSE,
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE test_tasks_types (
	test_task_type_id INT PRIMARY KEY,
    name VARCHAR(100),
    one_option_correct BOOLEAN DEFAULT FALSE,
    several_option_correct BOOLEAN DEFAULT FALSE,
    yes_or_no BOOLEAN DEFAULT FALSE,
    is_short_response BOOLEAN DEFAULT FALSE
);

CREATE TABLE test_tasks_with_options (
	test_task_id INT,
    option_id INT
);


