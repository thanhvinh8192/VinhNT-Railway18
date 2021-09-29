USE testing_system_assignment;
			 
-- Question 2: Lấy ra tất cả phòng ban
SELECT *
FROM department;

-- Question 3: Lấy ra id của phòng ban "Sale"
SELECT department_id AS sale_of_department_id
FROM department
WHERE department_name LIKE '%Sale';

-- Question 4: Lấy ra thông tin account có full name dài nhất
SELECT *, LENGTH(fullname) AS length_of_fullname
FROM `account`
WHERE LENGTH(fullname) = (SELECT MAX(LENGTH(fullname)) FROM `account`);

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT *, LENGTH(fullname) AS length_of_fullname
FROM `account`
WHERE LENGTH(fullname) = (SELECT MAX(LENGTH(fullname)) FROM `account`) AND department_id = 3;

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT * 
FROM `group`
WHERE create_date < '2019-12-20';

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT question_id, COUNT(answer_id) AS number_of_answer 
FROM answer
GROUP BY question_id
HAVING number_of_answer >= 4;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT * 
FROM exam
WHERE duration >= 60 AND create_date <= '20191220';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT * 
FROM `group`
WHERE DATEDIFF(CURDATE(), create_date)
ORDER BY create_date DESC
LIMIT 5;
-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT department_id, COUNT(account_id) AS  number_of_account
FROM `account`
WHERE department_id = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT *
FROM `account`
WHERE (SUBSTRING_INDEX(fullname, ' ', -1)) LIKE 'D%o';


-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
COMMIT;
SET SQL_SAFE_UPDATES = 0; 
DELETE FROM exam
WHERE create_date < '20191220';
SET SQL_SAFE_UPDATES = 1; 
ROLLBACK;

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
COMMIT;
SET SQL_SAFE_UPDATES = 0; 
DELETE FROM question
WHERE BINARY content LIKE 'câu hỏi%';
SET SQL_SAFE_UPDATES = 1; 
ROLLBACK;

-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
COMMIT;
SET SQL_SAFE_UPDATES = 0;
UPDATE `account`
	SET fullname = 'Nguyễn Bá Lộc', email = 'loc.nguyenba@vti.com.vn' 
WHERE account_id = 5;
SET SQL_SAFE_UPDATES = 1;
ROLLBACK;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
COMMIT;
SET SQL_SAFE_UPDATES = 0;
UPDATE group_account
SET group_id = 4
WHERE account_id = 5;
SET SQL_SAFE_UPDATES = 1;
ROLLBACK;