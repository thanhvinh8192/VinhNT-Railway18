USE testing_system_assignment;

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT a.fullname, a.department_id, d.department_name
FROM `account` a
INNER JOIN department d 
ON a.department_id = d.department_id
;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT *
FROM `account`
WHERE create_date > '2010-12-20'
;

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT a.account_id, a.email, a.username, a.position_id, p.position_name
FROM `account` a
INNER JOIN `position` p ON a.position_id = p.position_id
WHERE  p.position_name = 'Dev1' OR p.position_name = 'Dev2'
;

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT d.department_id, d.department_name, COUNT(a.account_id) AS total_account
FROM `account` a
INNER JOIN department d ON a.department_id = d.department_id
GROUP BY d.department_id
HAVING total_account > 3
;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT eq.question_id, q.content, COUNT(eq.question_id) AS total_used
FROM exam_question eq
INNER JOIN question q ON eq.question_id = q.question_id
GROUP BY eq.question_id
HAVING total_used = (
					SELECT MAX(total)  
                    FROM (	SELECT COUNT(question_id) AS total
							FROM exam_question
                            GROUP BY question_id
						)
AS ex_temp
)
;

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT cq.category_id, cq.category_name, COUNT(q.category_id) AS number_question_uses
FROM category_question cq
INNER JOIN question q ON q.category_id = cq.category_id
GROUP BY cq.category_id
;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT q.question_id, q.content, COUNT(eq.question_id) AS total_exam_uses 
FROM exam_question eq
INNER JOIN question q ON eq.question_id = q.question_id
GROUP BY eq.question_id
;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT q.question_id, q.content, COUNT(a.question_id) AS total_answers
FROM answer a 
INNER JOIN question q ON a.question_id = q.question_id
GROUP BY a.question_id
HAVING total_answers = (
						SELECT MAX(total)
                        FROM (SELECT COUNT(question_id) AS total
								FROM answer 
                                GROUP BY question_id)
						AS temp
)
;

-- Question 9: Thống kê số lượng account trong mỗi group
SELECT group_id, COUNT(account_id) AS total_account 
FROM group_account
GROUP BY group_id
;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT p.position_id, p.position_name, COUNT(a.position_id) total_account 
FROM `account` a
INNER JOIN `position` p ON a.position_id = p.position_id
GROUP BY p.position_id
HAVING total_account = (SELECT MIN(total)
						FROM (SELECT COUNT(position_id) AS total
								FROM `account`
                                GROUP BY position_id) AS temp
)
;

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của 
-- question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...
SELECT q.question_id, q.content, t.type_name, acc.fullname AS creator, an.content AS correct_answer
FROM question q
INNER JOIN `account` acc ON acc.account_id = q.creator_id
INNER JOIN type_question t ON t.type_id = q.type_id
INNER JOIN answer an ON an.question_id = q.question_id
WHERE an.is_correct = 1
ORDER BY q.question_id
;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại Essay hay Multiple-Choice
SELECT t.type_id, t.type_name, COUNT(q.type_id) AS total_questions
FROM question q 
INNER JOIN type_question t ON t.type_id = q.type_id
GROUP BY type_id
;