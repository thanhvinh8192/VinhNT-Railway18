DROP DATABASE IF EXISTS FinalExamJavaAdvance;

CREATE DATABASE FinalExamJavaAdvance;

USE FinalExamJavaAdvance;

DROP TABLE IF EXISTS 	`Department`;
CREATE TABLE IF NOT EXISTS `Department` (
	id 						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	department_name 		NVARCHAR(50) NOT NULL UNIQUE KEY,
    total_member			INT	UNSIGNED,
    `type`					ENUM('Dev','Test','ScrumMaster','PM') NOT NULL,
    created_date			DATETIME DEFAULT NOW()
);

-- create table: Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	id						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username				VARCHAR(50) NOT NULL UNIQUE KEY,
	`password` 				VARCHAR(800) NOT NULL,
    first_name				NVARCHAR(50) NOT NULL,
    last_name				NVARCHAR(50) NOT NULL,
    `role` 					ENUM('ADMIN','EMPLOYEE','MANAGER') NOT NULL DEFAULT 'EMPLOYEE',
    department_id 			INT UNSIGNED NOT NULL,
    FOREIGN KEY(department_id) REFERENCES Department(id)
);

-- =============================================
-- INSERT DATA 
-- =============================================
-- Add data Department
INSERT INTO Department(	department_name, 		total_member, 	`type`, 		created_date) 
VALUES
						('Marketing', 	1,		'Dev', 			'2020-03-05'),
						('Sale', 		2,		'Test', 		'2020-03-05'),
						('Bảo vệ', 		3,		'ScrumMaster', 	'2020-03-07'),
						('Nhân sự', 	4,		'PM', 			'2020-03-08'),
						('Kỹ thuật', 	5,		'Dev', 			'2020-03-10'),
						('Tài chính', 	6,		'ScrumMaster', 	NOW()		),
						('Phó giám đốc',7,		'PM', 			NOW()		),
						('Giám đốc', 	8,		'Test', 		'2020-04-07'),
						('Thư kí', 		9,		'PM', 			'2020-04-07'),
						('Bán hàng', 	1,		'Dev', 			'2020-04-09');
                    
-- Add data Account
-- Password: 123456
INSERT INTO `Account`(	username		,						`password`									,	first_name	,	last_name	,		`role`		,	department_id	)
VALUES 				(	'dangblack'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Hai Dang'	,		'ADMIN'		,		'5'			),
					(	'namblue'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Tran'	,	'Hoi Nam'	,		'EMPLOYEE'		,		'2'			),
					(	'phuongpink'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Phan'	,	'Thu Phuong'	,		'MANAGER'		,		'6'			),
					(	'quanganh'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Quang Anh'	,		'MANAGER'	,		'1'			),
                    (	'vanchien'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Tran'		,	'Van Chien'	,		'ADMIN'		,		'1'			),
                    (	'cocoduongqua'	,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Co Co'		,		'EMPLOYEE'	,		'1'			),
                    (	'doccocaubai'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Doc Co'	,		'ADMIN'		,		'2'			),
                    (	'khabanh'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Phan'		,	'Kha Bang'	,		'EMPLOYEE'	,		'2'			),
                    (	'huanhoahong'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Tran'		,	'Van Huan'	,		'ADMIN'		,		'2'			),
                    (	'tungnui'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Tung Nui'	,		'MANAGER'	,		'8'			),
                    (	'duongghuu'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Phan'		,	'Duong Huu'	,		'ADMIN'		,		'9'			),
                    (	'vtiaccademy'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Tran'		,	'Academy'	,		'MANAGER'	,		'10'		),
                    (	'namgreen'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Honag Nam'	,		'EMPLOYEE'	,		'2'			),
                    (	'congphuong'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Cong Phuong',		'ADMIN'		,		'2'			),
                    (	'xuantruong'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Xuan Truong',		'MANAGER'	,		'3'			),
                    (	'vanhau'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Doan'		,	'Van Hau'	,		'EMPLOYEE'	,		'7'			),
                    (	'ducchinh'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Ha'		,	'duc chinh'	,		'EMPLOYEE'	,		'10'		),
                    (	'tuananh'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Tuan Anh'	,		'MANAGER'	,		'3'			),
                    (	'hongduy'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen Phong'	,	'Hong Duy'	,		'EMPLOYEE'	,		'8'			),
                    (	'vantoan'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Van Toan'	,		'EMPLOYEE'	,		'6'			),
                    (	'hoangduc'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Hoang Duc'	,		'ADMIN'		,		'5'			);