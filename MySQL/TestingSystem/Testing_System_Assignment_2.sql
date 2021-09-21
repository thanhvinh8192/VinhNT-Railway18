-- Insert data to Department Table --
INSERT INTO `department`(department_name)
	VALUES 				('Nhân sự'),
                        ('Kỹ thuật'),
						('Kế toán'),
						('Marketing'),
                        ('Kinh doanh'),
                        ('Đào tạo')
;

-- Insert data to Position Table --
INSERT INTO `position`	(position_name)
	VALUES				('Dev'),
						('Test'),
                        ('Scrum Master'),
                        ('PM')
;
        
-- Insert data to Account Table --
INSERT INTO `account`	(email, 					username, 		fullname, 				department_id, 	position_id, 	create_date)	
	VALUES				('longtrinh@vti.com.vn', 	'longtrinh', 	'Trịng Hoài Long', 		1, 				3, 				'2019-12-01'),
						('baonguyen@vti.com.vn', 	'baonguyen', 	'Nguyễn Quốc Bảo',		2, 				1, 				CURDATE()),
                        ('chauduong@vti.com.vn', 	'chauduong', 	'Dương Minh Châu',		3, 				2, 				'2020-12-01'),
                        ('vudinh@vti.com.vn', 		'vudinh', 		'Đinh Thế Vũ',			4, 				1, 				'2019-12-01'),
                        ('thanhduong@vti.com.vn', 	'thanduong', 	'Dương Quốc Thành',		4, 				4, 				'2021-12-01'),
                        ('vti_5@vti.com.vn', 		'account5', 	'Ho Van Tinh', 			2, 				2, 				'2021-07-01'),
						('vti_6@vti.com.vn', 		'account_vti6', 'Cao Thai Son', 		3, 				1, 				CURDATE()	),
						('vti_7@vti.com.vn', 		'account_vti7', 'Tam Thất Tùng', 		1, 				3, 				'2020-10-01'),
						('vti_8@vti.com.vn', 		'account_vti8', 'Nguyen Quynh Thu', 	5, 				4, 				'2019-04-01'),
                        ('trungnguyen@vti.com.vn', 	'trungnguyen', 	'Nguyễn Thành Trung',	5 , 			1, 				CURDATE()	)
;

-- Insert data to Group Table --
INSERT INTO `group`	(group_name, 	creator_id, create_date)
	VALUES 			('Group VTI 1', 1, 			CURDATE()	),
					('Group VTI 2', 2, 			'2020-04-03'),
                    ('Group VTI 3', 3, 			CURDATE()	),
                    ('Group VTI 4', 4, 			'2019-05-03'),
                    ('Group VTI 5', 5, 			CURDATE()	),
                    ('Group VTI 6', 6, 			'2019-05-03')
;

-- Insert data to Group_Account Table --                    
INSERT INTO `group_account`(group_id, 	account_id, join_date)
	VALUES 					(1, 		1, 			NOW()		),
							(2, 		3, 			'2020-09-21'),
                            (6, 		5, 			'2021-09-21'),
                            (3, 		7, 			'2021-09-22'),
                            (3, 		9, 			'2021-09-22'),
                            (5, 		2, 			NOW()		),
                            (4, 		4, 			NOW()		),
                            (1, 		6, 			'2021-09-20'),
                            (5, 		8, 			'2021-09-21'),
                            (1, 		10, 		'2021-09-22'),
                            (6, 		4, 			NOW()		),
                            (4, 		2, 			'2021-09-21')
;

-- Insert data to Type_Question Table --
INSERT INTO `type_question` (type_name)
	VALUES 					('Essay'),
							('Multiple-Choice')
;

-- Insert data to Category_Question Table --
INSERT INTO `category_question` (category_name)
	VALUES 						('Java'), 
								('.NET'), 
								('SQL'), 
								('Postman'), 
								('Ruby'),
								('HTML'), 
								('CSS'), 
								('Javascript')
;

 -- Insert data to Question Table --                               
INSERT INTO `question` 	(content, 			category_id, 	type_id, 	creator_id, create_date)
	VALUES 				('Câu hỏi SQL 	1', 	3, 				2, 			1, 			'2021-04-01'),
						('Câu hỏi SQL 	2', 	3, 				2, 			2, 			CURDATE()	),
						('Câu hỏi JAVA 	1', 	1, 				1, 			10,			'2021-07-01'),
						('Câu hỏi JAVA 	2', 	1, 				2, 			5, 			'2021-06-01'),
						('Câu hỏi Postman', 	4, 				1, 			2, 			CURDATE()	),
                        ('Câu hỏi CSS', 		7, 				2, 			2, 			'2020-01-01'),
						('Câu hỏi Javascript', 	8, 				1, 			10,			'2021-07-01'),
						('Câu hỏi Ruby', 		1, 				2, 			5, 			'2021-06-01'),
						('Câu hỏi HTML 	2', 	6, 				2, 			2, 			CURDATE()	)
;

-- Insert data to Answer Table --
INSERT INTO `answer`(content, 							question_id, is_correct)
	VALUES 			('Câu trả lời 1 - question SQL 1', 		1, 			1),
					('Câu trả lời 2 - question SQL 1', 		1, 			0),
					('Câu trả lời 1 - question CSS', 		6, 			0),
					('Câu trả lời 2 - question CSS', 		6, 			1),
					('Câu trả lời 1 - question SQL 2', 		2, 			0),
					('Câu trả lời 2 - question SQL 2', 		2, 			0),
					('Câu trả lời 1 - question Postman', 	5, 			0),
					('Câu trả lời 4 - question SQL 2', 		2, 			1),
					('Câu trả lời 1 - question JAVA 1', 	3, 			0),
					('Câu trả lời 2 - question JAVA 1', 	3, 			1),
					('Câu trả lời 1 - question JAVA 2', 	4, 			0),
					('Câu trả lời 2 - question JAVA 2', 	4, 			0),
					('Câu trả lời 3 - question JAVA 2', 	4, 			0),
					('Câu trả lời 4 - question JAVA 2', 	4, 			1),
					('Câu trả lời 1 - question Ruby', 		8, 			1),
					('Câu trả lời 2 - question HTML 2', 	5, 			0)
;

-- Insert data to Exam Table --
INSERT INTO `exam`	(`code`, 	title, 		category_id, duration, creator_id, create_date)
	VALUES 			('MS_01', 'De thi 01', 		1, 			90, 		1, 		CURDATE()),
					('MS_02', 'De thi 02', 		1, 			60, 		5, 		CURDATE()),
					('MS_03', 'De thi 03', 		3, 			60, 		9, 		CURDATE()),
					('MS_04', 'De thi 04', 		3, 			90, 		1, 		CURDATE()),
					('MS_05', 'De thi 05', 		1, 			60, 		2, 		CURDATE()),
					('MS_06', 'De thi 06', 		6, 			90, 		2, 		CURDATE()),
					('MS_07', 'De thi 07', 		1, 			60, 		1, 		CURDATE())
;
-- Insert data to Exam_Question Table --
INSERT INTO `exam_question` (exam_id, question_id)
	VALUES 					(1, 		1),
							(3, 		3),
							(2, 		4),
							(1, 		2),
							(2, 		1),
							(3, 		6),
							(1, 		8),
							(4, 		7),
							(5, 		5),
							(2, 		2)
;
