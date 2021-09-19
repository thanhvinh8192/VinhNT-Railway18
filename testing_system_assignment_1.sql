CREATE SCHEMA IF NOT EXISTS testing_system_assignment_1;
USE testing_system_assignment_1;
-- ---------------- --
CREATE TABLE `department`(
	department_id 		INT AUTO_INCREMENT PRIMARY KEY,
	department_name 	VARCHAR(50) NOT NULL
);

CREATE TABLE `position`(
	position_id 		INT  AUTO_INCREMENT PRIMARY KEY,
	position_name 		VARCHAR(50) NOT NULL
);

CREATE TABLE `account`(
	account_id 			INT AUTO_INCREMENT PRIMARY KEY,
	email				VARCHAR(50) NOT NULL,
	username			VARCHAR(50) NOT NULL,
	fullname			VARCHAR(50) NOT NULL,
	department_id		INT NOT NULL,
	position_id			INT NOT NULL,
	create_date 		DATE NOT NULL
);

CREATE TABLE `group`(
	group_id 			INT AUTO_INCREMENT PRIMARY KEY,
	group_name			INT NOT NULL,
    creator_id			INT NOT NULL,
	create_date			DATE NOT NULL
);

CREATE TABLE `group_account`(
	group_id 			INT NOT NULL,
	account_id			INT NOT NULL,
	join_date			DATE NOT NULL
);

CREATE TABLE `type_question`(
	type_id 		INT AUTO_INCREMENT PRIMARY KEY,
	type_name 		VARCHAR(50) NOT NULL
);

CREATE TABLE `category_question`(
	category_id 	INT AUTO_INCREMENT PRIMARY KEY,
	category_name 	VARCHAR(50) NOT NULL
);

CREATE TABLE `question`(
	question_id 	INT AUTO_INCREMENT PRIMARY KEY,
	content			TEXT NOT NULL,
	category_id		INT NOT NULL,
	type_id			INT NOT NULL,
	creator_id		INT NOT NULL,
	create_date		DATE NOT NULL
);

CREATE TABLE `answer`(
	answer_id		INT AUTO_INCREMENT PRIMARY KEY,
	content			VARCHAR(50) NOT NULL,
    question_id		INT NOT NULL,
    is_correct		ENUM('D','S') NOT NULL
);

CREATE TABLE `exam`(
	exam_id			INT AUTO_INCREMENT PRIMARY KEY,
	title			CHAR(8) NOT NULL,
	category_id		INT NOT NULL,
	duration		TIME NOT NULL,
	creator_id		INT NOT NULL,
	create_date		DATE NOT NULL
);

CREATE TABLE `exam_question`(
	exam_id 		INT AUTO_INCREMENT PRIMARY KEY,
	question_id 	VARCHAR(50) NOT NULL
);

