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
    description VARCHAR(1000),
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
    mark INT NOT NULL,
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

CREATE TABLE tests (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    test_name VARCHAR(255) NOT NULL,
    tasks_number INT NOT NULL,
    test_base_id INT NOT NULL,
    total_mark INT NOT NULL,
    CONSTRAINT FK_TestBaseTask_Tests FOREIGN KEY (test_base_id) REFERENCES test_bases(id)
);

/*тут зберігаються завдання для конкретного тесту*/
CREATE TABLE tests_tasks (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    test_id INT NOT NULL,
    test_task_id INT NOT NULL,
    CONSTRAINT FK_Tests_TestsTasks FOREIGN KEY (test_id) REFERENCES tests(id),
    CONSTRAINT FK_TestBaseTask_TestsTasks FOREIGN KEY (test_task_id) REFERENCES test_base_tasks(id)
);

CREATE TABLE test_assignments (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    test_id INT NOT NULL,
    status VARCHAR(255) NOT NULL,
    due_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_Users_TestAssignments FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT FK_Tests_TestAssignments FOREIGN KEY (test_id) REFERENCES tests(id)
);

CREATE TABLE test_variants (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    assignment_id INT NOT NULL,
    task_id INT NOT NULL,
    task_order INT NOT NULL,
    CONSTRAINT FK_TestAssignments_TestVariants FOREIGN KEY (assignment_id) REFERENCES test_assignments(id),
    CONSTRAINT FK_TestTasks_TestVariants FOREIGN KEY (task_id) REFERENCES tests_tasks(id)
);

CREATE TABLE test_results (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    assignment_id INT NOT NULL,
    estimation INT NOT NULL,
    completed_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_TestAssignments_TestResults FOREIGN KEY (assignment_id) REFERENCES test_assignments(id)
);

CREATE TABLE test_results_tasks (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	test_result_id INT NOT NULL,
    task_id INT NOT NULL,
    response_id INT NOT NULL,
    CONSTRAINT FK_TestResults_TestResultsTasks FOREIGN KEY (test_result_id) REFERENCES test_results(id),
    CONSTRAINT FK_TestBaseTasks_TestResultsTasks FOREIGN KEY (task_id) REFERENCES test_base_tasks(id)
);



