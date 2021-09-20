DROP SCHEMA IF EXISTS testing_system_assignment_1;
CREATE SCHEMA IF NOT EXISTS testing_system_assignment_1;
USE testing_system_assignment_1;
-- ---------------- --
CREATE TABLE `department`(
	department_id		TINYINT UNSIGNED AUTO_INCREMENT,
	department_name		VARCHAR(50) NOT NULL,
PRIMARY KEY (department_id)
);

CREATE TABLE `position`(
	position_id			TINYINT UNSIGNED AUTO_INCREMENT ,
	position_name		VARCHAR(50) NOT NULL,
PRIMARY KEY (position_id)
);

CREATE TABLE `account`(
	account_id			INT UNSIGNED AUTO_INCREMENT ,
	email				VARCHAR(50) NOT NULL UNIQUE,
	username			VARCHAR(50) NOT NULL UNIQUE,
	fullname			VARCHAR(50) NOT NULL,
	department_id		TINYINT UNSIGNED,
	position_id			TINYINT UNSIGNED,
	create_date			DATETIME DEFAULT NOW(),
PRIMARY KEY (account_id),
CONSTRAINT `fk_account_department`
	FOREIGN KEY (department_id) REFERENCES `department` (department_id)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
CONSTRAINT `fk_account_position`
	FOREIGN KEY (position_id) REFERENCES `position` (position_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE `group`(
	group_id			TINYINT UNSIGNED AUTO_INCREMENT,
	group_name			VARCHAR(50) NOT NULL,
    creator_id			INT UNSIGNED NOT NULL,
	create_date			DATETIME DEFAULT NOW(),
PRIMARY KEY (group_id),
CONSTRAINT `fk_group_creator`
	FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE `group_account`(
	group_id			TINYINT UNSIGNED NOT NULL,
	account_id			INT UNSIGNED NOT NULL,
	join_date			DATETIME DEFAULT NOW(),
PRIMARY KEY (group_id, account_id),
CONSTRAINT `fk_group_account_group`
	FOREIGN KEY (group_id) REFERENCES `group`(group_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
CONSTRAINT `fk_group_account_members`
	FOREIGN KEY (account_id) REFERENCES `account`(account_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE    
);

CREATE TABLE `type_question`(
	type_id				TINYINT UNSIGNED AUTO_INCREMENT,
	type_name			ENUM ('Essay', 'Multiple-Choice') NOT NULL,
PRIMARY KEY (type_id)
);

CREATE TABLE `category_question`(
	category_id			TINYINT UNSIGNED AUTO_INCREMENT,
	category_name		VARCHAR(50) NOT NULL,
PRIMARY KEY (category_id)
);

CREATE TABLE `question`(
	question_id			TINYINT UNSIGNED AUTO_INCREMENT,
	content				TEXT NOT NULL,
	category_id			TINYINT UNSIGNED NOT NULL,
	type_id				TINYINT UNSIGNED NOT NULL,
	creator_id			INT UNSIGNED NOT NULL,
	create_date			DATETIME DEFAULT NOW(),
PRIMARY KEY (question_id),
CONSTRAINT `fk_question_category`
	FOREIGN KEY (category_id) REFERENCES `category_question`(category_id)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
CONSTRAINT `fk_question_type`
	FOREIGN KEY (type_id) REFERENCES `type_question`(type_id)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
CONSTRAINT `fk_question_account`
	FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
	ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE `answer`(
	answer_id			TINYINT UNSIGNED AUTO_INCREMENT,
	content				TEXT NOT NULL,
    question_id			TINYINT UNSIGNED NOT NULL,
    is_correct			ENUM('D','S') NOT NULL,
PRIMARY KEY (answer_id),
CONSTRAINT `fk_question_answer`
	FOREIGN KEY (answer_id) REFERENCES `question`(question_id)
	ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE `exam`(
	exam_id				TINYINT UNSIGNED AUTO_INCREMENT,
	`code`				CHAR(8) NOT NULL,
    title				VARCHAR(50) NOT NULL,
	category_id			TINYINT UNSIGNED NOT NULL,
	duration			TIME NOT NULL,
	creator_id			INT UNSIGNED NOT NULL,
	create_date			DATETIME DEFAULT NOW(),
PRIMARY KEY (exam_id),
CONSTRAINT `fk_exam_category`
	FOREIGN KEY (category_id) REFERENCES `category_question`(category_id)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
CONSTRAINT `fk_exam_account`
	FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
	ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE `exam_question`(
	exam_id				TINYINT UNSIGNED NOT NULL,
	question_id			TINYINT UNSIGNED NOT NULL,
PRIMARY KEY (exam_id, question_id),
CONSTRAINT `fk_exam_question_exam`
	FOREIGN KEY (exam_id) REFERENCES `exam`(exam_id)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
CONSTRAINT `fk_exam_question_question`
	FOREIGN KEY (question_id) REFERENCES `question`(question_id)
	ON DELETE CASCADE
    ON UPDATE CASCADE
);

