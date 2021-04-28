CREATE TABLE users (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(50),
    first_name VARCHAR(100),
    last_name VARCHAR(100)
);

CREATE TABLE test_bases (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    category VARCHAR(100),
    description VARCHAR(100),
    owner_id INT  NOT NULL,
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT FK_User_TestBases FOREIGN KEY (owner_id) REFERENCES users(id)
);

CREATE TABLE test_tasks_types (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    type VARCHAR(100)
);

CREATE TABLE test_base_tasks (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    question VARCHAR(1024),
    test_base_id INT NOT NULL,
    task_type_id INT NOT NULL,
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT FK_TestBase_Tasks FOREIGN KEY (test_base_id) REFERENCES test_bases(id),
	CONSTRAINT FK_TestBase_Types FOREIGN KEY (task_type_id) REFERENCES test_tasks_types(id)
);

CREATE TABLE task_options (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    option_value VARCHAR(255),
    test_base_task_id INT NOT NULL,
    correct BOOLEAN DEFAULT FALSE,
    CONSTRAINT FK_TestBaseTask_TasksOptions FOREIGN KEY (test_base_task_id) REFERENCES test_base_tasks(id)
);

CREATE TABLE test_results (
	test_result_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT,
    completed_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE test_results_tasks (
	test_result INT,
    task_id INT,
    response_id INT
);
/*
CREATE TABLE test_tasks (
	test_task_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    test_task_type INT NOT NULL,
    test_question VARCHAR(255),
    test_base INT,
    is_correct BOOLEAN DEFAULT FALSE,
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP
);
*/
/*
CREATE TABLE test_tasks_types (
	test_task_type_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    one_option_correct BOOLEAN DEFAULT FALSE,
    several_option_correct BOOLEAN DEFAULT FALSE,
    yes_or_no BOOLEAN DEFAULT FALSE,
    is_short_response BOOLEAN DEFAULT FALSE
);*/
/*
CREATE TABLE test_tasks_with_options (
	test_task_id INT,
    option_id INT
);
*/

