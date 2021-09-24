DROP SCHEMA IF EXISTS testing_system_assignment;
CREATE SCHEMA IF NOT EXISTS testing_system_assignment DEFAULT CHARACTER SET utf8;
USE testing_system_assignment;
-- ---------------- --

/*Create Department Table*/
CREATE TABLE `department`(
	department_id 			TINYINT UNSIGNED AUTO_INCREMENT,
	department_name 		VARCHAR(50) NOT NULL,
PRIMARY KEY (department_id)
);
		
/*Create Position Table*/
CREATE TABLE `position`(
	position_id 			TINYINT UNSIGNED AUTO_INCREMENT ,
	position_name 			ENUM ('Dev1', 'Dev2', 'PM', 'Leader', 'Scrum Master', 'Tester'),
PRIMARY KEY (position_id)
);

/*Create Account Table*/
CREATE TABLE `account` (
    account_id 				INT UNSIGNED AUTO_INCREMENT,
    email 					VARCHAR(50) NOT NULL UNIQUE,
    username 				VARCHAR(50) NOT NULL UNIQUE,
    fullname 				VARCHAR(50) NOT NULL,
    department_id 			TINYINT UNSIGNED,
    position_id 			TINYINT UNSIGNED,
    create_date 			DATE,
PRIMARY KEY (account_id),
    CONSTRAINT `fk_account_department` 
		FOREIGN KEY (department_id) REFERENCES `department` (department_id)
        ON DELETE SET NULL 
        ON UPDATE CASCADE,
    CONSTRAINT `fk_account_position`
		FOREIGN KEY (position_id) REFERENCES `position` (position_id)
        ON DELETE SET NULL 
        ON UPDATE CASCADE
);

/*Create Group Table*/
CREATE TABLE `group`(
	group_id 			TINYINT UNSIGNED AUTO_INCREMENT,
	group_name 			VARCHAR(50) NOT NULL,
    creator_id 			INT UNSIGNED,
	create_date 		DATE,
PRIMARY KEY (group_id),
CONSTRAINT `fk_group_creator`
	FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

/*Create Group_Account Table*/
CREATE TABLE `group_account`(
	group_id 			TINYINT UNSIGNED,
	account_id 			INT UNSIGNED,
	join_date 			DATETIME DEFAULT NOW(),
CONSTRAINT `unique_group_account` UNIQUE KEY (group_id, account_id),
CONSTRAINT `fk_group_account_group`
	FOREIGN KEY (group_id) REFERENCES `group`(group_id)
		ON DELETE SET NULL
		ON UPDATE CASCADE,
CONSTRAINT `fk_group_account_members`
	FOREIGN KEY (account_id) REFERENCES `account`(account_id)
		ON DELETE SET NULL
		ON UPDATE CASCADE
);

/*Create Type_Question Table*/
CREATE TABLE `type_question`(
	type_id				TINYINT UNSIGNED AUTO_INCREMENT,
	type_name			ENUM ('Essay', 'Multiple-Choice') NOT NULL,
PRIMARY KEY (type_id)
);

/*Create Category_Question Table*/
CREATE TABLE `category_question`(
	category_id			TINYINT UNSIGNED AUTO_INCREMENT,
	category_name		ENUM ('Java', 'SQL', '.NET', 'Ruby', 'Python', 'NodeJS', 'HTML', 'CSS', 'JavaScript') NOT NULL,
PRIMARY KEY (category_id)
);

/*Create Question Table*/
CREATE TABLE `question`(
	question_id			TINYINT UNSIGNED AUTO_INCREMENT,
	content				TEXT NOT NULL,
	category_id			TINYINT UNSIGNED,
	type_id				TINYINT UNSIGNED,
	creator_id			INT UNSIGNED,
	create_date			DATE,
PRIMARY KEY (question_id),
CONSTRAINT `fk_question_category`
	FOREIGN KEY (category_id) REFERENCES `category_question`(category_id)
	ON DELETE SET NULL
    ON UPDATE CASCADE,
CONSTRAINT `fk_question_type`
	FOREIGN KEY (type_id) REFERENCES `type_question`(type_id)
	ON DELETE SET NULL
    ON UPDATE CASCADE,
CONSTRAINT `fk_question_account`
	FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
	ON DELETE SET NULL
    ON UPDATE CASCADE
);

/*Create Answer Table*/
CREATE TABLE `answer`(
	answer_id			TINYINT UNSIGNED AUTO_INCREMENT,
	content				TEXT NOT NULL,
    question_id			TINYINT UNSIGNED NOT NULL,
    is_correct			BIT NOT NULL,
PRIMARY KEY (answer_id),
CONSTRAINT `fk_question_answer`
	FOREIGN KEY (question_id) REFERENCES `question`(question_id)
	ON DELETE CASCADE
    ON UPDATE CASCADE
);

/*Create Exam Table*/
CREATE TABLE `exam`(
	exam_id				TINYINT UNSIGNED AUTO_INCREMENT,
	`code`				CHAR(5) UNIQUE NOT NULL,
    title				VARCHAR(50) NOT NULL,
	category_id			TINYINT UNSIGNED,
	duration			SMALLINT UNSIGNED NOT NULL,
	creator_id			INT UNSIGNED,
	create_date			DATE,
PRIMARY KEY (exam_id),
CONSTRAINT `fk_exam_category`
	FOREIGN KEY (category_id) REFERENCES `category_question`(category_id)
	ON DELETE SET NULL
    ON UPDATE CASCADE,
CONSTRAINT `fk_exam_account`
	FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
	ON DELETE SET NULL
    ON UPDATE CASCADE
);

/*Create Exam_Question Table*/
CREATE TABLE `exam_question`(
	exam_id				TINYINT UNSIGNED,
	question_id			TINYINT UNSIGNED,
CONSTRAINT `unique_exam_question` UNIQUE KEY (exam_id, question_id),
CONSTRAINT `fk_exam_question_exam`
	FOREIGN KEY (exam_id) REFERENCES `exam`(exam_id)
	ON DELETE SET NULL
    ON UPDATE CASCADE,
CONSTRAINT `fk_exam_question_question`
	FOREIGN KEY (question_id) REFERENCES `question`(question_id)
	ON DELETE SET NULL
    ON UPDATE CASCADE
);

