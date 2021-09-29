-- Insert data to Department Table --
INSERT INTO `department`(department_name)
	VALUES 				('Phong Ky Thuat 1'),
						('Phong Ky Thuat 2'),
						('Phong Dev 1'),
						('Phong Dev 2'),
						('Phong Sale'),
						('Phong Marketing'),
						('Phong Giam Doc'),
						('Phong Tai Chinh')
;

-- Insert data to Position Table --
INSERT INTO `position`	(position_name)
	VALUES				('Dev1'),
						('Dev2'),
						('Tester'),
						('PM'),
						('Leader'),
						('Scrum Master')
;
        
-- Insert data to Account Table --
INSERT INTO `account`	(email, username, fullname, department_id, position_id, create_date)	
	VALUES				('vti_account1@vtiacademy.com', 'vti1', 'Nguyen Van Tinh', 1, 1, '2019-12-01'),
						('vti_account2@vtiacademy.com', 'vti2', 'Trinh Hoai Linh', 1, 2, '2020-12-01'),
						('vti_account3@vtiacademy.com', 'vti3', 'Nguyen Van Test', 1, 1, '2020-07-01'),
						('vti_account4@vtiacademy.com', 'vti4', 'Tran Van Tinh', 1, 2, '2019-09-01'),
						('vti_account5@vtiacademy.com', 'account5', 'Ho Van Tinh', 3, 2, '2021-07-01'),
						('vti_account6@vtiacademy.com', 'account_vti6', 'Cao Thai Son', 3, 1, CURDATE()),
						('vti_7@vtiacademy.com', 'account_vti7', 'Tam Thất Tùng', 3, 3, '2020-10-01'),
						('vti_8@vtiacademy.com', 'account_vti8', 'Nguyen Quynh Thu', 3, 4, '2019-04-01'),
						('vti_9@vtiacademy.com', 'account_vti9', 'Tran Kim Tuyen', 2, 1, CURDATE()),
						('vti_account10@vtiacademy.com', 'account_vti10', 'Nguyen Ba Dao', 1, 5, '2019-10-01'),
						('vti_account11@vtiacademy.com', 'account_vti11', 'Nguyen Van Binh', 1, 3, '2020-12-01'),
						('vti_account12@vtiacademy.com', 'account_vti2', 'Nguyen Phong Lam', 2, 5, '2021-09-17')
;

INSERT INTO `account` 	(email, username, fullname, department_id, position_id, create_date)
	VALUES 				('vti_account13@vtiacademy.com', 'vti13', 'Tran Thuy Linh', 4, 1, '2020-12-01'),
						('vti_account14@vtiacademy.com', 'vti14', 'Nguyen Tan Tai', 8, 2, '2021-2-01'),
						('vti_account15@vtiacademy.com', 'vti15', 'Luu Duc Hoa', 8, 1, '2021-07-01')
;

-- Insert data to Group Table --
INSERT INTO `group`	(group_name, 	creator_id, create_date)
	VALUES 			('Nhom 1', '3', '2021-04-03'),
					('Nhom 2', '3', '2019-01-03'),
					('Nhom 3', '2', '2020-04-03'),
					('Nhom 4', '1', CURDATE()	),
					('Nhom 5', '3', '2021-06-03'),
					('Nhom 6', '1', '2020-04-03'),
					('Nhom 7', '5', '2021-04-03'),
					('Nhom 8', '5', '2019-05-03'),
					('Nhom 9', '3', '2019-01-03'),
					('Nhom 10', '1', CURDATE()	)
;

-- Insert data to Group_Account Table --                    
INSERT INTO `group_account`(group_id, 	account_id, join_date)
	VALUES 					('1', '1', '2021-06-01'),
							('1', '3', '2020-01-01'),
							('1', '2', NOW()		),
							('1', '4', '2021-06-01'),
							('2', '1', '2021-06-01'),
							('2', '10', '2019-05-01'),
							('5', '1', '2021-06-01'),
							('5', '3', '2020-01-01'),
							('5', '4', '2021-07-01'),
							('3', '1', '2021-06-01'),
							('9', '2', '2021-06-01'),
							('10', '1', NOW()		)
;

-- Insert data to Type_Question Table --
INSERT INTO `type_question` (type_name)
	VALUES 					('Essay'),
							('Multiple-Choice')
;

-- Insert data to Category_Question Table --
INSERT INTO `category_question` (category_name)
	VALUES 						('Java'),
								('SQL'),
								('HTML'),
								('CSS '),
								('.NET'),
								('Python'),
								('Ruby'),
								('JavaScript')
;

 -- Insert data to Question Table --                               
INSERT INTO `question` 	(content, 			category_id, 	type_id, 	creator_id, create_date)
	VALUES 				('Câu hỏi SQL 1', 2, 2, 1, '2021-04-01'),
						('Câu hỏi SQL 2', 2, 2, 2, '2020-01-01'),
						('Câu hỏi JAVA 1', 1, 1, 10, '2021-07-01'),
						('Câu hỏi JAVA 2', 1, 2, 5, '2021-06-01'),
						('Câu hỏi HTML 1', 3, 1, 2, CURDATE()),
						('Câu hỏi HTML 2', 3, 2, 2, CURDATE())
;

-- Insert data to Answer Table --
INSERT INTO `answer`(content, 							question_id, is_correct)
	VALUES 			('Câu trả lời 1 - question SQL 1', 1, 1),
					('Câu trả lời 2 - question SQL 1', 1, 0),
					('Câu trả lời 3 - question SQL 1', 1, 0),
					('Câu trả lời 4 - question SQL 1', 1, 1),
					('Câu trả lời 1 - question SQL 2', 2, 0),
					('Câu trả lời 2 - question SQL 2', 2, 0),
					('Câu trả lời 3 - question SQL 2', 2, 0),
					('Câu trả lời 4 - question SQL 2', 2, 1),
					('Câu trả lời 1 - question JAVA 1', 3, 0),
					('Câu trả lời 2 - question JAVA 1', 3, 1),
					('Câu trả lời 1 - question JAVA 2', 4, 0),
					('Câu trả lời 2 - question JAVA 2', 4, 0),
					('Câu trả lời 3 - question JAVA 2', 4, 0),
					('Câu trả lời 4 - question JAVA 2', 4, 1),
					('Câu trả lời 1 - question HTML 1', 5, 1),
					('Câu trả lời 2 - question HTML 2', 5, 0)
;

-- Insert data to Exam Table --
INSERT INTO `exam`	(`code`, 	title, 		category_id, duration, creator_id, create_date)
	VALUES 			('MS_01', 'De thi 01', 1, 90, 1, CURDATE()),
					('MS_02', 'De thi 02', 1, 60, 5, CURDATE()),
					('MS_03', 'De thi 03', 2, 60, 9, CURDATE()),
					('MS_04', 'De thi 04', 2, 90, 1, CURDATE()),
					('MS_05', 'De thi 05', 1, 60, 2, CURDATE()),
					('MS_06', 'De thi 06', 2, 90, 2, CURDATE()),
					('MS_07', 'De thi 07', 1, 60, 1, CURDATE())
;

-- Insert data to Exam_Question Table --

INSERT INTO `exam_question` (exam_id, question_id)
	VALUES 					(1, 1),
							(2, 1),
							(3, 1),
							(4, 1),
							(5, 2),
							(6, 2),
							(7, 2),
							(1, 2),
							(2, 3),
							(3, 3),
							(4, 4),
							(5, 4),
							(6, 4),
							(7, 4),
							(4, 5),
							(6, 5)
;


